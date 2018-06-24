package cn.itcast.day22.io.file.demo;

import java.io.File;
import java.text.DateFormat;
import java.util.Date;

public class FileDemo {
	public static void main(String[] args) {
		File f = new File("1.txt");
		String name = f.getName();
		long time = f.lastModified();
		
		System.out.println("name:"+name);
		System.out.println("time:"+time);
		
		Date d = new Date(time);
		DateFormat df = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG);
		String str_time = df.format(d);
		System.out.println("str_time:"+str_time);
	}
}




