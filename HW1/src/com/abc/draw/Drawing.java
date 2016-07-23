/**
 * Name:	Bekabil Tolassa
 * Class:	ICS 440
 * Date:	January 22, 2016
 * Instructor: Paul Hyde
 * Program: The base of this program is written by my instructor and completed by me.
 */
package com.abc.draw;

import java.awt.*;
import java.util.ArrayList;

public class Drawing extends Object {

	private ArrayList<Drawable> listOfFigures = new ArrayList<Drawable>();

	/**
	 * no argument constructor Drawing()
	 */
	public Drawing() {

	}

	/**
	 * Constructor Drawing()
	 * 
	 * @param figure
	 */
	public Drawing(ArrayList<Drawable> figure) {

		for (int i = 0; i < figure.size(); i++) {
			this.listOfFigures.add((Drawable) figure);
		}
	}

	/**
	 * method append()
	 * 
	 * @param drawable
	 */
	public void append(Drawable drawable) {
		// Drawable object is added to the list of items that makes up this
		// Drawing.
		listOfFigures.add(drawable);

	}

	/**
	 * method drawAll()
	 * 
	 * @param g2
	 */
	public void drawAll(Graphics2D g2) {
		// Invokes draw(Graphics2D) on each of the Drawable's that have been
		// added via append(Drawable).
		for (int i = 0; i < listOfFigures.size(); i++) {
			listOfFigures.get(i).draw(g2);
		}

	}

}
