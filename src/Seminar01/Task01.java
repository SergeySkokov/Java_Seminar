// Tn = (n(n+1))/2
package Seminar01;

import java.util.Scanner;

public class Task01 {
    public static void main(String[] args) {
        int input = InputTriangularDigit();
        int result = GetTriangularDigit(input);
        PrintResult(input, result);
    }
    static int InputTriangularDigit(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите число: ");
        int threeDigit = sc.nextInt();
        return threeDigit;
    }
    static int GetTriangularDigit(int digit){
        return (digit*(digit + 1)) / 2;
    }
    static void PrintResult(int printInp, int printRes){
        System.out.println("Результат треугольного числа: " + printInp + " равен " + printRes);
    }
}
