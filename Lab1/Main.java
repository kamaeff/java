package Lab1;
//Лабораторная работа 1 (Вариант 8)

//Дан двумерный массив. Найти сумму чисел массива за исключением треугольной области ниже
//пересечения главной или побочной диогоналей 

import java.util.Scanner;

public class Main {

    public static void main(String args[]) {
        Scanner inp = new Scanner(System.in);

        System.out.print("Введите количество строк(стобцов будет такое же кол-во):");
        int N = inp.nextInt();

        int M = N;
        int[][] arr = new int[N][M];

        System.out.println("Ваша матрица:");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = (int) (Math.random() * 10);
                System.out.print(" " + arr[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("ОТвет:");
        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i < j || i + j < N + 1) {
                    sum += arr[i][j];
                }
            }
        }
        System.out.println(sum);
    }
}
