import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Task09 {
    public static void main(String[] args) {
        Locale.setDefault(new Locale("us", "US"));
        Scanner sc = new Scanner(System.in);
        System.out.println("Informe a quantidade de provas: ");
        int testQuant = sc.nextInt();
        if (testQuant <= 0) {
            System.out.println("\nQuantidade informada inválida.");
        }
        else {
            int[] grades = new int[testQuant];
            for (int i = 0; i < grades.length; i++ ) {
                System.out.printf("\nInforme a nota da prova %d: \n", i+1);
                grades[i] = sc.nextInt();
            }
            System.out.println();
            sortGrades(grades);
            gradesPointsAverage(grades);
        }
        sc.close();
    }

    private static void sortGrades (int[] grades) {
        Arrays.sort(grades);
        System.out.printf("A menor nota é: %d\n", grades[0]);
        System.out.printf("A maior nota é: %d\n", grades[grades.length-1]);
    }

    private static void gradesPointsAverage (int[] grades) {
        int gradesSum = 0;
        int gradesAverage;
        for (int i = 0; i < grades.length; i++ ) {
            gradesSum += grades[i];
        }
        gradesAverage = gradesSum / grades.length;
        System.out.printf("A média das notas é: %d\n", gradesAverage);
    }
}