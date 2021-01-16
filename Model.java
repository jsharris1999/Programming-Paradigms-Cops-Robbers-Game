/*
Jared Harris
October 22th, 2019
A program that keeps track of every car.
*/

import java.awt.Graphics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;


class Model
{
	private ArrayList<Sprite> SpriteList = new ArrayList<Sprite>();
	private int AutoCount = 0;

    Model() throws IOException 
	{
		Bank NewBankSprite = new Bank();
		SpriteList.add(NewBankSprite);
    }
	
	public synchronized void SpriteCreator(int x, int y)
	{
		if(AutoCount % 2 == 0)
		{
			CopAuto NewCopSprite = new CopAuto();
			NewCopSprite.setX(x);
			NewCopSprite.setY(y);
			SpriteList.add(NewCopSprite);
			AutoCount++;
		}
		else
		{
			RobberAuto NewRobberSprite = new RobberAuto();
			NewRobberSprite.setX(300);
			NewRobberSprite.setY(300);
			SpriteList.add(NewRobberSprite);
			AutoCount++;
		}
	}
	
	public synchronized void updateScene(int Height, int Width)
	{
		int LoopCount = SpriteList.size();
		int Index = 0;
		int CollisionIndex = 0;
		Iterator SpriteIterator = SpriteList.iterator();
		SpriteIterator.next();
		while(Index < LoopCount)
		{
			SpriteList.get(Index).updateState(Height, Width);
			if(SpriteList.get(Index) instanceof CopAuto)
			{
				if(Index % 2 == 1 && SpriteList.size() >= 2)
				{
					while(CollisionIndex < LoopCount)
					{
						if(SpriteList.get(Index).overlaps(SpriteList.get(CollisionIndex)))
						{
							if(SpriteList.get(CollisionIndex) instanceof RobberAuto)
							{
								if(((RobberAuto)SpriteList.get(CollisionIndex)).isCaptured() == false)
								{
									((RobberAuto)SpriteList.get(CollisionIndex)).captured();
								}
							}
						}
						CollisionIndex ++;
					}
				}
			}
			if(SpriteList.get(Index) instanceof RobberAuto)
			{
				
				if(((RobberAuto)SpriteList.get(Index)).hasEscaped() && SpriteIterator.hasNext())
				{
					System.out.println("I'm free!");
					SpriteIterator.remove();
					LoopCount--;
				}	
			}
			if(SpriteIterator.hasNext())
			{
				SpriteIterator.next();
			}
			CollisionIndex = 0;
			Index++;
		}
	}

    public synchronized void update(Graphics g) 
	{
		int LoopCount = SpriteList.size();
		int Index = 0;
		while(Index < LoopCount)
		{
			SpriteList.get(Index).updateImage(g);
			Index++;
		}
    }
	
	public synchronized void initialize()
	{
		int Index = 0;
		Iterator SpriteIterator = SpriteList.iterator();
		SpriteIterator.next();
		while(SpriteList.size() > 0)
		{
			if(SpriteList.get(Index) instanceof RobberAuto)
			{
				((RobberAuto)SpriteList.get(Index)).UndoCapture();
			}
			SpriteIterator.remove();
			if(SpriteIterator.hasNext())
			{
				SpriteIterator.next();
			}
		}
		Bank NewBankSprite = new Bank();
		SpriteList.add(NewBankSprite);
		RobberAuto.ResetCaptured();
		RobberAuto.ResetEscaped();
		Index++;
	}
}
