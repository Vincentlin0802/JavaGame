package test;

import java.awt.Graphics;
import java.awt.Image;



public class ball {
	Image img;
	 double x=100,y=100;;

	public void draw(Graphics g) {
		g.drawImage(img, (int)x,(int) y, null);
	
	}

	public ball(Image img,double x,double y) {
		this.img = img;
		this.x = x;
		this.y = y;
	}

	public ball(String imgpath ,double x,double y) {
		this.img = GameUtil.getImage(imgpath);
		this.x = x;
		this.y = y;
	}


	public double degree=3.14/3;	//[0,2pi]
	public double speed = 10;
	public void move() {
		
		if(speed > 0) {
			speed -= 0.02;
		}else {
			speed = 0;
		}
		
		x += speed*Math.cos(degree);
		y += speed*Math.sin(degree);
		if(y>500-40) {
			degree = -degree;
		}
		if(y<30) {
			degree = -degree;
		}
		if(x>500-40) {
			degree = Math.PI-degree;
		}
		if(x<0) {
			degree = Math.PI-degree;
		}
	}
}