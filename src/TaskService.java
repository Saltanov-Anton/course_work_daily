import Task.Task;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskService {
    private Map<Integer, Task> taskMap = new HashMap<>();
    private List<Task> removedTask = new ArrayList<>();

    public void add(Task task) {

    }

    public Task remove (int i) {
        Task task = new Task();
        return task;
    }

    public List<Task> getAllByDate (LocalDate l) {
        return new ArrayList<>();
    }
}
