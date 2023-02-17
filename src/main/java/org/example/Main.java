package org.example;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("sample_prefixes.txt"));
        ArrayList<String> prefixList = new ArrayList<String>();
        while (scanner.hasNext()){
            prefixList.add(scanner.next());
        }
        scanner.close();

        String inputString = "HYsHo4jasdjahsdkj";

        String longestPrefix = findLongestPrefix(inputString, prefixList);

        System.out.println("Longest matching prefix: " + longestPrefix);

    }



    public static String findLongestPrefix(String inputString, List<String> prefixList) {
        String longestPrefix = "";

        Collections.sort(prefixList);

        for (int i = 0;i<inputString.length();i++){
            String searchKey = inputString.substring(0,i);
            if(Collections.binarySearch(prefixList,searchKey)>0){
                int index = Collections.binarySearch(prefixList,searchKey);
                longestPrefix = prefixList.get(index);
            }
        }

        return longestPrefix;
    }
}