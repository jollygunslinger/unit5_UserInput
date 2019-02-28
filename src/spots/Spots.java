package spots;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;


public class Spots extends JFrame 
		implements MouseListener{
	Point clickPoint = new Point(-1,-1);
	int radius = 7;
	
	public Spots(String name)
	{
		super(name);
		setSize(800,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//Our JFrame is a Component. We want to register it to
		//fire MouseEvents according to the MouseListener interface
		//The class which will handle this interface in the JFrame itself
		//This implies that our JFrame must implement the MouseListener interface
		
		addMouseListener(this);
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
		Color color = new Color(1.0f, 0.0f, 0.0f);
		
		if (clickPoint.x >= 0) 
		{
			g.setColor(color);
			g.fillOval(clickPoint.x, clickPoint.y, 2*radius, 2*radius);
		}
	}
	
	public void mousePressed(MouseEvent e)
	{
		clickPoint.x = e.getX();
		clickPoint.y = e.getY();
		//Note that nothing happens unless I tell Java to repaint my screen
		repaint();
	}
	public void mouseClicked(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	
	public static void main(String[] args)
	{
		Spots spots = new Spots("My Spots Program");
		spots.setVisible(true);
	} //end of main

}
