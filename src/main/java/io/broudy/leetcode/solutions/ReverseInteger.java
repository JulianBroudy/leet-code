package io.broudy.leetcode.solutions;

/**
 * <a href="https://leetcode.com/problems/reverse-integer/">7. Reverse Integer</a>.
 *
 * @author <a href="https://github.com/JulianBroudy">Julian Broudy</a>
 */
public class ReverseInteger {
    public static void main(String[] args) {
        int integer = -1463847413;
        System.out.println(reverse(integer));
    }

    public static int reverse(int x) {
        StringBuilder builder = new StringBuilder(String.valueOf(x));
        boolean negative = false;
        if (builder.charAt(0) == '-') {
            negative = true;
            builder.deleteCharAt(0);
        }
        try {
            int reversedInt = Integer.parseInt(builder.reverse().toString());
            if (negative) {
                reversedInt *= -1;
            }
            return reversedInt;
        } catch (NumberFormatException e) {
            return 0;
        }
    }

}
