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

    private String longestSubString = "";
    private String subStringRemain = "";

    public int lengthOfLongestSubstring(String input) {
        if (input.isEmpty() && !subStringRemain.isEmpty())
            input = subStringRemain;

        final char toEvaluateChar = input.charAt(Constants.FIRST_INDEX);
        final String toEvaluateString = String.valueOf(toEvaluateChar);
        if (!longestSubString.contains(toEvaluateString)) {
            longestSubString += toEvaluateString;
        }

        input = input.replaceFirst(toEvaluateString, Constants.EMPTY_STRING);
        if (!input.isEmpty())
            lengthOfLongestSubstring(input);

        return longestSubString.length();
    }

    private class Constants {

        public static final String EMPTY_STRING = "";
        public static final int FIRST_INDEX = 0;

    }
}