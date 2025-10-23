import java.util.*;

public class SysInfo {

    static void mainMenu() {
        System.out.println("SysInfo\n==================\nSelect an option below by entering its number:");
        System.out.println("1:\tCPU");
        System.out.println("2:\tMemory");
        System.out.println("3:\tDisk");
        System.out.println("4:\tAttached Devices");
        System.out.println("5:\tExit");
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
                case 1:
                    System.out.println("CPU");
                    System.out.println();//newline

                    cpuInfo testCPU = new cpuInfo();
                    testCPU.read();

                    mainMenu();
                    selection = input.nextInt();
                    break;

                case 2:
                    System.out.println("Memory");
                    memInfo ramInfoInstance = new memInfo();
                    ramInfoInstance.printString("this is a test");

                    System.out.println();//newline
                    mainMenu();
                    selection = input.nextInt();
                    break;

                case 3:
                    System.out.println("Disk");
                    System.out.println();//newline

                    diskInfo testDisk = new diskInfo();
                    testDisk.testPrint();

                    mainMenu();
                    selection = input.nextInt();
                    break;

                case 4:
                    System.out.println("Attached Devices");
                    System.out.println();//newline

                    pciInfo testPCI = new pciInfo();
                    testPCI.read();
                    usbInfo testUsb = new usbInfo();
                    testUsb.read();

                    mainMenu();
                    selection = input.nextInt();
                    break;

                    

                case 5:
                    System.out.println("Exiting program...");
                    activeChoice = false;
                    break;

                default:
                    System.out.println("Invalid number, please try again.\n");
                    mainMenu();
                    selection = input.nextInt();
            } //end switch
        }//end while - main menu

    }
}