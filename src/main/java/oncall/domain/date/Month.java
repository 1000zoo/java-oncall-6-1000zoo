package oncall.domain.date;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Month {

    private final int month;
    private final List<Date> days = new ArrayList<>();

    public Month(int month, String dayOfWeek) {
        this.month = month;
        createDays(MonthInformation.getMaximumDay(month), DayOfWeek.findByName(dayOfWeek));
    }

    private void createDays(int maximumDay, DayOfWeek dayOfWeek) {
        for (int day = 1; day <= maximumDay; day++) {
            Date date = new Date(day, dayOfWeek, Holiday.isHoliday(month, day));
            days.add(date);
            dayOfWeek = dayOfWeek.next();
        }
    }

    public int getMonth() {
        return month;
    }

    public List<Date> getDays() {
        return Collections.unmodifiableList(days);
    }

    @Override
    public String toString() {
        return days.toString();
    }
}
