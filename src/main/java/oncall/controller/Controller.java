package oncall.controller;

import oncall.domain.EmergencyWorkers;
import oncall.domain.WorkerList;
import oncall.domain.date.Date;
import oncall.domain.date.Month;
import oncall.service.WorkScheduler;
import oncall.view.dto.ScheduleResultDto;
import oncall.view.output.ResultOutput;

public class Controller {

    private final ResultOutput output = new ResultOutput();

    private final MonthController monthController = new MonthController();
    private final WorkerController workerController = new WorkerController();

    public void start() {
        Month month = monthController.readMonth();
        WorkerList workerList = createWorkerList();
        WorkScheduler workScheduler = new WorkScheduler(workerList, month);

        workScheduler.schedule();

        printResults(month.getMonth(), workScheduler);
    }

    private WorkerList createWorkerList() {
        EmergencyWorkers weekdayWorkers = workerController.readWeekdayWorkers();
        EmergencyWorkers holidayWorkers = workerController.readHolidayWorkers();
        return new WorkerList(weekdayWorkers, holidayWorkers);
    }

    private void printResults(int month, WorkScheduler workScheduler) {
        for (Date date : workScheduler.getDays()) {
            ScheduleResultDto dto = new ScheduleResultDto(month, date, workScheduler.getWorkerNameAt(date));
            output.printResult(dto);
        }

    }
}
