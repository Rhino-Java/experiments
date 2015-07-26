package test.example;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateExample {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

		Predicate<Integer> p1 = (n) -> true;

		Predicate<Integer> p2 = (n) -> false;

		Predicate<Integer> p3 = (n) -> n % 2 == 0;

		Predicate<Integer> p4 = (n) -> n % 2 != 0;

		System.out.println("Print All Elements of the List -");

		printListElements(list, p1);

		System.out.println("\nPrint No Elements of the List -");

		printListElements(list, p2);

		System.out.println("\nPrint Even Elements of the List -");

		printListElements(list, p3);

		System.out.println("\nPrint Odd Elements of the List -");

		printListElements(list, p4);

	}

	private static void printListElements(List<Integer> list, Predicate<Integer> predicate) {

		list.forEach((t) -> {
			if (predicate.test(t)) {
				System.out.print(t + " ");
			}
		});
	}

}
