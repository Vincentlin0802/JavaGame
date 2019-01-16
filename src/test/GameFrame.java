package test;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;



/**
 * 游戏基本知识测试类
 * @author linshixuan
 *
 */
public class GameFrame  extends Frame{		//GUI编程：AWT,swing等
	
	Image img = GameUtil.getImage("timg4.jpg");
	
	
	
	/**
	 * 加载窗口
	 */
	public void launchFrame() {
		setSize(500,500);
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
	

	private double x=100,y=100;
	private double degree=3.14/3;	//[0,2pi]
	private double speed = 10;
	
	@Override
	public void paint(Graphics g) {
		g.drawImage(img, (int)x, (int)y, null);
		
		if(speed > 0) {
			speed -= 0.02;
		}else {
			speed = 0;
		}
		
		x += speed*Math.cos(degree);
		y += speed*Math.sin(degree);
		if(y>500-40||y<30) {
			degree = -degree;
		}
		if(x<0||x>500-40) {
			degree = Math.PI-degree;
		}
	}
		
		
		
		
		
		
		/*g.drawLine(100, 100, 200, 200);
		g.drawRect(100, 100, 200, 200);
		g.drawOval(100, 100, 200, 200);
		
		
		
		
		Font f = new Font("宋体",Font.BOLD,100);
		g.setFont(f);
		
		g.drawString("Vincent", 200, 200);
		Color c = g.getColor();
		g.setColor(Color.red);
		g.fillRect(100, 100, 20, 20);
		g.fillOval(300, 300, 20, 20);
		g.setColor(c);
	
	
		g.drawImage(img, (int)x,(int) y, null);
		x+=3;
		y+=3;
	}
*/
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



	
	public static void main(String[] args) {
		GameFrame gf = new GameFrame();
		gf.launchFrame();
	
	
	}


}
