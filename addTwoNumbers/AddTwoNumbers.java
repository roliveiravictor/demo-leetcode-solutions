/**

You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.

**/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

@MineSolution
import java.math.BigInteger;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String firstNumber = getLinkedListNodeValue(l1);
        String secondNumber = getLinkedListNodeValue(l2);

        String somatory = getSomatory(firstNumber, secondNumber);

        return buildNewListNode(somatory);
    }

    private String getLinkedListNodeValue(ListNode listRunner){
        StringBuilder concatenatedValue = new StringBuilder();
        while(listRunner != null) {
            concatenatedValue.append(listRunner.val);
            listRunner = listRunner.next;
        }
        return concatenatedValue.reverse().toString();
    }

    private String getSomatory(String firstNumber, String secondNumber){
        final BigInteger firstBig = new BigInteger(firstNumber);
        final BigInteger secondBig = new BigInteger(secondNumber);
        final BigInteger somatory = firstBig.add(secondBig);
        return String.valueOf(somatory);
    }

    private ListNode buildNewListNode(String somatory) {
        StringBuilder revertedValue = new StringBuilder(somatory).reverse();
        somatory = revertedValue.toString();

        int headPosition = getCharValue(somatory, 0);
        ListNode headNode = new ListNode(headPosition);

        ListNode toBeLinkedNode = null;
        ListNode previousLinkedNode = null;
        for(int i = 1 ; i < somatory.length() ; i++) {
            int currentValue = getCharValue(somatory, i);
            if(headNode.next == null) {
                toBeLinkedNode = new ListNode(currentValue);
                headNode.next = toBeLinkedNode;
            } else {
                previousLinkedNode = toBeLinkedNode;
                toBeLinkedNode = new ListNode(currentValue);
                previousLinkedNode.next = toBeLinkedNode;
            }
        }
        return headNode;
    }

    private int getCharValue(String mString, final int position){
        final char character = mString.charAt(position);
        return Character.getNumericValue(character);
    }
}

@LeetCodeSolution
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode dummyHead = new ListNode(0);
    ListNode p = l1, q = l2, curr = dummyHead;
    int carry = 0;
    while (p != null || q != null) {
        int x = (p != null) ? p.val : 0;
        int y = (q != null) ? q.val : 0;
        int sum = carry + x + y;
        carry = sum / 10;
        curr.next = new ListNode(sum % 10);
        curr = curr.next;
        if (p != null) p = p.next;
        if (q != null) q = q.next;
    }
    if (carry > 0) {
        curr.next = new ListNode(carry);
    }
    return dummyHead.next;
}
