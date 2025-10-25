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

    @Override
    protected void runMain() {
        InputView.readCarNames();
    }
}
