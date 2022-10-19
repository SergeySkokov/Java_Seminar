package Seminar02;

import java.util.Scanner;

public class Task02 {
    public static void main(String[] args) {
        int[] array = getArray();
        printArray(array);
        array = insertSort(array);
        printArray(array);
    }

    static int[] getArray(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите размер массива: ");
        int size = sc.nextInt();
        int arr[] = new int[size];
        System.out.println("Введите значения массива\n" +
                "(количество значений должно быть равно размеру массива,\n" +
                "числа должны быть натуральными): ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        return arr;
    }
    static int[] insertSort(int[] arr){
        int element;
        int indexToInsert;
        for (int i = 0; i < arr.length; i++) {
            element = arr[i];
            indexToInsert = i;
            while (indexToInsert > 0 && arr[indexToInsert - 1] > element){
                arr[indexToInsert] = arr[indexToInsert - 1];
                indexToInsert--;
                arr[indexToInsert] = element;
            }
        }
        return arr;
    }
    static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
