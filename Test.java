package cn.itcast.day23.io.test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;

/*
 * 综合练习:
 * 获取指定目录下,指定扩展名的文件(包含子目录),将这些文件的绝对路径写入到一个文本文件中
 * 简单说,就是建立一个指定扩展名的文件列表
 * 
 * 思路:
 * 1.深度遍历
 * 2.遍历时过滤,将符合的内容存储在容器中
 * 3.对容器遍历将绝对路径写入文件
 */
public class Test {

	public static void main(String[] args) throws IOException {
		File dir = new File("C:\\Users\\lll\\Desktop\\1.毕向东Java视频(史上最适合初学者入门的Java基础视频)\\1.code 袁二练习");
		String filterName = ".class";
		FilenameFilter filter = getFilter(filterName);
		
		ArrayList<File> list = new ArrayList<File>();
		getFiles(dir, filter, list);
		
		File destFile = new File(dir, "javalist.txt");
		writerToFile(list, destFile);
	}

	public static void writerToFile(ArrayList<File> list, File destFile) throws IOException {
		BufferedWriter bufw = null;
		try {
			bufw = new BufferedWriter(new FileWriter(destFile));
			for (File file : list) {
				bufw.write(file.getAbsolutePath());
				bufw.newLine();
				bufw.flush();
			}
		} catch (IOException e) {
			throw new RuntimeException("写入失败");
		} finally {
			if(bufw!=null) {
				try {
					bufw.close();
				} catch (IOException e) {
					throw new RuntimeException("关闭失败");
				}
			}
		}
	}
/**
 * 对指定目录中的内容进行深度遍历,并按照指定过滤器进行过滤
 * 将过滤后的内容存储在指定容器list中.
 * @param dir
 * @param filter
 * @param list
 * @throws IOException
 */
	public static void getFiles(File dir, FilenameFilter filter, ArrayList<File> list) throws IOException {
		File[] files = dir.listFiles();
		for (File file : files) {
			if (file.isDirectory()) {
				getFiles(file, filter, list);
			} else if (filter.accept(dir, file.getName()))
				list.add(file);
		}
	}

	private static FilenameFilter getFilter(String filterName) {
		FilenameFilter filter = new FilenameFilterByName(filterName);
		return filter;
	}

}

class FilenameFilterByName implements FilenameFilter {
	String filterName = null;

	FilenameFilterByName(String filterName) {
		this.filterName = filterName;
	}

	@Override
	public boolean accept(File dir, String name) {
		return name.endsWith(filterName);
	}

}















