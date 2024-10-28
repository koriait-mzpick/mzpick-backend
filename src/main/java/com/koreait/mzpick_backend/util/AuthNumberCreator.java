package com.koreait.mzpick_backend.util;

import java.util.Random;

public class AuthNumberCreator {

    public static String number6(){
        String authNumber = "";

        Random random = new Random();
        for(int count = 0; count < 6; count ++) {
            authNumber += random.nextInt(10);
        }
        return authNumber;
    }
}

