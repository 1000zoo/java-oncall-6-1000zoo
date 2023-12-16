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
        Worker previousWorker = null;

        for (Date date : month.getDays()) {
            previousWorker = process(date, previousWorker);
        }
    }

    private Worker process(Date date, Worker prevWorker) {
        Worker currentWorker = workerList.pickWorker(date, prevWorker);
        calendar.put(date, currentWorker);
        return currentWorker;
    }

    public void printCalendar() {
        for (Date date : month.getDays()) {
            System.out.println(date + ":" + calendar.get(date));
        }
    }
}
