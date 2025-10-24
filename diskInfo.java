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

    public void print_unit(long kilobytes){
        if (kilobytes < 1024) {
            System.out.printf("%d KB", kilobytes);
        } 
        else if (kilobytes < 1048576) {
            System.out.printf("%.2f MB", kilobytes / 1024.0);
        } 
        else if (kilobytes < 1073741824) {
            System.out.printf("%.2f GB", kilobytes / 1048576.0);
        } 
        else {
            System.out.printf("%.2f TB", kilobytes / 1073741824.0);
        }
    }
    //custom methods here
    public void testPrint() {
        read();
        System.out.println(diskCount());

        for (int i=0; i < diskCount(); i++) {
            long total = getTotal(i);
            long used = getUsed(i);
            System.out.printf("Name: %s\n", getName(i));
            System.out.print("Size: ");
            print_unit(total);
            System.out.println();
            System.out.printf("Used: ");
            print_unit(used);
            System.out.println();
            double percentage = (double)used/total;
            make_bar(percentage, 50);
        }
    }
}