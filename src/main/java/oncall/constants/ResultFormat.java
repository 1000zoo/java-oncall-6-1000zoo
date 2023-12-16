package oncall.constants;

public enum ResultFormat {
    RESULT_FORMAT("%d월 %d일%s%s %s");

    private final String format;

    ResultFormat(String format) {
        this.format = format;
    }

    public String formatting(int month, int day, boolean isHoliday, String dayOfWeek, String name) {
        return String.format(format, month, day, appendIfHoliday(isHoliday), dayOfWeek, name);

    }

    private String appendIfHoliday(boolean isOnlyHoliday) {
        if (isOnlyHoliday) {
            return " (휴일) ";
        }
        return " ";
    }
}
