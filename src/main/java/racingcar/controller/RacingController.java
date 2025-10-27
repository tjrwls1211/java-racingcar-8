package racingcar.controller;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    public void run() {
        List<String> carNames = InputView.readCarNames();
        int attemptCount = InputView.readAttemptCount();

        List<Car> cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());

        RacingGame racingGame = new RacingGame(cars);

        OutputView.printStartMessage();

        for (int i = 0; i < attemptCount; i++) {
            racingGame.moveAllCars();
            OutputView.printRoundResult(racingGame.getAllCars());
        }

        OutputView.printWinners(racingGame.getWinners());
    }
}
