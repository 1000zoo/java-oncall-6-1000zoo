package oncall.service;

import java.util.HashMap;
import java.util.Map;
import oncall.domain.EmergencyWorkers;
import oncall.domain.Worker;
import oncall.domain.WorkerList;
import oncall.domain.date.Date;
import oncall.domain.date.Month;

public class WorkScheduler {

    private final Map<Date, Worker> calendar = new HashMap<>();

    private final WorkerList workerList;
    private final Month month;

    public WorkScheduler(EmergencyWorkers weekdayWorkers, EmergencyWorkers holidayWorkers, Month month) {
        workerList = new WorkerList(weekdayWorkers, holidayWorkers);
        this.month = month;
    }

    public void schedule() {
        Worker prevWorker = null;

        for (Date date : month.getDays()) {
            prevWorker = process(date, prevWorker);
        }
    }

    private Worker process(Date date, Worker prevWorker) {
        if (prevWorker == null) {

        }
        return null;
    }
}
