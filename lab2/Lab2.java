//Лабораторная работа 2 (Вариант 8)

// Дан файл f, компоненты которого являются целыми числами.
// Сформировать файл g, таким образом чтобы он содержал числа, которые не
// повторяются.

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Lab2 {
    public static void main(String args[]) throws IOException {

        File dir1 = new File("lab2/f.txt");
        File dir2 = new File("lab2/g.txt");

        PrintWriter pw = new PrintWriter(dir1);
        PrintWriter pw2 = new PrintWriter(dir2);
        Scanner inp1 = new Scanner(System.in);

        System.out.print("I will enter random numbers into your file.\nEnter how many numbers you want. N = ");
        int N = inp1.nextInt();

        System.out.println();

        int[] arr = new int[N];
        System.out.println("The following numbers were sent to the file: \n");
        for (int i = 0; i < N; i++) {
            arr[i] = (int) (Math.random() * 10);
            System.out.print(arr[i] + " ");
            pw.print(arr[i] + " ");
        }
        System.out.println();
        pw.close();

        BufferedReader bf = new BufferedReader(new FileReader(dir1));

        String line = bf.readLine();
        String[] str = line.split(" ");
        int[] arr2 = new int[N];

        for (int i = 0; i < N; i++) {
            arr2[i] = Integer.parseInt(str[i]);
        }

        System.out.println("--------Ответ--------");

        for (int i = 0; i < N; i++) {
            int flag = 0;
            for (int j = 0; j < N; j++) {
                if (arr2[i] == arr2[j]) {
                    flag++;
                }
            }
            if (flag < 2) {
                System.out.print(arr2[i] + " ");
                pw2.print(arr2[i] + " ");
            }
        }
        pw2.close();
    }
}