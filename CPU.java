public class CPU {
    static {
        // Loading Mark's Library
        System.loadLibrary("libsysinfo"); //libsysinfo.so
    }

    public void printString(String x) {
        System.out.println("test: "+x);
    }
}
