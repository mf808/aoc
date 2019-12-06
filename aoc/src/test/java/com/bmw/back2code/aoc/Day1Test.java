package com.bmw.back2code.aoc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day1Test {

    @Test
    public void fuelCheck() {

        // given
        int mass = 12;

        // when
        int fuel = Day1.calcFuel(mass);

        // then

        Assertions.assertEquals(Math.floor(mass / 3) - 2, fuel);

    }

    @Test
    public void fuelCheck2() {

        // given
        int mass = 14;

        // when
        int fuel = Day1.calcFuel(mass);

        // then

        Assertions.assertEquals(Math.floor(mass / 3) - 2, fuel);

    }

    @Test
    public void fuelCheck3() {

        // given
        int mass = 1969;

        // when
        int fuel = Day1.calcFuel(mass);

        // then

        Assertions.assertEquals(Math.floor(mass / 3) - 2, fuel);

    }

    @Test
    public void fuelCheck4() {

        // given
        int mass = 1100756;

        // when
        int fuel = Day1.calcFuel(mass);

        // then

        Assertions.assertEquals(Math.floor(mass / 3) - 2, fuel);

    }

}
