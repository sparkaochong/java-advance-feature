package com.ac.collection.algorithm;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Description:
 * <p>
 * Created by aochong on 2019/10/15
 *
 * @author aochong
 * @version 1.0
 */
public class TestBinarySearch {
    public static void main(String[] args) {
        int[] arr = new int[]{8, 11, 19, 23, 27, 33, 45, 55, 67, 98};

        int target = 45;

        // 查找数组中是否有某个指定的元素
        // 可以使用 Java 提供的工具方法老做二分查找
        int index = Arrays.binarySearch(arr,target);
        System.out.println(index);

        List<Integer> list = Arrays.asList(new Integer[]{8, 11, 19, 23, 27, 33, 45, 55, 67, 98});
        // 集合的二分查找工具方法
        index = Collections.binarySearch(list,target);
        System.out.println(index);

    }

    /**
     * 查找数组中是否包含指定的元素
     * 存在一个问题：随着数组长度的变大，需要循环遍历的次数变多，性能下降
     * @param arr 数组
     * @param target 指定的元素值
     * @return 指定的元素在数组中的下标
     */
    public static int search(int[] arr,int target){
        for(int i=0;i<arr.length;i++){
            int element = arr[i];
            if(element==target){
                return i;
            }
        }
        return -1;
    }

    /**
     * 二分查找数组是否存在某个指定的元素
     * @param arr 数组
     * @param target 指定的元素
     * @return 指定的元素所在的下标，如果不存在，则返回 -1
     */
    public static int binarySearch(int[] arr,int target){
        int low = 0;
        int hig = arr.length-1;

        while(low<=hig){
            int mid = (low + hig) / 2;
            if(arr[mid]==target){
                // 找到了指定的元素，直接返回元素在数组中的下标
                return mid;
            }else{
                if(arr[mid]<target){
                    // 表示指定的元素肯定在右边
                    low = mid + 1;
                }else{
                    // 表示指定的元素肯定在左边
                    hig = mid-1;
                }
            }
        }
        // 数组中没有找到指定元素的值
        return -1;
    }
}
