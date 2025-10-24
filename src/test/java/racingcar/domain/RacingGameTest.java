package racingcar.domain;

import java.util.List;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class RacingGameTest {

    @Test
    void 시도_횟수만큼_자동차들이_이동한다() {
        List<Car> cars = List.of(new Car("jini"), new Car("mini"));
        RacingGame racingGame = new RacingGame(cars);

        racingGame.play(5);

        for (Car car : cars) {
            assertThat(car.getPosition()).isBetween(0, 5);
        }
    }
}
