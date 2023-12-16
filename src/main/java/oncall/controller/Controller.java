package oncall.controller;

import oncall.domain.date.Month;

public class Controller {

    private final MonthController monthController = new MonthController();

    public void start() {
        Month month = monthController.readMonth();
    }
}
