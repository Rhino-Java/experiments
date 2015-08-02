package test.example;

public class App {

	public static void main(String[] args) {

		RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

		randomNumberGenerator.generateUpToTwoDigitRandomNumbers();
		randomNumberGenerator.generateOnlyTwoDigitRandomNumbers();

		int randomNumberArray[] = randomNumberGenerator.getRandomNumberInSpecificRange(50, 100, 20);
		System.out.println("\nRandom Numbers between 50 and 100 are -");
		for (int i : randomNumberArray) {
			System.out.print(i+" ");
		}

	}
}
