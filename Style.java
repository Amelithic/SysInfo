//Styling codes - Amelie

/* HOW TO USE:
 * 1. Colouring text:
 * Instantiate class as object, to call static variables below (e.g. Style.RESET_CODE)
 * Concatonate desired escape codes onto print functions. Done!
 * Note: FG = foreground (text), BG = background
 * 
 * 2. Resetting the terminal screen
 * Call the function resetScreen() - requires ENTER to continue
 * 
 * 3. Wait for ENTER to continue
 * Use waitBuffer() to wait for input before continuing to next function.
 */

import java.util.Scanner;

public class Style {
    //ANSI escape codes for adding 
    public static String RESET_CODE = "\033[0m";
    public static String BOLD = "\033[1m";
    public static String RED_FG = "\033[31m";
    public static String GREEN_FG = "\033[32m";
    public static String YELLOW_FG = "\033[33m";
    public static String BLUE_FG = "\033[34m";


    public static void resetScreen() {
        System.out.println("\033[2J");
    }

    public static void waitBuffer() {
        Scanner input = new Scanner(System.in);
        input.nextLine();
    }
}
