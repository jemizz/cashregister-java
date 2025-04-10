package javaPractice;

import java.util.Scanner;
public class act {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Input number of grades : ");
        int num = input.nextInt();

        int[] grades = new int[num];

        int sum = 0;
        int failedCount = 0;
        int passedCount = 0;
        int ave;
        // THIS PART IS FOR WHEN YOU INPUT GRADE
        for (int i = 0; i < num; i++){
            do {
            System.out.print("Grade " + (i + 1) + " : ");
            grades[i] = input.nextInt();
            
                if (grades[i] < 1 || grades[i] > 100) {
                    System.out.println("Invalid grade. Please try again");
                }
            }while (grades[i] < 1 || grades[i] > 100);
        }
        // TO CALCULATE THE AVERAGE GRADE AND REMARK
        // THIS PART USES FOR EACH LOOP 
        for (int x: grades) {
            sum += x;
        }

        int arrayLength = grades.length;
        ave = (sum / arrayLength);
        System.out.println("Average : " + ave);

        System.out.print("Remarks : ");
        if (ave >= 99){
            System.out.print("A+");
        } else if (ave >= 97) {
            System.out.print("A-");
        } else if (ave >= 93) {
            System.out.print("A");
        } else if (ave >= 89) {
            System.out.print("B+");
        } else if (ave >= 83) {
            System.out.print("B-");
        } else if (ave >= 79) {
            System.out.print("B");
        } else if (ave >= 76) {
            System.out.print("C");
        } else if (ave == 75) {
            System.out.print("D");
        } else {
            System.out.print("E");
        } 
        
        for (int grade: grades) {
            if (grade <= 74) {
                failedCount++;
            } else {
                passedCount++;
            }
        }

        System.out.println("\nTotal number of Failed : " + failedCount);
        
        System.out.println("Total number of Passed : " + passedCount);
        input.close();
    }
}
