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

    public void make_bar(double percentage, int size){
        int progress = (int)Math.floor(percentage*size);
        for(int i = 0; i<progress; i++)
            System.out.print("\u2593");
        for(int j = 0; j<size-progress; j++)
            System.out.print("\u2591");
        System.out.println();
    }
    //custom methods here
    public void testPrint() {
        read();
        System.out.println(diskCount());

        for (int i=0; i < diskCount(); i++) {
            long total = getTotal(i);
            long used = getUsed(i);
            System.out.printf("Name: %s\n", getName(i));
            System.out.printf("Size: %d\n", total);
            System.out.printf("Used: %d\n", used);
            double percentage = (double)used/total;
            make_bar(percentage, 50);
        }
    }
}