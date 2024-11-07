package Draw;

public class Draw {
    public static void draw(String[] chars, int made_mistakes) {
        for (String c : chars) {
            System.out.print(c + " "); 
        }
        System.out.println(); 

        System.out.println("---------");
        System.out.println("|     |");

        if (made_mistakes >= 1) {
            System.out.println("|     0"); 
        } else {
            System.out.println("|"); 
        }

        if (made_mistakes >= 4) {
            System.out.println("|    /|\\"); 
        } else if (made_mistakes == 3) {
            System.out.println("|    /|");
        } else if (made_mistakes >= 2) {
            System.out.println("|     |");
        } else {
            System.out.println("|"); 
        }

        if (made_mistakes >= 6) {
            System.out.println("|     /\\"); 
        } else if (made_mistakes == 5) {
            System.out.println("|     /");
        } else if (made_mistakes >= 2) {
            System.out.println("|     "); 
        } else {
            System.out.println("|"); 
        }

        System.out.println("---------");

    }
}
