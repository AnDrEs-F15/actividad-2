package com.trad.trad.utils;

import java.util.Random;

public class GenerateCodeValidated {
    public static String generateCode (){
        Random code = new Random();
        return String.valueOf(code.nextInt(900000) + 100000);
    }
}
