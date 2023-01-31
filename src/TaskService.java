import Exceptions.TaskNotFoundException;
import Task.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class TaskService {
    private static Map<Integer, Task> taskMap = new HashMap<>();
    private static List<Task> removedTask = new ArrayList<>();

    public static void greatTask() {
        Scanner scanner = new Scanner(System.in);
        String title = DataCollector.scanTitle(scanner);
        String description = DataCollector.scanDescription(scanner);
        LocalDateTime dateTime = DataCollector.scanDateTime(scanner);
        Type type = DataCollector.scanType(scanner);
        Task task = DataCollector.scanPeriod(title, type, dateTime, description, scanner);
        System.out.println("Задача создана");
        add(task);
        Menu.showMainMenu();
    }

    public static void editTask(int id, int action) {
        Scanner scanner = new Scanner(System.in);
        switch (action) {
            case 1:
                taskMap.get(id).setType(DataCollector.scanType(scanner));
                break;
            case 2:
                taskMap.get(id).setTitle(DataCollector.scanTitle(scanner));
                break;
            case 3:
                taskMap.get(id).setDescription(DataCollector.scanDescription(scanner));
                break;
            case 4:
                taskMap.get(id).setDateTime(DataCollector.scanDateTime(scanner));
                break;
            case 5:
                Task task = taskMap.get(id);
                DataCollector.scanPeriod(task.getTitle(), task.getType(),
                        task.getDateTime(), task.getDescription(), scanner);
                add(task);
                break;
        }
        System.out.println(taskMap.get(id));
        Menu.showMainMenu();
    }

    public static void add(Task task) {
        taskMap.put(task.getId(), task);
    }

    public static void remove(Integer i) {
        removedTask.add(taskMap.get(i));
        taskMap.remove(i);
        Menu.showMainMenu();
    }

    public static Task getTaskById() throws TaskNotFoundException {
        Scanner scan = new Scanner(System.in);
        int id = DataCollector.scanId(scan);

        if (!taskMap.containsKey(id)) {
            throw new TaskNotFoundException("Задачи не найдены");
        }
        return taskMap.get(id);
    }

    public static void getAllByDate(LocalDate l) {
        for (Map.Entry<Integer, Task> entry : taskMap.entrySet()) {
            if (entry.getValue().getDateTime().toLocalDate().equals(l)) {
                System.out.println(entry.getValue().toString());
            } else {
                System.out.println("Задач нет");
            }
        }
    }

    public static Map<Integer, Task> getAllTasks() throws TaskNotFoundException {
        if (taskMap.isEmpty()) {
            throw new TaskNotFoundException("Задачи не найдены");
        }
        return taskMap;
    }

    public static List<Task> getRemovedTask() throws TaskNotFoundException {
        if (removedTask.isEmpty()) {
            throw new TaskNotFoundException("Архив пуст");
        }
        return removedTask;
    }
}
