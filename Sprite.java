/*
Jared Harris
October 22th, 2019
A program that handles the position of each car and draws them.
*/

import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;


class Sprite
{
	private String jpgName;
	private int XCoordinate;
	private int YCoordinate;
	private Image image;

	public Sprite(String jpgName)
	{
		setImage(jpgName);
		XCoordinate = 0;
		YCoordinate = 0;
	}
	
	public int getX() {	return XCoordinate; }
	public int getY() {	return YCoordinate; }
	public void setX(int x) { XCoordinate = x; }
	public void setY(int y) { YCoordinate = y; }
	
	public void setImage(String imagePath) 
	{
        try 
		{
            image = ImageIO.read(new File(imagePath));
        } 
		catch (IOException ioe) 
		{
            System.out.println("Unable to load image file.");
        }
	}
	public Image getImage() { return image; }	
	
	public void updateImage(Graphics g) 
	{
		g.drawImage(getImage(), getX(), getY(), 60, 60, null);
	}
	
	public void updateState(int Height, int Width)
	{
		
	}
	
	public boolean overlaps(Sprite s)
	{
		int xCheck1 = Math.abs(s.getX()-getX());
		int yCheck1 = Math.abs(s.getY()-getY());
		int xCheck2 = Math.abs(getX()-s.getX());
		int yCheck2 = Math.abs(getY()-s.getY());
		if(xCheck1 <= 60 && yCheck1 <= 60 && xCheck2 <= 60 && yCheck2 <= 60)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}