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
    public static final String RESET = "\033[0m";
    public static final String BOLD = "\033[1m";
    public static final String RED = "\033[31m";
    public static final String GREEN = "\033[32m";
    public static final String YELLOW = "\033[33m";
    public static final String BLUE = "\033[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String DIMMED = "\033[2;3m";
    public static final String SHORT_TAB = "    ";


    public static void resetScreen() {
        System.out.println("\033[H\033[2J"); //moves cursor to home, clears screen
        System.out.flush();
    }

    public static void waitBuffer() {
        System.out.println(DIMMED+"\n\nPress ENTER to continue...\n"+RESET);

        Scanner input = new Scanner(System.in);
        input.nextLine();
    }
}
