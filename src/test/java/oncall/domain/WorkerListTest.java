package oncall.domain;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import oncall.domain.date.Date;
import oncall.domain.date.DayOfWeek;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WorkerListTest {

    private WorkerList workerList;

    @BeforeEach
    private void setUp() {
        EmergencyWorkers weekday = EmergencyWorkers.from(List.of("가나", "다라", "마바", "사아", "자차"));
        EmergencyWorkers holiday = EmergencyWorkers.from(List.of("가나", "다라", "마바", "사아", "지우"));
        workerList = new WorkerList(weekday, holiday);
    }

    @Test
    @DisplayName("전체 인원이 5명이 안된다면 에러를 발생시켜야한다.")
    void sizeValidationTest() {
        List<String> weekdayNameList = List.of("지우", "가나");
        List<String> holidayNameList = List.of("지우");

        assertThrows(
                IllegalArgumentException.class,
                () -> new WorkerList(EmergencyWorkers.from(weekdayNameList), EmergencyWorkers.from(holidayNameList))
        );

    }

    @Test
    @DisplayName("이 전 근무자가 이틀 연속으로 근무를 설 때, 다음 근무자를 반환하는지")
    void pickWorkerTest() {
        // given
        Worker previousWorker = new Worker("가나");
        Date date = new Date(1, DayOfWeek.MONDAY, false);

        // when
        Worker worker = workerList.pickWorker(date, previousWorker);

        // then
        Assertions.assertThat(worker.name()).isEqualTo("다라");

    }

    @Test
    @DisplayName("이틀 연속이 아닐 경우, 바로 다음 근무자를 반환하는지")
    void pickWorkerTest2() {
        // given
        Worker previousWorker = new Worker("지우");
        Date date = new Date(1, DayOfWeek.MONDAY, false);

        // when
        Worker worker = workerList.pickWorker(date, previousWorker);

        // then
        Assertions.assertThat(worker.name()).isEqualTo("가나");

    }

}