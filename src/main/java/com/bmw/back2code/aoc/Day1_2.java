package com.bmw.back2code.aoc;

import java.util.List;

public class Day1_2 {

    static int calcFuel(int mass) {

        int result = Math.floorDiv(mass, 3) - 2;

        return result < 0 ? 0 : result + calcFuel(result);
    }

    public static void main(String[] args) {
        System.out.println(calculateFuelForModules(AOCHelper.ReadFileByLineInt(1, 1)));

    }

    public static int calculateFuelForModules(List<Integer> readFileByLineInt) {

        return readFileByLineInt.stream().map(Day1_2::calcFuel).mapToInt(Integer::intValue).sum();

    }

}
