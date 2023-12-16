package oncall.domain.date;

public class Date {

    private final int day;
    private final DayOfWeek dayOfWeek;

    public Date(int day, DayOfWeek dayOfWeek) {
        this.day = day;
        this.dayOfWeek = dayOfWeek;
    }

    @Override
    public String toString() {
        return "Date{" +
                "day=" + day +
                ", dayOfWeek=" + dayOfWeek +
                '}';
    }
}
