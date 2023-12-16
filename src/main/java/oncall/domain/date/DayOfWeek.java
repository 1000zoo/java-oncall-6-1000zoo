package oncall.domain.date;

import java.util.Arrays;
import oncall.constants.ErrorMessage;

public enum DayOfWeek {
    SUNDAY("일"),
    MONDAY("월"),
    TUESDAY("화"),
    WEDNESDAY("수"),
    THURSDAY("목"),
    FRIDAY("금"),
    SATURDAY("토");

    private final String name;

    DayOfWeek(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static DayOfWeek findByName(String name) {
        return Arrays.stream(values())
                .filter(dayOfWeek -> name.equals(dayOfWeek.name))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.INVALID_DAY_OF_WEEK.getMessage()));
    }

    public boolean isWeekend() {
        return this == SATURDAY || this == SUNDAY;
    }

    public DayOfWeek next() {
        return values()[(this.ordinal() + 1) % values().length];
    }
}
