//Disk Information - Anav

public class diskInfo {
    static {
        // Loading Mark's Library
        System.loadLibrary("sysinfo"); //libsysinfo.so
    }


    //defining native methods
    // Refresh the current values and counters - call this before other methods
    public native void read ();
    public native int diskCount ();
    public native String getName (int disk);
    public native long getTotal (int disk);
    public native long getUsed (int disk);
    public native long getAvailable (int disk);


    //custom methods here
    public void testPrint() {
        read();
        System.out.println(diskCount());

        for (int i=0; i < diskCount(); i++) {
            System.out.println(getName(i));
            System.out.println(getTotal(i));
        }
    }
}