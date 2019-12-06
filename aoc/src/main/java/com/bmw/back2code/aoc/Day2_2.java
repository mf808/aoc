package com.bmw.back2code.aoc;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class Day2_2 {

    // OPCODES
    private static int ADD = 1;
    private static int MUL = 2;
    private static int END = 99;

    private static int COMMAND_LENGTH = 4;

    static Map<Integer, BiFunction<Integer, Integer, Integer>> execute;

    public static int[] initMemory(int noun, int verb) {

        int[] memory = AOCHelper.ReadFileByCommaIntArray(2, 2);
        memory[1] = noun;
        memory[2] = verb;

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
        }

        return program[0];

    }

    public static void main(String[] args) {
        int noun = 0;
        int verb = 0;

        int result = -1;

        for (noun = 0; noun < 100; noun++) {
            for (verb = 0; verb < 100; verb++) {
                int[] program = initMemory(noun, verb);
                try {
                    result = runProgram(program);
                } catch (RuntimeException e) {

                }

                if (result == 19690720) {
                    System.out.println("Noun:" + noun + " Verb:" + verb);
                    break;
                }
            }

        }

    }

}
