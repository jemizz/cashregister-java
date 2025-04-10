package javaPractice;
import java.util.Scanner;
public class prac {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Input integer value: ");
        int num = input.nextInt();

        if (num > 400000){
            System.out.print("The integer input is out of range");
        } else {
            int sum = 0;
            int add = num * num - (num - 1);

            System.out.print("Addends: ");
            for (int i = 0; i < num; i++){
                int addends = add + (i * 2);
                sum += addends;
                System.out.print(addends + " ");
            }
            System.out.print("\nSum of addends (Cube): " + sum);
        }
        input.close();

    }
}
