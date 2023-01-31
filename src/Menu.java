import Exceptions.TaskNotFoundException;
import Task.Task;

import java.time.LocalDate;
import java.util.Scanner;

public class Menu {

    private static final Scanner scanner = new Scanner(System.in);

    public static void showMainMenu() {
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
                TaskService.greatTask();
                break;
            case 2:
                TaskService.getAllByDate(LocalDate.now());
                showMainMenu();
                break;
            case 3:
                LocalDate localDate = DataCollector.scanDate();
                TaskService.getAllByDate(localDate);
                break;
            case 4:
                try {
                    showTaskMenu(TaskService.getTaskById());
                    } catch (TaskNotFoundException e) {
                    System.out.println("Задача не найдена");
                    showMainMenu();
                }
                break;
            case 5:
                try {
                    System.out.println(TaskService.getAllTasks());
                    showMainMenu();
                } catch (TaskNotFoundException e) {
                    System.out.println(e);
                }
                showMainMenu();
                break;
            case 6:
                try {
                    System.out.println(TaskService.getRemovedTask());
                    showMainMenu();
                } catch (TaskNotFoundException e) {
                    System.out.println(e);
                }
                showMainMenu();
                break;
            case 7:
                System.exit(0);
                break;
            default:
                showMainMenu();
        }
    }

    public static void showTaskMenu(Task task) {
        System.out.println(task);
        System.out.println("Выберите действие: \n " +
                "1 - Изменить задачу \n " +
                "2 - Удалить задачу \n " +
                "3 - Вернуться в главное меню");
        switch (scanner.nextInt()) {
            case 1:
                showEditTaskMenu(task);
                break;
            case 2:
                TaskService.remove(task.getId());
                break;
            case 3:
                showMainMenu();
                break;
            default:
                showTaskMenu(task);
                break;
        }
    }

    public static void showEditTaskMenu(Task task) {
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
                TaskService.editTask(task.getId(), action);
                break;
            default:
                showEditTaskMenu(task);
                break;
        }
    }

}
