package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File("sample_prefixes.txt"));
        ArrayList<String> prefixList = new ArrayList<>();
        while (scanner.hasNext()){
            prefixList.add(scanner.next());
        }
        scanner.close();

        String input = "xzDD01KZeasdasdasd";

        PrefixFinder matcher = new PrefixFinder(prefixList);
        String longestMatchingPrefix = matcher.findLongestMatchingPrefix(input);
        System.out.println(longestMatchingPrefix);

    }


}