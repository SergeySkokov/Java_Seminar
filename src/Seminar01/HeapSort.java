package Seminar01;

import java.util.Scanner;

// Реализация пирамидальной сортировки на Java
public class HeapSort {
    public static void main(String[] args) {
        //Получаем массив
        int[] arrIn = getArray();

        //Выводим первоначальный массив в консоль
        printArray(arrIn);

        //Передаем массив для сортировки
        int[] arrOut = heapSort(arrIn);

        //Выводим отсортированный массив в консоль
        printArray(arrOut);
    }

    //Запрашиваем массив у пользователя
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
    //Метод для реализации пирамидальной сортировки
    static int[] heapSort(int arr[]) {
        int n = arr.length;

        // Главный цикл для создания корней (родителей) с помощью его итерации
        for (int i = n / 2 - 1; i >= 0; i--)
            //Вызываем метод heapify, передаем ему наш массив,
            //его длину и корень для создания дочерних элементов
            heapify(arr, n, i);

        // Один за другим извлекаем элементы из кучи
        for (int i = n - 1; i >= 0; i--) {
            // Перемещаем текущий корень в конец
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Вызываем процедуру heapify на уменьшенной куче
            heapify(arr, i, 0);
        }
        return arr;
    }

    // Процедура для преобразования в двоичную кучу поддерева с корневым узлом i, что является
// индексом в arr[]. n - размер кучи
    static void heapify(int arr[], int n, int i) {
        int largest = i; // Инициализируем наибольший элемент как корень
        int l = 2 * i + 1; // левый элемент = 2*i + 1
        int r = 2 * i + 2; // правый элемент = 2*i + 2

        // Если левый дочерний элемент больше корня
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // Если правый дочерний элемент больше, чем самый большой элемент на данный момент
        if (r < n && arr[r] > arr[largest])
            largest = r;
        // Если самый большой элемент не корень
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Рекурсивно преобразуем в двоичную кучу затронутое поддерево
            heapify(arr, n, largest);
        }
    }

    //Создаем универсальный метод для вывода массива в консоль
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
