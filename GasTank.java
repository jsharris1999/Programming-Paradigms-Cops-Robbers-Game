/*
Jared Harris
October 22th, 2019
A program that simulates a car's gas tank.
*/

import java.io.PrintWriter;

public class GasTank
{
	private double MaxCapaity;
	private double CurrentLevel;
	
	public GasTank(double MaxCapaity)
	{
		if(MaxCapaity >= 0)
		{
			this.MaxCapaity = MaxCapaity;
		}
		else
		{
			this.MaxCapaity = 0;
		}
		CurrentLevel = 0;
	}
	
	public double getCapacity()
	{
		return MaxCapaity;
	}
	
	public double getLevel()
	{
		return CurrentLevel;
	}
	
	public void setLevel(double levelIn)
	{
		if(levelIn >= MaxCapaity)
		{
			this.CurrentLevel = this.MaxCapaity;
		}
		else if(levelIn < 0)
		{
			this.CurrentLevel = 0;
		}
		else
		{
			this.CurrentLevel = levelIn;
		}
	}
}
