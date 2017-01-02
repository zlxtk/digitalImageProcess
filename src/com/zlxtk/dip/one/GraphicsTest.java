package com.zlxtk.dip.one;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphicsTest extends JPanel {

	/**
	 * 通过继承JPanel类，重载该方法，显示时swing会首先调用paint()方法，paint()方法会调用该方法
	 */
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		Graphics2D g2d = (Graphics2D) g;
//		g2d.setColor(Color.RED);// 设置颜色
//		g2d.drawRect(50, 50, 300, 300);// 在(50，50)坐标画一个宽500，高500的矩形
//		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
//				RenderingHints.VALUE_ANTIALIAS_ON);// 设置反锯齿
//		g2d.setPaint(Color.BLUE);// 设置画笔颜色
//		g2d.drawRoundRect(50, 50, 30, 30, 20, 20);// 在(50,50)坐标绘制宽高为30，角半径为20的圆角矩形

		
		float[] dash = { 10.0f, 5.0f, 3.0f };
		Stroke stroke = new BasicStroke(2.0f, BasicStroke.CAP_SQUARE,
				BasicStroke.JOIN_MITER, 10.0f, dash, 10);// 参数分别为：宽度，结束方式，连接方式，线段长度，点线模式，声明位移
		// 设置stroke对象的引用
		g2d.setStroke(stroke);
		Shape rect2D = new RoundRectangle2D.Double(50, 50, 300, 100, 10, 10);
		g2d.draw(rect2D);
		

		g2d.dispose();// 释放资源
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame j = new JFrame();
		GraphicsTest gt = new GraphicsTest();
		j.add(gt);
		j.setSize(500, 500);
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j.setVisible(true);
	}

}
