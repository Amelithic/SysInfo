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
            System.out.println("Select an option to display CPU information:");
            System.out.println("1. Display CPU Core Mode/Type");
            System.out.println("2. Cache Sizes and Times");
            System.out.println("3. Cpu perforance");
            System.out.println("4. Display ALL Information");
            System.out.println("5. Exit");
            int menuChoice = scanner.nextInt();

            switch(menuChoice) {
                case 1:

                    System.out.println("CPU model: "+getModel());
                    switch (coresPerSocket()) {
                            case 1:
                                System.out.println("Single Core CPU");
                                break;
                            case 2:
                                System.out.println("Dual Core CPU");
                                break;
                            case 4:
                                System.out.println("Quad Core CPU");
                                break;
                            case 6:
                                System.out.println("Hexa Core CPU");
                                break;
                            case 8:
                                System.out.println("Octa Core CPU");
                                break;
                            default:
                                System.out.println(coresPerSocket()+" Cores CPU");
                                break;
                    }
                    break;
                case 2:
                    System.out.println("L1 Data Cache Size: "+l1dCacheSize()+" bytes");
                    System.out.println("L1 Instruction Cache Size: "+l1iCacheSize());
                    System.out.println("L1 Total Cache Size: "+(l1dCacheSize()+l1iCacheSize())+" bytes");
                    System.out.println("L2 Cache Size: "+l2CacheSize()+" bytes");
                    System.out.println("L3 Cache Size: "+l3CacheSize()+" bytes"); 
                    System.out.println("Total cache size: "+(l1dCacheSize()+l1iCacheSize()+l2CacheSize()+l3CacheSize())+" bytes"); 
                    break;
                case 3:
                    read(1); //refresh values over 1 second
                    for (int i = 0; i < coresPerSocket(); i++) {
                        System.out.println("Core "+i+":");
                        System.out.println("User Time: "+getUserTime(i)+" jiffies");
                        System.out.println("Idle Time: "+getIdleTime(i)+" jiffies");
                        System.out.println("System Time: "+getSystemTime(i)+" jiffies");
                    }
                    break;
                case 4:
                System.out.println("CPU model: "+getModel());
                    switch (coresPerSocket()) {
                            case 1:
                                System.out.println("Single Core CPU");
                                break;
                            case 2:
                                System.out.println("Dual Core CPU");
                                break;
                            case 4:
                                System.out.println("Quad Core CPU");
                                break;
                            case 6:
                                System.out.println("Hexa Core CPU");
                                break;
                            case 8:
                                System.out.println("Octa Core CPU");
                                break;
                            default:
                                System.out.println(coresPerSocket()+" Cores CPU");
                                break;
                        }
                    System.out.println();
                    System.out.println();
                    System.out.println("L1 Data Cache Size: "+l1dCacheSize()+" bytes");
                    System.out.println("L1 Instruction Cache Size: "+l1iCacheSize());
                    System.out.println("L1 Total Cache Size: "+(l1dCacheSize()+l1iCacheSize())+" bytes");
                    System.out.println("L2 Cache Size: "+l2CacheSize()+" bytes");
                    System.out.println("L3 Cache Size: "+l3CacheSize()+" bytes"); 
                    System.out.println("Total cache size: "+(l1dCacheSize()+l1iCacheSize()+l2CacheSize()+l3CacheSize())+" bytes"); 
                    System.out.println();
                    System.out.println();
                    read(1); //refresh values over 1 second
                    for (int i = 0; i < coresPerSocket(); i++) {
                        System.out.println("Core "+i+":");
                        System.out.println("User Time: "+getUserTime(i)+" jiffies");
                        System.out.println("Idle Time: "+getIdleTime(i)+" jiffies");
                        System.out.println("System Time: "+getSystemTime(i)+" jiffies");
                    }
                    break;
                case 5:
                    x = false;
                    break;
                

                default:
                    System.out.println("Invalid option selected.");
                    break;
                }
            }
                
                

            
        // System.out.println("CPU model: "+getModel()); //prints model of CPU
        // System.out.println("Number of CPUs: "+socketCount());
        // System.out.println("Cores: "+coresPerSocket()); //prints model of CPU
        // System.out.println("L1 Data Cache Size: "+l1dCacheSize()+" bytes");
        // System.out.println("L1 Instruction Cache Size: "+l1iCacheSize());
        // System.out.println("L2 Cache Size: "+l2CacheSize()+" bytes");
        // System.out.println("L3 Cache Size: "+l3CacheSize()+" bytes");   
        // System.out.println(getUserTime(0)); //get time running user programs for core 0
        // System.out.println(getIdleTime(0)); //get time idle for core 0
        // System.out.println(getSystemTime(0)); //get time running system programs for core 0
        

        // System.out.println(getSystemTime(0)); //get time running system programs for core 0

        
    }
}
