package com.bmw.back2code.aoc;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AOCHelper {

    final static String PATH_TO_FILE = "C:\\develop\\adventOfCode\\aoc\\src\\main\\resources\\day";

    public static List<Integer> ReadFileByLineInt(int day, int part) {
        List<Integer> allLines = null;

        Path path = Paths.get(PATH_TO_FILE + day + "_" + part + ".txt");
        try {
            allLines = Files.readAllLines(path, StandardCharsets.UTF_8)
                    .stream()
                    .mapToInt(s -> Integer.parseInt(s))
                    .boxed()
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return allLines;

    }

    public static int[] ReadFileByLineIntArray(int day, int part) {
        int[] allLines = null;

        Path path = Paths.get(PATH_TO_FILE + day + "_" + part + ".txt");
        try {
            allLines = Files.readAllLines(path, StandardCharsets.UTF_8)
                    .stream()
                    .mapToInt(s -> Integer.parseInt(s))
                    .toArray();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return allLines;

    }

    public static int[] ReadFileByCommaIntArray(int day, int part) {
        int[] allLines = null;

        Path path = Paths.get(PATH_TO_FILE + day + "_" + part + ".txt");
        try {
            List<String> list = Files.readAllLines(path, StandardCharsets.UTF_8);

            allLines = Arrays.stream(list.get(0).split(",")).mapToInt(Integer::parseInt).toArray();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return allLines;

    }

    public List<String> ReadFileByLineString(int day, int part) {
        List<String> allLines = null;

        Path path = Paths.get(PATH_TO_FILE + day + "_" + part + ".txt");
        try {
            allLines = Files.readAllLines(path, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return allLines;

    }

    public String ReadFileByCommaString() {
        return null;

    }

}
