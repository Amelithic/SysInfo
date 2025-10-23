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
        System.out.println("Total RAM: "+getTotal());
        System.out.println("Used RAM: "+getUsed());
    }
}
