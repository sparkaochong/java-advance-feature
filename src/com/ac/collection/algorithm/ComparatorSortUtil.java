package com.ac.collection.algorithm;

import java.lang.reflect.Array;
import java.util.Comparator;

/**
 * Description:
 * <引用类型排序工具类>
 *     使用 java.util.Comparator 比较器实现
 * Created by aochong on 2019/10/15
 *
 * @author aochong
 * @version 1.0
 */
public class ComparatorSortUtil {
    /**
     * 冒泡排序
     * @param arr 要排序的数组
     */
    public static <T> void bubbleSort(T arr[],Comparator comparator){
        boolean hasSwap = false;
        if(arr.length<=1) return;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length-1-i;j++){
                if(comparator.compare(arr[j],arr[j+1])< 0){
                    swap(arr,j, j+1);
                    hasSwap = true;
                }
            }
            if(!hasSwap)break;
        }
    }

    /**
     * 引用类型数组的插入排序
     * @param arr 需要排序的数组
     * @param comparator 比较器
     * @param <T> 任意类型
     */
    public static <T> void insertionSort(T[] arr, Comparator<T> comparator){
        if(arr.length<=1)return;
        // 控制插入排序的次数
        for(int i=1;i<arr.length;i++){
            T value = arr[i];
            int j = i-1;
            for(;j>=0;--j){
                // 使用比较器来比较两个人
                // 返回值大于0的话，表示前面的人大于后面的人
                // 返回值小于0的话，表示前面的人小于后面的人
                // 返回值等于0的话，表示前面的人等于后面的人
                if(comparator.compare(arr[j],value)>0){
                    arr[j+1] = arr[j];
                }else{
                    break;
                }
            }
            arr[j+1] = value;
        }
    }

    /**
     * 归并排序
     * @param arr 需要排序的数组
     * @param <T> 任意类型
     */
    public static <T> void mergeSort(T[] arr,Comparator comparator){
        int length = arr.length;
        T[] tempArr = (T[]) Array.newInstance(arr.getClass().getComponentType(), arr.length);
        mergeSort(arr,tempArr,0,length-1,comparator);
    }

    public static <T> void mergeSort(T[] arr,T[] tempArr,int left,int right,Comparator comparator){
        if(left < right){
            int middle = (left + right)/2;
            // 归并排序左边的
            mergeSort(arr,tempArr,left,middle,comparator);
            // 归并排序右边的
            mergeSort(arr,tempArr,middle+1,right,comparator);
            // 将左边的元素和右边的元素按照顺序合并
            merge(arr,tempArr,left,middle+1,right,comparator);
        }
    }

    /**
     * 将左边的元素和右边的元素按照顺序合并
     * @param arr 数组
     * @param tempArr 临时数组
     * @param leftPos 左边数组的开始下标
     * @param rightPos 右边数组的开始下标
     * @param rightEnd 右边数组的结束下标
     */
    public static <T>  void merge(T[] arr,T[] tempArr,int leftPos,int rightPos,int rightEnd,Comparator comparator){
        // 左边数组的结束下标
        int leftEnd = rightPos - 1;
        // 定义临时数组的下标
        int tempPos = leftPos;
        // 计算需要合并排序的元素个数
        int numElement = rightEnd - leftPos + 1;
        // 对比左边和右边数组的元素，小的元素先放入到临时数组中
        while(leftPos<=leftEnd && rightPos<=rightEnd){
            if(comparator.compare(arr[leftPos],arr[rightPos])>0){
                tempArr[tempPos++] = arr[rightPos++];
            }else{
                tempArr[tempPos++] = arr[leftPos++];
            }
        }

        // 将左边数组剩下的元素拷贝到临时数组中
        while(leftPos<=leftEnd){
            tempArr[tempPos++] = arr[leftPos++];
        }

        // 将右边数组剩下的元素拷贝到临时数组中
        while(rightPos<=rightEnd){
            tempArr[tempPos++] = arr[rightPos++];
        }

        // 将临时数组中的元素复制到原始的数组
        for(int i=0;i<numElement;i++,rightEnd--){
            arr[rightEnd] = tempArr[rightEnd];
        }
    }

    /**
     * 快速排序
     * @param arr 需要排序的数组
     */
    public static <T> void quickSort(T[] arr, Comparator<T> comparator){
        int length = arr.length;
        if(length<=1) return;
        quickSort(arr,0,length-1,comparator);
    }

    private static <T> void quickSort(T[] arr,int p,int r, Comparator<T> comparator){
        // 终止条件
        if(p>=r) return;
        // 分区，返回分区之后的分区点所在的元素的下标
        int q = partition(arr,p,r,comparator);
        // 递归对分区点左边的数组进行快排
        quickSort(arr,p,q-1,comparator);
        // 递归对分区点右边的数组进行快排
        quickSort(arr,q+1,r,comparator);
    }

    /**
     * 分区的方法
     * @param arr 需要分区的数组
     * @param p 数组的第一个元素的下标
     * @param r 数组的最后一个元素的下标
     * @return 分区点所在的元素的下标
     */
    private static <T> int partition(T[] arr, int p, int r, Comparator<T> comparator) {
        // 定义分区点为最后一个元素
        T pivot = arr[r];
        // 定义个两个下标，都是从第一个元素开始
        int i = p;
        for(int j = p;j<=r-1;j++){
            if(comparator.compare(arr[j],pivot)<0){
                swap(arr,i,j);
                i++;
            }
        }
        swap(arr,i,r);
        return i;
    }

    public static <T> void swap(T[] arr,int i,int j){
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
