package oncall.domain;

import java.util.LinkedList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EmergencyWorkersTest {

    @Test
    @DisplayName("인원이 5명 이하면 에러를 발생시켜야한다.")
    void sizeTest() {
        // given
        List<String> names = List.of("지우", "카노", "지우");

        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> EmergencyWorkers.from(names)
        );

    }

    @Test
    @DisplayName("중복된 이름이 포함되면 에러를 발생시켜야한다.")
    void duplicatedNamesTest() {
        // given
        List<String> names = List.of("지우", "카노", "지우", "씨그램", "에어팟");

        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> EmergencyWorkers.from(names)
        );

    }

    public static void main(String[] args) {
        EmergencyWorkers workers = EmergencyWorkers.from(List.of("지우", "준빈", "민주", "승원", "준성"));
        LinkedList<Worker> queue = workers.getWorkerQueue();

        System.out.println(queue.remove(1));
        System.out.println("!!!");

        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
        System.out.println(queue);
    }
}