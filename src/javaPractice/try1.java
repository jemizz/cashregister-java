package javaPractice;
public class try1 {
    public static void main(String[] args) {
        int sum = 0;

        int myarray [] = {50, 60, 80, 90, 45};

        for (int i: myarray){
            sum += i;
        }
        int arraylength = myarray.length;
        double ave = sum / arraylength;

        System.out.println("Sum of the array: " + sum);
        System.out.println("Average of the array: " + ave);
        /* 
        System.out.println("Accessing array using for each loop: ");
        for (int arr: myarray) {
            System.out.println(arr);
        }
        */

        /* 
        System.out.println("Accessing array using for loop: ");
        for (int i = 0; i < myarray.length; i++){
            System.out.println(myarray[i]);
        }
         */   

        /* 
        can't figure this out, i was planning to get the sum of the 2d array
        for (int array: myarray){
            sum += array;
        }
        System.out.print("The sum of the array is: " + sum);

            {20, 30, 13,},
            {50, 78, 23},
            {87, 23, 82},
            {84, 62, 73} */

    }
}
