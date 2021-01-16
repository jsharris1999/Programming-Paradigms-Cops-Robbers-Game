/*
Jared Harris
October 22th, 2019
A program that creates a bank based on the sprite class.
*/

import java.io.PrintWriter;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Bank extends Sprite
{	
	public Bank()
	{
		super("bank.png");
	}
	
	public void updateImage(Graphics g) 
	{
		setX(300);
		setY(300);
		super.updateImage(g);
	}
}