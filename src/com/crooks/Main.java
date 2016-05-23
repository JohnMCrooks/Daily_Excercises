package com.crooks;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        //Goal: To return a hash index of the following names sorted by First letter

	String[] names = {"ALice", "Bob", "Charlie", "David", "Andrea", "Albert", "Beth", "John"};
        // want the outcome to be returned as shown below.
        //"A": ["Alice", "Andrea", "Albert"]
        //"B": ["Bob", "Beth"]
        //"C": ["Charlie"]
        //"D": ["David"]

    HashMap<String, ArrayList<String>> nameMap = new HashMap<String, ArrayList<String>>();
        for (String name: names) {
            char firstLetter = name.charAt(0);
            String firstLetterStr = String.valueOf(firstLetter);
            nameMap.put(firstLetterStr, new ArrayList<String>());
        }

        for (String name: names) {
            char firstLetter = name.charAt(0);
            String firstLetterStr = String.valueOf(firstLetter);
            ArrayList<String> arr = nameMap.get(firstLetterStr);
            arr.add(name);
        }
        System.out.println(nameMap);

        //Alternative solution to the above.
        nameMap = new HashMap<String, ArrayList<String>>();
        for (String name: names
             ) {
            char firstLetter = name.charAt(0);
            String firstLetterStr = String.valueOf(firstLetter);
            ArrayList<String> arr = nameMap.get(firstLetterStr);
            //on first round through  we check to see if the first letter has been used, if it hasn't we add it into the hashmap with the name
            if (arr == null){
                arr = new ArrayList<String>();
                arr.add(name);
                nameMap.put(firstLetterStr, arr);
            }
            else {
                //don't need to use nameMap.put() because it has already been populated with the first letter above
                arr.add(name);
            }

        }
    }
}
