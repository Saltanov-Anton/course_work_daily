package Task;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DailyTask extends Task {

    public DailyTask(String title, Type type, LocalDateTime dateTime, String description) {
        super(title, type, dateTime, description);
    }

    @Override
    public boolean appearsIn(LocalDate date) {
        return date.isAfter(getDateTime().toLocalDate()) || date.isEqual(getDateTime().toLocalDate());
    }
}
