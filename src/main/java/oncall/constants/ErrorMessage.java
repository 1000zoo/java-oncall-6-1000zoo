package oncall.constants;

public enum ErrorMessage {
    INVALID_WORKER_NAME("근무자의 이름은 5글자 이하여야 합니다."),
    INVALID_TOTAL_SIZE("총 인원이 너무 적습니다."),
    INVALID_DAY_OF_WEEK("잘못된 요일입니다."),
    INVALID_MONTH("잘못된 월 입력입니다."),
    INVALID_WORKERS_INPUT("근무 인력은 5 ~ 35 명 사이여야 합니다."),
    DUPLICATE_NICKNAME_EXIST("중복된 닉네임이 포함되어있습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR] " + message;
    }
}
