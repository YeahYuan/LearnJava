package cn.itcast.day26.net.chat;

import java.io.IOException;
import java.net.DatagramSocket;

public class ChatDemo {

	public static void main(String[] args) throws IOException {
		
		new Thread(new Send(new DatagramSocket())).start();
		new Thread(new Receive(new DatagramSocket(10000))).start();

	}

}
