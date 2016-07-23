/**
 * Name:	Bekabil Tolassa
 * Class:	ICS 440
 * Date:	January 22, 2016
 * Instructor: Paul Hyde
 * Program: This program is written to create and draw a Rectangle object
 */
package com.abc.draw.geometry;

import java.awt.Graphics2D;

import com.abc.draw.Drawable;

//class Rectangle implements Drawable interface
public class Rectangle implements Drawable {
	Point upperLeft;
	double width;
	double height;

	/**
	 * Constructor Rectangle()
	 * 
	 * @param upperLeft
	 * @param width
	 * @param height
	 */
	public Rectangle(Point upperLeft, double width, double height) {
		this.upperLeft = upperLeft;
		this.width = width;
		this.height = height;
	}

	/**
	 * method getUpperLeft()
	 * 
	 * @return upperLeft
	 */
	public Point getUpperLeft() {
		return upperLeft;
	}

	/**
	 * method getWidth()
	 * 
	 * @return width
	 */

	public double getWidth() {
		return width;
	}

	/**
	 * method getHeight()
	 * 
	 * @return height
	 */
	public double getHeight() {
		return height;
	}

	/**
	 * method setWidth()
	 * 
	 * @param width
	 */
	public void setWidth(double width) {
		this.width = width;
	}

	/**
	 * method setHeight()
	 * 
	 * @param height
	 */
	public void setHeight(double height) {
		this.height = height;
	}

	/**
	 * method draw()
	 * 
	 * @param g2
	 */
	@Override
	public void draw(Graphics2D g2) {
		int upperLeftX = (int) Math.round(upperLeft.getX());
		int upperLeftY = (int) Math.round(upperLeft.getY());
		int w = (int) Math.round(width);
		int h = (int) Math.round(height);
		// invoke method drawRect() on g2
		g2.drawRect(upperLeftX, upperLeftY, w, h);

	}
}
