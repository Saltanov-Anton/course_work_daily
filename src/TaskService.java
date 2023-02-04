
import Exceptions.TaskNotFoundException;
import Task.*;

import java.time.LocalDate;
import java.util.*;

public class TaskService {
    private static Map<Integer, Task> taskMap = new HashMap<>();
    private static List<Task> removedTask = new ArrayList<>();

    public static void add(Task task) {
        taskMap.put(task.getId(), task);
    }

    public static void remove(Integer i) {
        removedTask.add(taskMap.get(i));
        taskMap.remove(i);
    }

    public static Task getTaskById(Integer id) throws TaskNotFoundException {
        if (!taskMap.containsKey(id)) {
            throw new TaskNotFoundException("Задачи не найдены");
        }
        return taskMap.get(id);
    }

    public static List<Task> getAllByDate(LocalDate l) throws TaskNotFoundException {
        List<Task> taskByDate = new ArrayList<>();
        for (Map.Entry<Integer, Task> entry : taskMap.entrySet()) {
            if (entry.getValue().appearsIn(l)) {
                taskByDate.add(entry.getValue());
            } else {
                throw new TaskNotFoundException("Задачи не найдены");
            }
        }
        return taskByDate;
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
