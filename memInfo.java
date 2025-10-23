//Memory information - Amelie

public class memInfo {
    static {
        // Loading Mark's Library
        System.loadLibrary("libsysinfo"); //libsysinfo.so
    }


    // defining native methods
    public native void read ();
    public native int getTotal ();
    public native int getUsed ();


    //custom methods here

    
    public void printString(String x) {
        System.out.println("test: "+x);
        System.out.println("Total RAM: "+getTotal());
        System.out.println("Used RAM: "+getUsed());
    }
}
