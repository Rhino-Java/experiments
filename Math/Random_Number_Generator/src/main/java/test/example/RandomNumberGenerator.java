package test.example;

import java.util.Random;

public class RandomNumberGenerator {

	public void generateUpToTwoDigitRandomNumbers() {
		// note a single Random object is reused here
		Random randomGenerator = new Random();
		System.out.println("\nRandom Numbers UpTo Two Digits are -");
		for (int i = 0; i < 10; i++) {
			/*
			 * Generate random number between 0 (inclusive) and 100 (exclusive)
			 */
			int randomInt = randomGenerator.nextInt(100);
			System.out.print(randomInt+" ");
		}
	}

	public void generateOnlyTwoDigitRandomNumbers() {
		Random randomGenerator = new Random();
		System.out.println("\nOnly Two Digits Random Numbers are -");
		for (int i = 0; i < 10; i++) {
			/*
			 * Generate random number between 10 (inclusive) and 100 (exclusive)
			 */
			int randomInt = randomGenerator.nextInt(100 - 10) + 10;
			System.out.print(randomInt+" ");
		}
	}

	public int[] getRandomNumberInSpecificRange(int rangeStartPoint,
			int rangeEndPoint, int numbersToGenerate) {
		if (rangeEndPoint <= rangeStartPoint) {
			return null;
		}
		Random randomGenerator = new Random();
		int randomNumberArray[] = new int[numbersToGenerate];
		int randomInt = 0;
		for (int i = 0; i < numbersToGenerate; i++) {
			randomInt = randomGenerator
					.nextInt(rangeEndPoint - rangeStartPoint) + rangeStartPoint;
			randomNumberArray[i] = randomInt;
		}
		return randomNumberArray;
	}
}