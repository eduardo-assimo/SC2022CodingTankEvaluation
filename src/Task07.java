import java.util.Locale;
import java.util.Scanner;

public class Task07 {
    public static void main(String[] args) {
        Locale.setDefault(new Locale("us", "US"));
        Scanner sc = new Scanner(System.in);
        double initialValue, interest;
        int timeInMonths;
        System.out.println("Informe o valor inicial investido em R$.");
        initialValue = sc.nextDouble();
        System.out.println("Informe o juros ao mês em %.");
        interest = sc.nextDouble();
        System.out.println("Informe o tempo em meses que o dinheiro ficará investido.");
        timeInMonths = sc.nextInt();

        if (initialValue <= 0 || interest <= 0 || timeInMonths < 1) {
            System.out.println("Um dos valores informados é inválido.");
        }
        else {
            for (int i = 1; i <= timeInMonths; i++) {
                double interestValue, totalValue;
                interestValue = interestAmount(initialValue, interest);
                totalValue = profitAmount(initialValue, interestValue);
                System.out.printf("Mês %d: Juros: R$ %.2f , saldo: %.2f\n", i, interestValue, totalValue);
                initialValue = totalValue;
            }
        }
        sc.close();
    }

    private static double interestAmount (double initialValue, double interest) {
        double centesimal, interestValue;
        centesimal = interest / 100;
        interestValue = (initialValue * centesimal);
        return interestValue;
    }

    private static double profitAmount (double initialValue, double interestValue) {
        double profit;
        profit = initialValue + interestValue;
        return profit;
    }
}