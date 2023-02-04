
import Exceptions.TaskNotFoundException;
import Task.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Menu {

    public static void showMainMenu() {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("Выберите действие: \n " +
                        "1 - Добавить задачу \n " +
                        "2 - Посмотреть задачи на сегодня \n " +
                        "3 - Посмотреть задачи на выбранный день \n " +
                        "4 - Найти задачу \n " +
                        "5 - Посмотреть все задачи \n " +
                        "6 - Посмотреть архив задач \n " +
                        "7 - Завершить программу");
                switch (scanner.nextInt()) {
                    case 1:
                        greatTask(scanner);
                        break;
                    case 2:
                        try {
                            System.out.println(TaskService.getAllByDate(LocalDate.now()));
                        } catch (TaskNotFoundException e) {
                            System.out.println("Задач нет");
                        }

                        break;
                    case 3:
                        try {
                            LocalDate localDate = DataCollector.scanDate();
                            System.out.println(TaskService.getAllByDate(localDate));
                        } catch (TaskNotFoundException e) {
                            System.out.println("Задач нет");
                        }
                        break;
                    case 4:
                        Integer id = DataCollector.scanId(scanner);
                        try {
                            showTaskMenu(TaskService.getTaskById(id), scanner);
                        } catch (TaskNotFoundException e) {
                            System.out.println("Задача не найдена");
                        }
                        break;
                    case 5:
                        try {
                            System.out.println(TaskService.getAllTasks());
                        } catch (TaskNotFoundException e) {
                            System.out.println(e);
                        }
                        break;
                    case 6:
                        try {
                            System.out.println(TaskService.getRemovedTask());
                        } catch (TaskNotFoundException e) {
                            System.out.println(e);
                        }
                        break;
                    case 7:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Не та цифра");
                        ;
                }
        }

        }

    }

    public static void showTaskMenu(Task task, Scanner scanner) {
        while (true) {
            System.out.println(task);
            System.out.println("Выберите действие: \n " +
                    "1 - Изменить задачу \n " +
                    "2 - Удалить задачу \n " +
                    "3 - Вернуться в главное меню");
            switch (scanner.nextInt()) {
                case 1:
                    showEditTaskMenu(task, scanner);
                    showMainMenu();
                    break;
                case 2:
                    TaskService.remove(task.getId());
                    showMainMenu();
                    break;
                case 3:
                    showMainMenu();
                    break;
                default:
                    System.out.println("Не та цифра");
                    ;
                    break;
            }
        }
    }

    public static void showEditTaskMenu(Task task, Scanner scanner) {
        while (true) {
            System.out.println(" 1 - Изменить тип задачи \n " +
                    "2 - Изменить заголовок \n " +
                    "3 - Изменить описание \n " +
                    "4 - Изменить дату и время");

            int action = scanner.nextInt();
            switch (action) {
                case 1:
                case 2:
                case 3:
                case 4:
                    try {
                        editTask(task.getId(), action, scanner);
                    } catch (TaskNotFoundException e) {
                        System.out.println(e);
                    }
                    break;
                default:
                    System.out.println("Не та цифра");
                    break;
            }
        }

    }

    public static void greatTask(Scanner scanner) {
        String title = DataCollector.scanTitle(scanner);
        String description = DataCollector.scanDescription(scanner);
        LocalDateTime dateTime = DataCollector.scanDateTime(scanner);
        Type type = DataCollector.scanType(scanner);
        Task task = DataCollector.scanPeriod(title, type, dateTime, description, scanner);
        System.out.println("Задача создана");
        TaskService.add(task);
    }

    public static void editTask(int id, int action, Scanner scanner) throws TaskNotFoundException{
        while (true) {
            switch (action) {
                case 1:
                    TaskService.getTaskById(id).setType(DataCollector.scanType(scanner));
                    break;
                case 2:
                    TaskService.getTaskById(id).setTitle(DataCollector.scanTitle(scanner));
                    break;
                case 3:
                    TaskService.getTaskById(id).setDescription(DataCollector.scanDescription(scanner));
                    break;
                case 4:
                    TaskService.getTaskById(id).setDateTime(DataCollector.scanDateTime(scanner));
                    break;
                case 5:
                    Task task = TaskService.getTaskById(id);
                    DataCollector.scanPeriod(task.getTitle(), task.getType(),
                            task.getDateTime(), task.getDescription(), scanner);
                    TaskService.add(task);
                    break;
                default:
                    System.out.println("Не та цифра");
            }
            System.out.println(TaskService.getTaskById(id));
        }

    }

}
