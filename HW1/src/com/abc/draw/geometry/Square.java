/**
 * Name:	Bekabil Tolassa
 * Class:	ICS 440
 * Date:	January 22, 2016
 * Instructor: Paul Hyde
 * Program: This program is written to create and draw a Square object
 */
package com.abc.draw.geometry;
import java.awt.Graphics2D;

import com.abc.draw.Drawable;

//class Square implements Drawable interface
public class Square implements Drawable {
	private Point upperLeft;
	private double width;
	/**
	 * constructor Square
	 * @param upperLeft
	 * @param width
	 */
	public Square(Point upperLeft, double width){
		this.upperLeft = upperLeft;
		this.width = width;
	}
	/**
	 * method getUpperLeft()
	 * @return upperLeft
	 */
	public Point getUpperLeft(){
		return upperLeft;
	}
	/**
	 * method getWidth()
	 * @return width
	 */
	public double getWidth(){
		return width;
	}
	/**
	 * method setWidth()
	 * @param width
	 */
	public void setWidth(double width){
		this.width = width;
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
		//invoke method drawRect() on g2
		g2.drawRect(upperLeftX, upperLeftY, w, w);
	    
		
	}
}

