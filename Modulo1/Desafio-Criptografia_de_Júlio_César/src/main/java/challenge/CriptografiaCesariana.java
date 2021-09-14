package challenge;

import java.util.Locale;

public class CriptografiaCesariana implements Criptografia {
    @Override
    public String criptografar(String texto) {
        if(texto.isEmpty()) {
            throw new IllegalArgumentException();
        }

        String result = "";

        char[] characteres = texto.toLowerCase().toCharArray();
        char a;

        for(int index = 0; index < characteres.length; index +=1) {
            if (Character.isLetter(characteres[index])) {
                a = (char) (characteres[index] + 3);
            } else {
                a = (char) (characteres[index] + 0);
            }
            result += a;
        }
        return result;
    }

    @Override
    public String descriptografar(String texto) {
        if(texto.isEmpty()) {
            throw new IllegalArgumentException();
        }
        String result = "";

        char[] characteres = texto.toLowerCase().toCharArray();
        char a;

        for(int index = 0; index < characteres.length; index +=1) {
            if (Character.isLetter(characteres[index])) {
                a = (char) (characteres[index] - 3);
            } else {
                a = (char) (characteres[index] + 0);
            }
            result += a;
        }
        return result;
    }
}
