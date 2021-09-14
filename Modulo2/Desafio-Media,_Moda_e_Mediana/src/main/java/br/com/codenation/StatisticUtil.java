package br.com.codenation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StatisticUtil {

	public static int average(int[] elements) {
		int soma = 0;

		for (int index = 0; index < elements.length; index+=1) {
			soma += elements[index];
		}
		int media = soma / elements.length;
		return media;
	}

	public static int mode(int[] elements) {
		int contador = 0;
		int moda = 0;
		int repeticao = 0;

		for (int index = 0; index < elements.length; index+=1) {
			for (int index2 = 1; index2 < elements.length; index2+=1) {
				if (elements[index] == elements[index2]) {
					contador+=1;
				}
			}
			if (contador > repeticao) {
				repeticao = contador;
				moda = elements[index];
			}
			contador = 0;
		}
		return moda;
	}

	public static int median(int[] elements) {
		Arrays.sort(elements);
		int medianaImpar = (elements.length - 1) / 2;
		int medianaPar = (elements.length / 2);
		int mediana = 0;

		if (elements.length % 2 == 1) {
			mediana = elements[medianaImpar];
		} else {
			mediana = (elements[medianaPar] + elements[medianaPar - 1]) / 2;
		}
		System.out.println(mediana);
		return mediana;
	}
}