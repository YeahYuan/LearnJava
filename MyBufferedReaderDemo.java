package cn.itcast.day21.io.charstream.mybuffer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MyBufferedReaderDemo {

	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("IO_2.txt");
		MyBufferedReader bufr = new MyBufferedReader(fr);
		
		String line =null;
		while((line=bufr.myReadLine())!=null) {
			System.out.println(line);
		}
		bufr.myClose();

	}

}










