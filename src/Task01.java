import java.util.Scanner;

public class Task01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            double height, weight, imc;
            String classification;
            System.out.print("Informe sua altura em metros: ");
            height = sc.nextDouble();
            System.out.print("Informe seu peso em Kg: ");
            weight = sc.nextDouble();
            imc = calcImc(height, weight);
            classification = classifyImc(imc);
            System.out.printf("O valor do seu IMC é %.2f (considerado %s)", imc, classification);
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao executar o programa.");
        } finally {
            sc.close();
        }
    }

    private static double calcImc (double height, double weight) {
        double imc = weight / (height * height);
        return imc;
    }

    private static String classifyImc (double imc) {
        if (imc < 17.0) {
            return "Muito abaixo do peso";
        }
        else if (imc >= 17.0 && imc <= 18.49) {
            return "Abaixo do peso";
        }
        else if (imc >= 18.50 && imc <= 24.99) {
            return "Peso normal";
        }
        else if (imc >= 25.0 && imc <= 29.99) {
            return "Acima do peso";
        }
        else if (imc >= 30.0 && imc <= 34.99) {
            return "Obesidade I";
        }
        else if (imc >= 35.0 && imc <= 39.99) {
            return "Obesidade II (severa)";
        }
        else {
            return "Obesidade III (mórbida)";
        }
    }
}