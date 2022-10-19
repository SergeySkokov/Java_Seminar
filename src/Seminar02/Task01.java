package Seminar02;

public class Task01 {
    public static void main(String[] args) {
        int n = 3;
        shiftDisk(n, 'A', 'B', 'C');
    }
    public static void shiftDisk(int n, char TA, char TB, char TC){
        if (n == 1){
            System.out.println("Диск перемещается с " + TA + " в " + TC);
        }
        else {
            shiftDisk(n - 1, TA, TC, TB);
            System.out.println("Диск " + n + " из " + TA + " перемещается в " + TC);
            shiftDisk(n - 1, TB, TA, TC);
        }
    }

}
