package cn.itcast.day23.io.sequence;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

public class SequenceInputStreamDemo {

	public static void main(String[] args) throws IOException {
		/*
		 * Vector<InputStream> v = new Vector<InputStream>(); v.add(new
		 * FileInputStream("1.txt")); v.add(new FileInputStream("2.txt")); v.add(new
		 * FileInputStream("3.txt"));
		 * 
		 * Enumeration<InputStream> en = v.elements();
		 */

		ArrayList<InputStream> al = new ArrayList<InputStream>();
		for (int i = 1; i <= 3; i++) {
			al.add(new FileInputStream(i + ".txt"));
		}
		Enumeration<InputStream> en = Collections.enumeration(al);
		/*
		 * final Iterator<InputStream> it = al.iterator(); Enumeration<InputStream> en =
		 * new Enumeration<InputStream>() {
		 * 
		 * @Override public boolean hasMoreElements() { return it.hasNext(); }
		 * 
		 * @Override public InputStream nextElement() { return it.next(); } };
		 */

		SequenceInputStream sis = new SequenceInputStream(en);

		FileOutputStream fos = new FileOutputStream("4.txt");

		byte[] buf = new byte[1024];
		int len = 0;
		while ((len = sis.read(buf)) != -1) {
			fos.write(buf, 0, len);
			;
			fos.flush();
		}
		fos.close();
		sis.close();

	}

}
