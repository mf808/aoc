package com.bmw.back2code.aoc;

import java.util.List;

public class Day1 {

    static int calcFuel(int mass) {

        return (int) (Math.floor(mass / 3) - 2);
    }

    public static void main(String[] args) {
        System.out.println(calculateFuelForModules(AOCHelper.ReadFileByLineInt(1, 1)));

    }

    public static int calculateFuelForModules(List<Integer> readFileByLineInt) {

        return readFileByLineInt.stream().map(m -> calcFuel(m)).mapToInt(Integer::intValue).sum();

    }

}