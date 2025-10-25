package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class RacingController {

    public void run() {
        List<String> carNames = InputView.readCarNames();

        int attemptCount = InputView.readAttemptCount();

        List<Car> cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());

        RacingGame racingGame = new RacingGame(cars);

        System.out.println("\n실행 결과");
        for (int i = 0; i < attemptCount; i++) {
            racingGame.moveAllCars();
            for (Car car : cars) {
                OutputView.printCarStatus(car.getName(), car.getPosition());
            }
            System.out.println();
        }

        List<String> winners = racingGame.getWinners();
        OutputView.printWinners(winners);
    }
}
