    import java.util.Locale;
    import java.util.Scanner;

    public class Task02 {
        public static void main(String[] args) {
            Locale.setDefault(new Locale("us", "US"));
            Scanner sc = new Scanner(System.in);
            try {
                double nota, somatorio = 0.0, media;
                for (int i = 1; i <= 4; i++) {
                    System.out.printf("Informe a nota prova %d: \n", i);
                    nota = sc.nextDouble();
                    if (nota < 0 || nota > 10.0) {
                        somatorio = -1.0;
                        break;
                    }
                    somatorio += nota;
                }
                if (somatorio == -1.0) {
                    System.out.println("Valor inválido");
                } else {
                    media = somatorio / 4;
                    System.out.printf("A média do aluno foi %.2f", media);
                }
            } finally {
                sc.close();
            }
        }
    }