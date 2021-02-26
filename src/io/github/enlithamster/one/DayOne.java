package io.github.enlithamster.one;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import io.github.enlithamster.DayChallenge;
import io.github.enlithamster.FileLoader;

public class DayOne implements DayChallenge {

    public void launch() {

        // Setup
        ArrayList<Integer> numbers = new ArrayList<>();
        
        try {
            // Reading numbers from input file
            File input = FileLoader.getFile2("one/input.txt");
            Scanner fileReader = new Scanner(input);
            while (fileReader.hasNextInt()) numbers.add(fileReader.nextInt());
            fileReader.close();

            // Sorting the numbers
            Collections.sort(numbers);
            Integer[] keys = getKeys(numbers, 2020);
            if (keys != null) System.out.println("The searched numbers are " + keys[0] + " and " + keys[1] + ".");
            else System.out.println("No keys found.");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * Binary search algorithm for the two keys.
     * 
     * @param numbers List of sorted numbers to research
     * @param target Target sum to find
     * @return
     */
    private Integer[] getKeys(List<Integer> numbers, Integer target) {
        // Unsuccessful search
        if (numbers.isEmpty()) return null;

        Integer key1 = numbers.get(0);
        Integer i2 = getKeys(target, key1, numbers);
        if (i2 != -1) return new Integer[] {key1, numbers.get(i2)};
        else return getKeys(numbers.subList(1, numbers.size()), target);
    }

    private Integer getKeys(Integer target, Integer key1, List<Integer> numbers) {
        // Unsuccessful search
        if (numbers.isEmpty()) return -1;

        Integer pivot = numbers.size() / 2;
        Integer key2 = numbers.get(pivot);
        Integer attempt = key1 + key2;
        if (attempt == target) return pivot;
        else if (attempt < target) return getKeys(target, key1, numbers.subList(0, pivot));
        else return getKeys(target, key1, numbers.subList(pivot + 1, numbers.size()));
    }

}
