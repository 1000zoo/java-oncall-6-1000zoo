package oncall.domain.date;

import java.util.Arrays;

public enum Holiday {
    NEW_YEAR(1, 1),
    THIRD_ONE(3, 1),
    CHILDREN(5, 5),
    MEMORIAL(6, 6),
    INDEPENDENT(8, 15),
    FOUNDATION(10, 3),
    HANGUL(10, 9),
    XMAS(12, 25);

    private final int month;
    private final int day;

    Holiday(int month, int day) {
        this.month = month;
        this.day = day;
    }

    public static boolean isHoliday(int month, int day) {
        return Arrays.stream(values())
                .anyMatch(holiday -> holiday.month == month && holiday.day == day);
    }
}
