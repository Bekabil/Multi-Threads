/**
 * Name:	Bekabil Tolassa
 * Class:	ICS 440
 * Date:	January 22, 2016
 * Instructor: Paul Hyde
 * Program: This program is written to create and draw a Triangle object
 */
package com.abc.draw.geometry;

import java.awt.Graphics2D;

import com.abc.draw.Drawable;

//class Triangle implements Drawable interface
public class Triangle implements Drawable {
	private Point p1;
	private Point p2;
	private Point p3;

	/**
	 * Constructor Triangle
	 * 
	 * @param p1
	 * @param p2
	 * @param p3
	 */
	public Triangle(Point p1, Point p2, Point p3) {
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
	}

	/**
	 * method getP1()
	 * 
	 * @return p1
	 */
	public Point getP1() {
		return p1;
	}

	/**
	 * method getP2()
	 * 
	 * @return p2
	 */
	public Point getP2() {
		return p2;
	}

	/**
	 * method getP3()
	 * 
	 * @return p3
	 */
	public Point getP3() {
		return p3;
	}

	/**
	 * method draw()
	 * 
	 * @param g2
	 */
	@Override
	public void draw(Graphics2D g) {
		int x1 = (int) Math.round(p1.getX());
		int y1 = (int) Math.round(p1.getY());
		int x2 = (int) Math.round(p2.getX());
		int y2 = (int) Math.round(p2.getY());

		int k1 = (int) Math.round(p1.getX());
		int z1 = (int) Math.round(p1.getY());
		int k2 = (int) Math.round(p3.getX());
		int z2 = (int) Math.round(p3.getY());

		int i1 = (int) Math.round(p3.getX());
		int j1 = (int) Math.round(p3.getY());
		int i2 = (int) Math.round(p2.getX());
		int j2 = (int) Math.round(p2.getY());
		// invokes method drawLine() three times to form a triangle
		g.drawLine(x1, y1, x2, y2);
		g.drawLine(k1, z1, k2, z2);
		g.drawLine(i1, j1, i2, j2);

	}

}
