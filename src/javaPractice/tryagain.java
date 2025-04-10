package javaPractice;
import java.util.Scanner; 
public class tryagain {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Input integer value: ");
        int num = input.nextInt();

        if (num < 1 || num > 40000) {
            System.out.println("The integer is out of range");
        } else {
            int sum = 0;
            int add = num * num - (num - 1);

            System.out.println("Addends: ");
            for (int i = 0; i < num; i++) {
            int addends = add + (i * 2);
            
            sum += addends;
            System.out.println(addends + " ");
            }
            System.out.println("Sum: " + sum);
        }
    }
}
