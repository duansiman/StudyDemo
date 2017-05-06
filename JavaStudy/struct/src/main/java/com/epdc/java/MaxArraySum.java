package com.epdc.java;

import com.epdc.java.bean.Tuple;

/**
 * Created by epdc on 17-4-30.
 */
public class MaxArraySum {

    public static void main(String[] args) {

        int[] A = new int[]{-9, -2 , -3, -1, -4, -7, -1};
//        System.out.println(findMax(A, 0, A.length-1));
//        System.out.println(findCrossMax(A, 0, 3, A.length-1));
        System.out.println(findMaxOfLine(A, 0, A.length-1));
        System.out.println(findMaxOfLine2(A, 0, A.length - 1));
    }

    public static Tuple findMaxOfLine2(int[] A, int l, int r){
        int tempSum=0;
        int sum=Integer.MIN_VALUE;
        Tuple<Integer, Integer, Integer> tuple = new Tuple<>();
        int k=0;
        for(int i=l;i<=r;i++){
            tempSum+=A[i];
            if(tempSum > sum) {
                sum=tempSum;
                tuple.left = k;
                tuple.right=i;
            }
            if(tempSum < 0) {
                tempSum=0;
                k=i+1;
            }
        }
        tuple.sum = sum;
        return tuple;
    }

        public static Tuple findMaxOfLine(int[] A, int low, int high){
            Tuple<Integer, Integer, Integer> tuple = new Tuple<>();
            int sum = A[low];
            int eSum = A[low];
            int l=low;
            int r=low;
            for (int i = low+1; i <= high; i++) {
                eSum += A[i];
                if (eSum > sum) {
                    r=i;
                    sum=eSum;
                    continue;
                }
                int temp = eSum;
                for (int j = l; j < i; j++) {
                    temp -= A[j];
                    if (temp > sum) {
                        l=j+1;
                        r=i;
                        sum=temp;
                        eSum = temp;
                    }
                }
            }
            tuple.left=l;
            tuple.right=r;
            tuple.sum=sum;
            return tuple;
        }


    public static Tuple findMax(int[] A, int low, int high){
        Tuple<Integer, Integer, Integer> tuple = new Tuple<>();
        if (low == high) {
            tuple.left = low;
            tuple.right = high;
            tuple.sum = A[low];
            return tuple;
        } else {
            int mid = (low + high)/2;
            Tuple<Integer, Integer, Integer> lTuple = findMax(A, low, mid);
            Tuple<Integer, Integer, Integer> cTuple = findCrossMax(A, low, mid, high);
            Tuple<Integer, Integer, Integer> rTuple = findMax(A, mid + 1, high);
            if (lTuple.sum > cTuple.sum && lTuple.sum > rTuple.sum) {
                return lTuple;
            } else if (rTuple.sum > cTuple.sum && rTuple.sum > lTuple.sum) {
                return rTuple;
            } else {
                return cTuple;
            }
        }
    }

    public static Tuple findCrossMax(int[] A, int low, int mid, int high){
        Tuple<Integer, Integer, Integer> tuple = new Tuple<>();
        int lSum = Integer.MIN_VALUE;
        int temp = 0;
        int l = -1;
        for (int i = mid; i >= low; i--) {
            temp += A[i];
            if (temp > lSum) {
                lSum = temp;
                l = i;
            }
        }

        int rSum = Integer.MIN_VALUE;
        int r = -1;
        temp = 0;
        for (int i = mid; i <= high; i++) {
            temp += A[i];
            if (temp > rSum) {
                rSum = temp;
                r= i;
            }
        }
        tuple.left=l;
        tuple.right=r;
        tuple.sum = lSum + rSum - A[mid];
        return tuple;
    }

}
