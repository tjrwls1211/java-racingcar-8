package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RacingGame {
    private static final int RANDOM_MIN = 0;
    private static final int RANDOM_MAX = 9;

    private final List<Car> cars;

    public RacingGame(List<Car> cars) {
        this.cars = cars;
    }

    public void play(int attempts) {
        for (int i = 0; i < attempts; i++) {
            moveAllCars();
        }
    }

    private void moveAllCars() {
        for (Car car : cars) {
            int randomNumber = Randoms.pickNumberInRange(RANDOM_MIN, RANDOM_MAX);
            car.move(randomNumber);
        }
    }
}


