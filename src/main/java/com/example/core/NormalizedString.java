package com.example.core;

import java.util.List;
import java.util.stream.Collectors;

public class NormalizedString {

    public static void main(String[] args) {
        String s1 = "   Panda";
        String s2 = "  fish   ";
        String s3 = "Horse    ";
        String s4 = " CAT";
        String s5 = "  ";
        List<String> animals = List.of(s1, s2, s3, s4, s5);
        System.out.println(animals);
        animals.stream().forEach((animal) -> System.out.println(animal.trim()));
        List<String> trimmed = animals.stream()
                .map(animal -> animal.trim())
                .collect(Collectors.toList());
        System.out.println(trimmed);
        List<String> realAnimals = trimmed.stream()
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toList());
        System.out.println(realAnimals);
        List<String> normalizedAnimalNames = realAnimals.stream()
                .map(s -> s.toLowerCase())
                .collect(Collectors.toList());
        System.out.println(normalizedAnimalNames);
    }

}
