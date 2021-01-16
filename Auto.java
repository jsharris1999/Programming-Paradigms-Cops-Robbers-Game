/*
Jared Harris
October 22th, 2019
A program that simulates a car driving and calculates it's current location.
*/

import java.io.PrintWriter;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Auto extends Sprite
{
	private String CarDescription;
	private GasTank Tank;
	private Engine CarEngine;
	
	public Auto(String CarDescription, double MaxFuel, String AutoType)
	{
		super(AutoType);
		if(CarDescription.length() > 0)
		{
			this.CarDescription = CarDescription;
		}
		else
		{
			this.CarDescription = "Generic auto";
		}
		if(AutoType == "cop-auto.jpg")
		{
			Engine CopEngine = new Engine("Cop Engine", 30, 100);
			this.CarEngine = CopEngine;
		}
		else
		{
			Engine RobEngine = new Engine("Robber Engine", 20, 200);
			this.CarEngine = RobEngine;
		}
		if(MaxFuel >= 0)
		{
			this.Tank = new GasTank(MaxFuel);
		}
		else
		{
			this.Tank = new GasTank(0);
		}
	}
	
	public String getDescription()
	{
		String Fuel = String.format("fuel: %.2f", getFuelLevel());
		String ReturnString = CarDescription + " (engine: " + CarEngine.getDescription()
			+ "), " + Fuel + "/" + Tank.getCapacity() + ", location: (" +
			getX() + "," + getY() + ")";
		return ReturnString;
	}
	
	public double getFuelLevel()
	{
		double Fuel = Tank.getLevel();
		return Fuel;
	}
	
	public int getMPG()
	{
		int Miles = CarEngine.getMPG();
		return Miles;
	}
	
	public void fillUp()
	{
		Tank.setLevel(Tank.getCapacity());
	}
	
	public int getMaxSpeed()
	{
		int Speed = CarEngine.getMaxSpeed();
		return Speed;
	}
	
	public double drive(int distance, double xRatio, double yRatio)
	{
		double XCoordinate = 0;
		double YCoordinate = 0;
		double slope = yRatio/xRatio;
		double TempDistance = distance;
		int DistanceSquare = distance * distance;
		XCoordinate = Math.sqrt(DistanceSquare/(1 + (slope * slope)));
		YCoordinate = slope * XCoordinate;
		double GasUsed = TempDistance/CarEngine.getMPG();
		double MaxDistance = Tank.getLevel() * CarEngine.getMPG();
		if(Tank.getLevel() != 0)
		{
			if(distance >= MaxDistance)
			{
				if(Math.abs(xRatio) > 0 && Math.abs(yRatio) > 0)
				{
					DistanceSquare = (int)MaxDistance * (int)MaxDistance;
					XCoordinate = Math.sqrt(DistanceSquare/(1 + (slope * slope)));
					YCoordinate = slope * XCoordinate;
					if(yRatio > 0 && YCoordinate < 0)
					{
						YCoordinate = YCoordinate * -1;
					}
					if(yRatio < 0 && YCoordinate < 0)
					{
						YCoordinate = YCoordinate * -1;
					}
					if(xRatio < 0)
					{
						setX(getX() - (int)XCoordinate);
					}
					else
					{
						setX(getX() + (int)XCoordinate);
					}
					if(yRatio < 0)
					{
						setY(getY() - (int)YCoordinate);
					}
					else
					{
						setY(getY() + (int)YCoordinate);
					}
					Tank.setLevel(0);
					if(Tank.getLevel() <= 0)
					{
						//System.out.println("Ran out of gas after driving " + MaxDistance + " miles.");
					}
					return MaxDistance;
				}
				else if(Math.abs(xRatio) == 0)
				{
					if(yRatio < 0)
					{
						setY(getY() - (int)MaxDistance);
					}
					else
					{
						setY(getY() + (int)MaxDistance);
					}
					Tank.setLevel(0);
					if(Tank.getLevel() <= 0)
					{
						//System.out.println("Ran out of gas after driving " + MaxDistance + " miles.");
					}
					return MaxDistance;
				}
				else
				{
					if(xRatio < 0)
					{
						setX(getX() - (int)MaxDistance);
					}
					else
					{
						setX(getX() + (int)MaxDistance);
					}
					Tank.setLevel(0);
					if(Tank.getLevel() <= 0)
					{
						//System.out.println("Ran out of gas after driving " + MaxDistance + " miles.");
					}
					return MaxDistance;
				}
			}
			else
			{
				
				if(Math.abs(xRatio) > 0 && Math.abs(yRatio) > 0)
				{
					DistanceSquare = distance * distance;
					XCoordinate = Math.sqrt(DistanceSquare/(1 + (slope * slope)));
					YCoordinate = slope * XCoordinate;
					if(yRatio > 0 && YCoordinate < 0)
					{
						YCoordinate = YCoordinate * -1;
					}
					if(yRatio < 0 && YCoordinate < 0)
					{
						YCoordinate = YCoordinate * -1;
					}
					if(xRatio < 0)
					{
						setX(getX() - (int)XCoordinate);
					}
					else
					{
						setX(getX() + (int)XCoordinate);
					}
					if(yRatio < 0)
					{
						setY(getY() - (int)YCoordinate);
					}
					else
					{
						setY(getY() + (int)YCoordinate);
					}
					Tank.setLevel(Tank.getLevel() - GasUsed);
					if(Tank.getLevel() <= 0)
					{
						//System.out.println("Ran out of gas after driving " + MaxDistance + " miles.");
					}
					return distance;
				}
				else if(Math.abs(xRatio) == 0)
				{
					if(yRatio < 0)
					{
						setY(getY() - distance);
					}
					else
					{
						setY(getY() + distance);
					}
					Tank.setLevel(Tank.getLevel() - GasUsed);
					if(Tank.getLevel() <= 0)
					{
						//System.out.println("Ran out of gas after driving " + MaxDistance + " miles.");
					}
					return distance;
				}
				else
				{
					if(xRatio < 0)
					{
						setX(getX() - distance);
					}
					else
					{
						setX(getX() + distance);
					}
					Tank.setLevel(Tank.getLevel() - GasUsed);
					if(Tank.getLevel() <= 0)
					{
						//System.out.println("Ran out of gas after driving " + MaxDistance + " miles.");
					}
					return distance;
				}
			}
		}
		else
		{
			//System.out.println("Ran out of gas after driving " + 0.00 + " miles.");
			return 0;
		}
	}
	
	public void updateImage(Graphics g) 
	{
		super.updateImage(g);
	}
}
