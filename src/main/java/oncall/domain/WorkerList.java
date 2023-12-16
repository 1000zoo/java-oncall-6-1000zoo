package oncall.domain;

import java.util.LinkedList;
import oncall.domain.date.Date;

public class WorkerList {

    private final LinkedList<Worker> weekday;
    private final LinkedList<Worker> holiday;

    public WorkerList(EmergencyWorkers weekday, EmergencyWorkers holiday) {
        this.weekday = weekday.getWorkerQueue();
        this.holiday = holiday.getWorkerQueue();
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
}
