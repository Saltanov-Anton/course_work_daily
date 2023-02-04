package Task;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public abstract class Task {
    private static int idGenerator;
    private int id;
    private Type type;
    private LocalDateTime dateTime;
    private String title;
    private String description;

    public Task(String title, Type type, LocalDateTime dateTime, String description) {
        this.title = title;
        this.type = type;
        this.id = ++idGenerator;
        this.dateTime = dateTime;
        this.description = description;
    }

    public abstract boolean appearsIn(LocalDate localDate);

    public int getId() {
        return id;
    }

    public Type getType() {
        return type;
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
        return id == task.id && Objects.equals(title, task.title)
                && type == task.type && Objects.equals(dateTime, task.dateTime)
                && Objects.equals(description, task.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, type, id, dateTime, description);
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", type=" + type +
                ", dateTime=" + dateTime +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
