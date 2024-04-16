package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class DecodeMessage{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\ashis\\Downloads\\coding_qual_input.txt"));
        Map<Integer, String> map = new HashMap<>();
        String line = br.readLine();
        while (line != null) {
            String[] pairs = line.split(" ");
            map.put(Integer.valueOf(pairs[0]), pairs[1]);
            line = br.readLine();
        }
        String message = decodeMessage(map);
        System.out.println(message);
    }

    public static String decodeMessage(Map<Integer, String> map) {
        Set<Integer> keySetMaps = map.keySet();
        List<Integer> list = keySetMaps.stream().sorted().toList();
        List<List<String>> pyramid = new ArrayList<>();
        List<String> currentRow = new ArrayList<>();
        for (Integer keyNumber : list){
            currentRow.add(map.get(keyNumber));
            if (currentRow.size() >= pyramid.size()) {
                pyramid.add(new ArrayList<>(currentRow));
                currentRow.clear();
            }
            else {
                pyramid.get(pyramid.size() - 1).add(map.get(keyNumber));
            }
        }

        StringBuilder message = new StringBuilder();
        for (List<String> row : pyramid) {
            message.append(row.get(row.size() - 1));
            message.append(" ");
        }

        return message.toString();
    }
	
        String str = "12345";
        System.out.println(str.chars()
                .map(Character::getNumericValue)
                .sum());
}