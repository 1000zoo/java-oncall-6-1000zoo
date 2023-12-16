package oncall.domain.date;

public record Date(int day, DayOfWeek dayOfWeek, boolean isHoliday) {

    public boolean isWeekend() {
        return dayOfWeek.isWeekend();
    }

    public boolean isOnlyHoliday() {
        return isHoliday && !dayOfWeek.isWeekend();
    }
}
