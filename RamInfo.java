//Author: Amelie
/* DESCRIPTION:
*
*/

public class RamInfo {
    static {
        // Loading Mark's Library
        System.loadLibrary("libsysinfo"); //libsysinfo.so
    }

    public void printString(String x) {
        System.out.println("test: "+x);
    }

    // Refresh the current values and counters - call this before other methods
    public native void read ();
    public native int getTotal ();
    public native int getUsed ();
}
