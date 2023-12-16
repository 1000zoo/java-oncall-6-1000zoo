package oncall.domain;

import java.util.LinkedList;
import oncall.constants.ErrorMessage;
import oncall.domain.date.Date;

public class WorkerList {

    private final LinkedList<Worker> weekdayBackup;
    private final LinkedList<Worker> holidayBackup;

    private final LinkedList<Worker> weekday;
    private final LinkedList<Worker> holiday;

    public WorkerList(EmergencyWorkers weekday, EmergencyWorkers holiday) {
        validate(weekday.size() + holiday.size());
        this.weekday = weekday.getWorkerQueue();
        this.holiday = holiday.getWorkerQueue();

        weekdayBackup = new LinkedList<>(this.weekday);
        holidayBackup = new LinkedList<>(this.holiday);
    }

    private void validate(int totalSize) {
        if (totalSize < 5) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_TOTAL_SIZE.getMessage());
        }
    }

    public Worker pickWorker(Date date, Worker previousWorker) {
        if (date.isHoliday() || date.isWeekend()) {
            return pickFromHoliday(previousWorker);
        }
        return pickFromWeekday(previousWorker);
    }

    private Worker pickFromWeekday(Worker previousWorker) {
        if (previousWorker == null || !previousWorker.equals(weekday.peek())) {
            return weekday.poll();
        }
        return weekday.remove(1);
    }

    private Worker pickFromHoliday(Worker previousWorker) {
        if (previousWorker == null || !previousWorker.equals(holiday.peek())) {
            return holiday.poll();
        }
        return holiday.remove(1);
    }

    private void fillWeekdayWorker() {
        if (weekday.size() < 5) {
            weekday.addAll(weekdayBackup);
        }
    }

    private void fillHolidayWorker() {
        if (holiday.size() < 5) {
            holiday.addAll(holidayBackup);
        }
    }
}
