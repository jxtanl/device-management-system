// Jessica Longstreth, CIS 340 T/Th 3:00-4:15PM, MP2 

import java.util.ArrayList;
import java.util.Scanner;

public class Device {
    
    private String sku;
    private String name;
    private boolean available;
    
    public Device(String sku, String name, boolean available) {
        this.sku = sku;
        this.name = name;
        this.available = available;
    }
    
    public String getSKU() {
        return sku;
    }
    
    public void setSKU(String sku) {
        this.sku = sku;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public boolean isAvailable() {
        return available;
    }
    
    public void setAvailable(boolean available) {
        this.available = available;
    }

}

