import java.util.Locale;
import java.util.Scanner;

public class Task03 {
    public static void main(String[] args) {
        Locale.setDefault(new Locale("us", "US"));
        Scanner sc = new Scanner(System.in);
        try {
            double tc;
            int counter;

            for(counter = 1; counter <=2; counter++) {
                System.out.print("Informe a temperatura: ");
                tc = sc.nextDouble();
                tInformation(tc, counter);
            }
            System.out.print("Informe a temperatura. Informe \"=\" ao finalizar: ");
            do {
                if(sc.hasNextDouble()){
                    tc = sc.nextDouble();
                    tInformation(tc, counter);
                    counter++;
                    System.out.print("Informe a temperatura. Informe \"=\" ao finalizar: ");
                }
            } while (sc.hasNextDouble());
        }
        finally{
            sc.close();
        }
    }
    private static double switchToF (double tc) {
        double fator1 = 9.0/5.0, fator2 = 32.0, calctf = (tc * fator1) + fator2;
        return calctf;
    }

    private static void tInformation(double tc, int counter) {
       double tf = switchToF(tc);
        System.out.printf("Temperatura %d %.2fºC são %.2fºF\n\n", counter, tc, tf);
    }
}