package ObjectInstances;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Transaction {
    private Karyawan cashier;
    private Karyawan engineer;
    private Kendaraan vehicle;
    private List<String> services = new ArrayList<>();
    private HashMap<Item, Integer> consumedItems = new HashMap<>();

    public Transaction() {}

    public <T> Transaction(Karyawan cashier, Karyawan engineer, T vehicle, List<String> services,
            HashMap<Item, Integer> consumedItems) {
        this.cashier = cashier;
        this.engineer = engineer;
        this.setVehicle(vehicle);
        this.addBatchService(services);
        this.addConsumedItems(consumedItems);
    }

    public Karyawan getCashier() {
        return cashier;
    }

    public void setCashier(Karyawan cashier) {
        if (cashier == null)
            throw new Error("Person is null");

        this.cashier = cashier;
    }

    public Karyawan getEngineer() {
        return engineer;
    }

    public void setEngineer(Karyawan engineer) {
        if (engineer == null)
            throw new Error("Person is null");

        this.engineer = engineer;
    }

    public Kendaraan getVehicle() {
        return vehicle;
    }

    public <T> void setVehicle(T vehicle) {
        if (vehicle instanceof Motor) {
            this.vehicle = (Motor) vehicle;
            return;
        }

        if (vehicle instanceof Mobil) {
            this.vehicle = (Mobil) vehicle;
            return;
        }

        throw new Error("The instance is not contained in Vehicles Object Family");
    }

    public List<String> getServices() {
        return services;
    }

    public List<String> getServices(String target) {
        List<String> service = new ArrayList<>();

        for (String value : this.services) {
            if (value.equalsIgnoreCase(target))
                service.add(value);
        }

        if (service.size() < 1)
            throw new Error("Target not found");

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

    public String removeService(String services) {
        String removedService = null;

        int targetIdx = this.services.indexOf(services);

        if (targetIdx == -1)
            throw new Error("Target not found");

        removedService = this.services.get(targetIdx);

        if (removedService == null)
            throw new Error("Target not found");

        return removedService;
    }

    public void setVehicle(Kendaraan vehicle) {
        this.vehicle = vehicle;
    }

    public HashMap<Item, Integer> getConsumedItems() {
        return consumedItems;
    }

    public void setConsumedItems(HashMap<Item, Integer> consumedItems) {
        this.consumedItems = consumedItems;
    }

    public void addConsumedItem(Item consumedItem, int amount) {
        this.consumedItems.put(consumedItem, amount);
    }

    public void addConsumedItems(HashMap<Item, Integer> itemsConsumed) {
        if (itemsConsumed.size() < 1)
            return;

        for (Item key : itemsConsumed.keySet()) {
            if (itemsConsumed.get(key) < 1)
                throw new Error("atleast has to be 1 item in the list");
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

    public void printTransaction() {
        long total = 0;

        System.out.print("Kasir: ");
        System.out.println(cashier.getNama() + "\n");

        System.out.print("Montir: ");
        System.out.println(cashier.getNama() + "\n");

        Motor mtr = null;
        Mobil mbl = null;

        if (this.vehicle instanceof Motor)
            mtr = ((Motor) this.vehicle);

        if (this.vehicle instanceof Mobil)
            mbl = ((Mobil) this.vehicle);

        if (mtr != null) {
            System.out.printf("\nKendaraan: Motor\nNama Pemilik: %s\nMerk: %s\nNo.Pol: %s\n", mtr.getOwner(),
                    mtr.getMerk(), mtr.getNoPol());
        }

        if (mbl != null) {
            System.out.printf("\nKendaraan: Mobil\nNama Pemilik: %s\nMerk: %s\nJenis Mesin: %s\nNo.Pol: %s\n",
                    mbl.getOwner(), mbl.getMerk(), mbl.getJenisMesin(), mbl.getNoPol());
        }

        System.out.println("\nPelayanan: ");
        printServices();

        System.out.println("\nItem terpakai: ");
        for (Item key : this.consumedItems.keySet()) {
            System.out.print("\t- " + key.getNamaBarang());
            System.out.println(" " + this.consumedItems.get(key) + key.getSatuan());

            total += this.consumedItems.get(key) * key.getHargaSatuan();
        }
        System.out.println("\nTotal: " + total);

        System.out.println("-------------------------------------------------------------------");
    }

    public void printServices() {
        for (String value : services) {
            System.out.println("\t- " + value);
        }
    }
}
