# SysInfo Java Tool

*Project to create a "sysinfo" utility in Java that describes computer CPU, speed, RAM, disk, attached devices.*

<p>Collaborators: Amelie McCarthy, Aidan Tomasko, Adam Ryan, Anav Vashisht
Group 13 - A4</p>

<p>Amelie -> RAM
Adam -> CPU
Aidan -> Attached Devices (PCI and USB)
Anav -> Disks</p>

---

## Features:
- Displays CPU info
    - Displays CPU model and number of cores
    - Displays Cache sizes
    - Performance metrics and current CPU load metric
- Displays RAM info
    - Total RAM and used RAM amounts
    - Live graph of current RAM usage
- Displays Attached Devices (PCI and USB)
  - Displays total devices connected count
  - Displays hierarchical view of PCI and USB buses, device and functions
  - Identifies common device vendor IDs
- Displays Disk info
  - Displays total disks count
  - Displays current attached disk locations with sizes
  - Visual table of current disk usage
- Styling (coloured text, reset screen, etc.) using custom Style class.
