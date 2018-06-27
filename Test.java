package cn.itcast.day24.io.encode;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class Test {
	/*
	 * 需求:定义一个方法,按照最大的字节数来取子串 说明: java中字符串"abcd"和"ab你好"的长度一样,都是四个字符
	 * 但对应的字节数不同,因为一个汉字占两个字节 例:对于"ab你好" 取三个字节应舍弃"你"的半个,为"ab"; 取四个字节则不舍弃,为"ab你";
	 * 取五个字节舍弃半个"好",仍为"ab你".
	 */
	public static void main(String[] args) throws IOException {
		String str = "ab你好c哈";
		
		for(int len=1; len<=str.getBytes("GBK").length; len++) {
			String s1 = cutStringByByte(str,len,"GBK");
			System.out.println("截取"+len+"个字节结果是:"+s1);
		}
	}

	public static String cutStringByByte(String str,int len,String charseName) throws IOException {
		byte[] buf = str.getBytes(charseName);
		int count = 0;
		for(int x=len-1; x>=0; x--) {
			if(buf[x]<0) {
				count++;
			}
			else
				break;
		}
		if(count%2==0) {
			return new String(buf,0,len,charseName);
		}
		else
			return new String(buf,0,len-1,charseName);
	}
}




















