package com.example.java8.java8features.multithreading;

import java.util.HashMap;
import java.util.Map;

public class Test {

    public static void main(String[] args) {
        System.out.println(getUniqueCharacterSubstring("abaabcbb"));
    }

    static String getUniqueCharacterSubstring(String input) {
        Map<Character, Integer> visited = new HashMap<>();
        String output = "";
        for (int start = 0, end = 0; end < input.length(); end++) {
            char currChar = input.charAt(end);
            if (visited.containsKey(currChar)) {
                start = Math.max(visited.get(currChar)+1, start);
            }
            if (output.length() < end - start + 1) {
                output = input.substring(start, end + 1);
            }
            visited.put(currChar, end);
        }
        return output;
    }
    public  static int lengthOfLongestSubstring(String s) {
        if(s==null)
            return 0;
        boolean[] flag = new boolean[256];
        int result = 0;
        int start = 0;
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char current = arr[i];
            if (flag[current]) {
                result = Math.max(result, i - start);
// the loop update the new start point
// and reset flag array
// for example, abccab, when it comes to 2nd c,
// it update start from 0 to 3, reset flag for a,b
                for (int k = start; k < i; k++) {
                    if (arr[k] == current) {
                        start = k + 1;
                        break;
                    }
                    flag[arr[k]] = false;
                }
            } else {
                flag[current] = true;
            }
        }
                result = Math.max(arr.length - start, result);
        return result;
    }

}
