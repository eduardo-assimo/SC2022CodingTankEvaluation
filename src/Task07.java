import java.math.BigDecimal;
import java.util.Locale;
import java.util.Scanner;

public class Task07 {
    public static void main(String[] args) {
        Locale.setDefault(new Locale("us", "US"));
        Scanner sc = new Scanner(System.in);
        BigDecimal initialValue, interest;
        int timeInMonths;
        System.out.println("Informe o valor inicial investido em R$.");
        initialValue = sc.nextBigDecimal();
        System.out.println("Informe o juros ao mês em %.");
        interest = sc.nextBigDecimal();
        System.out.println("Informe o tempo em meses que o dinheiro ficará investido.");
        timeInMonths = sc.nextInt();

        if (initialValue.compareTo(BigDecimal.ZERO) != 1 || interest.compareTo(BigDecimal.ZERO) !=1 || timeInMonths < 1) {
            System.out.println("Um dos valores informados é inválido.");
        }
        else {
            for (int i = 1; i <= timeInMonths; i++) {
                BigDecimal interestValue, totalValue;
                interestValue = interestAmount(initialValue, interest);
                totalValue = profitAmount(initialValue, interestValue);
                System.out.printf("Mês %d: Juros: R$ %.2f , saldo: %.2f\n", i, interestValue, totalValue);
                initialValue = totalValue;
            }
        }
        sc.close();
    }

    private static BigDecimal interestAmount (BigDecimal initialValue, BigDecimal interest) {
        BigDecimal centesimal, interestValue;
        centesimal = interest.divide(new BigDecimal(100));
        interestValue = (initialValue.multiply(centesimal));
        return interestValue;
    }

    private static BigDecimal profitAmount (BigDecimal initialValue, BigDecimal interestValue) {
        BigDecimal profit;
        profit = initialValue.add(interestValue);
        return profit;
    }
}