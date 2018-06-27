package cn.itcast.day25.gui.awt;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrameDemo {

	public static void main(String[] args) {
		Frame f = new Frame("哈哈哈哈");
		f.setSize(1500, 1000);
		f.setLocation(600, 400);
		f.setLayout(new FlowLayout());
		
		f.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			
		});
		
		Button but = new Button("close");
		but.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		f.add(but);
		
		f.setVisible(true);

	}

}
