package racingcar.domain;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void 랜덤_값이_4_이상일_때_전진한다() {
        Car car = new Car("jini");
        car.move(4);
        assert car.getPosition() == 1;
    }

    @Test
    void 랜덤_값이_4_미만일_때_멈춘다() {
        Car car = new Car("jini");
        car.move(3);
        assert car.getPosition() == 0;
    }
}
