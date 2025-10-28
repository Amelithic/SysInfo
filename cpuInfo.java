// CPU Information - Adam
import java.util.Scanner;

public class cpuInfo {
    static {
        // Loading Mark's Library
        System.loadLibrary("sysinfo"); //libsysinfo.so
    }

    //colors
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String BOLD = "\u001B[1m";

    //defining native methods
    // Refresh the current values and counters - call this before other methods
    public native void read (int seconds);
    public native void read ();

    // Return the number of cores per CPU socket
    public native int coresPerSocket ();

    // Return the number of CPUs in this computer
    public native int socketCount ();

    // Return the model number of the CPU
    public native String getModel ();

    // Return the size in bytes of the L1 data cache
    public native int l1dCacheSize ();

    // Return the size in bytes of the L1 instruction cache
    public native int l1iCacheSize ();

    // Return the size in bytes of the L2 cache
    public native int l2CacheSize ();

    // Return the size in bytes of the L3 cache
    public native int l3CacheSize ();

    // Return the time in "jiffies" or 1/100ths of a second 
    // that the specified core has been in user mode
    public native int getUserTime (int core);

    // Return the time in "jiffies" or 1/100ths of a second 
    // that the specified core has been idle
    public native int getIdleTime (int core);

    // Return the time in "jiffies" or 1/100ths of a second 
    // that the specified core has been in system mode
    public native int getSystemTime (int core);


    //custom methods here
    public void testDisplayCPU() {
      
        boolean x = true;
        while (x) {
            Scanner scanner = new Scanner(System.in);
            System.out.println(CYAN + "-------------------------------------" + RESET);
            System.out.println(BOLD + "         CPU INFORMATION TOOL        " + RESET);
            System.out.println(CYAN + "-------------------------------------" + RESET);
            System.out.println();
            System.out.println();

            System.out.println(YELLOW + "Select an option to display CPU information:" + RESET);
            System.out.println(GREEN + "1." + RESET + " Display CPU Core Mode/Type");
            System.out.println(GREEN + "2." + RESET + " Cache Sizes and Times");
            System.out.println(GREEN + "3." + RESET + " Cpu performance");
            System.out.println(GREEN + "4." + RESET + " Display ALL Information");
            System.out.println(GREEN + "5." + RESET + " Exit");
            int menuChoice = scanner.nextInt();
            read();
            switch(menuChoice) {

                case 1:
                    Style.resetScreen();
                    System.out.println(PURPLE + "CPU model: " + RESET + getModel());
                    switch (coresPerSocket()) {
                        case 1:
                            System.out.println(BLUE + "Single Core CPU" +RESET);
                            break;
                        case 2:
                            System.out.println(BLUE + "Dual Core CPU" + RESET);
                            break;
                        case 4:
                            System.out.println(BLUE + "Quad Core CPU" + RESET);
                            break;
                        case 6:
                            System.out.println(BLUE+ "Hexa Core CPU" + RESET);
                            break;
                        case 8:
                            System.out.println(BLUE + "Octa Core CPU" +RESET);
                            break;
                        default:
                            System.out.println(BLUE + coresPerSocket() + " Cores CPU" + RESET);
                            break;
                    }
                    break;

                case 2:
                    Style.resetScreen();
                    System.out.println(YELLOW + "L1 Data Cache Size: " + RESET + l1dCacheSize() + " bytes");
                    System.out.println(YELLOW + "L1 Instruction Cache Size: " + RESET + l1iCacheSize());
                    System.out.println(YELLOW + "L1 Total Cache Size: " + RESET + (l1dCacheSize()+l1iCacheSize()) + " bytes");
                    System.out.println(YELLOW + "L2 Cache Size: " + RESET + l2CacheSize() + " bytes");
                    System.out.println(YELLOW + "L3 Cache Size: " + RESET + l3CacheSize() + " bytes"); 
                    System.out.println(YELLOW + "Total cache size: " + RESET + 
                        (l1dCacheSize()+l1iCacheSize()+l2CacheSize()+l3CacheSize()) + " bytes"); 
                    break;

                case 3:
                    Style.resetScreen();
                    read(1); //refresh values over 1 second
                    for (int i = 0; i < coresPerSocket(); i++) {
                        System.out.println(BLUE + "Core " + i + ":" + RESET);
                        System.out.println("User Time: " + GREEN + getUserTime(i) + " jiffies" + RESET);
                        System.out.println("Idle Time: " + PURPLE + getIdleTime(i) + " jiffies" + RESET);
                        System.out.println("System Time: " + RED + getSystemTime(i) + " jiffies" + RESET);
                    }
                    break;

                case 4:
                    Style.resetScreen();
                    System.out.println(PURPLE + "CPU model: " + RESET + getModel());
                    switch (coresPerSocket()) {
                        case 1:
                            System.out.println(BLUE + "Single Core CPU" + RESET);
                            break;
                        case 2:
                            System.out.println(BLUE + "Dual Core CPU" + RESET);
                            break;
                        case 4:
                            System.out.println(BLUE + "Quad Core CPU" + RESET);
                            break;
                        case 6:
                            System.out.println(BLUE + "Hexa Core CPU" + RESET);
                            break;
                        case 8:
                            System.out.println(BLUE + "Octa Core CPU" + RESET);
                            break;
                        default:
                            System.out.println(BLUE + coresPerSocket() + " Cores CPU" + RESET);
                            break;
                    }
                    System.out.println();
                    System.out.println();
                    System.out.println(YELLOW + "L1 Data Cache Size: " + RESET + l1dCacheSize() + " bytes");
                    System.out.println(YELLOW + "L1 Instruction Cache Size: " + RESET + l1iCacheSize());
                    System.out.println(YELLOW + "L1 Total Cache Size: " + RESET + (l1dCacheSize()+l1iCacheSize()) + " bytes");
                    System.out.println(YELLOW + "L2 Cache Size: " + RESET + l2CacheSize() + " bytes");
                    System.out.println(YELLOW + "L3 Cache Size: " + RESET + l3CacheSize() + " bytes"); 
                    System.out.println(YELLOW + "Total cache size: " + RESET + 
                        (l1dCacheSize()+l1iCacheSize()+l2CacheSize()+l3CacheSize()) + " bytes"); 
                    System.out.println();
                    System.out.println();
                    read(1); //refresh values over 1 second
                    for (int i = 0; i < coresPerSocket(); i++) {
                        System.out.println(BLUE + "Core " + i + ":" + RESET);
                        System.out.println("User Time: " + GREEN + getUserTime(i) + " jiffies" + RESET);
                        System.out.println("Idle Time: " + PURPLE + getIdleTime(i) + " jiffies" + RESET);
                        System.out.println("System Time: " + RED + getSystemTime(i) + " jiffies" + RESET);
                    }
                    break;

                case 5:
                    Style.resetScreen();
                    System.out.println(RED + "Exiting program... Goodbye!" + RESET);
                    x = false;
                    break;

                default:
                    System.out.println(RED + "Invalid option selected." + RESET);
                    break;
            }
        }
    }
}
