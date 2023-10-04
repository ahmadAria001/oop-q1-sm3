package Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import ObjectInstances.Item;

public class ControllerInventaris {
    private HashMap<Integer, Item> listItem = new HashMap<>();
    private int idItem = 1;

    public void Exec(int choice) {
        switch (choice) {
        case 1:
            addHandler();
            return;
        case 2:
            removeHandler();
            return;

        default:
            return;
        }
    }

    public void addHandler() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nama Item: ");
        String name = sc.next();

        sc.nextLine();

        System.out.print("Satuan: ");
        String units = sc.next();

        System.out.print("Harga Satuan: ");
        long price = sc.nextLong();

        System.out.print("Stok: ");
        int stock = sc.nextInt();

        addItem(new Item(name, stock, units, price));

        return;
    }

    public void removeHandler() {
        Scanner sc = new Scanner(System.in);

        printItems();

        System.out.println("Nama: ");
        String name = sc.nextLine();

        Item removed = removeItem(name);

        System.out.println(removed != null ? "Removed: " + removed.getNamaBarang() : "Item Tidak ditemukan!");

        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            System.err.println(e);
        }
        return;
    }

    public void addItem(Item item) {
        this.listItem.put(idItem++, item);
    }

    public void addBatchItem(List<Item> batchItem) {
        for (Item item : batchItem) {
            this.listItem.put(idItem++, item);
        }
    }

    public HashMap<Integer, Item> getListInventaris() {
        return listItem;
    }

    public Item getItem(String name) {
        for (int key : this.listItem.keySet()) {
            if (listItem.get(key).getNamaBarang().equals(name))
                return listItem.get(key);
        }

        return null;
    }

    public void printItems() {
        for (int key : this.listItem.keySet()) {
            System.out.printf("Nama Item: %s\nHarga Item: %s\nSatuan: %s\nStok: %s\n\n",
                    listItem.get(key).getNamaBarang(), listItem.get(key).getHargaSatuan(),
                    listItem.get(key).getSatuan(), listItem.get(key).getStok());
        }
    }

    public Item removeItem(String name) {
        Item removedItem = null;

        for (int key : this.listItem.keySet()) {
            if (this.listItem.get(key).getNamaBarang().equalsIgnoreCase(name)) {
                removedItem = this.listItem.remove(key);
                break;
            }
        }

        if (removedItem == null)
            throw new Error("Item not found");

        return removedItem;
    }

    public Item getItem(int id) {
        return listItem.get(id);
    }
}
