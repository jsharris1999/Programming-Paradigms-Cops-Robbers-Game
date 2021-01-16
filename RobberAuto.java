/*
Jared Harris
October 22th, 2019
A program that creates a cop car based on the auto class.
*/

import java.io.PrintWriter;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class RobberAuto extends Auto
{
	private int xRatio;
	private int yRatio;
	private boolean Captured = false;
	private boolean Escaped = false;
	private static int NumberCaptured = 0;
	private static int NumberEscaped = 0;
	
	public RobberAuto()
	{
		super("Robber Car", 50000, "red-auto.jpg");
		Random Number = new Random();
		xRatio = (Number.nextInt() % 6);
		yRatio = (Number.nextInt() % 6);
		fillUp();
	}
	
	public void updateImage(Graphics g) 
	{
		super.updateImage(g);
	}
	
	public void updateState(int Height, int Width)
	{
		if(Captured == false)
		{
			drive(4, xRatio, yRatio);
			if(getX() < 0 || getX() > Width || getY() < 0 || getY() > Height)
			{
				if(Escaped == false)
				{
					NumberEscaped++;
				}
				Escaped = true;
			}
		}
	}
	
	public void captured()
	{
		setImage("jail.jpg");
		Captured = true;
		NumberCaptured++;
	}
	
	public void UndoCapture()
	{
		setImage("red-auto.jpg");
		Captured = false;
	}
	
	public boolean isCaptured()
	{
		return Captured;
	}
	
	public boolean hasEscaped()
	{
		return Escaped;
	}
	
	public static int TotalCaptured()
	{
		return NumberCaptured;
	}
	
	public static int TotalEscaped()
	{
		return NumberEscaped;
	}
	
	public static void ResetCaptured()
	{
		NumberCaptured = 0;
	}
	
	public static void ResetEscaped()
	{
		NumberEscaped = 0;
	}
}