/*
Jared Harris
October 22th, 2019
A program that updates the locations of all of the cars using threads.
*/

import javax.swing.JFrame;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.event.*;

public class SpriteMover extends Thread implements Runnable
{
	Model model;
	View view;
	
	public SpriteMover(Model m, View v)
	{
		model = m;
		view = v;
	}
	
	public void run()
	{
		while(true)
		{
			model.updateScene(700, 1000);
			view.repaint();
			try
			{
				Thread.sleep(2);
			}
			catch(InterruptedException e){}
		}
	}
}