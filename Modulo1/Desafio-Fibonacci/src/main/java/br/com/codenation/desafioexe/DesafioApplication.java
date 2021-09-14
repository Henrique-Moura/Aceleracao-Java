package br.com.codenation.desafioexe;

import java.util.ArrayList;
import java.util.List;

public class DesafioApplication {

	public static List<Integer> fibonacci() {
		ArrayList<Integer> fibonacciList = new ArrayList<>();
		fibonacciList.add(0);
		fibonacciList.add(1);

		int number1 = 0;
		int number2 = 1;

		while (number2 < 350) {
			int number3 = number1 + number2;
			number1 = number2;
			number2 = number3;

			fibonacciList.add(number3);
		}

		return fibonacciList;
	}

	public static Boolean isFibonacci(Integer a) {
		boolean result = fibonacci().contains(a);

		return result;
	}

}