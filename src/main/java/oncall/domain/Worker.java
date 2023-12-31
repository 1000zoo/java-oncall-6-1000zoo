package oncall.domain;

import oncall.constants.ErrorMessage;

public record Worker(String name) {

    public Worker {
        if (name.length() < 1 || name.length() > 5) {
            System.out.println(name);
            throw new IllegalArgumentException(ErrorMessage.INVALID_WORKER_NAME.getMessage());
        }
    }
}
