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

@MineSolution
public class Solution {

    public int lengthOfLongestSubsequence(String s) {
        String output = "";
        while(!s.isEmpty()){
            char firstChar = s.charAt(0);
            output += firstChar;
            s = s.replaceAll(String.valueOf(firstChar), "");
        }
        return output.length();
    }

}
