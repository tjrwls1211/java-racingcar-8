package racingcar.view;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

class InputViewTest extends NsTest {

    @Test
    void 자동차_이름을_입력받는다() {
        run("pobi,woni,jun", "5");

        assertThat(output()).contains("경주할 자동차 이름을 입력하세요");
    }

    @Test
    void 시도할_횟수를_입력받는다() {
        run("pobi,woni", "5");

        assertThat(output()).contains("시도할 횟수는 몇 회인가요?");
    }

    @Test
    void 자동차_이름이_5자를_초과하면_예외가_발생한다() {
        List<String> names = List.of("abcdef", "jini");
        assertThatThrownBy(() -> InputView.validateCarNames(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자를 초과할 수 없습니다.");
    }

    @Test
    void 자동차_이름이_비어있으면_예외가_발생한다() {
        List<String> names = List.of(" ", "jini");
        assertThatThrownBy(() -> InputView.validateCarNames(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 비어 있을 수 없습니다.");
    }

    @Test
    void 자동차_이름이_중복되면_예외가_발생한다() {
        List<String> names = List.of("pobi", "woni", "pobi");
        assertThatThrownBy(() -> InputView.validateCarNames(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 자동차 이름이 있습니다.");
    }

    @Test
    void 자동차_이름_목록이_비어있으면_예외가_발생한다() {
        List<String> names = List.of();
        assertThatThrownBy(() -> InputView.validateCarNames(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름 목록은 비어 있을 수 없습니다.");
    }

    @Test
    void 자동차_대수가_2대_미만이면_예외가_발생한다() {
        List<String> names = List.of("pobi");
        assertThatThrownBy(() -> InputView.validateCarNames(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차는 2대 이상이어야 합니다.");
    }

    @Test
    void 시도_횟수가_숫자가_아닐_경우_예외가_발생한다() {
        assertThatThrownBy(() -> InputView.validateAttemptCount("five"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수는 숫자여야 합니다.");
    }

    @Test
    void 시도_횟수가_1회_미만일_경우_예외가_발생한다() {
        assertThatThrownBy(() -> InputView.validateAttemptCount("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수는 1회 이상이어야 합니다.");
    }

    @Override
    protected void runMain() {
        InputView.readCarNames();
        InputView.readAttemptCount();
    }
}
