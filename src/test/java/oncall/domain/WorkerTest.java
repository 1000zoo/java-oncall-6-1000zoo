package oncall.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class WorkerTest {

    @ParameterizedTest
    @DisplayName("사원 이름 유효성 테스트")
    @CsvSource(value = {
            "가나다라마바"
    }, delimiter = ',')
    void workerNameTest(String name) {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new Worker(name)
        );
    }

}