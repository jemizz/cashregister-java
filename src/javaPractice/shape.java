package javaPractice;
import java.util.Scanner;
public class shape {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Input number: ");
        int size = input.nextInt();

        int shape[][]= new int[size][size];   
        // REVERSE ISOSCLES TRIANGLE 
        for (int i = 0; i <= size; i++){
            for (int j = 0; j <= i; j++){
                System.out.printf("* ", shape[i][j]);
            }
            System.out.println();
        }
        
        /* isosceles triangle
        for (int i = 0; i < size; i++){
            for (int j = 0; j <= i; j++){
                System.out.printf("* ", shape[i][j]);
            }
            System.out.println();
        }
        */
        /* square shape
        int shape[][]= new int[size][size];

        for (int i = 0; i <size; i++){
            for (int j = 0; j<size; j++){
                System.out.printf("* ", shape[i][j]);
            }
            System.out.println();
        }
        */
    }
}
