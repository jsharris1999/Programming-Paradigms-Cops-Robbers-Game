/*
Jared Harris
October 22th, 2019
A program that creates a panel to view all of the cars.
*/

import javax.swing.JFrame;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.event.*;

public class View extends JFrame implements ActionListener
{

    private class MyPanel extends JPanel
	{
        Controller controller;

        MyPanel(Controller c)
		{
            controller = c;
            addMouseListener(c);
			
        }

        public void paintComponent(Graphics g)
		{
            controller.update(g);
            revalidate();
        }
    }


    public View(Controller c) throws Exception
	{
        setTitle("Assignment 5");
		addKeyListener(c);
        setSize(1000, 700);
        getContentPane().add(new MyPanel(c));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent evt)
	{
        repaint();
    }
}

