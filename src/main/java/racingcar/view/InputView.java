package racingcar.view;

import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static List<String> readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        validateInputFormat(input);

        List<String> carNames = Arrays.stream(input.split(","))
                .map(String::trim)
                .toList();

        validateCarNames(carNames);
        return carNames;
    }

    public static int readAttemptCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();
        validateAttemptCount(input);
        return Integer.parseInt(input);
    }

    public static void validateInputFormat(String input) {
        if (input.endsWith(",")) {
            throw new IllegalArgumentException("자동차 이름은 쉼표(,)로 끝날 수 없습니다.");
        }
        if (input.contains(",,")) {
            throw new IllegalArgumentException("자동차 이름 사이에 빈 값이 있으면 안 됩니다.");
        }
        if (input.startsWith(",")) {
            throw new IllegalArgumentException("자동차 이름은 쉼표(,)로 시작할 수 없습니다.");
        }
    }

    public static void validateCarNames(List<String> names) {
        if (names.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름 목록은 비어 있을 수 없습니다.");
        }

        if (names.size() < 2) {
            throw new IllegalArgumentException("자동차는 2대 이상이어야 합니다.");
        }

        long distinctCount = names.stream().distinct().count();
        if (distinctCount != names.size()) {
            throw new IllegalArgumentException("중복된 자동차 이름이 있습니다.");
        }

        for (String name : names) {
            if (name.isBlank()) {
                throw new IllegalArgumentException("자동차 이름은 비어 있을 수 없습니다.");
            }
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
            }
        }
    }

    public static void validateAttemptCount(String input) {
        try {
            int attemptCount = Integer.parseInt(input);
            if (attemptCount < 1) {
                throw new IllegalArgumentException("시도 횟수는 1회 이상이어야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
    }
}
