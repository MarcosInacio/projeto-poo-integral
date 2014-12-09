package com.ufrpe.integrais.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {
/*
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		
		frame.add(new Surface());
		
		frame.setTitle("Projeto de Introdução à Programação II - UFRPE - 2014.2");
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
	}/*/
}

class Surface extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setPaint(Color.white);
		g2.fill(new Rectangle2D.Double(0, 0, 800, 600));
		g2.drawRect(0, 0, 800, 600);
		
		g2.setColor(Color.black);
		g2.drawLine(0, 300, 800, 300);
		g2.drawLine(400, 0, 400, 600);
		g2.setColor(Color.red);
		
		double j = 0;
		int x = 8;
		double startX = 0;
		Queue<Double> points = new LinkedList<Double>();
		for (double i = -x; i < x; i += 0.002) {
			double y = function(i);
			points.add(y);
			g2.draw(new Line2D.Double(startX + j, 300 - y, startX + j, 300 - y));
			//g2.draw(new Line2D.Double(startX - j, 300 - y, startX - j, 300 - y));
			
			j += 0.1;
		}

		g2.setColor(Color.blue);
		double k = 1;
		double area = 0;
				
		for (double i = -x; i < x; i += 0.002) {
			double y = function(i);
			
			if (y >= 0) {
				g2.draw(new Rectangle2D.Double((int)startX + (k), 300 - y, 1, y));
			} else {
				g2.draw(new Rectangle2D.Double((int)startX + (k), 300, 1, -y));
			}
			
			area += Math.abs(y / 50);
			k+= 0.1;
		}
		
		g2.drawString("Área: " + area, 10, 20);
	}
	
	private double function(double x) {
		return (Math.cos(x)) * 60;
	}
}