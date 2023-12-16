package oncall.view.output;

import oncall.view.dto.ScheduleResultDto;

public class ResultOutput {

    private final Output output = new Output();

    public void printResult(ScheduleResultDto scheduleResultDto) {
        output.print(formatting(scheduleResultDto));
    }

    private String formatting(ScheduleResultDto dto) {
        return formatting(dto.month(), dto.getDay(), dto.isOnlyHoliday(), dto.getDayOfWeek(), dto.workerName());
    }

    private String formatting(int month, int day, boolean isOnlyHoliday, String dayOfWeek, String name) {
        return String.format("%d월 %d일%s%s %s\n", month, day, appendIfHoliday(isOnlyHoliday), dayOfWeek, name);
    }

    private String appendIfHoliday(boolean isOnlyHoliday) {
        if (isOnlyHoliday) {
            return " (휴일) ";
        }
        return " ";
    }
}
