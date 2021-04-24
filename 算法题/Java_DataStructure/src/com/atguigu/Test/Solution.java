//package com.atguigu.Test;
//
//class Solution {
//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        int[][] matrix =new int[
//                  [1, 4, 7, 11, 15],
//                  [2, 5, 8, 12, 19],
//                  [3, 6, 9, 16, 22],
//                  [10, 13, 14, 17, 24],
//                  [18, 21, 23, 26, 30]
//                ];
//
//
//    }
//
//    public boolean searchMatrix(int[][] matrix, int target) {
//        for (int i = 0; i < matrix.length; i++) {
//            int[] arr = matrix[i];
//            if (target > arr[arr.length - 1]) {
//                i++;
//            }
//            return binarySearch(arr, target);
//        }
//        return false;
//    }
//
//    public boolean binarySearch(int[] arr, int target) {
//        int left = 0;
//        int right = arr.length - 1;
//        while (left <= right) {
//            int mid = (left + right) / 2;
//            if (arr[mid] == target) {
//                return true;
//            } else if (arr[mid] > target) {
//                right = mid - 1;
//            } else {
//                left = mid + 1;
//            }
//        }
//        return false;
//    }
//}