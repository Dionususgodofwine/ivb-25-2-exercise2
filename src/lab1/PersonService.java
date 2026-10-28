package lab1;

import java.time.LocalDate;
import java.util.Scanner;

public class PersonService {
    static Person[] people ;
    static {
        people = new Person[] {
                new Person("Иванов Иван Иванович", "г. Москва, ул. Ленина 1", "+79991112233", "ivanov@mail.ru", 15, 5, 1990),
                new Person("Петров Петр Петрович", "г. СПБ, ул. Мира 5", "+79992223344", "petrov@mail.ru", 10, 9, 1985),
                new Person("Сидоров Алексей Сергеевич", "г. Казань, ул. Новая 12", "+79993334455", "sidorov@mail.ru", 25, 9, 1998),
                new Person("Алексеева Анна Владимировна", "г. Тверь, ул. Садовая 3", "+79994445566", "alexeeva@mail.ru", 3, 12, 2001),
                new Person("Алексеева Вячеслав Владимировна", "г. Тверь, ул. Садовая 3", "+79994445566", "alexeeva@mail.ru", 3, 12, 2001)
                new Person("Сидоров Сергей Сергеевич", "г. Казань, ул. Новая 12", "+79993334455", "sidorov@mail.ru", 25, 9, 1998),
                new Person("Иванов Марат Иванович", "г. Москва, ул. Ленина 1", "+79991112233", "ivanov@mail.ru", 15, 5, 1990),
        };
    }
        public static void fillPeople() {
            System.out.print("Введите количество новых людей для добавления=> ");
            int n = (new Scanner(System.in, "cp1251")).nextInt();

            int oldLength = (people != null) ? people.length : 0;Person[] extendedPeople = new Person[oldLength + n];

            // Копируем старых людей в новый расширенный массив
            if (oldLength > 0) {
                System.arraycopy(people, 0, extendedPeople, 0, oldLength);
            }

            System.out.println("Введите информацию о новых людях: ");
            for (int i = 0; i < n; i++) {
                System.out.println("Человек " + (oldLength + i + 1) + "=>");
                extendedPeople[oldLength + i] = new Person();
            }

            // Обновляем ссылку на массив
            people = extendedPeople;
        }
        public static void printPeople() {
        System.out.println("\nЗаписная книжка:");
        for (int i = 0; i < people.length; i++) {
            System.out.println(people[i]);
        }
    }
    public static void groupByMonth() {
        System.out.println("\nСписок абонентов, сгруппированный по месяцам:");
        String[] months = {"Январь", "Февраль", "Март", "Апрель", "Май", "Июнь",
                "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"};
        for (int m = 1; m <= 12; m++) {
            boolean hasPeople = false;
            for (Person p : people) {
                if (p.getBirthMonth() == m) {
                    if (!hasPeople) {
                        System.out.println("--- " + months[m - 1] + " ---");
                        hasPeople = true;
                    }
                    System.out.println("\t" + p);
                }
            }
        }
    } public static void findCurrentMonthBirthdays() {
        int currentMonth = LocalDate.now().getMonthValue();
        System.out.println("\nЛюди, у которых день рождения в текущем месяце (" + currentMonth + "):");
        boolean found = false;
        for (Person p : people) {
            if (p.getBirthMonth() == currentMonth) {
                System.out.println("\t* " + p);
                found = true;
            }
        }
        if (!found) {
            System.out.println("\tВ этом месяце именинников нет.");
        }
    }
    }
}
