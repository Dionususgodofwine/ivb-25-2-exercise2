package lab1;

import java.time.LocalDate;
import java.util.Scanner;

public class Person {
    // поля класса
    private String fullName;  // ФИО
    private String address;   // адрес
    private String phone;     // телефон
    private String email;     // e-mail
    private int birthDay;     // день рождения (1-31)
    private int birthMonth;   // месяц рождения (1-12)
    private int birthYear;    // год рождения
    private static Person[] people;

    static {
        people = new Person[] {
                new Person("Иванов Иван Иванович", "г. Москва, ул. Ленина 1", "+79991112233", "ivanov@mail.ru", 15, 5, 1990),
                new Person("Петров Петр Петрович", "г. СПБ, ул. Мира 5", "+79992223344", "petrov@mail.ru", 10, 9, 1985),
                new Person("Сидоров Алексей Сергеевич", "г. Казань, ул. Новая 12", "+79993334455", "sidorov@mail.ru", 25, 9, 1998),
                new Person("Алексеева Анна Владимировна", "г. Тверь, ул. Садовая 3", "+79994445566", "alexeeva@mail.ru", 3, 12, 2001),
                new Person("Алексеева Вячеслав Владимировна", "г. Тверь, ул. Садовая 3", "+79994445566", "alexeeva@mail.ru", 3, 12, 2001)

        };
    }

    // конструкторы
    public Person(String fullName, String address, String phone, String email, int birthDay, int birthMonth, int birthYear) {
        setFullName(fullName);
        setAddress(address);
        setPhone(phone);
        setEmail(email);
        setBirthDay(birthDay);
        setBirthMonth(birthMonth);
        setBirthYear(birthYear);
    }

    public Person() {
        Scanner sc = new Scanner(System.in, "UTF-8");

        // Ввод ФИО с проверкой (только буквы, пробелы и дефисы, нельзя пропускать)
        while (true) {
            System.out.print("ФИО: ");
            String name = sc.nextLine();
            if (name != null && !name.trim().isEmpty() && name.matches("^[а-яА-ЯёЁa-zA-Z\\s-]+$")) {
                this.fullName = name;
                break;
            } else {
                System.out.println("Недопустимое значение! ФИО не должно быть пустым и должно содержать только буквы.");
            }
        }

        // Ввод адреса с защитой от пропусков
        while (true) {
            System.out.print("\tАдрес: ");
            String addr = sc.nextLine();
            if (addr != null && !addr.trim().isEmpty()) {
                this.address = addr;
                break;
            } else {
                System.out.println("Недопустимое значение! Адрес не должен быть пустым.");
            }
        }

        // Ввод телефона с проверкой (без букв, нельзя пропускать)
        while (true) {
            System.out.print("\tТелефон: ");
            String phoneNumber = sc.nextLine();
            if (phoneNumber != null && !phoneNumber.trim().isEmpty() && phoneNumber.matches("^\\+?[0-9\\s\\-\\(\\)]+$")) {
                this.phone = phoneNumber;
                break;
            } else {
                System.out.println("Недопустимое значение! Телефон не должен быть пустым и не должен содержать буквы.");
            }
        }

        // Ввод e-mail с защитой от пропусков
        while (true) {
            System.out.print("\te-mail: ");
            String mail = sc.nextLine();
            if (mail != null && !mail.trim().isEmpty()) {
                this.email = mail;
                break;} else {
                System.out.println("Недопустимое значение! E-mail не должен быть пустым.");
            }
        }

        // Ввод даты рождения с проверкой на реальное существование (високосные годы, длина месяцев)
        while (true) {
            try {
                System.out.print("\tДень рождения (1-31): ");
                int d = Integer.parseInt(sc.nextLine().trim());
                System.out.print("\tМесяц рождения (1-12): ");
                int m = Integer.parseInt(sc.nextLine().trim());
                System.out.print("\tГод рождения: ");
                int y = Integer.parseInt(sc.nextLine().trim());

                // Проверка через LocalDate: если дата некорректная (например, 31 апреля), выбросится исключение
                LocalDate.of(y, m, d);

                // Дополнительная проверка на разумные границы года
                int currentYear = LocalDate.now().getYear();
                if (y < 1900 || y > currentYear) {
                    System.out.println("Недопустимое значение года! Введите корректный год (от 1900 до " + currentYear + ").");
                    continue;
                }

                this.birthDay = d;
                this.birthMonth = m;
                this.birthYear = y;
                break;
            } catch (Exception e) {
                System.out.println("Недопустимое значение или несуществующая дата (например, 31 апреля, 30 февраля)! Введите заново.");
            }
        }
    }

    // метод toString
    public String toString() {
        return String.format("Человек: %s \t Адрес: %s \t Тел: %s \t Email: %s \t ДР: %02d.%02d.%d",
                fullName, address, phone, email, birthDay, birthMonth, birthYear);
    }

    // геттеры и сеттеры для всех полей
    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        if (fullName == null || fullName.isEmpty() || !fullName.matches("^[а-яА-ЯёЁa-zA-Z\\s-]+$")) {
            System.out.println("Недопустимое значение !");
        } else {
            this.fullName = fullName;
        }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (address == null || address.isEmpty()) System.out.println("Недопустимое значение !");
        else this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        if (phone == null || phone.isEmpty() || !phone.matches("^\\+?[0-9\\s\\-\\(\\)]+$")) {
            System.out.println("Недопустимое значение !");
        } else {
            this.phone = phone;
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null || email.isEmpty()) System.out.println("Недопустимое значение !");
        else this.email = email;
    }

    public int getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(int birthDay) {
        if (birthDay < 1 || birthDay > 31) System.out.println("Недопустимое значение !");
        else this.birthDay = birthDay;
    }

    public int getBirthMonth() {
        return birthMonth;
    }

    public void setBirthMonth(int birthMonth) {
        if (birthMonth < 1 || birthMonth > 12) System.out.println("Недопустимое значение !");
        else this.birthMonth = birthMonth;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        if (birthYear <= 0) System.out.println("Недопустимое значение !");
        else this.birthYear = birthYear;
    }

    // Ввод информации о новых людях с сохранением старых
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

    // вывод полученной информации
    public static void printPeople() {
        System.out.println("\nЗаписная книжка:");
        for (int i = 0; i < people.length; i++) {
            System.out.println(people[i]);
        }
    }

    // a. Группировка абонентов по месяцах их дней рождения
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
    }

    // b. Поиск людей, у которых день рождения в текущем месяце
    public static void findCurrentMonthBirthdays() {
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

    // c. Сортировка по фамилиям по алфавиту (пузырьком)
    public static void sortByLastName() {
        for (int i = 0; i < people.length - 1; i++) {
            for (int j = 0; j < people.length - 1 - i; j++) {
                if (people[j].getFullName().compareTo(people[j + 1].getFullName()) > 0) {
                    Person rab = people[j];
                    people[j] = people[j + 1];
                    people[j + 1] = rab;
                }
            }
        }
        System.out.println("\nОтсортированный список по алфавиту:");
        for (int i = 0; i < people.length; i++) {
            System.out.println("*" + people[i]);
        }
    }
}
