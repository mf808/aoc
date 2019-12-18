package com.bmw.back2code.aoc;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class Day2_1 {

    // OPCODES
    private static int ADD = 1;
    private static int MUL = 2;
    private static int END = 99;

    private static int COMMAND_LENGTH = 4;

    static Map<Integer, BiFunction<Integer, Integer, Integer>> execute;

    public static int[] initMemory() {

        int[] memory = AOCHelper.ReadFileByCommaIntArray(2, 1);
        memory[1] = 12;
        memory[2] = 2;

        return memory;

    }

    private static int getValue(int[] program, int position) {

        return program[position];

    }

    public static int runProgram(int[] program) {
        execute = new HashMap<>();

        execute.put(ADD, (a, b) -> {
            return a + b;
        });
        execute.put(MUL, (a, b) -> {
            return a * b;
        });

        for (int i = 0; program[i] != END; i += 4) {
            int resultPos = program[i + 3];
            int opcode = program[i];
            int operand1Pos = getValue(program, program[i + 1]);
            int operand2Pos = getValue(program, program[i + 2]);

            program[resultPos] = execute.get(opcode).apply(operand1Pos, operand2Pos);
            System.out.println(
                    "calculated:" + opcode + " " + operand1Pos + " " + operand2Pos + " = " + program[resultPos]);
        }

        return program[0];

    }

    public static void main(String[] args) {

        int[] program = initMemory();
        System.out.println(runProgram(program));

    }

}
