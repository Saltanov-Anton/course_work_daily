package Task;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MonthlyTask extends Task {

    public MonthlyTask(String title, Type type, LocalDateTime dateTime, String description) {
        super(title, type, dateTime, description);
    }

    @Override
    public boolean appearsIn(LocalDate date) {
        return (date.isAfter(getDateTime().toLocalDate()) || date.isEqual(getDateTime().toLocalDate()))
                && (date.getDayOfMonth() == getDateTime().getDayOfMonth());
    }
}
