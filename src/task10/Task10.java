package task10;

import java.math.BigDecimal;
import java.util.Locale;
import java.util.Scanner;

public class Task10 {

    private static TabelaPrice tabelaPrice;

    public static void main(String[] args) {
        Locale.setDefault(new Locale("us", "US"));
        Scanner sc = new Scanner(System.in);
        BigDecimal valorEmprestimo, taxaJuros;
        int quantMeses;
        System.out.println("Qual o valor do um empréstimo? ");
        valorEmprestimo = sc.nextBigDecimal();
        System.out.println("Qual a taxa de juros do empréstimo? ");
        taxaJuros = sc.nextBigDecimal();
        System.out.println("Qual o tempo para pagamento, em quantidade de meses? ");
        quantMeses = sc.nextInt();
        tabelaPrice = new TabelaPrice(valorEmprestimo, taxaJuros, quantMeses);
        tabelaPrice.setParcelasEmprestimo(new Parcela[quantMeses]);
        sc.close();
        tabelaPrice.calculaTabelaPrice();
        tabelaPrice.imprimeTabelaPrice();
    }
}