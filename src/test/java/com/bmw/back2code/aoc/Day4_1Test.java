package com.bmw.back2code.aoc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class Day4_1Test {
    @Test
    void compute1(){

        //given
        int numDigits=2;
        int lowerRange=10;
        int upperRange=20;

        //when
        int result = Day4_1.computePossiblePasswords(numDigits,lowerRange, upperRange);

        //then
        Assertions.assertEquals(1,result);

    }

    @Test
    void goTest(){

        //given
        String input="278384-824795";

        //when
        int result = Day4_1.go(input);
        System.out.println("Result:"+result);

        //then
        Assertions.assertEquals(921,result);

    }


@Test
    void adjacentTestTrue(){

    //given
    int password=492355258;

    //when
    boolean result = Day4_1.hasAdjacentNumbers(password);

    //then
    Assertions.assertEquals(true,result);
}
    @Test
    void adjacentTestFalse(){

        //given
        int password=492365258;

        //when
        boolean result = Day4_1.hasAdjacentNumbers(password);

        //then
        Assertions.assertEquals(false,result);
    }

    @Test
    void risingTrue1(){

        //given
        int password=12345678;

        //when
        boolean result = Day4_1.hasOnlyRisingDigits(password);

        //then
        Assertions.assertEquals(true,result);
    }

    @Test
    void risingTrue2(){

        //given
        int password=12344678;

        //when
        boolean result = Day4_1.hasOnlyRisingDigits(password);

        //then
        Assertions.assertEquals(true,result);
    }

    @Test
    void risingFalse(){

        //given
        int password=12365678;

        //when
        boolean result = Day4_1.hasOnlyRisingDigits(password);

        //then
        Assertions.assertEquals(false,result);
    }

    @Test
    void testTrue(){

        //given
        int password=111111;

        //when
        boolean result = Day4_1.hasOnlyRisingDigits(password) &&Day4_1.hasAdjacentNumbers(password) ;

        //then
        Assertions.assertEquals(true,result);
    }
    @Test
    void testFalse1(){

        //given
        int password=223450;

        //when
        boolean result = Day4_1.hasOnlyRisingDigits(password) &&Day4_1.hasAdjacentNumbers(password) ;

        //then
        Assertions.assertEquals(false,result);
    }
    @Test
    void testFalse2(){

        //given
        int password=123789;

        //when
        boolean result = Day4_1.hasOnlyRisingDigits(password) &&Day4_1.hasAdjacentNumbers(password) ;

        //then
        Assertions.assertEquals(false,result);
    }


}