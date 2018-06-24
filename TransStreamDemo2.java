package cn.itcast.day22.io.transstream.demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class TransStreamDemo2 {

	public static void main(String[] args) throws IOException {
	/*
	 * 需求:将一个中文字符串数据根据指定的编码表写入到一个文本文件中
	 * 
	 * 1.目的地:Outputstream  Writer
	 * 2.是否文本?是--Writer
	 * 3.设备?硬盘:File
	 * FileWriter fr = new FileWriter("1.txt");
	 * 但是需要制定编码表,FileWriter只能使用默认
	 * ----OutputStreamWriter
	 * OutputStreamWriter接收一个输出流对象,鉴于是操作文件,对象为FileOutputStream
	 * OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("a.txt"),charseName);
	 * 
	 * 需要高效吗?
	 * BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("a.txt"),charseName));
	 * 
	 * 
	 */
		//writeFileWriter();
		//writeUTF8();
		read();
	}

	public static void read() throws IOException {
		InputStreamReader isr = new InputStreamReader(new FileInputStream("GBK.txt"),"utf-8");
		char[] buf = new char[10];
		int len = isr.read(buf);
		String str = new String(buf,0,len);
		System.out.println(str);
		isr.close();
	}

	public static void writeUTF8() throws IOException {
		OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("GBK.txt"),"GBK");
		osw.write("你好");
		osw.close();
	}

	public static void writeFileWriter() throws IOException {
		FileWriter fw = new FileWriter("1.txt");
		fw.write("你好");
		fw.close();
		
	}

}
