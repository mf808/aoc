package com.bmw.back2code.aoc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Day2_1Test {

    @Test
    void test1() {
        // given
        int[] program = new int[] { 1, 0, 0, 0, 99 };

        // when
        int result = Day2_1.runProgram(program);
        // then
        Assertions.assertEquals(2, result);
    }

    @Test
    void test2() {
        // given
        int[] program = new int[] { 2, 3, 0, 3, 99 };

        // when
        int result = Day2_1.runProgram(program);
        // then
        Assertions.assertEquals(2, result);
    }

    @Test
    void test3() {
        // given
        int[] program = new int[] { 2, 4, 4, 5, 99, 0 };

        // when
        int result = Day2_1.runProgram(program);
        // then
        Assertions.assertEquals(2, result);
    }

    @Test
    void test4() {
        // given
        int[] program = new int[] { 1, 1, 1, 4, 99, 5, 6, 0, 99 };

        // when
        int result = Day2_1.runProgram(program);
        // then
        Assertions.assertEquals(30, result);
    }

}
