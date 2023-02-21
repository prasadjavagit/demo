package com.example.core;

public class Palindrome {

    public static void main(String[] args) {
        String str = "raceCar";
        System.out.println(palindromechecker(str));
    }

    public static boolean palindromechecker(String original) {
        String normalized = original.toLowerCase();
        StringBuilder reversed = new StringBuilder();
        for (int i = normalized.length() - 1; i >= 0; i--) {
            reversed.append(normalized.charAt(i));
        }
        return normalized.equals(reversed.toString());
    }
}
