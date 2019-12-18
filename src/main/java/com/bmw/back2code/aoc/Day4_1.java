package com.bmw.back2code.aoc;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

class Day4_1 {


    public static int computePossiblePasswordsPart1(int lowerRange, int upperRange) {

        return (int) IntStream
                .rangeClosed(lowerRange, upperRange)
                .filter(p -> hasAdjacentNumbers(Integer.toString(p)) && hasOnlyRisingDigits(Integer.toString(p)))
                .count();

    }

    public static int computePossiblePasswordsPart2(int lowerRange, int upperRange) {
        return (int) IntStream
                .rangeClosed(lowerRange, upperRange)
                .filter(p -> hasAdjacentNumbersOnlyTwice(Integer.toString(p)) && hasOnlyRisingDigits(Integer.toString(p)))
                .count();
    }


    public static boolean hasAdjacentNumbers(String password) {

        List<String> digitList = Arrays.asList(password.split(""));

        return digitList
                .stream()
                .collect(groupingBy(str -> str, counting()))
                .entrySet()
                .stream().anyMatch(x -> x.getValue() >= 2);
    }

    public static boolean hasAdjacentNumbersOnlyTwice(String password) {

        List<String> digitList = Arrays.asList(password.split(""));

        return digitList
                .stream()
                .collect(groupingBy(str -> str, counting()))
                .entrySet()
                .stream().anyMatch(x -> x.getValue() == 2);

    }


    public static boolean hasOnlyRisingDigits(String password) {

        String[] digits = password.split("");

        Arrays.sort(digits);
        return Arrays.equals(digits, password.split(""));
    }

}
