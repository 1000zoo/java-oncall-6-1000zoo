package oncall.constants;

public enum ErrorMessage {
    INVALID_WORKER_NAME("근무자의 이름은 5글자 이하여야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR] " + message;
    }
}
