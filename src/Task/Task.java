package Task;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Task {
    private static int idGenerator;
    private String title;
    private Type type;
    private int id;
    private LocalDateTime dateTime;
    private String description;

    public boolean appearsIn(LocalDate localDate) {
        return false;
    }

    public int getId() {
        return 1;
    }

    public Type getType() {
        return type;
    }

    public void setTitle() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id && Objects.equals(title, task.title) && type == task.type && Objects.equals(dateTime, task.dateTime) && Objects.equals(description, task.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, type, id, dateTime, description);
    }
}
