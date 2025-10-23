//Disk Information - Anav

public class diskInfo {
    static {
        // Loading Mark's Library
        System.loadLibrary("libsysinfo"); //libsysinfo.so
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
}