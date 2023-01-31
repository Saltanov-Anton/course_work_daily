package Task;


import java.time.LocalDate;
import java.time.LocalDateTime;

public class OneTimeTask extends Task {

    public OneTimeTask(String title, Type type, LocalDateTime dateTime, String description) {
        super(title, type, dateTime, description);
    }

    public void changeDate(LocalDate localDate) {
        while (localDate.isAfter(this.getDateTime().toLocalDate())) {
            this.setDateTime(this.getDateTime().plusDays(1));
        }
    }

    @Override
    public boolean appearsIn(LocalDate localDate) {
        if (localDate.equals(this.getDateTime().toLocalDate())) {
            return true;
        }
        return false;
    }
}
