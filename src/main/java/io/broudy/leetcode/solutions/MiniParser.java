package io.broudy.leetcode.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.broudy.leetcode.misc.NestedInteger;

/**
 * 385. Mini Parser
 * 
 * https://leetcode.com/problems/mini-parser/description/
 */
public class MiniParser {

    public static void main(String[] args) {
        // final String s = "123,[456,[789]]";
        final String s = "[123,456,[788,799,833],[[]],10,[]]";

        System.out.println(deserialize(s));
    }

    public static NestedInteger deserialize(String s) {
        if (s.charAt(0) != '[') {
            return new NestedInteger(Integer.valueOf(s));
        } else {
            return deserializeList(s.substring(1, s.length() - 1), true);
        }
    }

    private static NestedInteger deserializeList(String s, boolean isList) {

        final List<NestedInteger> listOfNestedIntegers = new ArrayList<>();

        char ch;
        int[] endsOfInteger = new int[2];
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);

            if ((ch >= '0' && ch <= '9') || ch == '-') {
                int endOfInteger = s.length();
                endsOfInteger[0] = s.indexOf(',', i);
                endsOfInteger[1] = s.indexOf(']', i);
                Arrays.sort(endsOfInteger);
                for (int end : endsOfInteger) {
                    if (end != -1) {
                        endOfInteger = end;
                        break;
                    }
                }
                listOfNestedIntegers
                        .add(new NestedInteger(Integer.valueOf(s.substring(i, endOfInteger))));
                i = endOfInteger;
            } else if (ch == '[') {
                final int jumpTo = i + findEndOfList(s.substring(i + 1));
                listOfNestedIntegers.add(deserializeList(s.substring(i + 1, jumpTo + 1), true));
                i = jumpTo;
            }
        }

        if (isList) {
            final NestedInteger nestedInteger = new NestedInteger();
            for (NestedInteger nested : listOfNestedIntegers) {
                nestedInteger.add(nested);
            }
            return nestedInteger;
        } else {
            return listOfNestedIntegers.get(0);
        }
    }

    private static int findEndOfList(String substring) {
        int leftBrackets = 1;

        char ch;
        for (int i = 0; i < substring.length(); i++) {
            ch = substring.charAt(i);
            if (ch == ']') {
                leftBrackets--;
            } else if (ch == '[') {
                leftBrackets++;
            }
            if (leftBrackets == 0) {
                return i;
            }
        }

        return -1;
    }

}
