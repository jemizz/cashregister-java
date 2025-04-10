import java.util.Scanner;

class Party {
    private int numGuests;

    public int getNumGuests() {
        return numGuests;
    }

    public void setNumGuests(int num) {
        numGuests = num;
    }

    public void showInvitation() {
        System.out.println("Please come to my party!");
    }
}

class DinnerParty extends Party {
    private int foodChoice;

    public int getFoodChoice() {
        return foodChoice;
    }

    public void setFoodChoice(int choice) {
        foodChoice = choice;
    }

    @Override
    public void showInvitation() {
        System.out.println("Please come to my dinner party!");
    }
}

class DemoParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of guests for the dinner party: ");
        int numGuests = scanner.nextInt();

        System.out.print("Enter the menu option (1 for chicken or 2 for beef): ");
        int foodChoice = scanner.nextInt();

        DinnerParty dinnerParty = new DinnerParty();
        dinnerParty.setNumGuests(numGuests);
        dinnerParty.setFoodChoice(foodChoice);

        System.out.println("The dinner party has " + dinnerParty.getNumGuests() + " guests.");
        System.out.println("Menu option " + dinnerParty.getFoodChoice() + " will be served.");

        dinnerParty.showInvitation();

        scanner.close();
    }
    
}
