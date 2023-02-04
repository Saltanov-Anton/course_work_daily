
import Task.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public final class DataCollector {

    public static Type scanType(Scanner scanner) {
        //лучше цикл делать вместо рекурсии
        Type type = null;
        System.out.println("Выберите тип задачи: \n 1 - Рабочая \n 2 - Личная");
        boolean b = true;
        while (b) {
            switch (scanner.nextInt()) {
                case 1:
                    type = Type.WORK;
                    b = false;
                    break;
                case 2:
                    type = Type.PERSONAL;
                    b = false;
                    break;
                default:
                    System.out.println("Неверное значение");
            }
        }

        return type;
    }

    public static String scanTitle(Scanner scanner) {
        StringBuilder sb = new StringBuilder();
        System.out.println("Введите заголовок задачи: ");

        while (sb.toString().isBlank()) {
            sb.append(scanner.nextLine());
        }

        return sb.toString();
    }

    public static String scanDescription(Scanner scanner) {
        StringBuilder description = new StringBuilder();
        System.out.println("Введите описание задачи");

        while (description.toString().isBlank()) {
            description.append(scanner.nextLine());
        }
        return description.toString();
    }

    public static LocalDateTime scanDateTime(Scanner scanner) {
        LocalDateTime localDateTime = null;
        boolean b = true;

        while (b) {
            StringBuilder dateTime = new StringBuilder();
            System.out.println("Установите дату в формате: " +
                    "\n Год-месяц-число(2013-12-20)");
            dateTime.append(scanner.nextLine());

            System.out.println("И время: \n Часы-Минуты(08:55)");
            dateTime.append("T").append(scanner.nextLine()).append(":00");
            try {
                localDateTime = LocalDateTime.parse(dateTime);
                b = false;
            } catch (DateTimeParseException e) {
                System.out.println("Неверный формат");
            }
        }
        return localDateTime;
    }

    public static LocalDate scanDate() {
        LocalDate localDate = null;
        boolean b = true;
        while (b) {
            StringBuilder dateTime = new StringBuilder();
            System.out.println("Ведите дату в формате: " +
                    "\n Год-месяц-число(2013-12-20)");
            dateTime.append(new Scanner(System.in).nextLine());
            try {
                localDate = LocalDate.parse(dateTime);
                b = false;
            } catch (DateTimeParseException e) {
                System.out.println("Неверный формат");
            }
        }
        return localDate;
    }

    public static Task scanPeriod(String title, Type type,
                                  LocalDateTime dateTime, String description, Scanner scanner) {
        Task task = null;
        boolean b = true;
        while (b) {
            System.out.println("Когда повторять? \n " +
                    "1 - Один раз \n " +
                    "2 - Ежедневно \n " +
                    "3 - Каждую неделю \n " +
                    "4 - Каждый месяц \n " +
                    "5 - Каждый год");
            switch (scanner.nextInt()) {
                case 1:
                    task = new OneTimeTask(title, type, dateTime, description);
                    b = false;
                    break;
                case 2:
                    task = new DailyTask(title, type, dateTime, description);
                    b = false;
                    break;
                case 3:
                    task = new WeeklyTask(title, type, dateTime, description);
                    b = false;
                    break;
                case 4:
                    task = new MonthlyTask(title, type, dateTime, description);
                    b = false;
                    break;
                case 5:
                    task = new YearlyTask(title, type, dateTime, description);
                    b = false;
                    break;
                default:
                    System.out.println("Не та цифра");
            }
        }
        return task;
    }

    public static int scanId(Scanner scanner) {
        System.out.println("Введите id задачи");
        int id = scanner.nextInt();
        return id;

    }
}
