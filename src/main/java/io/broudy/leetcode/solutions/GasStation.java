package io.broudy.leetcode.solutions;

/**
 * <a href="https://leetcode.com/problems/gas-station">134. Gas Station</a>.
 *
 * @author <a href="https://github.com/JulianBroudy">Julian Broudy</a>
 */
public class GasStation {
    public static void main(String[] args) {
//        int[] gas = new int[]{1, 2, 3, 4, 5};
//        int[] cost = new int[]{3, 4, 5, 1, 2};
//        int[] gas = new int[]{5, 1, 2, 3, 4};
//        int[] cost = new int[]{4, 4, 1, 5, 1};
        int[] gas = new int[]{5, 8, 2, 8};
        int[] cost = new int[]{6, 5, 6, 6};

        System.out.println(canCompleteCircuit(gas, cost));
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int cSum = 0, totalSum = 0;
        int startingPoint = 0;
        int diffSum;
        for (int i = 0; i < gas.length; i++) {
            diffSum = gas[i] - cost[i];
            cSum += diffSum;
            totalSum += diffSum;
            if (cSum < 0) {
                cSum = 0;
                startingPoint = (i + 1) % gas.length;
            }
        }
        return totalSum < 0 ? -1 : startingPoint;
    }

}
