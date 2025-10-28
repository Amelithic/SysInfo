// Attached devices (USB) - Aidan

import java.util.ArrayList;
import java.util.List;

public class usbInfo {
    static {
        // Loading Mark's Library
        System.loadLibrary("sysinfo"); //libsysinfo.so
    }


    //defining native methods
    // Refresh the current values and counters - call this before other methods
    public native void read ();

    // Return the number of USB buses
    public native int busCount ();

    // Return the number of devices on a USB bus
    public native int deviceCount (int bus);

    // Return the vendor ID of a USB device
    public native int vendorID (int bus, int device);

    // Return the product ID of a USB device
    public native int productID (int bus, int device);


    //custom methods here
}
//USB Device
class DevicesUSB {
    int vendorID;
    int productID;

        public DevicesUSB (int vendorID, int productID)  {
            this.vendorID = vendorID;
            this.productID = productID;
    }
}
//USB Buses
class BusesUSB {
    List<DevicesUSB> busesAr = new ArrayList<>();
}
//USB PCI
class usbArrays {
    List<BusesUSB> usbAr = new ArrayList<>();
    usbInfo usbinfo = new usbInfo();

        public usbArrays() {
            usbinfo.read();

            int busCount = usbinfo.busCount ();

            for (int b = 0; b < busCount; b++) {
                    BusesUSB bus = new BusesUSB();

                    int deviceCount = usbinfo.deviceCount (b);
                    for (int d = 0; d < deviceCount; d++) {
                        int vendor = usbinfo.vendorID (b, d);
                        int product = usbinfo.productID (b, d);
                        bus.busesAr.add(new DevicesUSB (vendor, product));
                    }

                    //Only add if bus has at least one valid device
                    if (!bus.busesAr.isEmpty()) {
                        usbAr.add(bus);
                    }
                }
        }

        //Print Structure
        public void printUSBStructure() {
            System.out.println("\nAttached USB Devices\n");
            for (int b = 0; b < usbAr.size(); b++) {
                System.out.println("USB Bus " + b);
                BusesUSB bus = usbAr.get(b);

                for (int d = 0; d < bus.busesAr.size(); d++) {
                    DevicesUSB device = bus.busesAr.get(d);
                    System.out.printf("   USB Device %d -> Vendor: 0x%04X, Product: 0x%04X%n", d, device.vendorID, device.productID);

                }
            }
        }
}