package com.zlxtk.dip.one;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.color.ColorSpace;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ByteLookupTable;
import java.awt.image.ColorConvertOp;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.awt.image.LookupOp;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class filterTest extends JPanel {

	BufferedImage image = null;

	public filterTest() {
		// TODO Auto-generated constructor stub
		try {
			URL url = this.getClass().getResource("lena.jpg");
			image = ImageIO.read(url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		Graphics2D g2d = (Graphics2D) g;
		// 灰度调节
//		ColorConvertOp co = new ColorConvertOp(
//				ColorSpace.getInstance(ColorSpace.CS_GRAY), null);
//		image = co.filter(image, null);
//
		
		// 黑白调节,需先变为灰度图像
//		byte[] threshold=new byte[256];
//		for (int i = 0; i < 256; i++) {
//			threshold[i]=(i<128)?(byte)0:(byte)255;
//		}
//		BufferedImageOp lo=new LookupOp(new ByteLookupTable(0, threshold), null);
//		image=lo.filter(image, null);
		
		//模糊
		float ninth=1.0f/9.0f;
		float[] bk={ninth,ninth,ninth,
				ninth,ninth,ninth,
				ninth,ninth,ninth};
		BufferedImageOp cf=new ConvolveOp(new Kernel(3, 3, bk));
		image=cf.filter(image, null);
		
		//缩放
		double sx=0.5;
		double sy=0.5;
		AffineTransformOp ao=new AffineTransformOp(AffineTransform.getScaleInstance(sx, sy), AffineTransformOp.TYPE_BILINEAR);
		int nw=(int)(image.getWidth()*sx);//缩放后图像的宽高
		int nh=(int)(image.getHeight()*sy);
		BufferedImage result=new BufferedImage(nw,nh,BufferedImage.TYPE_3BYTE_BGR);
		//实现缩放
		image=ao.filter(image, result);
		
		// 画出图
		g2d.drawImage(image, image.getWidth() + 10, 0, image.getWidth(),
				image.getHeight(), null);
		
//		this.repaint();//刷新，重新绘制

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame j = new JFrame();
		filterTest gt = new filterTest();
		j.add(gt);
		j.setSize(500, 500);
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j.setVisible(true);
	}

}
