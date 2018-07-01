package cn.itcast.day26.net.chat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Receive implements Runnable {

	private DatagramSocket ds;
	
	public Receive(DatagramSocket ds) {
		this.ds = ds;
	}
	@Override
	public void run() {
		System.out.println("接收端开启.....");
		while(true) {
			byte[] buf = new byte[1024];
			DatagramPacket dp = new DatagramPacket(buf, buf.length);
		
			try {
				ds.receive(dp);
			} catch (Exception e) {
			}
		
			String ip = dp.getAddress().getHostName();
			int port = dp.getPort();
			String data = new String(dp.getData(),0,dp.getLength());
			System.out.println(ip+"--"+port+"--"+data);
			
			if(data.equals("886")) {
					System.out.println(ip+"退出聊天室");
			}
		
			//ds.close();

		}
	}

}
















