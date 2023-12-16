package oncall.constants;

public enum InstructionMessage {
    TYPE_MONTH("비상 근무를 배정할 월과 시작 요일을 입력하세요> "),

    ;

    private final String message;

    InstructionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
