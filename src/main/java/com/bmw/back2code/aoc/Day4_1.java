package com.bmw.back2code.aoc;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day4_1 {


    public static int go(String input) {
        int lR = Integer.parseInt(input.split("-")[0]);
        int uR = Integer.parseInt(input.split("-")[1]);
        int numDigits = input.split("-")[0].length();
        int result = computePossiblePasswords(numDigits,lR, uR);
        return result;
    }


    public static int computePossiblePasswords(int numDigits, int lowerRange, int upperRange){
        int start = lowerRange;
        int stop = upperRange;
        int possiblePWs=0;
        for (int pw =start ;pw<=stop;pw++){

            if (hasAdjacentNumbers(pw) && hasOnlyRisingDigits(pw))
                possiblePWs++;
        }


        return possiblePWs;
    }


    public static boolean hasAdjacentNumbers(int password) {

        String word = Integer.toString(password);
        char[] words = word.toCharArray();
        //long result = IntStream.range(1,word.length()).mapToObj(n ->(words[n] == words[n-1])).count();

        boolean result =false;

        for (int i = 1; i<word.length(); i++){
            if (words[i] == words[i-1]) {
                result = true;
            }
        }


        return result;
    }

    public static boolean hasOnlyRisingDigits(int password) {
        String word = Integer.toString(password);
        char[] words = word.toCharArray();
        //long result = IntStream.range(1,word.length()).mapToObj(n ->(words[n] == words[n-1])).count();

        boolean result =true;

        for (int i = 1; i<word.length(); i++){
            if (  words[i-1] > words[i]) {
                result = false;
            }
        }

         return result;
    }
}
