package racingcar.domain;

import java.util.List;

public class RacingGame {
    private final Cars cars;

    public RacingGame(List<Car> cars) {
        this.cars = new Cars(cars);
    }

    public void moveAllCars() {
        cars.moveAll();
    }

    public List<String> getWinners() {
        return cars.getWinners();
    }

    public List<Car> getAllCars() {
        return cars.getAllCars();
    }
}
