/**
 * Name:	Bekabil Tolassa
 * Class:	ICS 440
 * Date:	January 22, 2016
 * Instructor: Paul Hyde
 * Program: This program is written and provide by my instructor
 */
package com.abc.draw;

import java.awt.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class DrawingComponent extends JComponent {
	private Drawing drawing;

	public DrawingComponent(Drawing drawing) {
		this.drawing = drawing;
	}

	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;

		g2.setPaint(Color.YELLOW);
		Dimension size = getSize();
		g2.fillRect(0, 0, size.width, size.height);

		g2.setPaint(Color.BLUE);
		drawing.drawAll(g2);
	}
}
