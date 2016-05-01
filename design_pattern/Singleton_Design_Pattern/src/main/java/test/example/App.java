package test.example;

import test.example.singleton.SingletonClass;

public class App {
	public static void main(String[] args) {

		System.out.println("Counter initial value = " + SingletonClass.getInstance().getCounter());
		SingletonClass.getInstance().setCounter(10);
		System.out.println("Counter new value = " + SingletonClass.getInstance().getCounter());
		SingletonClass.getInstance().setCounter(210);
		System.out.println("Counter final value = " + SingletonClass.getInstance().getCounter());
	}
}
