package io.broudy.leetcode.solutions.concurrency.fizz_buzz_multithreaded;

/**
 * 1195. Fizz Buzz Multithreaded
 * <p>
 * <a href="https://leetcode.com/problems/fizz-buzz-multithreaded/description/">Fizz Buzz Multithreaded</a>
 */
public class FizzBuzzMultithreaded {

	public static void main(String[] args) {

		final int n = 15;
		FizzBuzz fizzBuzz = new FizzBuzz(n);

		FizzBuzzMultithreadedThread a = new FizzBuzzMultithreadedThread(fizzBuzz, FizzBuzzMethods.FIZZ,
		                                                                () -> System.out.print("Fizz, "));
		FizzBuzzMultithreadedThread b = new FizzBuzzMultithreadedThread(fizzBuzz, FizzBuzzMethods.BUZZ,
		                                                                () -> System.out.print("Buzz, "));
		FizzBuzzMultithreadedThread c = new FizzBuzzMultithreadedThread(fizzBuzz, FizzBuzzMethods.FIZZBUZZ,
		                                                                () -> System.out.print("FizzBuzz, "));
		FizzBuzzMultithreadedThread d = new FizzBuzzMultithreadedThread(fizzBuzz, FizzBuzzMethods.NUMBER,
		                                                                () -> System.out.println("Number"));

		d.start();
		a.start();
		b.start();
		c.start();

	}

	public enum FizzBuzzMethods {
		FIZZ, BUZZ, FIZZBUZZ, NUMBER
	}

}
