package io.broudy.leetcode.solutions.concurrency.buildingH2O;

import io.broudy.leetcode.solutions.concurrency.buildingH2O.BuildingH2O.HOMethod;

/**
 * A helper class to simulate LeetCode's test runs.
 *
 * @author <a href="https://broudy.io/">Julian Broudy</a>
 */
public class BuildingH2OThread extends Thread {

	private final H2O h2O;
	private final HOMethod method;
	private final Runnable runnable;

	public BuildingH2OThread(H2O h2O, HOMethod method, Runnable runnable) {
		super();
		this.h2O = h2O;
		this.method = method;
		this.runnable = runnable;
	}

	@Override
	public void run() {
		switch (method) {
			case O -> {
				try {
					h2O.oxygen(runnable);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			case H -> {
				try {
					h2O.hydrogen(runnable);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
