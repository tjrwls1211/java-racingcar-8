package racingcar.view;

import java.util.List;

public class OutputView {

    public static String generateCarStatus(String name, int position) {
        String status = "-".repeat(position);
        return name + " : " + status;
    }

    public static String generateWinners(List<String> winners) {
        String winnerNames = String.join(", ", winners);
        return "최종 우승자 : " + winnerNames;
    }

    public static void printCarStatus(String name, int position) {
        System.out.println(generateCarStatus(name, position));
    }

    public static void printWinners(List<String> winners) {
        System.out.println(generateWinners(winners));
    }
}
