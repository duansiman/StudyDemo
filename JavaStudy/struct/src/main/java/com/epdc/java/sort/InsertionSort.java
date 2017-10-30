package com.epdc.java.sort;

import java.util.Arrays;

/**
 * Created by epdc on 17-4-23.
 */
public class InsertionSort {

    public static void main(String[] args){

        int[] datas = new int[]{1, 2, 3, 4, 5, 6};
        for (int i = 1; i < datas.length; i++) {
            int k = i;
            int value = datas[i];
            for (int j = i-1; j >= 0; j--) {
                if (datas[j] > value) {
                    datas[k] = datas[j];
                    k = j;
                }
            }
            if (k != i) {
                datas[k] = value;
            }
        }

        System.out.println(Arrays.toString(datas));

    }

}
