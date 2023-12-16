package oncall.constants;

public enum ErrorMessage {
    INVALID_WORKER_NAME("근무자의 이름은 5글자 이하여야 합니다."),
    INVALID_DAY_OF_WEEK("잘못된 요일입니다."),
    INVALID_MONTH("잘못된 월 입력입니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR] " + message;
    }
}
