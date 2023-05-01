package com.example.parkering.service;

public class CarService {
    public static boolean CRegNumber(String regNumber) {       
        if (regNumber.length() != 6) {
            return false;
        }
        for (int i = 0; i < 3; i++) {
            if (Character.isLetter(regNumber.charAt(i))) {
                if ((Character.isDigit(regNumber.charAt(i + 3)))) {
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }
    
}
