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

                    Style.waitBuffer();
                    Style.resetScreen();
                    break;

                case 2:
                    Style.resetScreen();

                    CacheSizes();

                    Style.waitBuffer();
                    Style.resetScreen();
                    break;

                case 3:
                    Style.resetScreen();

                    System.out.println(Style.BOLD+Style.RED+"Current CPU Performance"+Style.RESET+"\n==================\n");
                    CpuPerformance();
                    System.out.println(Style.BOLD+Style.RED+"\n\nCPU Load Analysis"+Style.RESET+"\n==================\n");
                    cpuLoadCheck();

                    Style.waitBuffer();
                    Style.resetScreen();
                    break;

                case 4:
                    Style.resetScreen();
                    CoreType();
                    CacheSizes();
                    CpuPerformance();
                    cpuLoadCheck();

                    Style.waitBuffer();
                    Style.resetScreen();
                    break;

                case 5:
                    Style.resetScreen();
                    System.out.println(Style.RED + "Exiting CPU menu... Goodbye!" + Style.RESET);
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
        System.out.println(Style.YELLOW + "L1 Instruction Cache Size: " + Style.RESET + l1iCacheSize() + " bytes");
        System.out.println(Style.YELLOW + "L1 Total Cache Size: " + Style.RESET + (l1dCacheSize()+l1iCacheSize()) + " bytes");
        System.out.println(Style.YELLOW + "L2 Cache Size: " + Style.RESET + l2CacheSize() + " bytes");
        System.out.println(Style.YELLOW + "L3 Cache Size: " + Style.RESET + l3CacheSize() + " bytes"); 
        System.out.println(Style.YELLOW + "Total cache size: " + Style.RESET + 
         (l1dCacheSize()+l1iCacheSize()+l2CacheSize()+l3CacheSize()) + " bytes\n"); 
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

    public void cpuLoadCheck() {
        read(); //needs to initially read to not output 0
        System.out.println(Style.DIMMED+"\nReading...\n"+Style.RESET);
        

        //START OF CHECK - READ CPU INITIAL VALUES
        read(1);
        int cores = coresPerSocket();
        System.out.println("Cores: "+cores);

        //Iterate cores and store initial ratios of use per core
        double initial_ratio[][] = new double[cores][1];

        for (int i=0; i < cores; i++) {
            long coreIdleTime = getIdleTime(i);
            long coreTotalTime = getIdleTime(i) + getUserTime(i) + getSystemTime(i);

            System.out.println(Style.CYAN+"Core"+i+Style.RESET);
            System.out.println(Style.BOLD+"\tIdle time: "+Style.RESET+coreIdleTime);
            System.out.println(Style.BOLD+"\tTotal time: "+Style.RESET+coreTotalTime);
        
            initial_ratio[i][0] = (double) coreIdleTime / coreTotalTime;
            System.out.println(Style.BOLD+"\n\tRatio: "+Style.RESET+initial_ratio[i][0]);
        }


        //CHECK AFTER 1000 MILLISECONDS - READ CPU FINAL VALUES
        read(1);
        System.out.println(Style.BOLD+Style.GREEN+"\nFinal values after 1s:\n"+Style.RESET);

        //Iterate cores and store final ratios of use per core
        double final_ratio[][] = new double[cores][1];

        for (int i=0; i < cores; i++) {
            long coreIdleTime = getIdleTime(i);
            long coreTotalTime = getIdleTime(i) + getUserTime(i) + getSystemTime(i);

            System.out.println(Style.CYAN+"Core"+i+Style.RESET);
            System.out.println(Style.BOLD+"\tIdle time: "+Style.RESET+coreIdleTime);
            System.out.println(Style.BOLD+"\tTotal time: "+Style.RESET+coreTotalTime);
        
            final_ratio[i][0] = (double) coreIdleTime / coreTotalTime;
            System.out.println(Style.BOLD+"\n\tRatio: "+Style.RESET+final_ratio[i][0]);
            System.out.println();
        }


        //DISPLAY RESULTS OF RATIOS - RETURN INCREASE/DECREASE IN CPU LOAD
        System.out.println(Style.BOLD+Style.GREEN+"Results...\n"+Style.RESET);

        for (int i=0; i < cores; i++) {
            double ratio = final_ratio[i][0] - initial_ratio[i][0];

            System.out.println(Style.CYAN+"Core"+i+Style.RESET);
            System.out.println(Style.BOLD+"Change in ratio (decimal of CPU in use): "+Style.RESET+ratio);

            String ratioChange = ((ratio > 0)? "decreased" : "increased");
            System.out.printf(Style.GREEN+"CPU load has "+Style.BOLD+"%s"+Style.RESET+Style.GREEN+" by %.2f percent\n"+Style.RESET,ratioChange,Math.abs(ratio*100));
        }

    }

}  
    



          


