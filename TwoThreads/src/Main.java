
public class Main {
	
	public static class FirstThread implements  Runnable {
		
		private int waitTime;
		
		
		
		public FirstThread(int waitTime) {
			
			this.waitTime = waitTime;
		}

		@Override 
		public void run() {
			int i =0;
			
			while (true){
			System.out.println(i);	
			++i;
			sleep();
			}
			
		}

		private void sleep() {
			try {
				Thread.sleep(waitTime);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new Thread(new FirstThread(500)).start();
		new Thread(new FirstThread(1000)).start();
		

	}

}
