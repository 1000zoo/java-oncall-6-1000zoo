package oncall.controller;

import java.util.Arrays;
import java.util.List;
import oncall.constants.InstructionMessage;
import oncall.domain.EmergencyWorkers;
import oncall.view.Input;
import oncall.view.output.Output;

public class WorkerController {

    private final Input input = new Input();
    private final Output output = new Output();

    public EmergencyWorkers readWeekdayWorkers() {
        return read(InstructionMessage.TYPE_WEEKDAY_WORKERS.getMessage());
    }

    public EmergencyWorkers readHolidayWorkers() {
        return read(InstructionMessage.TYPE_HOLIDAY_WORKERS.getMessage());
    }

    private EmergencyWorkers read(String message) {
        while (true) {
            try {
                return readUntilValidInput(message);
            } catch (IllegalArgumentException exception) {
                output.print(exception.getMessage());
            }
        }
    }

    private EmergencyWorkers readUntilValidInput(String message) {
        List<String> splitList = Arrays.stream(message.split(",")).toList();
        return EmergencyWorkers.from(splitList);
    }


}
