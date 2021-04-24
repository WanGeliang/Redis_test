package leetcode.src;

import java.util.HashSet;

/**
 * @author 万葛亮
 * @Date 2020 09 06 20:40
 * @GIRL friend 江珊
 */
public class leetcode_287 {

    public static void main(String[] args) {
        leetcode_287 leetcode287 = new leetcode_287();
        int[] col={1,2,3,4,2};
        System.out.println(leetcode287.findDuplicate(col));
    }

    //寻找重复数组
    public int findDuplicate(int[] nums){
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {

            if (set.contains(nums[i])){
                return nums[i];
            }
            set.add(nums[i]);
        }
        return -1;
    }
}
