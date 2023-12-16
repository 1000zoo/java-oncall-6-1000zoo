package oncall.domain.date;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DateTest {

    @Test
    @DisplayName("동일성 테스트")
    void equalsTest() {
        // given
        Date date1 = new Date(1, DayOfWeek.FRIDAY, true);
        Date date2 = new Date(1, DayOfWeek.FRIDAY, true);

        // when
        Map<Date, Integer> map = new HashMap<>();
        map.put(date1, 1);
        map.put(date2, 23);

        // then
        assertThat(map.size()).isEqualTo(1);

    }
}