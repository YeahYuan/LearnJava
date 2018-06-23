package cn.itcast.day21.io.bytestream.test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyMp3Test {

	public static void main(String[] args) throws IOException {
		copy5();

	}
//总结:要么自建缓存区byte[1024],要么用Buffer(不带byte[])
	
	
//千万不要用!!!没有效率!	(一个字节一个字节复制)
	public static void copy5() throws IOException {
		FileInputStream fis = new FileInputStream("0.jpg");
		FileOutputStream fos = new FileOutputStream("5.jpg");
		
		int ch = 0;
		while((ch=fis.read())!=-1) {
			fos.write(ch);
		}
		fis.close();
		fos.close();
		
	}
//自定义刚好文件大小的数组缓冲区,不建议用,文件过大会爆内存
	public static void copy4() throws IOException {
		FileInputStream fis = new FileInputStream("0.jpg");
		FileOutputStream fos = new FileOutputStream("4.jpg");
		
		byte[] buf = new byte[fis.available()];
		fis.read(buf);
		fos.write(buf);
		
		fis.close();
		fos.close();
	}
//建议使用该方法(缓冲区不带自定义的数组缓冲区)
	public static void copy3() throws IOException {
		FileInputStream fis = new FileInputStream("0.jpg");
		BufferedInputStream bufis = new BufferedInputStream(fis);
		
		FileOutputStream fos = new FileOutputStream("3.jpg");
		BufferedOutputStream bufos = new BufferedOutputStream(fos);
		
		int ch = 0;
		while((ch=bufis.read())!=-1) {
			bufos.write(ch);;
		}
		bufis.close();
		bufos.close();
		
	}
//缓冲区带自定义的数组缓冲区
	public static void copy2() throws IOException {
		FileInputStream fis = new FileInputStream("0.jpg");
		BufferedInputStream bufis = new BufferedInputStream(fis);
		
		FileOutputStream fos = new FileOutputStream("2.jpg");
		BufferedOutputStream bufos = new BufferedOutputStream(fos);
		
		byte[] buf = new byte[1024];
		
		int len = 0;
		while((len=bufis.read(buf))!=-1) {
			bufos.write(buf,0,len);
			bufos.flush();
		}
		bufis.close();
		bufos.close();
		
	}
	
	
//建议使用该方法!!!常用!!!自定义缓冲区
	public static void copy1() throws IOException {
		FileInputStream fis = new FileInputStream("0.jpg");
		FileOutputStream fos = new FileOutputStream("1.jpg");
		
		byte[] buf = new byte[1024];
		
		int len = 0;
		while((len=fis.read(buf))!=-1) {
			fos.write(buf,0,len);
		}
		fis.close();
		fos.close();
	}

}





















