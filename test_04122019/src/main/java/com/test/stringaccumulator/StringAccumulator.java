package com.test.stringaccumulator;

import java.util.*;

public class StringAccumulator {

    private int count = 0;
    public List<Integer> negativeNumbers = new ArrayList();

    public int add(String numbers){

        if(numbers.length() != 0){
            String delimters = createDelimiters(numbers);
            if(numbers.startsWith("//")){
                numbers = numbers.split("\\\\n")[1];
            }
            String[] numberStringArray = numbers.split(delimters);
            for(String numberStringElements : numberStringArray){
                int numberStringElementValue = Integer.parseInt(numberStringElements);
                if(numberStringElementValue < 0)
                    negativeNumbers.add(numberStringElementValue);
                else if(numberStringElementValue < 1000)
                    count += numberStringElementValue;
            }
        }
        return count;
    }

    private String createDelimiters(String numbersString){
        String delimiter = "[,\n]";
        List<String> multiDelimiter = new ArrayList();
        if(numbersString.startsWith("//")){
            //has custom delimeters
            String[] delimitersSet = numbersString.split("\\\\n")[0].substring(2).split("\\|");
            delimiter = "[,\n";
            for(String delimiterValue : delimitersSet){
                if(delimiterValue.length() >1 && checkUniqueCharStream(delimiterValue)){
                    multiDelimiter.add("\\"+delimiterValue.charAt(0)+"+");
                }else if(delimiterValue.length() >1 ){
                    multiDelimiter.add(delimiterValue);
                }else {
                    delimiter += delimiterValue;
                }
            }
            delimiter += "]";
        }
        if(!multiDelimiter.isEmpty()){
            String multiDelimiterString = String.join("|", multiDelimiter);
            return "("+delimiter+"|"+multiDelimiterString+")";
        }
        return delimiter;
    }

    private boolean checkUniqueCharStream(String s)
    {
        int n = s.length();
        for (int i = 1; i < n; i++)
            if (s.charAt(i) != s.charAt(0))
                return false;
        return true;
    }
}
