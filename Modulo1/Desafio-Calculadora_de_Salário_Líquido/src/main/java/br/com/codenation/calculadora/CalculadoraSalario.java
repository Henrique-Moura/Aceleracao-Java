package br.com.codenation.calculadora;


public class CalculadoraSalario {

	double aliquotINSS;
	double baseSalary;
	double aliquotIR;

	public long calcularSalarioLiquido(double salarioBase) {
		double aliquotINSS = calcularInss(salarioBase);

		baseSalary = salarioBase - aliquotINSS;
		System.out.println(baseSalary);


		if (baseSalary < 1039) {
			return Math.round(0.0);
		} else if (baseSalary <= 3000) {
			aliquotIR = 0;
		} else if (baseSalary <= 6000) {
			aliquotIR = baseSalary * 0.075;
		} else {
			aliquotIR = baseSalary * 0.15;
		}

		return Math.round(baseSalary - aliquotIR);
	}
	
	
	//Exemplo de método que pode ser criado para separar melhor as responsábilidades de seu algorítmo

	private double calcularInss(double salarioBase) {
		if (salarioBase <= 1500) {
			aliquotINSS = salarioBase * 0.08;
		} else if (salarioBase <= 4000) {
			aliquotINSS = salarioBase * 0.09;
		} else {
			aliquotINSS = salarioBase * 0.11;
		}
		return aliquotINSS;
	}

}
/*Dúvidas ou Problemas?
Manda e-mail para o meajuda@codenation.dev que iremos te ajudar! 
*/