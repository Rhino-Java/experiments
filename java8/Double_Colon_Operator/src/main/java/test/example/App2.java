package test.example;

import java.util.Arrays;
import java.util.List;

public class App2 {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

		list.forEach(System.out::println);
	}

}
