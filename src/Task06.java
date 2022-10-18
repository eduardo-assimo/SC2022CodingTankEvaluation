import java.util.Locale;
import java.util.Scanner;

public class Task06 {
    public static void main(String[] args) {
        Locale.setDefault(new Locale("us", "US"));
        Scanner sc = new Scanner(System.in);
        String op;
        System.out.print("Qual operação deseja fazer? ( opções: + - / * ): ");
        op = sc.nextLine();
        switch (op) {
            case "+" -> soma(sc);
            case "-" -> subtracao(sc);
            case "/" -> divisao(sc);
            case "*" -> multiplicacao(sc);
            default -> System.out.println("\nOperação desconhecida.");
        }
        sc.close();
    }
    private static void soma (Scanner sc) {
        System.out.print("\nInforme o primeiro número: ");
        int a = sc.nextInt();
        System.out.print("Informe o segundo número: ");
        int b = sc.nextInt();
        System.out.println("\nO resultado é " + (a+b));
    }
    private static void subtracao (Scanner sc) {
        System.out.print("\nInforme o primeiro número: ");
       int a = sc.nextInt();
        System.out.print("Informe o segundo número: ");
        int b = sc.nextInt();
        System.out.println("\nO resultado é " + (a-b));
    }
    private static void divisao (Scanner sc) {
        System.out.print("\nInforme o primeiro número: ");
        int a = sc.nextInt();
        System.out.print("Informe o segundo número: ");
        int b = sc.nextInt();
        if (b != 0) {
            System.out.println("\nO resultado é " + (a/b));
        }
        else {
            System.out.println("\nOperação inválida: é impossível dividir por 0 (zero).");
        }
    }
    private static void multiplicacao (Scanner sc) {
        System.out.print("\nInforme o primeiro número: ");
        int a = sc.nextInt();
        System.out.print("Informe o segundo número: ");
        int b = sc.nextInt();
        System.out.println("\nO resultado é " + (a*b));
    }
}