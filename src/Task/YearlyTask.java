package Task;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class YearlyTask extends Task {

    public YearlyTask(String title, Type type, LocalDateTime dateTime, String description) {
        super(title, type, dateTime, description);
    }

    public void changeDate(LocalDate localDate) {
        while (localDate.isAfter(this.getDateTime().toLocalDate())) {
            this.setDateTime(this.getDateTime().plusYears(1));
        }
    }
}
