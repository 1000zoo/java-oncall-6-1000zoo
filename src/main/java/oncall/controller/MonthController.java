package oncall.controller;

import oncall.constants.ErrorMessage;
import oncall.constants.InstructionMessage;
import oncall.domain.date.Month;
import oncall.view.Input;
import oncall.view.output.Output;

public class MonthController {

    private final Input input = new Input();
    private final Output output = new Output();

    public Month readMonth() {
        while (true) {
            try {
                return read();
            } catch (IllegalArgumentException exception) {
                output.print(exception.getMessage());
            }
        }
    }

    private Month read() {
        output.printInstruction(InstructionMessage.TYPE_MONTH.getMessage());
        String line = input.read();
        return parser(line);
    }

    private Month parser(String line) {
        String[] split = line.split(",");
        int day = dayParser(split[0]);
        String dayOfWeek = split[1];
        return new Month(day, dayOfWeek);
    }

    private int dayParser(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_MONTH.getMessage());
        }
    }

}
