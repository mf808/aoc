package com.bmw.back2code.aoc;

import com.bmw.back2code.aoc.Day3_1.AOCGrid;
import com.bmw.back2code.aoc.Day3_1.AOCPatch;
import com.bmw.back2code.aoc.Day3_1.AOCPosition;
import com.bmw.back2code.aoc.Day3_1.AOCWire;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Day3_1Test {

    @Test
    void createArrayTest() {
        // given
        int rows = 100;
        // when

        AOCGrid grid = new AOCGrid(rows);
        // then
        Assertions.assertEquals(grid.grid.length, 101);
        Assertions.assertEquals(grid.grid[0].length, 101);

    }

    @Test
    void getDirectionTest() {
        // given

        AOCPatch p = new AOCPatch("R75");

        // when
        String direction = p.getDirection();
        // then
        Assertions.assertEquals(direction, "R");
    }

    @Test
    void getDistanceTest() {
        // given
        AOCPatch patch = new AOCPatch("R75");
        // when
        int position = patch.getDistance();
        // then
        Assertions.assertEquals(position, 75);
    }

    @Test
    void createSimpleWireTest() {
        // given

        // when
        AOCWire wire = new AOCWire();
        wire.setWire(Arrays.asList(new AOCPatch("R75")));

        // then
        Assertions.assertEquals(wire.getPatches().size(), 1);
    }

    @Test
    void createSimpleWireTest2() {
        // given

        // when
        AOCWire wire = new AOCWire("R75,D4");

        // then
        Assertions.assertEquals(wire.getPatches().size(), 2);
    }

    @Test
    void wireToPatchesTest() {
        // given
        AOCWire wire = new AOCWire("R75,D30,R83,U83");

        // when
        List<AOCPatch> patches = wire.getPatches();

        // then
        Assertions.assertEquals(patches.size(), 4);
        Assertions.assertEquals(patches.get(0).getDirection() + patches.get(0).getDistance(), "R75");
        Assertions.assertEquals(patches.get(1).getDirection() + patches.get(1).getDistance(), "D30");
        Assertions.assertEquals(patches.get(2).getDirection() + patches.get(2).getDistance(), "R83");
        Assertions.assertEquals(patches.get(3).getDirection() + patches.get(3).getDistance(), "U83");
    }

    @Test
    void findMaxGridSizeForWireTest() {
        // given
        AOCWire wire = new AOCWire("R75,D30,R83,U83");

        // when
        int dimension = wire.getMaxGridSize();
        // then
        Assertions.assertEquals(dimension, 75 + 30 + 83 + 83);

    }

    @Test
    void findMaxGridSizeTest() {
        // given
        List<AOCWire> wires = Arrays.asList(new AOCWire("R1,D2,R3,U99"), new AOCWire("R1,U2,R3,D1"));

        int maxRows = 105;

        // when
        int dimension = AOCGrid.findMaxGridSize(wires);
        // then
        Assertions.assertEquals(dimension, maxRows);

    }

    @Test
    void buildWiresFromFileTest() {
        // given

        // when
        List<AOCWire> wires = AOCWire.buildWiresFromInput(AOCHelper.ReadFileByLineString(3, 1));

        int sizeWire1 = wires.get(0).getPatches().size();
        int sizeWire2 = wires.get(1).getPatches().size();

        // then

        Assertions.assertEquals(wires.size(), 2);
        Assertions.assertEquals(wires.get(0).getPatches().get(0).getDirection(), "R");
        Assertions.assertEquals(wires.get(0).getPatches().get(0).getDistance(), 995);
        Assertions.assertEquals(wires.get(1).getPatches().get(0).getDirection(), "L");
        Assertions.assertEquals(wires.get(1).getPatches().get(0).getDistance(), 999);

        Assertions.assertEquals(wires.get(0).getPatches().get(sizeWire1 - 1).getDirection(), "R");
        Assertions.assertEquals(wires.get(0).getPatches().get(sizeWire1 - 1).getDistance(), 915);
        Assertions.assertEquals(wires.get(1).getPatches().get(sizeWire2 - 1).getDirection(), "L");
        Assertions.assertEquals(wires.get(1).getPatches().get(sizeWire2 - 1).getDistance(), 534);

    }

    @Test
    void getMaxGridSizeTest() {
        // given

        // when
        List<AOCWire> wires = AOCWire.buildWiresFromInput(AOCHelper.ReadFileByLineString(3, 1));

        // then
        System.out.println(AOCGrid.findMaxGridSize(wires));
    }

    @Test
    void findGridCenterTest() {
        // given
        List<AOCWire> wires = AOCWire.buildWiresFromInput(AOCHelper.ReadFileByLineString(3, 1));
        AOCGrid grid = new AOCGrid(2000);

        // when

        // then
        Assertions.assertEquals(grid.getCenterPos().getRowIndex(), 2000 / 2);
        Assertions.assertEquals(grid.getCenterPos().getColIndex(), 2000 / 2);
    }

    @Test
    void getGridValueTest() {
        // given
        AOCGrid grid = new AOCGrid(3);

        // when
        grid.setGridValue(new AOCPosition(0, 0), 0);
        grid.setGridValue(new AOCPosition(0, 1), 1);
        grid.setGridValue(new AOCPosition(0, 2), 2);
        grid.setGridValue(new AOCPosition(1, 0), 3);
        grid.setGridValue(new AOCPosition(1, 1), 4);
        grid.setGridValue(new AOCPosition(1, 2), 5);
        grid.setGridValue(new AOCPosition(2, 0), 6);
        grid.setGridValue(new AOCPosition(2, 1), 7);
        grid.setGridValue(new AOCPosition(2, 2), 8);
        grid.printGrid();
        // then
        Assertions.assertEquals(grid.getGridValue(new AOCPosition(0, 0)), 0);
        Assertions.assertEquals(grid.getGridValue(new AOCPosition(0, 1)), 1);
        Assertions.assertEquals(grid.getGridValue(new AOCPosition(0, 2)), 2);
        Assertions.assertEquals(grid.getGridValue(new AOCPosition(1, 0)), 3);
        Assertions.assertEquals(grid.getGridValue(new AOCPosition(1, 1)), 4);
        Assertions.assertEquals(grid.getGridValue(new AOCPosition(1, 2)), 5);
        Assertions.assertEquals(grid.getGridValue(new AOCPosition(2, 0)), 6);
        Assertions.assertEquals(grid.getGridValue(new AOCPosition(2, 1)), 7);
        Assertions.assertEquals(grid.getGridValue(new AOCPosition(2, 2)), 8);
    }

    @Test
    void markGridTest1() {
        // given
        AOCGrid grid = new AOCGrid(5);

        // when
        grid.printGrid();
        grid.layWireUp(2, 1);
        System.out.println();
        grid.printGrid();
        // then
        Assertions.assertEquals(grid.getGridValue(new AOCPosition(0, 2)), 1);
        Assertions.assertEquals(grid.getGridValue(new AOCPosition(1, 2)), 1);

    }

    @Test
    void markGridTest2() {
        // given
        AOCGrid grid = new AOCGrid(5);

        // when
        grid.printGrid();
        grid.layWireDown(2, 1);
        System.out.println();
        grid.printGrid();
        // then
        Assertions.assertEquals(grid.getGridValue(new AOCPosition(3, 2)), 1);
        Assertions.assertEquals(grid.getGridValue(new AOCPosition(4, 2)), 1);

    }

    @Test
    void markGridTest3() {
        // given
        AOCGrid grid = new AOCGrid(5);

        // when
        grid.printGrid();
        grid.layWireLeft(2, 1);
        System.out.println();
        grid.printGrid();
        // then
        Assertions.assertEquals(grid.getGridValue(new AOCPosition(2, 0)), 1);
        Assertions.assertEquals(grid.getGridValue(new AOCPosition(2, 1)), 1);

    }

    @Test
    void markGridTest4() {
        // given
        AOCGrid grid = new AOCGrid(5);

        // when
        grid.printGrid();
        grid.layWireRight(2, 1);
        System.out.println();
        grid.printGrid();
        // then
        Assertions.assertEquals(grid.getGridValue(new AOCPosition(2, 3)), 1);
        Assertions.assertEquals(grid.getGridValue(new AOCPosition(2, 4)), 1);

    }

    @Test
    void addWire() {
        // given
        AOCGrid grid = new AOCGrid(5);
        AOCWire wire = new AOCWire("R1,U1,L2,D2,R3,U1,L1");
        // when
        grid.applyWire(wire, 1);
        grid.printGrid();
        // then
        Assertions.assertEquals(grid.getGridValue(new AOCPosition(2, 3)), 1);

    }

    @Test
    void findClosestCrossing2() {
        // given

        List<AOCWire> wires = Arrays.asList(new AOCWire("R8,U5,L5,D3"), new AOCWire("U7,R6,D4,L4"));
        AOCGrid grid = new AOCGrid(20);

        // when
        grid.applyWire(wires.get(0), 1);

        grid.applyWire(wires.get(1), 2);
        grid.printGrid();
        int mD = grid.calcManhattendistance();
        System.out.println(mD);
        Collections.sort(grid.crossings);
        System.out.println(grid.crossings);
        System.out.println("RESULT:" + grid.crossings.get(0));
        // then
        Assertions.assertEquals(6, grid.crossings.get(0));
    }

    @Test
    void findClosestCrossing3() {
        // given

        List<AOCWire> wires = Arrays.asList(new AOCWire("R75,D30,R83,U83,L12,D49,R71,U7,L72"),
                new AOCWire("U62,R66,U55,R34,D71,R55,D58,R83"));
        AOCGrid grid = new AOCGrid(600);

        // when
        grid.applyWire(wires.get(0), 1);
        grid.applyWire(wires.get(1), 2);
        // grid.printGrid();
        int mD = grid.calcManhattendistance();
        Collections.sort(grid.crossings);
        System.out.println(grid.crossings);
        System.out.println("RESULT:" + grid.crossings.get(0));

        // then
        Assertions.assertEquals(159, grid.crossings.get(0));
    }

    @Test
    void findClosestCrossing4() {
        // given

        List<AOCWire> wires = Arrays.asList(new AOCWire("R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51"),
                new AOCWire("U98,R91,D20,R16,D67,R40,U7,R15,U6,R7"));
        AOCGrid grid = new AOCGrid(700);

        // when
        grid.applyWire(wires.get(0), 1);
        grid.applyWire(wires.get(1), 2);
        int mD = grid.calcManhattendistance();
        Collections.sort(grid.crossings);
        System.out.println(grid.crossings);
        System.out.println("RESULT:" + grid.crossings.get(0));
        // then
        Assertions.assertEquals(135, grid.crossings.get(0));
    }

    @Test
    void findClosestCrossing5() {
        // given
        List<AOCWire> wires = AOCWire.buildWiresFromInput(AOCHelper.ReadFileByLineString(3, 1));
        AOCGrid grid = new AOCGrid(25000);
        // when
        grid.applyWire(wires.get(0), 1);
        grid.applyWire(wires.get(1), 2);

        Collections.sort(grid.crossings);
        System.out.println(grid.crossings);
        System.out.println("RESULT:" + grid.crossings.get(0));
        // then
        Assertions.assertEquals(5319, grid.crossings.get(0));
    }

    @Test
    void positionEqualityTest() {
        // given
        AOCPosition pos1 = new AOCPosition(1, 1);
        AOCPosition pos2 = new AOCPosition(1, 1);

        // when

        // then
        Assertions.assertEquals(pos1, pos2);
    }
}
