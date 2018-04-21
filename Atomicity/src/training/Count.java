package training;

public class Count {

	private long variable = 0;
	private Object LOCK = new Object();
	private static final long LIMIT = 100_000_000;

	private class Incrementer implements Runnable {

		@Override
		public void run() {

			for (int i = 0; i < LIMIT / 2; i++) {
				synchronized (LOCK) {
					variable++;
				}
			}

			// System.out.println(variable);
		}
	}

	public void startTest() throws InterruptedException {
		long start = System.currentTimeMillis();
		Thread thread1 = new Thread(new Incrementer());
		Thread thread2 = new Thread(new Incrementer());
		thread1.start();
		thread2.start();
		thread1.join();
		thread2.join();
		System.out.println(variable);
		System.out.println("It took: " + (System.currentTimeMillis() - start) + " ms");

	}

	public static void main(String[] args) throws InterruptedException {

		new Count().startTest();
	}

}
