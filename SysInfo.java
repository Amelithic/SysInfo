import java.util.*;
import java.lang.Math;

public class SysInfo {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // Creating Scanner object

        mainMenu();

        //Menu select
        int selection = input.nextInt(); //read selection from user
        boolean activeChoice = true; //program active means loop runs after one option selected

        while (activeChoice) {
            switch (selection) {
                case 1:
                    Style.resetScreen();
                    System.out.println("CPU");
                    System.out.println();//newline

                    cpuInfo testCPU = new cpuInfo();
                    testCPU.testDisplayCPU();

                    Style.waitBuffer();
                    mainMenu();
                    selection = input.nextInt();
                    break;

                case 2:
                    Style.resetScreen();
                    boolean isLiveDisplay = true;
                    memInfo ramInfoInstance = new memInfo();

                    try {
                        while (isLiveDisplay) {
                            Thread.sleep(500); //waits 0.5 seconds before refreshing
                            Style.resetScreen();
                            ramInfoInstance.read(); //why does it have to print to console ;-;

                            Style.resetScreen();
                            System.out.println(Style.RED_FG+Style.BOLD+"Memory"+Style.RESET);

                            ramInfoInstance.displayMemory();
                            System.out.println(Style.DIMMED+"\n\nPress ENTER to continue...\n"+Style.RESET);

                            if (System.in.available() > 0) {
                                //if input available - non-blocking method
                                if (input.hasNextLine()) {
                                    //exit if ENTER key pressed
                                    isLiveDisplay = false;
                                }
                            }

                        }   
                    } catch (Exception e) {
                        System.out.println("Error displaying memory info.");
                        System.out.println(e.getMessage());
                    }
                    System.out.println();//newline

                    Style.waitBuffer();

                    mainMenu();
                    selection = input.nextInt();
                    break;

                case 3:
                    Style.resetScreen();
                    System.out.println("Disk");
                    System.out.println();//newline

                    diskInfo testDisk = new diskInfo();
                    testDisk.testPrint();

                    Style.waitBuffer();
                    mainMenu();
                    selection = input.nextInt();
                    break;

                case 4:
                    Style.resetScreen();
                    System.out.println("Attached Devices");
                    System.out.println();//newline

                    pciInfo testPCI = new pciInfo();
                    testPCI.read();
                    usbInfo testUsb = new usbInfo();
                    testUsb.read();

                    //testing
                    System.out.println("Busses: " + testPCI.busCount());
                    System.out.println("Devices: " + testPCI.deviceCount(0));
                    System.out.println("Functions: " + testPCI.functionCount(0,0));
                    System.out.println("VID: " + testPCI.vendorID(0,0,0));
                    System.out.println("VID: " + testPCI.vendorID(0,0,1));
                    System.out.println("VID: " + testPCI.vendorID(0,0,2));
                    System.out.println("VID: " + testPCI.vendorID(0,0,3));
                    System.out.println("PID: " + testPCI.productID(0,0,0));
                    System.out.println("PID: " + testPCI.productID(0,0,1));
                    System.out.println("PID: " + testPCI.productID(0,0,2));
                    System.out.println("PID: " + testPCI.productID(0,0,3));
                    System.out.println();

                    pciArrays pci = new pciArrays();
                    pci.printStructure();

                    Style.waitBuffer();
                    mainMenu();
                    selection = input.nextInt();
                    break;

                    

                case 5:
                    System.out.println("Exiting program...");
                    activeChoice = false;
                    break;

                default:
                    Style.resetScreen();
                    System.out.println("Invalid number, please try again.\n");
                    Style.waitBuffer();
                    mainMenu();
                    selection = input.nextInt();
            } //end switch
        }//end while - main menu
    }

    static void mainMenu() {
        Style.resetScreen();
        System.out.println(Style.BOLD+Style.RED_FG+"  _________              .___        _____       \n" + //
                        " /   _____/__.__. ______ |   | _____/ ____\\____  \n" + //
                        " \\_____  <   |  |/  ___/ |   |/    \\   __\\/  _ \\ \n" + //
                        " /        \\___  |\\___ \\  |   |   |  \\  | (  <_> )\n" + //
                        "/_______  / ____/____  > |___|___|  /__|  \\____/ \n" + //
                        "        \\/\\/         \\/           \\/             "+Style.RESET); //Ascii text - "Sys Info"
        System.out.println(Style.BOLD+"\nSelect an option below by entering its number:"+Style.RESET);
        System.out.println("1:\tCPU");
        System.out.println("2:\tMemory");
        System.out.println("3:\tDisk");
        System.out.println("4:\tAttached Devices");
        System.out.println("5:\tExit");
        System.out.println();
    }
}