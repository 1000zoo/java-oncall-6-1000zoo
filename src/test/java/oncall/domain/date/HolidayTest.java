package oncall.domain.date;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class HolidayTest {

    @ParameterizedTest
    @DisplayName("공휴일인지 아닌지 테스트")
    @CsvSource(value = {
            "1,1,true",
            "12,25,true",
            "10,6,false"
    }, delimiter = ',')
    void isHolidayTest(int month, int day, boolean answer) {
        boolean result = Holiday.isHoliday(month, day);

        assertThat(result).isEqualTo(answer);
    }
}