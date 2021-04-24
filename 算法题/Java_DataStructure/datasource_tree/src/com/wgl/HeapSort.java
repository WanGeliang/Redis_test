package com.wgl;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author 万葛亮
 * @Date 2020 07 29 11:46
 * @GIRL friend 江珊
 */
public class HeapSort {
    public static void main(String[] args) {
//        int arr[] = {4, 6, 8, 5, 9};
        // 创建要给80000个的随机的数组
		int[] arr = new int[8000000];
		for (int i = 0; i < 8000000; i++) {
			arr[i] = (int) (Math.random() * 8000000); // 生成一个[0, 8000000) 数
		}

		System.out.println("排序前");
		Date data1 = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date1Str = simpleDateFormat.format(data1);
		System.out.println("排序前的时间是=" + date1Str);


        adjustHeap(arr);

		Date data2 = new Date();
		String date2Str = simpleDateFormat.format(data2);
		System.out.println("排序前的时间是=" + date2Str);
//        System.out.println("排序后=" + Arrays.toString(arr));
//        System.out.println(Arrays.toString(arr));
    }

    public static void adjustHeap(int[] arr){
        int temp=0;
        for (int i=arr.length/2-1;i>=0;i--){
            heapSort(arr,i,arr.length);
//            System.out.println(Arrays.toString(arr));
        }

        for (int i = arr.length-1; i >0 ; i--) {
            temp=arr[i];
            arr[i]=arr[0];
            arr[0]=temp;
//            System.out.println(Arrays.toString(arr));
            heapSort(arr,0,i);
        }
    }

    public static void heapSort(int[] arr, int i, int length) {
        int temp = arr[i];
        for (int j = 2 * i + 1; j < length; j=2*j+1) {
            if (j + 1 < length && arr[j] < arr[j + 1]) {
                j++;
            }
            if (arr[j]>temp){
                arr[i]=arr[j];
                i=j;
            }else {
                break;
            }
        }
        arr[i]=temp;
    }
}

