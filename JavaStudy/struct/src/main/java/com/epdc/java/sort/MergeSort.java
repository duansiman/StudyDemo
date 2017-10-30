package com.epdc.java.sort;

import java.util.Arrays;

/**
 * Created by epdc on 17-4-23.
 */
public class MergeSort {

    public static void main(String[] args){
        int[] datas = new int[]{6,5,4,3,2,1,0,-1};
        mergeSort(datas, 0, datas.length-1);
        System.out.println(Arrays.toString(datas));
    }

    public static void mergeSort(int[] A, int p, int r){

        if (p < r) {
            int q = (p + r)/2;
            mergeSort(A, p, q);
            mergeSort(A, q+1, r);
            merge(A, p, q, r);
        }

    }

    public static void merge(int[] A, int p, int q, int r){
        int[] lp = new int[q - p + 1];
        int[] lq = new int[r - q];
        System.arraycopy(A, p, lp, 0, q - p + 1);
        System.arraycopy(A, q+1, lq, 0, r - q);
        int k = p, i, j;
        for (i = 0, j = 0; i < lp.length && j < lq.length; k++) {
            if (lp[i] > lq[j]) {
                A[k] = lq[j];
                j++;
            } else {
                A[k] = lp[i];
                i++;
            }
        }

        if (i < lp.length) {
            for (;i<lp.length;i++,k++) {
                A[k] = lp[i];
            }
        }

        if (j < lq.length) {
            for (;j<lq.length;j++,k++) {
                A[k] = lq[j];
            }
        }
    }

}
