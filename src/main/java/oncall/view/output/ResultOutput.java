package oncall.view.output;

import oncall.view.dto.ScheduleResultDto;

public class ResultOutput {

    private final Output output = new Output();

    public void printResult(ScheduleResultDto scheduleResultDto) {
        StringBuilder stringBuilder = new StringBuilder();
        output.print(formatting(stringBuilder, scheduleResultDto));
    }

    private String formatting(StringBuilder builder, ScheduleResultDto dto) {
        return builder.append(formatting(dto.month(), dto.getDay(), dto.getDayOfWeek()))
                .append(appendIfHoliday(dto))
                .append(dto.workerName())
                .toString();
    }

    private String appendIfHoliday(ScheduleResultDto dto) {
        if (dto.isOnlyHoliday()) {
            return "(휴일) ";
        }
        return " ";
    }

    private String formatting(int month, int day, String dayOfWeek) {
        return String.format("%d 월 %d  %s", month, day, dayOfWeek);
    }

}
