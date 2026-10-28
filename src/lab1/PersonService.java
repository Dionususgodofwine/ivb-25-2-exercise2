package lab1;

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
    }
}
