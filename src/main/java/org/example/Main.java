package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){


        Scanner scanner;
        try {
            scanner = new Scanner(new File("sample_prefixes.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        ArrayList<String> prefix_list = new ArrayList<>();
        while (scanner.hasNext()){
            prefix_list.add(scanner.next());
        }
        scanner.close();

        //Input string
        String inputString = "2y3fKTSabcd";

        String longestPrefix = findLongestPrefix(inputString, prefix_list);

        System.out.println("Longest matching prefix: " + longestPrefix);

    }



    public static String findLongestPrefix(String inputString, List<String> prefixList) {
        String longestPrefix = "";

        for (int i = 1;i<prefixList.size();i++) {
            if (inputString.startsWith(prefixList.get(i)) && prefixList.get(i).length() > longestPrefix.length()){
                longestPrefix = prefixList.get(i);
            }
        }
        return longestPrefix;
    }
}