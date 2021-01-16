/*
Jared Harris
October 22th, 2019
A program that simulates a car engine.
*/

import java.io.PrintWriter;

public class Engine
{
	private String Description;
	private int MPG;
	private int MaxSpeed;
	
	public Engine(String Description, int MPG, int MaxSpeed)
	{
		if(Description.length() > 0)
		{
			this.Description = Description;
		}
		else
		{
			this.Description = "Generic engine";
		}
		if(MPG >= 0)
		{
			this.MPG = MPG;
		}
		else
		{
			this.MPG = 0;
		}
		if(MaxSpeed >= 0)
		{
			this.MaxSpeed = MaxSpeed;
		}
		else
		{
			this.MaxSpeed = 0;
		}
	}
	
	public int getMPG()
	{
		return MPG;
	}
	
	public int getMaxSpeed()
	{
		return MaxSpeed;
	}
	
	public String getDescription()
	{
		String MPGString = "MPG: " + MPG;
		String MaxSpeedString = "Max Speed: " + MaxSpeed;
		String ReturnString = Description + " (" + MPGString + ", " + MaxSpeedString + ")";
		return ReturnString;
	}
}
