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

  private final int FIRST_INDEX = 0;
  private final String EMPTY_STRING = "";

  public int lengthOfLongestSubsequence(String inputString) {
      String outputString = "";
      while(!inputString.isEmpty()){
          char firstInputCharacter = inputString.charAt(FIRST_INDEX);
          outputString += firstInputCharacter;

          String toBeReplacedChar = String.valueOf(firstInputCharacter);
          inputString = inputString.replaceAll(toBeReplacedChar, EMPTY_STRING);
      }
      return outputString.length();
  }
}
