//Лаборатроная работа 2.2 (Вариант 8)

// Введена строка символов. Вывести статистику слов по их количеству (слово - количество).

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Lab2_2 {
    public static void main(String args[]) {
        Scanner inp = new Scanner(System.in);

        System.out.print("Введите текст: ");
        String str = inp.nextLine();

        int index = 0;

        String[] ar = str.split("\\s");

        Map<String, Integer> mp = new HashMap<String, Integer>();

        for (int i = 0; i < ar.length; i++) {
            index = 0;

            for (int j = 0; j < ar.length; j++) {
                if (ar[i].equals(ar[j])) {
                    index++;
                }
            }

            mp.put(ar[i], index);
        }

        System.out.println(mp);
    }
}