import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Converter {
    Scanner scanner = new Scanner(System.in);

    public void statisticsForTheMonth(StepTracker stepTracker, StepTracker.MonthData monthData) {
        System.out.println("Ведите номер месяца");
        int monthNumber = scanner.nextInt();
        String nameMonth = switch (monthNumber) {
            case 0 -> "январь";
            case 1 -> "февраль";
            case 2 -> "март";
            case 3 -> "апрель";
            case 4 -> "май";
            case 5 -> "июнь";
            case 6 -> "июль";
            case 7 -> "август";
            case 8 -> "сентябрь";
            case 9 -> "октябрь";
            case 10 -> "ноябрь";
            case 11 -> "декабрь";
            default -> null;
        };
        double distanceTraveled = 0;
        double caloriesBurned = 0;
        for (Map.Entry<Integer, Integer> entry : monthData.monthToData.entrySet()
        ) {
            distanceTraveled += entry.getValue();
            caloriesBurned += (entry.getValue() * 50);
        }
        System.out.println("За " + nameMonth + " следующая статистика: ");
        System.out.println("всего пройдено: " + (distanceTraveled / 100) + " метров");
        System.out.println("всего ссожено: " + (caloriesBurned / 1000) + " килокалорий");
        System.out.println(stepTracker.getMonthToData().get(monthNumber) + ";");

    }
}
