import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

/**
   This component draws two car shapes.
   Modify the run method of the startAnimation in CarPanel 
   so that the car will go to the right, left, up or down 
   depending on what is retrieved from the CarQueue.  
   The cars should go in the opposite direction if they hit a boundary.  
   @author Odalis Flores
   Tread lab
   Professor: Khandan Vahbzadeh Monshi 
*/
public class CarPanel extends JComponent
{  
	private Car car1;
	private int x,y, delay;
	private CarQueue carQueue;
	private int direction;

	CarPanel(int x1, int y1, int d, CarQueue queue)
	{
		delay = d;
        x=x1;
        y=y1;
        car1 = new Car(x, y, this);
        carQueue = queue;
	}
	public void startAnimation()
	   {
	      class AnimationRunnable implements Runnable
	      {
	         public void run()
	         {
	            try {
	            	int deltay=10;
	            	int deltax=10;
	            	for(int i=0;i<10;i++) {
	            		direction = carQueue.deleteQueue();	
	            		
	            		if(y<=400 && x<=300) {	            			
	            			switch(direction) {
	            			case 0: 
	            				//move up if y is greater than 10, sub deltay
	            				if(y>10) 
	            					y-=deltay;
	            				//if y is 0 (hits a bound) go opposite, add deltay
	            				else if (y==0)
	            					y+=deltay;
	            				//else leave as is.
	            				else y+=0;
	            				break;
	            			case 1:
	            				//move down if y is less than 390, add deltay
	            				if(y<390)
	            					y+=deltay;
	            				//if y is 400 (hits a bound) go opposite, sub deltay
	            				else if (y==400)
	            					y-=deltay;
	            				//else leave as is.
	            				else y+=0;
	            			break;
	            			case 2:
	            				//move right if x is less than 290, add deltax
	            				if(x<290)
	            					x+=deltax;
	            				//if x is 300 (hits a bound) go opposite, sub deltax
	            				else if (x==300)
	            					x-=deltax;
	            				//else leave as is.
	            				else x+=0;
	            				break;
	            			case 3:
	            				//move to the left if x is greater than 10, sub deltax
	            				if(x>10)
	            					x-=deltax;
	            				//if x is 0, (hits a bound) go opposite add deltax
	            				else if (x==0)
	            					x+=deltax;
	            				//else leave x alone.
	            				else x+=0;
	            				break;
	            			default:
	            			}
	            			repaint();
	            			Thread.sleep(delay*1000);
	            			}
	            	}
	            }
	            catch (InterruptedException exception)
	            {
	            	
	            }
	            finally
	            {
	            	
	            }
	         }
	      }
	     
	      Runnable r = new AnimationRunnable();
	      Thread t = new Thread(r);
	      t.start();
	   }
	
   public void paintComponent(Graphics g)
   {  
      Graphics2D g2 = (Graphics2D) g;

      car1.draw(g2,x,y);    
   }
}
