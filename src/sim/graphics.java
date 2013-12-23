package sim;

import java.awt.*;
import java.awt.geom.Line2D;

import javax.swing.*;

import java.lang.Math;
 
public class graphics
{
	static int [][]z;
	static int step=0;
	static int x2=0;
	static int l=0;
			
    graphics(int[][] x, int l)
    {
        DrawFrame frame = new DrawFrame();
    //  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        z = x;
        x2=main.time;	
       if (x2> 4000) step = (int)x2/400  ; else step =1;
        this.l=l;
  //      System.out.print("Lenth " + main.time);
 //       System.out.print("Step " + step );
    }
}
 
class DrawFrame extends JFrame
{
    public DrawFrame()
    {
        setTitle("Graph");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
 
        add(new DrawPanel());
    }
 
    public static final int DEFAULT_WIDTH = 400;
    public static final int DEFAULT_HEIGHT = 400;
}
 
class DrawPanel extends JPanel
{	int turn = graphics.step;
	int stepY;
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        double y=0;
        int ss =0;
        double[] x = new double [400];
        double shX = 0;
        double shY = 50;
        for(int t  = 0; t < graphics.x2; ++t) {
            
        	stepY=stepY+ graphics.z[graphics.l][t];
        	System.out.print(" t" + (int) t + "step " + stepY      	+ "turn=" + turn		); 
        	if (turn==t & ss< 400){
        		ss++;
        		turn = graphics.step+turn;
        		if (ss<400)x[ss] =(double)stepY/graphics.step*2;
        		
        		System.out.print(" x=" + (int) x[ss]);  	
					
			stepY=0;
			
        	}// end if turn
        
        }// end for t
        //g2.draw  ( new Line2D.Double(0,0,200,200));

        System.out.println("ss=" +ss);
        for (int i=10; i<ss; i=i+5){
        	
        	g2.draw  ( new Line2D.Double(i,x[i-5],i+5,x[i]));
        	g2.draw  ( new Line2D.Double(i,x[i-5]/2,i+5,x[i]/2));
        	g2.draw  ( new Line2D.Double(i,x[i-5]*2,i+5,x[i]*2));
        
        	System.out.print(" " + (int) x[i]); 
        }
    	g2.draw  ( new Line2D.Double(0,200,400,200));
    	System.out.println("");
    	System.out.println("END!!!");

}


}