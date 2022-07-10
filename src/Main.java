import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();
        Converter converter = new Converter();
        printMenu();
        int userInput = scanner.nextInt();


        while (userInput != 5) {
            if (userInput > 5 || userInput < 0) {
                System.out.println("ввели некоретное число, попробуйте еще раз");
                userInput = scanner.nextInt();
            } else if (userInput == 1) {
                stepTracker.add();
            } else if (userInput == 2) {
                stepTracker.print();
            } else if (userInput == 3) {
                converter.statisticsForTheMonth(stepTracker, stepTracker.monthData);
            } else if (userInput == 4)
                stepTracker.setGoalDays();
            System.out.println(" ");
            printMenu();
            userInput = scanner.nextInt();
        }
    }
    private static void printMenu() {
        System.out.println("выберите пункт: \n1) ввести количество шагов за определенный день " +
                "\n2) вывести в консоль количество шагов за определенный день \n3) напечатать статику за определенный месяц  \n4) изменить цель по количеству шагов" +
                "\n5) выйти из приложения");
    }
}
