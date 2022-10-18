import java.util.Locale;
import java.util.Scanner;

public class Task08 {
    public static void main(String[] args) {
        Locale.setDefault(new Locale("us", "US"));
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite um número inteiro positivo: ");
        int n, result;
        n = sc.nextInt();
        if (n <= 0) {
            System.out.println("Número digitado inválido.");
        }
        else if (n == 1){
            System.out.println("A soma do número 1 com todos os seus antecessores positivos é igual a 1.");
        }
        else {
            result = calculus(n);
            System.out.printf("A soma do número %d com todos os seus antecessores positivos é igual a %d.", n, result);
        }
        sc.close();
    }
    private static int calculus (int n) {
        int sum = 0;
        for (int i = n; i > 0; i--) {
            sum += i;
        }
        return sum;
    }
}