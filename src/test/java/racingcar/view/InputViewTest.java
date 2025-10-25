package racingcar.view;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
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

    @Test
    void 자동차_이름이_5자를_초과하면_예외가_발생한다() {
        assertThatThrownBy(() -> InputView.validateCarName("abcdefg"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자를 초과할 수 없습니다.");
    }

    @Test
    void 자동차_이름이_비어있으면_예외가_발생한다() {
        assertThatThrownBy(() -> InputView.validateCarName(" "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 비어있을 수 없습니다.");
    }

    @Override
    protected void runMain() {
        InputView.readCarNames();
        InputView.readAttemptCount();
    }
}
