// Jessica Longstreth, CIS 340 T/Th 3:00-4:15PM, MP2 

import java.util.ArrayList;
import java.util.Scanner;

class DeviceManagementSystem {
    private ArrayList<Device> devices;

    public DeviceManagementSystem() {
        devices = new ArrayList<>();
        devices.add(new Device("6757A", "Apple 9.7-inch iPad Pro", true));
        devices.add(new Device("93P51B", "Amazon Kindle Fire Kids Edition", true));
        devices.add(new Device("10N8C", "LeapFrog Epic Learning Tablet", true));
        devices.add(new Device("85U2O", "Amazon Kindle Fire HD 8", false));
        devices.add(new Device("91H2D", "HP Envy 8 Note", true));
    }
    
    public void displayMenu() {
        System.out.println("\nLibrary Device Checkout System\n");
        System.out.println("1.  List Devices by Title");
        System.out.println("2.  Add New Devices");
        System.out.println("3.  Edit Device Information");
        System.out.println("4.  Search by Device Name");
        System.out.println("5.  Check Out Devices");
        System.out.println("6.  Check In Devices");
        System.out.println("7.  Exit\n");
        System.out.print("Select menu options (1-7): ");
  
    }

    public void displayDevices() {
        System.out.println("\n\t\tLibrary Device Checkout System - List\n");
        System.out.printf("#  %-6s %-30s %-15s\n", "SKU", "Name", "Availability");
        int i = 1;
        for (Device device : devices) {
            System.out.printf("%-3d %-6s %-30s %-15s\n", i++, device.getSKU(), device.getName(),
                    device.isAvailable() ? "Available" : "Checked Out");
        }
        System.out.println("\nPress Enter to continue…");
        new Scanner(System.in).nextLine();
    }
    

    public void addDevice() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nLibrary Device Checkout System - Add New Device\n");
        System.out.print("Sku: ");
        String sku = scanner.next();
        System.out.print("Name: ");
        scanner.nextLine();
        String name = scanner.nextLine(); 
        devices.add(new Device(sku, name.trim(), true));
        System.out.println("\nAdded " + name.trim() + " to Catalog.\nPress Enter to continue…");
        scanner.nextLine(); 
    }


    public void editDevice() {
        Scanner scanner = new Scanner(System.in);
        displayDevices();
        System.out.println("\nLibrary Device Checkout System - Edit Device\n");
        System.out.print("Enter Device Number to Edit (1-" + devices.size() + "): ");
        int deviceNumber = scanner.nextInt();
        scanner.nextLine(); 
        if (deviceNumber >= 1 && deviceNumber <= devices.size()) {
            System.out.print("Sku: ");
            String newSku = scanner.next();
            System.out.print("Name: ");
            scanner.nextLine(); 
            String newName = scanner.nextLine();
            devices.get(deviceNumber - 1).setAvailable(true);
            devices.get(deviceNumber - 1).setSKU(newSku);
            devices.get(deviceNumber - 1).setName(newName.trim());
            System.out.println("\nDevice information updated.\nPress Enter to continue…");
            scanner.nextLine();
        } else {
            System.out.println("\nInvalid device number.\nPress Enter to continue…");
            scanner.nextLine();
        }
    }


    public void searchDeviceByName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nLibrary Device Checkout System - Search\n");
        System.out.print("Enter Device to Search for: ");
        String searchTerm = scanner.nextLine().toLowerCase();
        System.out.println("\nListings for '" + searchTerm + "'\n");
        System.out.printf("#  %-6s %-30s\n", "SKU", "Name");
        int i = 1;
        for (Device device : devices) {
            if (device.getName().toLowerCase().contains(searchTerm)) {
                System.out.printf("%-3d %-6s %-30s\n", i++, device.getSKU(), device.getName());
            }
        }
        System.out.println("\nPress Enter to continue…");
        scanner.nextLine(); 
    }

    public void checkOutDevice() {
        Scanner scanner = new Scanner(System.in);
        displayAvailableDevices();
        System.out.println("\nLibrary Device Checkout System - Check Out Devices\n");
        System.out.print("Enter Device Number: ");
        int deviceNumber = scanner.nextInt();
        scanner.nextLine(); 
        if (deviceNumber >= 1 && deviceNumber <= devices.size() && devices.get(deviceNumber - 1).isAvailable()) {
            devices.get(deviceNumber - 1).setAvailable(false);
            System.out.println("\nDevice Checked Out.\nPress Enter to continue…");
            scanner.nextLine(); 
        } else {
            System.out.println("\nInvalid device number or the device is not available.\nPress Enter to continue…");
            scanner.nextLine(); 
        }
    }

    public void checkInDevice() {
        Scanner scanner = new Scanner(System.in);
        displayCheckedOutDevices();
        System.out.println("\nLibrary Device Checkout System - Check In Devices\n");
        System.out.print("Enter Device Number: ");
        int deviceNumber = scanner.nextInt();
        scanner.nextLine(); 
        if (deviceNumber >= 1 && deviceNumber <= devices.size() && !devices.get(deviceNumber - 1).isAvailable()) {
            devices.get(deviceNumber - 1).setAvailable(true);
            System.out.println("\nDevice Checked In.\nPress Enter to continue…");
            scanner.nextLine(); 
        } else {
            System.out.println("\nInvalid device number or the device is not checked out.\nPress Enter to continue…");
            scanner.nextLine(); 
        }
    }

    private void displayAvailableDevices() {
        System.out.println("\nAvailable Devices\n");
        System.out.printf("#  %-6s %-30s\n", "SKU", "Name");
        int i = 1;
        for (Device device : devices) {
            if (device.isAvailable()) {
                System.out.printf("%-3d %-6s %-30s\n", i++, device.getSKU(), device.getName());
            }
        }
    }

    private void displayCheckedOutDevices() {
        System.out.println("\nChecked Out Devices\n");
        
    }
   
}

