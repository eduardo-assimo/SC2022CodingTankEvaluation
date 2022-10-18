import java.util.Locale;
import java.util.Scanner;

public class Task05 {
    public static void main(String[] args) {
        Locale.setDefault(new Locale("us", "US"));
        Scanner sc = new Scanner(System.in);
        int size = args.length;
        double n1, n2;
        switch (size) {
                case 0:
                    System.out.print("Digite o primeiro número: ");
                    n1 = sc.nextDouble();
                    System.out.print("Digite o segundo número: ");
                    n2 = sc.nextDouble();
                    soma(n1, n2);
                    break;
                case 1:
                    n1 = Double.parseDouble(args[0]);
                    System.out.print("Digite o segundo número: ");
                    n2 = sc.nextDouble();
                    soma(n1, n2);
                    break;
                case 2:
                    n1 = Double.parseDouble(args[0]);
                    n2 = Double.parseDouble(args[1]);
                    soma(n1, n2);
                    break;
                default:
                    System.out.println("Número de argumentos inválidos.");
        }
        sc.close();
    }

    private static void soma (double a, double b) {
    System.out.println("A soma dos dois números informados é " + (a+b));
    }
}