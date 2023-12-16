package oncall.view.dto;

import oncall.domain.date.Date;

public record ScheduleResultDto(int month, Date date, String workerName) {
    public int getDay() {
        return date.day();
    }

    public String getDayOfWeek() {
        return date.dayOfWeek().getName();
    }

    public boolean isOnlyHoliday() {
        return date.isOnlyHoliday();
    }
}
