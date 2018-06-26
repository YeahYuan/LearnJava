package cn.itcast.day23.io.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest {
	/*
	 * 练习
	 * 定义功能,获取一个应用程序运行的次数,如果超过五次,给出使用次数已到,请注册的提示,并不要再运行程序
	 * 思路:
	 * 1.应该有计数器
	 * 2.计数器要存储在硬盘文件中,生命周期变长
	 * 3.程序启动时先读取硬盘上的文件,获取上次计数器次数,判断,自增,重新写入文件
	 * 4.映射关系---map;读取写入硬盘--io;map+io = properties;
	 */
	public static void main(String[] args) throws IOException {
		getSppCount();
	}

	private static void getSppCount() throws IOException {
		File confile = new File("count.properties");
		if(!confile.exists()) {
			confile.createNewFile();
		}
		FileInputStream fis = new FileInputStream(confile);
		Properties prop = new Properties();
		prop.load(fis);
		int count = 0;
		String value = prop.getProperty("count");
		if(value!=null) {
			count = Integer.parseInt(value);
			if(count >=5) {
				throw new RuntimeException("超过使用次数,请注册!");
			}
		}
		count++;
		prop.setProperty("count", count+"");
		System.out.println("使用次数:"+count);
		FileOutputStream fos = new FileOutputStream(confile);
		prop.store(fos, null);
		
		fis.close();
		fos.close();
	}
}













