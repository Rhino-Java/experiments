package test.example;

import java.util.Arrays;
import java.util.List;

public class StreamApi {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
		
		System.out.println("Square of each element of the list using Stream API -");

		list.stream().map((x) -> x * x).forEach((Integer n) -> System.out.print(n + " "));

	}
}