import java.util.*;

public class SysInfo {
    static void mainMenu() {
        System.out.println("SysInfo\n==================\nSelect an option below by entering its number:");
        System.out.println("1:\tx");
        System.out.println("2:\tx");
        System.out.println("3:\tx");
        System.out.println("4:\tExit");
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // Creating Scanner object


        mainMenu();

        //Menu select
        int selection = input.nextInt(); //read selection from user
        boolean activeChoice = true; //program active means loop runs after one option selected

        while (activeChoice) {
            if (selection == 1) {
                System.out.println("TEST");
                System.out.println();//newline

                mainMenu();
                selection = input.nextInt();

            } else if (selection == 2) {
                System.out.println("TEST");
                System.out.println();//newline

                mainMenu();
                selection = input.nextInt();

            } else if (selection == 3) {
                System.out.println("TEST");
                System.out.println();//newline

                mainMenu();
                selection = input.nextInt();

            } else if (selection == 4) {
                System.out.println("Exiting...");
                activeChoice = false;

            } else {
                System.out.println("Invalid number, please try again.\n");
                mainMenu();
                selection = input.nextInt();

            }
        }//end while

    }
}
