package Task;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DailyTask extends Task {

    public DailyTask(String title, Type type, LocalDateTime dateTime, String description) {
        super(title, type, dateTime, description);
    }

    public void changeDate(LocalDate localDate) {
        while (localDate.isAfter(this.getDateTime().toLocalDate())) {
            this.setDateTime(this.getDateTime().plusDays(1));
        }
    }
}
