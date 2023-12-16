package oncall.domain.date;

public class Date {

    private final int day;
    private final DayOfWeek dayOfWeek;
    private final boolean isHoliday;

    public Date(int day, DayOfWeek dayOfWeek) {
        this.day = day;
        this.dayOfWeek = dayOfWeek;
        this.isHoliday = true;
    }

    @Override
    public String toString() {
        return "Date{" +
                "day=" + day +
                ", dayOfWeek=" + dayOfWeek +
                '}';
    }
}
