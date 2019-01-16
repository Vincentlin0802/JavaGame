package test;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;



public class MyFrame extends Frame{
	
	
	
	/**
	 * 加载窗口
	 */
	public void launchFrame() {
		setSize(Constant.Game_Width,Constant.Game_Height);
		setLocation(100,100);
		setVisible(true);
	
		new PaintThread().start(); //启动重画线程
		
		addWindowListener(new WindowAdapter() {
 
		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
			
		});
			
		}
	/**
	 * 定义一个重画窗口的线程类，是一个内部类
	 * @author linshixuan
	 *
	 */
	class PaintThread extends Thread{
		
		public void run() {
		while(true) {
			repaint();
				try {
					Thread.sleep(40);//1s = 1000ms
				} catch (InterruptedException e) {
					e.printStackTrace();
				}	
			}
		}
	}

	
	
}
