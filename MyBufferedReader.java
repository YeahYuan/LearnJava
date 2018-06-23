package cn.itcast.day21.io.charstream.mybuffer;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class MyBufferedReader extends Reader {
	
	private Reader r;
	
	//1.定义一个数组作为缓冲区
	private char[] buf = new char[1024];
	
	//2.定义一个指针用于操作数组中的元素,当操作到最后一个元素后,指针归零
	private int pos = 0;
	
	//3.定义一个计数器记录缓冲区中的数据个数,当数据减到0,就从源中继续获取数据
	private int count = 0;
	
	MyBufferedReader(Reader r){
		this.r =r;
	}
	
	public int myRead() throws IOException {
		if(count==0) {
			count = r.read(buf);
			pos = 0;
		}
		if(count<0)
			return -1;
		char ch = buf[pos];
		pos++;
		count--;
		return (int)ch;
	}
	
	public String myReadLine() throws IOException {
		StringBuilder sb = new StringBuilder();
		
		int ch = 0;
		
		while((ch = myRead())!=-1) {
			if(ch=='\r')
				continue;
			if(ch=='\n')
				return sb.toString();
			
			sb.append((char)ch);
		}
		if((sb.length())!=0)
			return sb.toString();
		return null;
	}

	public void myClose() throws IOException {
		r.close();
	}

	@Override
	public int read(char[] cbuf, int off, int len) throws IOException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void close() throws IOException {
		// TODO Auto-generated method stub
		
	}
}



















