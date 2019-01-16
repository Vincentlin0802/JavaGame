package test;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.imageio.ImageIO;


	public class ChangeSize {
		     
		    
		     public void main(String[] args) throws Exception {
		         //读取图片
		         BufferedInputStream in = new BufferedInputStream(new FileInputStream("/Users/linshixuan/Desktop/timg3.jpg"));
		         //字节流转图片对象
		         Image bi =ImageIO.read(in);
		         //获取图像的高度，宽度
		        int height=bi.getHeight(null);
		        int width =bi.getWidth(null);
		        //构建图片流
		        BufferedImage tag = new BufferedImage(width/2 , height/2 , BufferedImage.TYPE_INT_RGB);
		         //绘制改变尺寸后的图
		       tag.getGraphics().drawImage(bi, 0, 0,50 , 50 , null);  
		       //输出流
		        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("/Users/linshixuan/Desktop/timg4.jpg"));
	        //JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
	      //encoder.encode(tag);
        ImageIO.write(tag, "PNG",out);
	        in.close();
		        out.close();
		//转字节流
		//ByteArrayOutputStream out = new ByteArrayOutputStream();

		//ImageIO.write(tag, "PNG",out);
		//InputStream is = new ByteArrayInputStream(out.toByteArray());

		        }
		 }

