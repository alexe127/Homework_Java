//    3.	+Написать программу вычисления n-ого треугольного числа
import java.util.Scanner;


public class Task1 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите число n, для вычисления n-ого треугольного числа:");

        int n = scan.nextInt();

        if (n < 0) {
            System.out.println("Для отрицательных чисел треугольное число посчитать не получится.");
        } else {
            System.out.println("Для n = " + n + " треугольное число = " + triangularNumber(n));
        }
    }

    public static int triangularNumber(int n) {
        int result =   (n * (n + 1)) / 2;        
        
        return (result);
    }
}