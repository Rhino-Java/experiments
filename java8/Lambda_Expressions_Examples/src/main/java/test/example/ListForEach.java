package test.example;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ListForEach {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

		System.out.println("Elements of the list using Traditional Method -");
		// Old Way
		for (Integer i : list) {
			System.out.print(i + " ");
		}
		// Using Consumer Interface
		System.out.println("\nElements of the list using Consumer Functional Interface -");
		list.forEach(new Consumer<Integer>() {

			@Override
			public void accept(Integer t) {
				System.out.print(t + " ");

			}
		});

		// Using Lambda Expressions
		System.out.println("\nElements of the list using Lambda expressions -");
		list.forEach((t) -> System.out.print(t + " "));

		System.out.println("\nSquare of each element of the list using Lambda expressions -");
		list.forEach((t) -> System.out.print(t * t + " "));

	}

}
