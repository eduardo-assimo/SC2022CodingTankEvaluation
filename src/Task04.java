import java.util.Locale;

public class Task04 {
        public static void main(String[] args) {
            Locale.setDefault(new Locale("us", "US"));
            int size = args.length;
                if (size != 1) {
                System.out.println("Número inválido de argumentos, é esperado que seja informado um argumento");
            }
            else {
                    String saida = (Integer.parseInt(args[0]) % 2 == 0) ? "PAR" : "IMPAR";
                    System.out.println(saida);
                }
        }
    }