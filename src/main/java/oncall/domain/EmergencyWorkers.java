package oncall.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import oncall.constants.ErrorMessage;

public class EmergencyWorkers {
    private final List<Worker> workers;

    private EmergencyWorkers(List<Worker> workers) {
        this.workers = workers;
    }

    public static EmergencyWorkers from(List<String> names) {
        validate(names);
        List<Worker> workers = new ArrayList<>();
        Set<String> duplicateChecker = new HashSet<>();

        for (String name : names) {
            if (duplicateChecker.contains(name)) {
                throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NICKNAME_EXIST.getMessage());
            }
            workers.add(new Worker(name));
            duplicateChecker.add(name);
        }
        return new EmergencyWorkers(workers);
    }

    private static void validate(List<String> names) {
        if (names.size() < 5 || names.size() > 35) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_WORKERS_INPUT.getMessage());
        }
    }
}
