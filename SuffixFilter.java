package cn.itcast.day23.io.splitfilemergefile;

import java.io.File;
import java.io.FilenameFilter;

public class SuffixFilter implements FilenameFilter {
	
	private String suffix;
	
	public SuffixFilter(String suffix) {
		super();
		this.suffix = suffix;
	}

	@Override
	public boolean accept(File dir, String name) {
		// TODO Auto-generated method stub
		return name.endsWith(suffix);
	}

}







