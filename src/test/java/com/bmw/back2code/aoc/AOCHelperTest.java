package com.bmw.back2code.aoc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class AOCHelperTest {

    @Test
    void testDownload() {
        // given
        int day = 1;
        int part = 1;

        // when
        List<Integer> list = AOCHelper.ReadFileByLineInt(day, part);

        // then
        Assertions.assertEquals(list.size(), 100);

    }

}
