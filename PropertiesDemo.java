package cn.itcast.day22.io.properties;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class PropertiesDemo {

	public static void main(String[] args) throws IOException {
		/*
		 * Properties prop = System.getProperties(); File file = new
		 * File("properties.txt"); FileWriter fw = new FileWriter(file); prop.store(fw,
		 * null);
		 */

		// 需求:修改硬盘中的配置文件信息
		File file = new File("properties.txt");
		if(!file.exists()) {
			file.createNewFile();
		}
		FileReader fr = new FileReader(file);
		Properties prop = new Properties();
		prop.load(fr);

		prop.setProperty("yuaner", "18");

		prop.list(System.out);

		FileWriter fw = new FileWriter(file);
		prop.store(fw, null);
		
		fr.close();
		fw.close();
	}

}
