import java.util.*;

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
                    System.out.println("Memory");
                    memInfo ramInfoInstance = new memInfo();
                    ramInfoInstance.printString("this is a test");

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
                    System.out.println("Invalid number, please try again.\nPress ENTER to continue\n");
                    Style.waitBuffer();
                    mainMenu();
                    selection = input.nextInt();
            } //end switch
        }//end while - main menu

    }

    static void mainMenu() {
        Style.resetScreen();
        System.out.println(Style.BOLD+Style.RED_FG+"SysInfo\n==================\nSelect an option below by entering its number:"+Style.RESET_CODE);
        System.out.println("1:\tCPU");
        System.out.println("2:\tMemory");
        System.out.println("3:\tDisk");
        System.out.println("4:\tAttached Devices");
        System.out.println("5:\tExit");
        System.out.println();
    }
}