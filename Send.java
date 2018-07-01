package cn.itcast.day26.net.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Send implements Runnable {

	private DatagramSocket ds;
	
	public Send(DatagramSocket ds) {
		this.ds = ds;
	}

	@Override
	public void run() {
		System.out.println("发送端开启.....");
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		try {
			while((line=bufr.readLine())!=null) {
				byte[] buf = line.getBytes();
				DatagramPacket dp = 
						new DatagramPacket(buf, buf.length, 
								InetAddress.getByName("10.0.161.64"), 10000);
				ds.send(dp);
				if(line.equals("886"))
					break;
			}
			ds.close();
		} catch (Exception e) {
		}

	}

}

















