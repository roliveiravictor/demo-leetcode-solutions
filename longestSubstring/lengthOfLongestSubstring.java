package com.leetcode.lengthOfLongestSubstring;

/*
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 */

import com.leetcode.interfaces.MineSolution;

import java.util.HashSet;
import java.util.Set;

@MineSolution
public class Solution {

    private int maxSubStringLength = 0;

    public int lengthOfLongestSubstring(String input) {
        if(input.isEmpty()){
            return maxSubStringLength;
        }
        getMaxSubStringLength(input);
        return maxSubStringLength;
    }

    private void getMaxSubStringLength(String input){
        final Set<Character> charSet = new HashSet<>();
        for(int charPosition = 0; charPosition < input.length(); charPosition++){
            final char mChar = input.charAt(charPosition);
            if(charSet.contains(mChar)){
                maxSubStringLength = Math.max(maxSubStringLength, charPosition);
                final String nextSubString = input.substring(Constants.SECOND_INDEX);
                getMaxSubStringLength(nextSubString);
                return;
            }
            charSet.add(mChar);
        }
        maxSubStringLength = Math.max(maxSubStringLength, input.length());
    }

    private class Constants {
        private static final int SECOND_INDEX = 1;
    }
}

@LeetCodeSolution
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j <= n; j++)
                if (allUnique(s, i, j)) ans = Math.max(ans, j - i);
        return ans;
    }

    public boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            Character ch = s.charAt(i);
            if (set.contains(ch)) return false;
            set.add(ch);
        }
        return true;
    }
}
