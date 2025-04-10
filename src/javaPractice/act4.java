package javaPractice;
import java.util.Arrays;
import java.util.Scanner;
public class act4 {
    public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    System.out.print("Input number of test scores: ");
    int num = input.nextInt();
     
    if (num < 10 || num > 50) {
        System.out.println("You should only input number between 10 to 50");
        return;
    }
    int test;
    int scores[] = new int[num];

    System.out.println ("Input test score: ");
    for (int i = 0; i < num; i++) {
        do {
        test = input.nextInt();

            if (test < 70 || test > 100) {
                System.out.println("Invalid Input");
            } 
        } while (test < 70 || test > 100);
        scores[i] = test; 
    }
    
    System.out.println();
    System.out.println("Test Scores");
    for (int i = 0; i < num; i++) {
        System.out.println(scores[i]);
    } for (int j = 0; j < num; j++){
        System.out.println(scores[j]);
    }
    
}
}
