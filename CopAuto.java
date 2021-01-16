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

public class CopAuto extends Auto
{
	private static int xRatio;
	private static int yRatio;
	private int NegativeX = xRatio * -1;
	private int NegativeY = yRatio * -1;
	private boolean xSignal = false;
	private boolean ySignal = false;
	
	public CopAuto()
	{
		super("Cop Car", 50000, "cop-auto.jpg");
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
		int UsedXRatio = xRatio;
		int UsedYRatio = yRatio;
		NegativeX = xRatio * -1;
		NegativeY = yRatio * -1;
		if(xSignal == false && ySignal == false)
		{
			if(getX() < 0 || getX() + 60 >= Width)
			{
				xSignal = true;
			}
			if(getY() < 0 || getY() + 60 >= Height)
			{
				ySignal = true;
			}
		}
		else
		{
			if(xSignal == true && ySignal == false)
			{
				if(getX() < 0 || getX() + 60 >= Width)
				{
					xSignal = false;
				}
				if(getY() < 0 || getY() + 60 >= Height)
				{
					ySignal = true;
				}
			}
			else if(xSignal == false && ySignal == true)
			{
				if(getX() < 0 || getX() + 60 >= Width)
				{
					xSignal = true;
				}
				if(getY() < 0 || getY() + 60 >= Height)
				{
					ySignal = false;
				}
			}
			else if(xSignal == true && ySignal == true)
			{
				if(getX() < 0 || getX() + 60 >= Width)
				{
					xSignal = false;
				}
				if(getY() < 0 || getY() + 60 >= Height)
				{
					ySignal = false;
				}
			}
		}
		if(xSignal == true)
		{
			UsedXRatio = NegativeX;
		}
		if(ySignal == true)
		{
			UsedYRatio = NegativeY;
		}
		drive(2, UsedXRatio, UsedYRatio);
	}
}
