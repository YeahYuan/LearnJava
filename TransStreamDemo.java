package cn.itcast.day22.io.transstream.demo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class TransStreamDemo {

	public static void main(String[] args) throws IOException {
		//读取键盘输入字节,并将字母转换成大写,输入over时退出
		//简单方法
		//使用readline()
//		InputStream in = System.in;
//		InputStreamReader isr = new InputStreamReader(in);
//		BufferedReader bufr = new BufferedReader(isr);
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		
//		OutputStream out = System.out;
//		OutputStreamWriter osw = new OutputStreamWriter(out);
//		BufferedWriter bufw = new BufferedWriter(osw);
		BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String line =null;
		while((line=bufr.readLine())!=null) {
			if(line.equals("over"))
				break;
			bufw.write(line.toUpperCase());
			bufw.newLine();
			bufw.flush();
		}

	}

}
