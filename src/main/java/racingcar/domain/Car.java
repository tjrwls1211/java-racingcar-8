package racingcar.domain;

public class Car {
    private static final int MOVING_THRESHOLD = 4;

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void move(int randomNumber) {
        if (randomNumber >= MOVING_THRESHOLD) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }
}
