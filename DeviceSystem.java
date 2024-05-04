// Jessica Longstreth, CIS 340 T/Th 3:00-4:15PM, MP2 

import java.util.Scanner;

public class DeviceSystem {
    public static void main(String[] args) {
        DeviceManagementSystem system = new DeviceManagementSystem();
        Scanner scanner = new Scanner(System.in);

        do {
            system.displayMenu();
            System.out.print("\n\t\t");
            int option = scanner.nextInt();
            scanner.nextLine(); 
            switch (option) {
            case 1:
                system.displayDevices();
                break;
            case 2:
                system.addDevice();
                break;
            case 3:
                system.editDevice();
                break;
            case 4:
                system.searchDeviceByName();
                break;
            case 5:
                system.checkOutDevice();
                break;
            case 6:
                system.checkInDevice();
                break;
            case 7:
                System.out.println("Goodbye!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option.");
            }
        } while (true);
    }
}