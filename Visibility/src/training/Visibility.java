package training;

public class Visibility {
	
	private boolean stopRequested = false;
	
	
	
	public synchronized boolean isStopRequested() {
		return stopRequested;
	}

	public synchronized void setStopRequested(boolean stopRequested) {
		this.stopRequested = stopRequested;
	}

	private class StoppedThread extends Thread{

		@Override
		public void run() {
			int i =0;
		  while (isStopRequested()){
			  i++;
		  }
		  System.out.println("Thread stopped");
		}
		
	}
	
	public void startTest() throws InterruptedException{
		new StoppedThread().start();
		Thread.sleep(1000);
		setStopRequested( true);
	}

	public static void main(String[] args) throws InterruptedException {
		
		new Visibility().startTest();

	}

}
