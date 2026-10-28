package lab1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //создаем экземпляр класса для работы с массивом людей

        cycle: while (true) {
            System.out.println("1. Заполнить массив");
            System.out.println("2. Распечатать");
            System.out.println("3. Выдать список абонентов по месяцах дней рождений");
            System.out.println("4. Найти людей с днем рождения в текущем месяце");
            System.out.println("5. Упорядочить по фамилиям по алфавиту");
            System.out.println("6. Выход");
            System.out.print("Выберите пункт меню (1..6) ");
            int c = (new Scanner(System.in)).nextInt();
            switch (c) {
                case 1: PersonService.fillPeople(); break;
                case 2: Person.printPeople(); break;
                case 3: Person.groupByMonth(); break;
                case 4: Person.findCurrentMonthBirthdays(); break;
                case 5: Person.sortByLastName(); break;
                default: break cycle;
            }
        }
    }
}