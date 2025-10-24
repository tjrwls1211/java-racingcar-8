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

        assertThat(cars)
                .allSatisfy(car -> assertThat(car.getPosition()).isBetween(0, 5));
    }

    @Test
    void 가장_먼저_도착한_자동차가_우승한다() {
        List<Car> cars = List.of(new Car("jini"), new Car("mini"));
        RacingGame racingGame = new RacingGame(cars);

        racingGame.play(5);
        List<String> winners = racingGame.getWinners();

        System.out.println(winners);

        assertThat(winners).isNotEmpty();
    }


}
