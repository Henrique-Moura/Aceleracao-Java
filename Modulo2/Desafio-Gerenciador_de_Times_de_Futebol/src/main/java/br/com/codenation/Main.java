package br.com.codenation;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        DesafioMeuTimeApplication desafio = new DesafioMeuTimeApplication();
        desafio.incluirTime(1L, "Corinthians", LocalDate.ofEpochDay(1910-9-01), "Preto", "Branco");


        desafio.incluirJogador(1L, 1L, "Jô", LocalDate.ofEpochDay(1987-03-20), 90, BigDecimal.valueOf(350.00));
    }
}
