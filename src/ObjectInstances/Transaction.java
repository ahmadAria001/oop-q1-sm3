package ObjectInstances;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Transaction {
    private Karyawan cashier;
    private Karyawan engineer;
    private Kendaraan vehicle;
    private List<String> services = new ArrayList<>();
    private HashMap<Item,Integer> consumedItems = new HashMap<>();
    
    public Transaction() {
    }

    public <T> Transaction(Karyawan cashier, Karyawan engineer, T vehicle, List<String> services) {
        this.cashier = cashier;
        this.engineer = engineer;
        this.setVehicle(vehicle);
        this.addBatchService(services);
    }

    public Karyawan getCashier() {
        return cashier;
    }

    public void setCashier(Karyawan cashier) {
        this.cashier = cashier;
    }

    public Karyawan getEngineer() {
        return engineer;
    }

    public void setEngineer(Karyawan engineer) {
        this.engineer = engineer;
    }

    public Kendaraan getVehicle() {
        return vehicle;
    }

    public <T> void setVehicle(T vehicle) {
        if (!new Motor().equals(vehicle) || ! new Mobil().equals(vehicle)) throw new Error("The instance is not contained in Vehicles Object Family");

        if (new Motor().equals(vehicle))
        this.vehicle = (Motor) vehicle;

        if (new Mobil().equals(vehicle))
        this.vehicle = (Mobil) vehicle;
    }

    public List<String> getServices() {
        return services;
    }

    public void setServices(List<String> services) {
        this.services = services;
    }

    public void addService(String service) {
        this.services.add(service);
    }
    public void addBatchService(List<String> services) {
        for (int i = 0; i < services.size(); i++) {
            this.services.add(services.get(i));
        }
    }

    public void setVehicle(Kendaraan vehicle) {
        this.vehicle = vehicle;
    }

    public HashMap<Item,Integer> getConsumedItems() {
        return consumedItems;
    }

    public void setConsumedItems(HashMap<Item,Integer> consumedItems) {
        this.consumedItems = consumedItems;
    }

    public void addConsumedItem(Item consumedItem, int amount) {
        this.consumedItems.put(consumedItem, amount);
    }
    
    public void addConsumedItems(HashMap<Item,Integer> itemsConsumed) {
        if (itemsConsumed.size() < 1) throw new Error("atleast has to be 1 item in the list");
        
        for (Item key : itemsConsumed.keySet()) {
            if (itemsConsumed.get(key) < 1) throw new Error("atleast has to be 1 item in the list");
            break;
        }

        this.consumedItems.putAll(itemsConsumed);
    }

    public Item removeItem(String itemName) {
        Item removedItem = null;

        for (Item key : consumedItems.keySet()) {
            if (key.getNamaBarang().equals(itemName))
            removedItem = key;
            this.consumedItems.remove(key);
        }

        return removedItem;
    }
}
