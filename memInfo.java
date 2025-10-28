//Memory information - Amelie

import java.util.Random;

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
    public void displayMemory() {
        float totalRAM = (float) getTotal();
        float usedRAM = (float) getUsed();

        System.out.println("\nTotal RAM: ");
        System.out.print("    "+Style.BOLD);
        diskInfo.print_unit((long)totalRAM);
        System.out.println(Style.RESET+"\nUsed RAM: ");
        System.out.print("    "+Style.BOLD);
        diskInfo.print_unit((long)usedRAM);

        float percentUsed = (usedRAM/totalRAM) * 100;
        System.out.println(Style.RESET+"\n\n\nPercent used: ");
        System.out.printf(Style.BOLD+"    %.2f",percentUsed);
        System.out.print(Style.RESET+"%\n");

        displayGraph(percentUsed);
    }

    public static void displayGraph(float percentUsed) {

        System.out.print(Style.RED_FG+"┌────────────────────┐"+Style.RESET);
        System.out.print(Style.RED_FG+"\n│"+Style.RESET);

        // 1 bar = 5 percent used
        int pointsInPercentage = (int) Math.floor(percentUsed) / 5;
        for (int i=0; i < pointsInPercentage; i++) {
            System.out.print("▉");
        }
        int remainder = 20 - pointsInPercentage;
        for (int i=0; i < remainder; i++) {
            System.out.print(Style.DIMMED+"░"+Style.RESET);
        }

        System.out.print(Style.RED_FG+"│\n"+Style.RESET);
        System.out.println(Style.RED_FG+"└────────────────────┘"+Style.RESET);

    }
}
