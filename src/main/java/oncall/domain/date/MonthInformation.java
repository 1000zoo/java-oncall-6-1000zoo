package oncall.domain.date;

import java.util.Arrays;
import oncall.constants.ErrorMessage;

public enum MonthInformation {
    JANUARY(1, 31),
    FEBRUARY(2, 28),
    MARCH(3, 31),
    APRIL(4, 30),
    MAY(5, 31),
    JULY(6, 30),
    JUNE(7, 31),
    AUGUST(8, 31),
    SEPTEMBER(9, 30),
    OCTOBER(10, 31),
    NOVEMBER(11, 30),
    DECEMBER(12, 31),
    ;

    private final int name;
    private final int maximumDay;

    MonthInformation(int name, int maximumDay) {
        this.name = name;
        this.maximumDay = maximumDay;
    }

    public static int getMaximumDay(int name) {
        return Arrays.stream(values())
                .filter(monthInformation -> name == monthInformation.name)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.INVALID_MONTH.getMessage()))
                .maximumDay;
    }
}
