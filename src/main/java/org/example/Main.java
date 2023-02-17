package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args){


        Scanner scanner;
        try {
            scanner = new Scanner(new File("sample_prefixes.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        ArrayList<String> prefixList = new ArrayList<>();
        while (scanner.hasNext()){
            prefixList.add(scanner.next());
        }
        scanner.close();

        //Input string
        String inputString = "Rhp1IhPabcd";

        String longestPrefix = findLongestPrefix(inputString, prefixList);

        System.out.println("Longest matching prefix: " + longestPrefix);

    }



    public static String findLongestPrefix(String inputString, List<String> prefixList) {
        String longestPrefix = "";

        String startingLetter = inputString.substring(0,1);

        List<String> filteredList = prefixList.stream().filter(s->s.startsWith(startingLetter)).toList();


        for (int i = 1;i<filteredList.size();i++) {
            if (inputString.startsWith(filteredList.get(i)) && filteredList.get(i).length() > longestPrefix.length()){
                longestPrefix = filteredList.get(i);
            }
        }
        return longestPrefix;
    }
}