package io.broudy.leetcode.solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/majority-element/">169. Majority Element</a>.
 *
 * @author <a href="https://github.com/JulianBroudy">Julian Broudy</a>
 */
public class MajorityElement {
    public static void main(String[] args) {
        int[] intArray = new int[]{3,2,3,2,2,3,2};
        System.out.println(majorityElement(intArray));
    }

    private static int majorityElement(int[] nums) {
        Map<Integer, Integer> numberToCountMapping = new HashMap<>();
        for (int num : nums) {
            numberToCountMapping.compute(num, (k, v) -> v == null ? 0 : v + 1);
        }
        int majorityElement = nums[0];
        int lastMajorityCount = 0;
        for (Map.Entry<Integer, Integer> entry : numberToCountMapping.entrySet()) {
            if(entry.getValue()>lastMajorityCount){
                lastMajorityCount = entry.getValue();
                majorityElement = entry.getKey();
            }
        }
        return majorityElement;
    }
    
}
