public class CPU {
    static {
        // Loading Mark's Library
        System.loadLibrary("libsysinfo"); //libsysinfo.so
    }

    public void printString(String x) {
        System.out.println("test: "+x);
    }

    /*
    //measurements of core (specify core) at T=0
    long busy0 = cpuInfo.getBusy(core);
    long idle0 = cpuInfo.getIdle(core);

    Thread.sleep(1000); //wait 1 second (t=1)

    //measurements of core (specify core) at T=1
    long busy1 = cpuInfo.getBusy(core);
    long idle1 = cpuInfo.getIdle(core);

    //change over 1 second
    long changeBusy = busy1 - busy0;
    long changeIdle = idle1 - idle0;
    double load = (double) changeBusy / (changeBusy + changeIdle); //average load for core over 1 second
    */

    /* COMBINED FOR ALL CORES
    int coreCount = cpuInfo.getCoreCount();
    double totalLoad = 0.0;
    
    for (int core = 0; core < coreCount; core++) {
        long busy0 = cpuInfo.getBusy(core);
        long idle0 = cpuInfo.getIdle(core);
        // store these in arrays or a list
    }
    
    // wait 1 second
    Thread.sleep(1000);
    
    for (int core = 0; core < coreCount; core++) {
        long busy1 = cpuInfo.getBusy(core);
        long idle1 = cpuInfo.getIdle(core);
        long deltaBusy = busy1 - busy0[core];
        long deltaIdle = idle1 - idle0[core];
        double load = (double) deltaBusy / (deltaBusy + deltaIdle);
        totalLoad += load;
    }
    
    double averageLoad = totalLoad / coreCount;
    */
}
