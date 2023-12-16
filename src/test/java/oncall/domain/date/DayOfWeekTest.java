package oncall.domain.date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DayOfWeekTest {

    @Test
    @DisplayName("잘못된 요일 테스트")
    void invalidDayOfWeek() {

        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> DayOfWeek.findByName("툐")
        );

    }

}