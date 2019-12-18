package com.bmw.back2code.aoc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class Day4_1Test {
    @Test
    void compute1(){

        //given
        int numDigits=2;
        int lowerRange=10;
        int upperRange=20;

        //when
        int result = Day4_1.computePossiblePasswordsPart1(lowerRange, upperRange);

        //then
        Assertions.assertEquals(1,result);

    }

    @Test
    void goTest_Part1(){

        //given

        //when
        int result = Day4_1.computePossiblePasswordsPart1(278384,824795);
        System.out.println("Result:"+result);

        //then
        Assertions.assertEquals(921,result);

    }

    @Test
    void goTest_Part2(){

        //given

        //when
        int result = Day4_1.computePossiblePasswordsPart2(278384,824795);
        System.out.println("Result:"+result);

        //then
        Assertions.assertEquals(603,result);

    }


@Test
    void adjacentTestTrue(){

    //given
    String password="492355258";

    //when
    boolean result = Day4_1.hasAdjacentNumbers(password);

    //then
    Assertions.assertEquals(true,result);
}
    @Test
    void adjacentTestFalse(){

        //given
        String password="1234567890";

        //when
        boolean result = Day4_1.hasAdjacentNumbers(password);

        //then
        Assertions.assertEquals(false,result);
    }

    @Test
    void risingTrue1(){

        //given
        String password="12345678";

        //when
        boolean result = Day4_1.hasOnlyRisingDigits(password);

        //then
        Assertions.assertEquals(true,result);
    }

    @Test
    void risingTrue2(){

        //given
        String password="12344678";

        //when
        boolean result = Day4_1.hasOnlyRisingDigits(password);

        //then
        Assertions.assertEquals(true,result);
    }

    @Test
    void risingFalse(){

        //given
        String password="12365678";

        //when
        boolean result = Day4_1.hasOnlyRisingDigits(password);

        //then
        Assertions.assertEquals(false,result);
    }

    @Test
    void testTrue(){

        //given
        String password="111111";

        //when
        boolean result = Day4_1.hasOnlyRisingDigits(password) &&Day4_1.hasAdjacentNumbers(password) ;

        //then
        Assertions.assertEquals(true,result);
    }
    @Test
    void testFalse1(){

        //given
        String password="223450";

        //when
        boolean result = Day4_1.hasOnlyRisingDigits(password) &&Day4_1.hasAdjacentNumbers(password) ;

        //then
        Assertions.assertEquals(false,result);
    }
    @Test
    void testFalse2(){

        //given
        String password="123789";

        //when
        boolean result = Day4_1.hasOnlyRisingDigits(password) &&Day4_1.hasAdjacentNumbers(password) ;

        //then
        Assertions.assertEquals(false,result);
    }

    @Test
    void testTrueOnlyTwice1(){

        //given
        String password="111122";

        //when
        boolean result = Day4_1.hasOnlyRisingDigits(password) &&Day4_1.hasAdjacentNumbersOnlyTwice(password) ;

        //then
        Assertions.assertEquals(true,result);
    }


    @Test
    void testTrueOnlyTwice2(){

        //given
        String password="112233";

        //when
        boolean result = Day4_1.hasOnlyRisingDigits(password) &&Day4_1.hasAdjacentNumbersOnlyTwice(password) ;

        //then
        Assertions.assertEquals(true,result);
    }



    @Test
    void testTrueOnlyTwice3(){

        //given
        String password="123455";

        //when
        boolean result = Day4_1.hasOnlyRisingDigits(password) && Day4_1.hasAdjacentNumbersOnlyTwice(password) ;

        //then
        Assertions.assertEquals(true,result);
    }

    @Test
    void testTrueOnlyTwice4(){

        //given
        String password="111122";

        //when
        boolean result = Day4_1.hasOnlyRisingDigits(password) && Day4_1.hasAdjacentNumbersOnlyTwice(password) ;

        //then
        Assertions.assertEquals(true,result);
    }


}