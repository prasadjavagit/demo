package com.example.core;

public class PrimeOrNot {

    public static void main(String[] args) {
        int num =4 ;
        System.out.println(isPrime(num));
    }

    public static boolean isPrime(int number) {
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
