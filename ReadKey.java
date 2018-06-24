package cn.itcast.day22.io.transstream.demo;

import java.io.IOException;
import java.io.InputStream;

public class ReadKey {

	public static void main(String[] args) throws IOException {
		//读取键盘输入字节,并将字母转换成大写,输入over时退出
		readKey();

	}
//用数组,一次读取1024个字节 超级麻烦😭😭
	public static void readKey2() throws IOException {
		InputStream in = System.in;
		byte[] b = new byte[1024];
		char[] c =new char[1024];
		int len = 0;
		String temp = null;
		while((len=in.read(b))!=-1) {
			for(int i = 0;i<b.length;i++) {
				if(b[i]==(byte)'\r') 
					continue;
				if(b[i]==(byte)'\n') {
					temp = temp.valueOf(c,0,i-1);	
					for(int j=0;j<1024;j++) {
						b[i]=0;
						c[i]=0;
					}
					if(temp.equals("over"))
						return;
					System.out.println(temp.toUpperCase());
				}
				else {				
					c[i]=(char)b[i];
				}
			}
		}
		
	}

//使用数组做容器(一次读取一个)
	public static void readKey1() throws IOException {
		InputStream in = System.in;
		char[] c = new char[1024];
		int pos = 0;
		int ch = 0;
		String temp = null;
		while((ch=in.read())!=-1) {
			if(ch==(int)'\r') 
				continue;
			if(ch==(int)'\n') {
				temp = temp.valueOf(c, 0, pos);
				pos=0;
				
				if(temp.equals("over"))
					break;
				System.out.println(temp.toUpperCase());
			}
			else {				
				c[pos]=(char)ch;
				pos++;
			}
		}
		
	}
	
	
	
	
	
	
	
//使用StringBuilder
	public static void readKey() throws IOException {
		InputStream in = System.in;
		StringBuilder sb = new StringBuilder();
		int ch = 0;
		while((ch=in.read())!=-1) {
			if(ch==(int)'\r') 
				continue;
			if(ch==(int)'\n') {
				String temp = sb.toString();
				sb.delete(0, sb.length());
				if("over".equals(temp)) {
					break;
				}
				System.out.println(temp.toUpperCase());
			}
			else
				sb.append((char)ch);
		}
	
	}

}













