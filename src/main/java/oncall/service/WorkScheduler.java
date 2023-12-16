package oncall.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import oncall.domain.Worker;
import oncall.domain.WorkerList;
import oncall.domain.date.Date;
import oncall.domain.date.Month;

public class WorkScheduler {

    private final Map<Date, Worker> calendar = new HashMap<>();

    private final WorkerList workerList;
    private final Month month;

    public WorkScheduler(WorkerList workerList, Month month) {
        this.workerList = workerList;
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

    public String getWorkerNameAt(Date date) {
        return calendar.get(date).name();
    }

    public List<Date> getDays() {
        return month.getDays();
    }
}
