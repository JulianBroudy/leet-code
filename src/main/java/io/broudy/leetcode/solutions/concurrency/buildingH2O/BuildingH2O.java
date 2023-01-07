package io.broudy.leetcode.solutions.concurrency.buildingH2O;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/building-h2o/">1117. Building H2O</a>.
 *
 * @author <a href="https://broudy.io/">Julian Broudy</a>
 */
public class BuildingH2O {

	public static void main(String[] args) {
		final String water = "HHHHHHOOHHOO";

		H2O h2O = new H2O();

		final List<Thread> threads = new ArrayList<>();
		for (char ch : water.toCharArray()) {
			final Thread thread;
			if (ch == 'H') {
				thread = createThread(h2O, HOMethod.H, "H");
			} else {
				thread = createThread(h2O, HOMethod.O, "O");
			}
			threads.add(thread);
		}

		for (Thread thread : threads) {
			thread.start();
		}
	}

	private static List<Thread> createThreads(int numberOfThreads, H2O h2O, HOMethod method, String toBePrinted) {
		List<Thread> threads = new ArrayList<>();
		for (int i = 0; i < numberOfThreads; i++) {
			threads.add(createThread(h2O, method, toBePrinted));
		}
		return threads;
	}

	private static Thread createThread(H2O h2O, HOMethod method, String toBePrinted) {
		return new BuildingH2OThread(h2O, method, () -> System.out.print(toBePrinted));
	}

	enum HOMethod {
		H, O
	}

}
