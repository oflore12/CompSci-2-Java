import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;
/**
 * CarQueue class that maintains a queue of random directions that the car should go.
 * There is an addToQueue method that has a class that implements runnable, 
 * define the run method (add random directions into the queue and then sleep), 
 * creates an instance of the runnable object, creates a thread and starts the thread.  
 * @author Odalis Flores
 * Tread lab
 * Professor: Khandan Vahbzadeh Monshi 
 */
public class CarQueue {
	Queue<Integer> carQueue;
	Random direction;
	
	public CarQueue() {
		carQueue= new ArrayDeque<Integer>();
		direction= new Random();
		
		carQueue.add(direction.nextInt(4));
		carQueue.add(direction.nextInt(4));
		carQueue.add(direction.nextInt(4));
		carQueue.add(direction.nextInt(4));
		carQueue.add(direction.nextInt(4));
	}
	
	public void addToQueue() {
		// TODO Auto-generated method stub
		class QueueRunnable implements Runnable{

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					while(true) {
						carQueue.add(direction.nextInt(4));
						Thread.sleep(200);
					}
				}
				catch(InterruptedException exception) {
					
				}
				finally {
					
				}
			}
		}
		Runnable r = new QueueRunnable();
		Thread t = new Thread(r);
		t.start();
		
		
	}

	public int deleteQueue() {
		return carQueue.remove();
	}

}
