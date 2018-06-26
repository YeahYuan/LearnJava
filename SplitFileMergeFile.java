package cn.itcast.day23.io.splitfilemergefile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Properties;

public class SplitFileMergeFile {
	public static final int SIZE = 1024 * 20;

	public static void main(String[] args) throws IOException {
		File f = new File("1.jpg");
		splitFile(f);
		File dir = new File("C:\\Users\\lll\\eclipse-workspace\\YeahYuanLeanJava\\partfile");
		mergeFile(dir);

	}

	public static void mergeFile(File dir) throws IOException {

		/*
		 * 获取指定目录下的配置文件对象
		 */
		File[] files = dir.listFiles(new SuffixFilter(".properties"));
		if (files.length != 1) {
			throw new RuntimeException(dir + "当前目录下没有properties文件,或不唯一");
		}
		// 记录配置文件对象
		File confile = files[0];
		// 获取文件中信息================================================
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(confile);
		prop.load(fis);
		int count = Integer.parseInt(prop.getProperty("partcount"));
		String filename = prop.getProperty("filename");

		// 获取该目录下的所有碎片文件=========================================
		File[] partFiles = dir.listFiles(new SuffixFilter(".part"));
		if (partFiles.length != count - 1) {
			throw new RuntimeException("碎片文件不符合要求,个数不对!应该是" + count + "个");
		}
		// 将碎片文件与流对象关联 并存储到集合中
		ArrayList<FileInputStream> al = new ArrayList<FileInputStream>();
		for (int x = 0; x < partFiles.length; x++) {
			al.add(new FileInputStream(partFiles[x]));
		}

		// 将多个留合并成一个序列流
		Enumeration<FileInputStream> en = Collections.enumeration(al);
		SequenceInputStream sis = new SequenceInputStream(en);
		FileOutputStream fos = new FileOutputStream(new File(dir, "merge" + filename));

		byte[] buf = new byte[1024];
		int len = 0;
		while ((len = sis.read(buf)) != -1) {
			fos.write(buf, 0, len);
		}

		fos.close();
		sis.close();
	}

	public static void splitFile(File f) throws IOException {
		FileInputStream fis = new FileInputStream(f);
		FileOutputStream fos = null;
		byte[] buf = new byte[SIZE];
		int len = 0;
		int count = 1;

		/*
		 * 切割文件时,必须记录住被切割文件的名称,以及切割出来碎片文件的个数,以方便合并 这个信息为了方便描述,使用键值对的形式,使用properties对象.
		 */

		Properties prop = new Properties();

		File dir = new File("C:\\Users\\lll\\eclipse-workspace\\YeahYuanLeanJava\\partfile");
		if (!dir.exists()) {
			dir.mkdirs();
		}
		while ((len = fis.read(buf)) != -1) {
			fos = new FileOutputStream(new File(dir, (count++) + ".part"));
			fos.write(buf, 0, len);
			fos.close();
		}
		// 将被切割文件的信息保存到prop集合中
		prop.setProperty("partcount", count + "");
		prop.setProperty("filename", f.getName());
		// 将prop集合中的数据存储到文件中
		fos = new FileOutputStream(new File(dir, count + ".properties"));
		prop.store(fos, "save file info");

		fos.close();
		fis.close();

	}

}
