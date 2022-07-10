import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class StepTracker {
    int goalDays = 10000;
    private HashMap<Integer, MonthData> monthToData = new HashMap<>();
    Scanner scanner = new Scanner(System.in);
    MonthData monthData = new MonthData();

    public void add() {
        try {
            System.out.println("для добавления своих результатом, введите сначала месяц, потом день, потом количество шагов");
            int monthNumber = scanner.nextInt();
            if (monthNumber > 11 || monthNumber < 0) throw new IllegalArgumentException();
            int dayNumber = scanner.nextInt();
            if (dayNumber > 30 || dayNumber < 0) throw new IllegalArgumentException();
            int numberOfSteps = scanner.nextInt();
            monthData.getMonthToData().put(dayNumber, numberOfSteps);
            monthToData.put(monthNumber, monthData);
        } catch (IllegalArgumentException e) {
            System.out.println("некоретно введен месяц или день");
        }
    }

    public void print() {
        try {
            System.out.println("для получения результата за конкретный день, введите сначала месяц, потом день");
            int month = scanner.nextInt();
            if (month > 11 || month < 0) throw new IllegalArgumentException();
            int day = scanner.nextInt();
            if (day > 30 || day < 0) throw new IllegalArgumentException();
            String nameMonth = switch (month) {
                case 0 -> "января";
                case 1 -> "февраля";
                case 2 -> "марта";
                case 3 -> "апреля";
                case 4 -> "мая";
                case 5 -> "июня";
                case 6 -> "июля";
                case 7 -> "августа";
                case 8 -> "сентября";
                case 9 -> "октября";
                case 10 -> "ноября";
                case 11 -> "декабря";
                default -> null;
            };
            try {
                System.out.println("за " + day + " день " + nameMonth + " я прошел " + monthToData.get(month).monthToData.get(day));
            } catch (Exception e) {
                System.out.println("за указанный день статистики нет");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("некоретно введен месяц или день");
        }
    }

    public HashMap<Integer, MonthData> getMonthToData() {
        return monthToData;
    }

    @Override
    public String toString() {
        return "StepTracker{" +
                "monthToData=" + monthToData +
                '}';
    }

    public MonthData getMonthData() {
        return monthData;
    }

    public void setGoalDays() {
        System.out.println("Введите новое значение цели по количеству шагов");
        int newGoalDays = scanner.nextInt();
        System.out.println("новое значение: " + newGoalDays + " прошлое значение шагов" + goalDays);
        this.goalDays = newGoalDays;
    }

    public class MonthData {

        HashMap<Integer, Integer> monthToData = new HashMap<>();

        public MonthData() {
        }

        public HashMap<Integer, Integer> getMonthToData() {
            return monthToData;
        }

        @Override
        public String toString() {
            for (Map.Entry<Integer, Integer> entry : monthToData.entrySet()
            ) {
                if (entry.getValue() > goalDays) {
                    System.out.println("За день №  " + entry.getKey() + " я прошел " + entry.getValue() + " шагов и выполнил цель и прошел " + entry.getValue() + " шагов");
                } else
                    System.out.println("За день №  " + entry.getKey() + " я прошел " + entry.getValue() + " шагов, а надо было пройти на " + (goalDays - entry.getValue()) + " шагов");
            }
            return "Вся статистика за указанный месяц";
        }
    }
}
