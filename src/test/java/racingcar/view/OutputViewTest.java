package racingcar.view;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

public class OutputViewTest {

    @Test
    void 자동차_이동_결과를_출력한다() {
        String output = OutputView.generateCarStatus("pobi", 3);
        assertThat(output).isEqualTo("pobi : ---");
    }

    @Test
    void 우승자를_출력한다() {
        String output = OutputView.generateWinners(List.of("pobi", "jun"));
        assertThat(output).isEqualTo("최종 우승자 : pobi, jun");
    }
}
