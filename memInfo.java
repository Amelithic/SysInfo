//Memory information - Amelie

public class memInfo {
    static {
        // Loading Mark's Library
        System.loadLibrary("sysinfo"); //libsysinfo.so
    }


    // defining native methods
    public native void read ();
    public native int getTotal ();
    public native int getUsed ();


    //custom methods here    
    public void printString(String x) {
        System.out.println("test: "+x);
        read();
        float totalRAM = (float) getTotal();
        float usedRAM = (float) getUsed();

        System.out.println("Total RAM: "+totalRAM);
        System.out.println("Used RAM: "+usedRAM);

        float percentUsed = Math.round((usedRAM/totalRAM) * 100);
        System.out.println("\nPercent used: "+percentUsed+"%\n");

        printBarGraph(totalRAM, usedRAM, usedRAM-300);
    }

    public void printBarGraph(float total, float... values) {
        //input is total (e.g. 4GB RAM), values are sections of total in use

        for (float x : values) {
            System.out.println(x);
        }

    }
}
