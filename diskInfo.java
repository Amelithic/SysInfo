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

    public String make_bar(double percentage, int size){
        int progress = (int)Math.floor(percentage*size);
        String temp = "";
        for(int i = 0; i<progress; i++)
            temp += "\u2593";
        for(int j = 0; j<size-progress; j++)
            temp += "\u2591";
        return temp;
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
        System.out.println(Style.BLUE + "------------------------------------------------------------------------------------------------------" + Style.RESET);
        System.out.printf(Style.BLUE + "| %-15s | %-12s | %-12s | %-50s |\n" + Style.RESET, "Name", "Size", "Used", "Bar");
        System.out.println(Style.BLUE + "------------------------------------------------------------------------------------------------------" + Style.RESET);
        for (int i=0; i < diskCount(); i++) {
            long total = getTotal(i);
            long used = getUsed(i);

            System.out.printf(Style.BLUE + "|" + Style.YELLOW + " %-15s " + Style.BLUE + "|" + Style.YELLOW + " %-12s " + Style.BLUE + "|" + Style.YELLOW + " %-12s " + Style.BLUE + "|" + Style.RESET, getName(i), print_unit(total), print_unit(used));
            double percentage = (double)used/total;

            if(percentage < 0.2){
                System.out.print(Style.RESET + " " + make_bar(percentage, 50) + Style.BLUE + " |");
            }

            else if(percentage >= 0.2 && percentage <0.6){
                System.out.print(Style.GREEN + " " + make_bar(percentage, 50) + Style.GREEN + " |");
            }

            else if(percentage >= 0.6 && percentage <0.8){
                System.out.print(Style.CYAN + " " + make_bar(percentage, 50) + Style.BLUE + " |");
            }

            else{
                System.out.print(Style.RED + " " + make_bar(percentage, 50) + Style.BLUE + " |");
            }

            System.out.println();
        }
        System.out.println(Style.BLUE + "------------------------------------------------------------------------------------------------------" + Style.RESET);

    }
}