package com.ac.collection.algorithm;

/**
 * Description:
 * <排序算法的工具类提供了四种排序算法的实现>
 *     1. 冒泡排序
 *     2. 插入排序
 *     3. 归并排序
 *     4. 快速排序
 * Created by aochong on 2019/10/15
 *
 * @author aochong
 * @version 1.0
 */
public class PrimitiveTypeSortUtil {
    /**
     * 快速排序
     * @param arr 需要排序的数组
     */
    public static void quickSort(int[] arr){
        int length = arr.length;
        if(length<=1) return;
        quickSort(arr,0,length-1);
    }

    private static void quickSort(int[] arr,int p,int r){
        // 终止条件
        if(p>=r) return;
        // 分区，返回分区之后的分区点所在的元素的下标
        int q = partition(arr,p,r);
        // 递归对分区点左边的数组进行快排
        quickSort(arr,p,q-1);
        // 递归对分区点右边的数组进行快排
        quickSort(arr,q+1,r);
    }

    /**
     * 分区的方法
     * @param arr 需要分区的数组
     * @param p 数组的第一个元素的下标
     * @param r 数组的最后一个元素的下标
     * @return 分区点所在的元素的下标
     */
    private static int partition(int[] arr, int p, int r) {
        // 定义分区点为最后一个元素
        int pivot = arr[r];
        // 定义个两个下标，都是从第一个元素开始
        int i = p;
        for(int j = p;j<=r-1;j++){
            if(arr[j]<pivot){
                swap(arr,i,j);
                i++;
            }
        }
        swap(arr,i,r);
        return i;
    }

    /**
     * 快速排序
     * @param arr 需要排序的数组
     */
    public static void quickSort(long[] arr){
        int length = arr.length;
        if(length<=1) return;
        quickSort(arr,0,length-1);
    }

    private static void quickSort(long[] arr,int p,int r){
        // 终止条件
        if(p>=r) return;
        // 分区，返回分区之后的分区点所在的元素的下标
        int q = partition(arr,p,r);
        // 递归对分区点左边的数组进行快排
        quickSort(arr,p,q-1);
        // 递归对分区点右边的数组进行快排
        quickSort(arr,q+1,r);
    }

    /**
     * 分区的方法
     * @param arr 需要分区的数组
     * @param p 数组的第一个元素的下标
     * @param r 数组的最后一个元素的下标
     * @return 分区点所在的元素的下标
     */
    private static int partition(long[] arr, int p, int r) {
        // 定义分区点为最后一个元素
        long pivot = arr[r];
        // 定义个两个下标，都是从第一个元素开始
        int i = p;
        for(int j = p;j<=r-1;j++){
            if(arr[j]<pivot){
                swap(arr,i,j);
                i++;
            }
        }
        swap(arr,i,r);
        return i;
    }

    public static void mergeSort(int[] arr){
        int length = arr.length;
        int[] tempArr = new int[length];
        mergeSort(arr,tempArr,0,length-1);
    }

    public static void mergeSort(int[] arr,int[] tempArr,int left,int right){
        if(left < right){
            int middle = (left + right)/2;
            // 归并排序左边的
            mergeSort(arr,tempArr,left,middle);
            // 归并排序右边的
            mergeSort(arr,tempArr,middle+1,right);
            // 将左边的元素和右边的元素按照顺序合并
            merge(arr,tempArr,left,middle+1,right);
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
    public static void merge(int[] arr,int[] tempArr,int leftPos,int rightPos,int rightEnd){
        // 左边数组的结束下标
        int leftEnd = rightPos - 1;
        // 定义临时数组的下标
        int tempPos = leftPos;
        // 计算需要合并排序的元素个数
        int numElement = rightEnd - leftPos + 1;
        // 对比左边和右边数组的元素，小的元素先放入到临时数组中
        while(leftPos<=leftEnd && rightPos<=rightEnd){
            if(arr[leftPos]>arr[rightPos]){
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
     * 插入排序
     * @param arr 需要排序的数组
     */
    public static void insertionSort(int[] arr){
        if(arr.length<=1)return;
        // 控制插入排序的次数
        for(int i=1;i<arr.length;i++){
            int value = arr[i];
            int j = i-1;
            for(;j>=0;--j){
                if(arr[j]> value){
                    arr[j+1] = arr[j];
                }else{
                    break;
                }
            }
            arr[j+1] = value;
        }
    }

    /**
     * 冒泡排序
     * @param arr 要排序的数组
     */
    public static void bubbleSort(int arr[]){
        boolean hasSwap = false;
        if(arr.length<=1) return;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j]< arr[j+1]){
                    swap(arr,j, j+1);
                    hasSwap = true;
                }
            }
            if(!hasSwap)break;
        }
    }

    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void swap(long[] arr,int i,int j){
        long temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
