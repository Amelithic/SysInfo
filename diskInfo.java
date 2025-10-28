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

    public static String print_unit(long kilobytes){
        if (kilobytes < 1024) {
            return String.format("%d KiB", kilobytes);
        } 
        else if (kilobytes < 1048576) {
            return String.format("%.2f MiB", kilobytes / 1024.0);
        } 
        else if (kilobytes < 1073741824) {
            return String.format("%.2f GiB", kilobytes / 1048576.0);
        } 
        else {
            return String.format("%.2f TiB", kilobytes / 1073741824.0);
        }
    }
    //custom methods here
    public void print_table() {
        read();
        System.out.println(Style.BOLD + Style.CYAN + "Number of disks: " + diskCount() + "\n" + Style.RESET );
        System.out.println(Style.BLUE + "_____________________________________________________" + Style.RESET);
        System.out.printf(Style.BLUE + "| %-15s | %-8s | %-20s |\n" + Style.RESET, "Name", "Size", "Bar");
        for (int i=0; i < diskCount(); i++) {
            long total = getTotal(i);
            long used = getUsed(i);

            System.out.printf("", getName(i));
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