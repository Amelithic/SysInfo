// CPU Information - Adam
import java.util.Scanner;

public class cpuInfo {
    static {
        // Loading Mark's Library
        System.loadLibrary("sysinfo"); //libsysinfo.so
    }
    
    
    


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
            System.out.println(Style.CYAN + "-------------------------------------" + Style.RESET);
            System.out.println(Style.BOLD + "         CPU INFORMATION TOOL        " + Style.RESET);
            System.out.println(Style.CYAN + "-------------------------------------" + Style.RESET);
            System.out.println();
            System.out.println();

            System.out.println(Style.YELLOW + "Select an option to display CPU information:" + Style.RESET);
            System.out.println(Style.GREEN + "1." + Style.RESET + " Display CPU Core Mode/Type");
            System.out.println(Style.GREEN + "2." + Style.RESET + " Cache Sizes and Times");
            System.out.println(Style.GREEN + "3." + Style.RESET + " Cpu performance");
            System.out.println(Style.GREEN + "4." + Style.RESET + " Display ALL Information");
            System.out.println(Style.GREEN + "5." + Style.RESET + " Exit");
            int menuChoice = scanner.nextInt();
            read();
            
        
            switch(menuChoice) {

                case 1:
                    Style.resetScreen();
                    CoreType();
                    break;

                case 2:
                    Style.resetScreen();
                    CacheSizes();
                    break;

                case 3:
                    CpuPerformance();
                    break;

                case 4:
                    CoreType();
                    CacheSizes();
                    CpuPerformance();
                    break;

                case 5:
                    Style.resetScreen();
                    System.out.println(Style.RED + "Exiting program... Goodbye!" + Style.RESET);
                    x = false;
                    break;

                default:
                    System.out.println(Style.RED + "Invalid option selected." + Style.RESET);
                    break;
            }
        }
    }
      
        
    public void CpuPerformance(){
        read(1); //refresh values over 1 second
        for (int i = 0; i < coresPerSocket(); i++) {
            System.out.println(Style.CYAN + "Core " + i + ":" + Style.RESET);
            System.out.println("User Time: " + Style.GREEN + getUserTime(i) + " jiffies" + Style.RESET);
            System.out.println("Idle Time: " + Style.PURPLE + getIdleTime(i) + " jiffies" + Style.RESET);
            System.out.println("System Time: " + Style.RED + getSystemTime(i) + " jiffies" + Style.RESET);
        }
    }


    public void CacheSizes(){
        
        System.out.println(Style.YELLOW + "L1 Data Cache Size: " + Style.RESET + l1dCacheSize() + " bytes");
        System.out.println(Style.YELLOW + "L1 Instruction Cache Size: " + Style.RESET + l1iCacheSize());
        System.out.println(Style.YELLOW + "L1 Total Cache Size: " + Style.RESET + (l1dCacheSize()+l1iCacheSize()) + " bytes");
        System.out.println(Style.YELLOW + "L2 Cache Size: " + Style.RESET + l2CacheSize() + " bytes");
        System.out.println(Style.YELLOW + "L3 Cache Size: " + Style.RESET + l3CacheSize() + " bytes"); 
        System.out.println(Style.YELLOW + "Total cache size: " + Style.RESET + 
         (l1dCacheSize()+l1iCacheSize()+l2CacheSize()+l3CacheSize()) + " bytes"); 
    }
   
   
    public void CoreType(){
                
                    
                    System.out.println(Style.PURPLE + "CPU model: " + Style.RESET + getModel());
                    switch (coresPerSocket()) {
                        case 1:
                            System.out.println(Style.CYAN + "Single Core CPU" +Style.RESET);
                            break;
                        case 2:
                            System.out.println(Style.CYAN + "Dual Core CPU" + Style.RESET);
                            break;
                        case 4:
                            System.out.println(Style.CYAN + "Quad Core CPU" + Style.RESET);
                            break;
                        case 6:
                            System.out.println(Style.CYAN+ "Hexa Core CPU" + Style.RESET);
                            break;
                        case 8:
                            System.out.println(Style.CYAN + "Octa Core CPU" +Style.RESET);
                            break;
                        default:
                            System.out.println(Style.CYAN + coresPerSocket() + " Cores CPU" + Style.RESET);
                            break;
                        }
    } 

}  
    



          


