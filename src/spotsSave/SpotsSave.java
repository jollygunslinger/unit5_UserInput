package spotsSave;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import java.util.ArrayList;

//Class to save Spot Data
class Data
{
	int x,y;
	Color c;
	Data(int x, int y, Color cl)
	{
		this.x = x;
		this.y = y;
		c=cl;
	}
}

public class SpotsSave extends JFrame 
		implements MouseListener{
	
	int radius = 7;
	ArrayList<Data> arr = new ArrayList<Data>();
	
	public SpotsSave(String name)
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
		Dimension  d = getSize();
		Insets insets = getInsets();
		int left = insets.left;
		int right = insets.right;
		int top = insets.top;
		int bottom = insets.bottom;
		
		g.setColor(Color.yellow);
		g.fillRect(0, 0, d.width, d.height);
		
		g.setColor(Color.red);
		g.drawRect(left, top, d.width - 1 - left- right, d.height -1 -top - bottom); //draw boundary
		
		//Paint all spots
		for(int i=0; i <arr.size(); i++)
		{
			Data data = arr.get(i);
			g.setColor(data.c);
			g.fillOval(data.x - radius, data.y - radius, 2*radius, 2*radius);
		}
	}
	
	public void mousePressed(MouseEvent e)
	{
		int x = e.getX();
		int y = e.getY();
		
		Color color = new Color(
				(float)Math.random(), (float)Math.random(), (float)Math.random());
		Data d = new Data(x, y, color);
		
		//add a new Spot to the Data collection
		arr.add(d);
		
		//Note that nothing happens unless I tell Java to repaint my screen
		repaint();
	}
	public void mouseClicked(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	
	public static void main(String[] args)
	{
		SpotsSave spots = new SpotsSave("My Spots Program");
		spots.setVisible(true);
	} //end of main

}