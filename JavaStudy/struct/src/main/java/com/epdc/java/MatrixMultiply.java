package com.epdc.java;

import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;
import java.util.Arrays;

/**
 * Created by epdc on 17-5-15.
 */
public class MatrixMultiply {

    public static final int size = 4;
    
    public static void main(String[] args){

        int[][] A = new int[][]{
                {1, 2, 3, 4},
                {1, 2, 3, 4},
                {1, 2, 3, 4},
                {1, 2, 3, 4},
        };
        int[][] B = new int[][]{
                {5, 6, 7, 8},
                {5, 6, 7, 8},
                {5, 6, 7, 8},
                {5, 6, 7, 8},
        };

        squareMatrixMultiply(A, B);
        System.out.println();
        int[][] result = squareMatrixMultiplyRecursive(A, 0, 0, B, 0, 0, size);
        print(result,size);
    }

    private static void print(int[][] result, int size){
        for (int i = 0; i < size; i++) {
            System.out.println(Arrays.toString(result[i]));
        }
    }

    public static void squareMatrixMultiply(int[][] A, int[][] B){
        int[][] C = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                C[i][j] = 0;
                for (int k = 0; k < size; k++) {
                    System.out.print(A[i][k]+"*"+B[k][j]+" ");
                    C[i][j] += A[i][k] * B[k][j];
                }
                System.out.println();
            }
        }
        for (int i = 0; i < size; i++) {
            System.out.println(Arrays.toString(C[i]));
        }
    }

    public static int[][] addMatrix(int[][] A, int[][] B, int size){
        int[][] C = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                C[i][j] = A[i][j] + B[i][j];
            }
        }
        return C;
    }

    public static int[][] squareMatrixMultiplyRecursive(int[][] A, int alfrom, int acfrom, int[][] B, int blfrom, int bcfrom, int size){
        int[][] C = new int[size][size];
        if (size == 1) {
            System.out.print(A[alfrom][acfrom]+" * "+B[blfrom][bcfrom] + " + ");
                C[0][0] = A[alfrom][acfrom] * B[blfrom][bcfrom];
        } else {
            int mid = size / 2;
            int[][] C11 = addMatrix(squareMatrixMultiplyRecursive(A, alfrom, acfrom, B, blfrom, bcfrom, mid),
                    squareMatrixMultiplyRecursive(A, alfrom, alfrom + mid, B, blfrom + mid, bcfrom, mid), mid);
            System.out.println();
            int[][] C12 = addMatrix(squareMatrixMultiplyRecursive(A, alfrom, acfrom, B, blfrom, bcfrom + mid, mid),
                    squareMatrixMultiplyRecursive(A, alfrom, alfrom + mid, B, blfrom + mid, bcfrom+mid, mid), mid);
            System.out.println();
            int[][] C21 = addMatrix(squareMatrixMultiplyRecursive(A, alfrom+mid, acfrom, B, blfrom, bcfrom, mid),
                    squareMatrixMultiplyRecursive(A, alfrom+mid, alfrom + mid, B, blfrom + mid, bcfrom, mid), mid);
            System.out.println();
            int[][] C22 = addMatrix(squareMatrixMultiplyRecursive(A, alfrom+mid, acfrom, B, blfrom, bcfrom+mid, mid),
                    squareMatrixMultiplyRecursive(A, alfrom+mid, alfrom + mid, B, blfrom + mid, bcfrom+mid, mid), mid);
            System.out.println();
            mergeMatrix(C, C11, C12, C21, C22, mid);
            print(C, size);
            System.out.println();
        }
        return C;

    }

    private static void mergeMatrix(int[][] c, int[][] c11, int[][] c12, int[][] c21, int[][] c22, int mid) {
        for (int i = 0; i < mid*2; i++) {
            for (int j = 0; j < mid * 2; j++) {
                if (i < mid && j < mid)
                    c[i][j] = c11[i][j];
                if (i >= mid && j >= mid)
                    c[i][j] = c22[i-mid][j-mid];
                if (i < mid && j >= mid)
                    c[i][j] = c12[i][j-mid];
                if (i >= mid && j < mid)
                    c[i][j] = c21[i-mid][j];
            }
        }
    }


}

