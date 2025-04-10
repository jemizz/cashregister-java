package javaPractice;

public class multiarray {
    public static void main(String[] args) {

        String user[][] = {{"jem", "jem123"}, 
                            {"ash", "ash123"}, 
                            {"maki", "maki123"}, 
                            {"nikki", "nikki123"}
                        };

        for (String users[]: user) {
            for (String info: users){
                System.out.println(info);
            }
        }
    }
}
