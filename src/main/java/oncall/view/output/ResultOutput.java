package oncall.view.output;

import oncall.constants.ResultFormat;
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
        return ResultFormat.RESULT_FORMAT.formatting(month, day, isOnlyHoliday, dayOfWeek, name);
    }
}
