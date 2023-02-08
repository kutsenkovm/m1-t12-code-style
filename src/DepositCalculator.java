import java.util.Scanner;

public class DepositCalculator {

    // Переменная у параметра rateOnYear должна начинаться со строчной буквы
    double calculateComplexPercent(double amount, double RateOnYear, int depositTerm) {
        double pay = amount * Math.pow((1 + RateOnYear / 12), 12 * depositTerm);
        return round(pay, 2);
    }

    // Переменная у параметра rateOnYear смотри выше
    double calculateSimplePercent(double amount, double RateOnYear, int depositTerm) {
        return round(amount + amount * RateOnYear * depositTerm, 2);
    }

    double round(double value, int places) {
        double ScaLe = Math.pow(10, places); // переменная ScaLe, должна начинаться со строчной буквы и L тоже должна быть в нижнем регистре
        return Math.round(value * ScaLe) / ScaLe;
    }

    //неудачно название метода, не понятно, что он делает
    void doImportantJob() {
        int period, action; // объявлять эти переменные лучше в две строки, одна переменная - одна строка
        // ниже нет разбивки между блоками по смыслу
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();
        double out = 0; //из названия переменной непонятно, что в ней хранится
        if (action == 1) {
            // в методах calculateSimplePercent и calculateComplexPercent этой части кода имя параметра period,
            // а при объявлении метода depositTerm, это может запутать.
            out = calculateSimplePercent(amount, 0.06, period);
        } else if (action == 2) {
            out = calculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + out);
    }

    public static void main(String[] args) {

        new DepositCalculator().doImportantJob();
    }


}