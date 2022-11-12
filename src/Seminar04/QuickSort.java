package Seminar04;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = getArray();
        System.out.println(Arrays.toString(array));
        quickSort(array, 0, array.length - 1);
        System.out.println("Результат реализации быстрой сортировки: ");
        System.out.println(Arrays.toString(array));
    }

    static int[] getArray() {
        Random rnd = new Random();
        Scanner sc = new Scanner(System.in);
        System.out.println("Задайте размер массива: ");
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rnd.nextInt(-100, 100);
        }
        return arr;
    }

    private static void quickSort(int[] array, int left, int right) {
        if (left >= right) return;
        int pivot = getPivotIndex(array, left, right);
        quickSort(array, left, pivot - 1);
        quickSort(array, pivot + 1, right);
    }

    private static int getPivotIndex(int[] array, int left, int right) {
        int pivotIndex = left - 1;
        for (int i = left; i < right; i++) {
            if (array[i] < array[right]){
                pivotIndex++;
                swap(pivotIndex, i, array);
            }
        }
        swap(pivotIndex + 1, right, array);
        return pivotIndex + 1;
    }

    private static void swap(int pivotIndex, int i, int[] array) {
        int temp = array[pivotIndex];
        array[pivotIndex] = array[i];
        array[i] = temp;
    }
}
