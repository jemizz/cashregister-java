package javaPractice;
import java.util.Scanner;
public class foreach {
    public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    System.out.print("Enter how many number you want to add: ");
    int num = input.nextInt();
    
    int[] num2 = new int[num];
    int sum = 0;

    for (int i=0; i < num; i++ ) {
        System.out.print("Number " + (i + 1) + " : ");
        num2[i] = input.nextInt();
    }
    for (int x: num2) {
        sum += x;
    }
    System.out.print("Sum: " + sum);

    input.close();
}
}


