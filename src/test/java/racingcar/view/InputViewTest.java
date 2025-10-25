package racingcar.view;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class InputViewTest extends NsTest {

    @Test
    void 자동차_이름을_입력받는다() {
        run("pobi,woni,jun");

        assertThat(output()).contains("경주할 자동차 이름을 입력하세요");
    }

    @Test
    void 시도할_횟수를_입력받는다() {
        run("pobi,woni", "5");

        assertThat(output()).contains("시도할 횟수는 몇 회인가요?");
    }

    @Override
    protected void runMain() {
        InputView.readCarNames();
        InputView.readAttemptCount();
    }
}
