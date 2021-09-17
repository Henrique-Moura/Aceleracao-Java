package com.challenge.desafio;

import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;
import com.challenge.interfaces.Calculavel;

import java.lang.reflect.Field;
import java.math.BigDecimal;


public class CalculadorDeClasses implements Calculavel {
    // Feito em parceria Kamila Ribeiro
    @Override
    public BigDecimal somar(Object classe) {
        // Field[] é um array de atributos.
        Field[] fields = classe.getClass().getDeclaredFields();
        BigDecimal result = BigDecimal.ZERO;

        for (Field field : fields) {
            field.setAccessible(true);
            if(field.getType().equals(BigDecimal.class)) {
                if (field.isAnnotationPresent(Somar.class)) {
                    try {
                        result = result.add((BigDecimal) field.get(classe));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return result;
    }


    @Override
    public BigDecimal subtrair(Object classe) {
        Field[] fields = classe.getClass().getDeclaredFields();
        BigDecimal result = BigDecimal.ZERO;

        for (Field field : fields) {
            field.setAccessible(true);
            if(field.getType().equals(BigDecimal.class)) {
                if (field.isAnnotationPresent(Subtrair.class)) {
                    try {
                        result = result.add((BigDecimal) field.get(classe));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return result;
    }

    @Override
    public BigDecimal totalizar(Object classe) {
        return somar(classe).subtract(subtrair(classe));
    }
}
