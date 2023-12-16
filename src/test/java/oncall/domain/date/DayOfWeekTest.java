package oncall.domain.date;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class DayOfWeekTest {

    @Test
    @DisplayName("잘못된 요일 테스트")
    void invalidDayOfWeek() {

        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> DayOfWeek.findByName("툐")
        );

    }

    @ParameterizedTest
    @DisplayName("다음 요일을 불러오는 지 테스트")
    @CsvSource(value = {
            "일,월",
            "월,화"
    }, delimiter = ',')
    void nextDayTest(String today, String answer) {
        //given
        DayOfWeek day = DayOfWeek.findByName(today);

        //when
        DayOfWeek tomorrow = day.next();

        //then
        assertThat(tomorrow.getName()).isEqualTo(answer);
    }

}