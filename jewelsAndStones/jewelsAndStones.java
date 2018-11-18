package com.leetcode.jewelsAndStones;

/*
 * You're given strings J representing the types of stones that are jewels,
 * and S representing the stones you have.  Each character in S is a type of stone you have.
 * You want to know how many of the stones you have are also jewels.
 *
 * The letters in J are guaranteed distinct, and all characters in J and S are letters.
 * Letters are case sensitive, so "a" is considered a different type of stone from "A".
 *
 */

import com.leetcode.interfaces.MineSolution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@MineSolution
public class Solution {

    public int numJewelsInStones(String jewelsId, String stones) {
        int jewelsAmount = 0;

        final List<Character> stonesList = stones.chars().mapToObj(e->(char) e).collect(Collectors.toList());
        for(char stone : stonesList)
            if(jewelsId.contains(String.valueOf(stone)))
                jewelsAmount++;

        return jewelsAmount;
    }

}

@TopLeetCodeSolution
public int numJewelsInStones(String J, String S) {
       int cntJewels = 0;
       if (J == null || J.length() == 0 || S == null || S.length() == 0) {
           return cntJewels;
       }
       int[] hash = new int[256];
       for (char ch : S.toCharArray()) {
           hash[ch]++;
       }
       for (char ch : J.toCharArray()) {
           if (hash[ch] != 0) {
               cntJewels += hash[ch];
               hash[ch] = 0;
           }
       }
       return cntJewels;
}
