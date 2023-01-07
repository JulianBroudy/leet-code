package io.broudy.leetcode.solutions.concurrency.buildingH2O;

import java.util.concurrent.Semaphore;

/**
 * <a href="https://leetcode.com/problems/building-h2o/">1117. Building H2O</a>.
 *
 * @author <a href="https://github.com/JulianBroudy">Julian Broudy</a>
 */
class H2O {

	private final Semaphore hydrogenSemaphore;
	private final Semaphore oxygenSemaphore;
	private volatile int remainingHydrogen;

	public H2O() {
		this.hydrogenSemaphore = new Semaphore(1);
		this.oxygenSemaphore = new Semaphore(1);
		this.remainingHydrogen = 2;
	}

	public synchronized void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
		while (true) {
			hydrogenSemaphore.acquire();
			if (remainingHydrogen != 0) {
				releaseHydrogen.run();
				remainingHydrogen--;
				hydrogenSemaphore.release();
				notifyAll();
				break;
			} else {
				hydrogenSemaphore.release();
				wait();
			}
		}
	}

	public synchronized void oxygen(Runnable releaseOxygen) throws InterruptedException {
		while (true) {
			oxygenSemaphore.acquire();
			if (remainingHydrogen == 0) {
				releaseOxygen.run();
				remainingHydrogen = 2;
				oxygenSemaphore.release();
				notifyAll();
				break;
			} else {
				oxygenSemaphore.release();
				wait();
			}
		}
	}
}
