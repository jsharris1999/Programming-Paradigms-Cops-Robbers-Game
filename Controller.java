/*
Jared Harris
October 22th, 2019
A program that creates a contoller to create and view the cop cars and robber cars.
*/

import java.awt.Graphics;
import java.io.IOException;
import java.awt.event.*;
import javax.swing.Timer;
import javax.swing.SwingUtilities;

class Controller implements MouseListener, KeyListener
{
    Model model;
    View view;

    Controller() throws IOException, Exception 
	{
        model = new Model();
        view = new View(this);
        //new Timer(50, view).start();
    }

    public void update(Graphics g) 
	{
        model.update(g);
    }

    public void mousePressed(MouseEvent e) 
	{
		view.repaint();
		if (SwingUtilities.isLeftMouseButton(e)) 
		{
			int x = e.getX();
			int y = e.getY();
			model.SpriteCreator(x,y);
		} 
		else if (SwingUtilities.isRightMouseButton(e))  
		{
			model.updateScene(view.getHeight(), view.getWidth());
		}
    }
	
	@Override
	public void keyTyped(KeyEvent e)
	{
		if(e.getKeyChar() == 'h')
		{
			System.out.println("Hello world");
		}
		else if(e.getKeyChar() == 'n')
		{
			System.out.println("Robbers Captured: " + RobberAuto.TotalCaptured());
			System.out.println("Robbers Escaped: " + RobberAuto.TotalEscaped());
		}
		else if(e.getKeyChar() == 'r')
		{
			model.initialize();
		}
		else if(e.getKeyChar() == 's')
		{
			SpriteMover SpriteThread = new SpriteMover(model, view);
			SpriteThread.start();
		}
	}
	
	public void keyPressed(KeyEvent e){    }
	public void keyReleased(KeyEvent e) {    }
    public void mouseReleased(MouseEvent e) {    }
    public void mouseEntered(MouseEvent e) {    }
    public void mouseExited(MouseEvent e) {    }
    public void mouseClicked(MouseEvent e) {    }
	

    public static void main(String[] args) throws Exception 
	{
        //  Use the following line to determine which directory your program
        //  is being executed from, since that is where the image files will
        //  need to be.
        //System.out.println("cwd=" + System.getProperty("user.dir"));
        new Controller();
    }
}
