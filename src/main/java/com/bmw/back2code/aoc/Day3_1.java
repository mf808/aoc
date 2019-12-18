package com.bmw.back2code.aoc;

import java.util.*;

public class Day3_1 {

    public static class AOCGrid {
        int[][] grid;
        AOCPosition centerPos;
        AOCPosition currentPos;
        List<Integer> crossings;
        Map<String, Integer> steps;
        List<Integer> stepCounter;


        public AOCGrid(int size) {
            if (size % 2 == 0) {
                this.grid = new int[size + 1][size + 1];
            } else {
                this.grid = new int[size][size];
            }
            this.centerPos = getGridCenter();
            this.currentPos = getGridCenter();
            crossings = new ArrayList<>();
            steps = new HashMap<>();
            stepCounter = new ArrayList<>();
            stepCounter.add(0);
            stepCounter.add(0);
            stepCounter.add(0);


        }

        void initPositions() {
            this.centerPos = getGridCenter();
            this.currentPos = getGridCenter();
        }

        public void printCurrentPosition() {
            System.out.print("Current ");
            printPosition(currentPos);
        }

        public void printCenterPosition() {
            System.out.print("Center ");
            printPosition(centerPos);
        }

        public void printPosition(AOCPosition pos) {
            System.out.println(" position is:" + pos.getRowIndex() + " " + pos.getColIndex());
        }

        public static int findMaxGridSize(List<AOCWire> wires) {
            return wires.stream().mapToInt(AOCWire::getMaxGridSize).max().orElse(-1);
        }

        public AOCPosition getGridCenter() {
            return new AOCPosition((this.grid.length / 2), (this.grid[1].length / 2));
        }

        public int getGridValue(AOCPosition pos) {
            return this.grid[pos.getRowIndex()][pos.getColIndex()];
        }

        public void setGridValue(AOCPosition pos, int value) {
            this.grid[pos.getRowIndex()][pos.getColIndex()] = value;
        }

        public AOCPosition getCenterPos() {
            return this.centerPos;
        }

        public void setCenterPos(AOCPosition pos) {
            this.centerPos = pos;
        }

        public AOCPosition getCurrentPos() {
            return this.currentPos;
        }

        public void setCurrentPos(AOCPosition pos) {
            this.currentPos = pos;
        }

        public void layWireUp(int numSteps, int wireId) {

            for (int i = 0; i < numSteps; i++) {
                currentPos.goUp();
                markGrid(currentPos, wireId);

            }

        }

        public void layWireDown(int numSteps, int wireId) {

            for (int i = 0; i < numSteps; i++) {
                currentPos.goDown();
                markGrid(currentPos, wireId);

            }

        }

        public void layWireLeft(int numSteps, int wireId) {

            for (int i = 0; i < numSteps; i++) {
                currentPos.goLeft();
                markGrid(currentPos, wireId);

            }

        }

        public void layWireRight(int numSteps, int wireId) {

            for (int i = 0; i < numSteps; i++) {
                currentPos.goRight();
                markGrid(currentPos, wireId);

            }

        }

        public void markGrid(AOCPosition pos, int wireId) {


            stepCounter.set(wireId, stepCounter.get(wireId) + 1);

            int row = pos.getRowIndex();
            int col = pos.getColIndex();
            if (grid[row][col] == 1 && grid[row][col] != wireId) {
                grid[row][col] = 3;
                int distance = (Math.abs(col - getGridCenter().getColIndex())
                        + Math.abs(row - getGridCenter().getRowIndex()));

                crossings.add(distance);
                String key = Integer.toString(row) + col;

                if (!steps.containsKey(key)) {
                    steps.put(key, stepCounter.get(wireId));
                } else {
                    steps.put(key, steps.get(key) + stepCounter.get(wireId));

                }

                System.out.println("Crossing " + steps.size() + "at:" + row + " " + col);
                System.out.println("Distance is:" + distance);
                System.out.println("Step is:" + stepCounter.get(wireId));
            } else {
                grid[row][col] = wireId;
            }

        }

        public void resetGrid(int size) {
            if (size % 2 == 0) {
                this.grid = new int[size + 1][size + 1];
            } else {
                this.grid = new int[size][size];
            }
        }

        public void printGrid() {
            for (int[] ints : grid) {
                for (int j = 0; j < ints.length; j++) {
                    System.out.print(ints[j] + " ");
                }
                System.out.println();
            }
        }

        public void applyWire(AOCWire wire, int wireId) {
            System.out.println("Size of Patches on wire:" + wire.getPatches().size());
            initPositions();
            printCenterPosition();
            printCurrentPosition();
            for (AOCPatch patches : wire.getPatches()) {
                System.out.println(patches.getDirection() + patches.getDistance());
                if (patches.getDirection().equals("U")) {
                    layWireUp(patches.getDistance(), wireId);
                }
                if (patches.getDirection().equals("D")) {
                    layWireDown(patches.getDistance(), wireId);
                }
                if (patches.getDirection().equals("L")) {
                    layWireLeft(patches.getDistance(), wireId);
                }
                if (patches.getDirection().equals("R")) {
                    layWireRight(patches.getDistance(), wireId);
                }
            }

        }


    }

    public static class AOCPosition {

        private int rowIndex;
        private int colIndex;

        public AOCPosition(int row, int column) {
            this.rowIndex = row;
            this.colIndex = column;
        }

        public int getRowIndex() {
            return rowIndex;
        }

        public void setRowIndex(int rowIndex) {
            this.rowIndex = rowIndex;
        }

        public int getColIndex() {
            return colIndex;
        }

        public void setColIndex(int colIndex) {
            this.colIndex = colIndex;
        }

        private void goUp() {
            rowIndex -= 1;
        }

        private void goDown() {
            rowIndex += 1;
        }

        private void goLeft() {
            colIndex -= 1;
        }

        private void goRight() {
            colIndex += 1;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + colIndex;
            result = prime * result + rowIndex;
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            AOCPosition other = (AOCPosition) obj;
            if (colIndex != other.colIndex)
                return false;
            return rowIndex == other.rowIndex;
        }

    }

    public static class AOCPatch {
        private String direction;
        private int distance;

        public AOCPatch(String patch) {
            this.direction = patch.substring(0, 1);
            this.distance = Integer.parseInt(patch.substring(1));
        }

        public String getDirection() {
            return direction;
        }

        public void setDirection(String direction) {
            this.direction = direction;
        }

        public int getDistance() {
            return distance;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }

    }

    public static class AOCWire {
        private List<AOCPatch> patches;

        public AOCWire() {
            this.patches = new ArrayList<>();
        }

        public AOCWire(String stringWire) {

            this.patches = processWire(stringWire);
        }

        private List<AOCPatch> processWire(String wire) {

            List<AOCPatch> patches = new ArrayList<>();
            for (String p : wire.split(",")) {

                patches.add(new AOCPatch(p));
            }

            return patches;
        }

        public int getMaxGridSize() {
            return patches.stream().mapToInt(AOCPatch::getDistance).sum();
        }

        public List<AOCPatch> getPatches() {
            return patches;
        }

        public void setWire(List<AOCPatch> wire) {
            this.patches = wire;
        }

        public static List<AOCWire> buildWiresFromInput(List<String> readFileByLineString) {

            List<AOCWire> wires = new ArrayList<>();

            for (String line : readFileByLineString) {
                wires.add(new AOCWire(line));

            }

            return wires;
        }

    }
}
