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
            switch (selection) {
                case 0:
                    System.out.println("CPU");
                    System.out.println();//newline

                    mainMenu();
                    selection = input.nextInt();
                    break;

                case 1:
                    System.out.println("Memory");
                    System.out.println();//newline

                    mainMenu();
                    selection = input.nextInt();
                    break;

                case 2:
                    System.out.println("Disk");
                    System.out.println();//newline

                    mainMenu();
                    selection = input.nextInt();
                    break;

                case 3:
                    System.out.println("Attatched");
                    activeChoice = false;
                    break;

                    

                case 4:
                    System.out.println("Exiting program...");
                    activeChoice = false;
                    break;

                default:
                    System.out.println("Invalid number, please try again.\n");
                    mainMenu();
                    selection = input.nextInt();
            } //end switch
        }//end while

    }
}

class pciInfo {
    // Refresh the current values and counters - call this before other methods
    public native void read ();

    // Return the number of PCI buses
    public native int busCount ();

    // Return the number of devices on a PCI bus
    public native int deviceCount (int bus);

    // Return the number of functions in a PCI device
    public native int functionCount (int bus, int device);

    // Return the number of functions in a PCI device
    public native int functionPresent (int bus, int device, int function);

    // Return the vendor ID of a PCI device
    public native int vendorID (int bus, int device, int function);

    // Return the product ID of a PCI device
    public native int productID (int bus, int device, int function);
}