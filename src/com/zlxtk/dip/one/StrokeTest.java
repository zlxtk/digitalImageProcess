package com.zlxtk.dip.one;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class StrokeTest extends JPanel {

	@Override
	protected void paintComponent(Graphics arg0) {
		// TODO Auto-generated method stub
		Graphics2D g2d = (Graphics2D) arg0;
		// 创建stroke实例
		float[] dash = { 10.0f, 5.0f, 3.0f };
		Stroke stroke = new BasicStroke(2.0f, BasicStroke.CAP_SQUARE,
				BasicStroke.JOIN_MITER, 10.0f, dash, 10);// 参数分别为：宽度，结束方式，连接方式，线段长度，点线模式，声明位移

		// 设置stroke对象的引用
		g2d.setStroke(stroke);

		// 创建形状
		Shape rect2D = new RoundRectangle2D.Double(50, 50, 300, 100, 10, 10);
		g2d.draw(rect2D);

		g2d.dispose();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame j = new JFrame();
		StrokeTest gt = new StrokeTest();
		j.add(gt);
		j.setSize(500, 500);
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j.setVisible(true);
	}

}
