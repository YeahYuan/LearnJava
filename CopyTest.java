package cn.itcast.day21.io.charstream.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * 需求:将C盘的一个文本文件复制到D盘
 * 思路:
 * 1.需要读取源数据
 * 2.将读取到的源数据写入到目的地
 * 3.操作文本数据-->字符流
 */
public class CopyTest {

	public static void main(String[] args) throws IOException {
		
		copy1();
		copy2();
		copy3();//用Buffer
		copy4();//用buffer的特有方法line

	}

	private static void copy4() throws IOException {
		FileReader fr = new FileReader("IO_2.txt");
		BufferedReader bufr = new BufferedReader(fr);
		
		FileWriter fw = new FileWriter("copytext_4.txt");
		BufferedWriter bufw = new BufferedWriter(fw);
		
		String line =null;
		while((line=bufr.readLine())!=null) {
			bufw.write(line);
			bufw.newLine();
			bufw.flush();
		}
		bufr.close();
		bufw.close();
	}

	private static void copy3() throws IOException {
		FileReader fr = new FileReader("IO_2.txt");
		BufferedReader bufr = new BufferedReader(fr);
		
		FileWriter fw = new FileWriter("copytext_3.txt");
		BufferedWriter bufw = new BufferedWriter(fw);
		
		int ch =0;
		while((ch = bufr.read())!=-1) {
			bufw.write(ch);
			bufw.flush();
		}
		bufr.close();
		bufw.close();
		
	}

	private static void copy2() {
		FileReader fr = null;
		FileWriter fw = null;
		
		try {
			fr = new FileReader("IO_2.txt");
			fw = new FileWriter("copytext_2.txt");
			char[] buf = new char[1024];
			int len =0;
			while((len=fr.read(buf))!=-1) {
				fw.write(buf, 0, len);;
				}	
		} catch (Exception e) {
			throw new RuntimeException("读写失败");
		}
		finally {
			if(fr!=null){
				try {
					fr.close();
				} catch (IOException e) {
					throw new RuntimeException("关闭失败");
				}
			}
			if(fw!=null){
				try {
					fw.close();
				} catch (IOException e) {
					throw new RuntimeException("关闭失败");
				}
			}
		}
		
		
		
	}

	private static void copy1() throws FileNotFoundException, IOException {
		//1.读取一个已有的文本文件,使用字符流对象和文件相关联
		FileReader fr = new FileReader("IO_2.txt");
		//2.创建一个目的地,用于存储读到的数据
		FileWriter fw = new FileWriter("copytext_1.txt");
		//3.频繁的读写操作
		int ch = 0;
		while((ch=fr.read())!=-1) {
			fw.write(ch);
		}
		//4.关闭流资源
		fw.close();
		fr.close();
	}

}





















