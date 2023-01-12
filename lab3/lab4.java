/*
    Customer: Фамилия, Имя, Отчество, Адрес, Телефон, Номер кредитной карточки, Номер банковского счета. Создать массив объектов. Вывести:
    а) список покупателей в алфавитном порядке; б) список покупателей, номер кредитной карточки которых находится в заданном интервале.
*/

package lab3;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class Customer {
    public int id;
    public String surname;
    public String name;
    public String middleName;
    public String address;
    public int phoneNumber;
    public int cardNumber; // credit card number
    public int baNumber; // bank account number

    public Customer(int id, String surname, String name, String middleName, String address, int phoneNumber,
            int cardNumber, int baNumber) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.middleName = middleName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.cardNumber = cardNumber;
        this.baNumber = baNumber;
    }

    public String get_Surname() {
        return surname;
    }

    public int get_CardNumber() {
        return cardNumber;
    }

    public String Print() {
        return "\n------------------------------------" + "\nid: " + id + "\nФамилия: " + surname + "\nИмя: " + name
                + "\nОтчество: "
                + middleName + "\nАдресс: "
                + address + "\nНомер телефона: " + phoneNumber +
                "\nНомер кредитной карты: " + cardNumber + "\nНомер банковского счета: " + baNumber
                + "\n------------------------------------";
    }
}

public class lab4 {

    static Customer[] Customer() {
        Customer[] customers = new Customer[5];
        customers[0] = new Customer(1, "Камаев", "Антон", "Львович", "Йошкар-Оа", 84938493, 88484, 93939);
        customers[1] = new Customer(2, "Иванов", "Иван", "Иванович", "Москва", 89458948, 34839, 3483934);
        customers[2] = new Customer(3, "Васильев", "Василий", "Васильевич", "Мурманск", 49594850, 34343, 203232);
        customers[3] = new Customer(4, "Петров", "Петр", "Петрович", "Москва", 549859, 4950443, 423432);
        customers[4] = new Customer(5, "Максимов", "Максим", "Максимович", "Ростов", 4343443, 686868, 3423434);

        return customers;
    }

    public static void SpisokAlf(Customer[] customers) {
        String[] surnames = new String[customers.length];
        int i = 0;
        for (Customer n : customers) {
            surnames[i] = n.get_Surname();
            i++;
        }
        Arrays.sort(surnames);

        for (String d : surnames) {
            for (Customer customer : customers) {
                if (d.equals(customer.get_Surname())) {
                    System.out.println(customer.Print());
                }
            }
        }
    }

    public static int CardInter(Customer[] customers, int a, int b) {
        int tmp = 0;
        for (Customer cus : customers) {
            if (cus.get_CardNumber() >= a && cus.get_CardNumber() <= b) {
                System.out.println(cus.Print());
            } else {
                tmp++;
            }
        }
        return tmp;
    }

    public static void main(String args[]) {
        Customer[] customer_list = Customer();
        Scanner inp = new Scanner(System.in);
        int N = 0;
        while (N < 3) {

            System.out.println("------------------------------------Menu------------------------------------");
            System.out.println("0.Выход");
            System.out.println("1.Вывывести список покупателей в алфавитном порядке");
            System.out.println(
                    "2.Вывести список покупателей, номер кредитной карточки которых находится в заданном интервале");
            System.out.println("------------------------------------Menu------------------------------------");
            System.out.print("INPUT:");
            N = inp.nextInt();
            if (N < 3) {
                switch (N) {
                    case 1:
                        System.out.println("Сортирую...");
                        SpisokAlf(customer_list);
                        break;

                    case 2:
                        System.out.println("Введите интервал");

                        System.out.print("a=");
                        int a = inp.nextInt();

                        System.out.print("b=");
                        int b = inp.nextInt();

                        System.out.println("Вычисляю...");

                        int buff = CardInter(customer_list, a, b);
                        if (buff > 4) {
                            System.out.println("Таких пользователей нет!");
                        }
                        break;

                    case 0:
                        System.exit(0);
                        break;
                }
            } else {
                System.out.println("Вы ввели неправильный пункт!");
                N = 0;
            }

        }

    }
}
