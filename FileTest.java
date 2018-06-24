package cn.itcast.day22.io.file.test;

import java.io.File;

public class FileTest {

	public static void main(String[] args) {
		File dir = new File("C:\\Users\\lll\\Desktop\\itcast");
		listAll(dir,0);//深度遍历文件夹
		deleteAll(dir);//删除整个目录文件夹
	}

	public static void deleteAll(File dir) {
		File[] files = dir.listFiles();
		for(File file:files) {
			if(file.isDirectory()) {
				deleteAll(file);
			}
			else
				System.out.println(file.getAbsolutePath()+"delete:"+file.delete());
		}
		dir.delete();
	}

	
	
	
	
	public static void listAll(File dir, int lever) {
		System.out.println(getSpace(lever)+"dir:"+dir.getName());
		lever++;
		File[] file = dir.listFiles();
		for(int x=0;x<file.length;x++) {
			if(file[x].isDirectory()) {
				listAll(file[x],lever);
			}
			else
				System.out.println(getSpace(lever)+"file:"+file[x].getName());
		}
		
	}

	private static String getSpace(int lever) {
		StringBuilder sb = new StringBuilder();
		sb.append("|---");
		for(int i=0;i<lever;i++) {
			sb.insert(0, "|   ");
		}
		return sb.toString();
	}

}
