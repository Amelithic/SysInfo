// Attached devices (PCI) - Aidan
import java.util.ArrayList;
import java.util.List;

public class pciInfo {
    static {
        // Loading Mark's Library
        System.loadLibrary("sysinfo"); //libsysinfo.so
    }


    //defining native methods
    // Refresh the current values and counters - call this before other methods
    public native void read ();

    // Return the number of PCI buses
    public native int busCount ();

    // Return the number of devices on a PCI bus
    public native int deviceCount (int bus);

    // Return the number of functions in a PCI device
    public native int functionCount (int bus, int device);

    // Return the number of functions in a PCI device
    public native int functionPresent (int bus, int device, int function);

    // Return the vendor ID of a PCI device
    public native int vendorID (int bus, int device, int function);

    // Return the product ID of a PCI device
    public native int productID (int bus, int device, int function);


    //custom methods here
}
//ChatGPT generated (sorry :( )
//PCI function
class Functions {
    int vendorID;
    int productID;

    public Functions(int vendorID, int productID) {
        this.vendorID = vendorID;
        this.productID = productID;
    }
}


//PCI device
class Devices {
    List<Functions> devicesAr = new ArrayList<>();
}


//PCI bus
class Busses {
    List<Devices> bussesAr = new ArrayList<>();
}


//entire PCI
class pciArrays {
    List<Busses> pcisAr = new ArrayList<>();
    pciInfo pciinfo = new pciInfo();

    public pciArrays() {
        // Refresh PCI info from the native library
        pciinfo.read();

        // Get the total number of buses
        int busCount = pciinfo.busCount();

        // Build nested structure dynamically
        for (int b = 0; b < busCount; b++) {
            Busses bus = new Busses();

            int deviceCount = pciinfo.deviceCount(b);
            for (int d = 0; d < deviceCount; d++) {
                Devices device = new Devices();

                int functionCount = pciinfo.functionCount(b, d);
                for (int f = 0; f < functionCount; f++) {
                    if (pciinfo.functionPresent(b, d, f) == 1) {
                        int vendor = pciinfo.vendorID(b, d, f);
                        int product = pciinfo.productID(b, d, f);
                        device.devicesAr.add(new Functions(vendor, product));
                    }
                }

                // Only add if device has at least one valid function
                if (!device.devicesAr.isEmpty()) {
                    bus.bussesAr.add(device);
                }
            }

            // Only add if bus has at least one valid device
            if (!bus.bussesAr.isEmpty()) {
                pcisAr.add(bus);
            }
        }//end of for loop
    }

    // Print structure
    public void printStructure() {
        for (int b = 0; b < pcisAr.size(); b++) {
            System.out.println("Bus " + b);
            Busses bus = pcisAr.get(b);

            for (int d = 0; d < bus.bussesAr.size(); d++) {
                System.out.println("  Device " + d);
                Devices device = bus.bussesAr.get(d);

                for (int f = 0; f < device.devicesAr.size(); f++) {
                    Functions func = device.devicesAr.get(f);
                    System.out.printf("    Function %d -> Vendor: 0x%04X, Product: 0x%04X%n", f, func.vendorID, func.productID);
                }
            }
        }
    }
}
//javac *.java - compiles all
//java SysInfo - runs