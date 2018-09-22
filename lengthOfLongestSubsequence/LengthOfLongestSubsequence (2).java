package com.leetcode.lengthOfLongestSubsequence;

/*
 *
 *   Given a string, find the length of the longest subsequence without repeating characters.
 *
 *   Example:
 *
 *   Input: "pwwkew"
 *   Output: 4
 *   Explanation: The answer is "pwke", with the length of 4.
 *
 */

import com.leetcode.interfaces.MineSolution;

@MineSolution
public class Solution {

    public int lengthOfLongestSubsequence(String inputString) {
        String outputString = "";
        while(!inputString.isEmpty()){
            char firstInputCharacter = inputString.charAt(Constants.FIRST_INDEX);
            outputString += firstInputCharacter;

            String toBeReplacedChar = String.valueOf(firstInputCharacter);
            inputString = inputString.replaceAll(toBeReplacedChar, Constants.EMPTY_STRING);
        }
        return outputString.length();
    }

    private class Constants {

        public static final String EMPTY_STRING = "";
        public static final int FIRST_INDEX = 0;

    }

}