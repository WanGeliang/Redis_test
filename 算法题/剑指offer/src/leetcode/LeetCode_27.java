package leetcode;

import java.util.Arrays;

public class LeetCode_27 {
    public static void main(String[] args) {
        int nums[] = {0, 1, 2, 2, 3, 0, 4, 2};
        System.out.println(new LeetCode_27().removeElement(nums, 2));
    }


    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0)
            return 0;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
}
