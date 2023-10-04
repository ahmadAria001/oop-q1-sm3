package Utilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import Controller.ControllerInventaris;
import Controller.ControllerKaryawan;
import Controller.ControllerTransactions;
import ENUMS.LampColor;
import ObjectInstances.Item;
import ObjectInstances.Karyawan;
import ObjectInstances.Mobil;
import ObjectInstances.Motor;
import ObjectInstances.Transaction;

public class Container {
    private static ControllerKaryawan instanceKaryawan = new ControllerKaryawan();
    private static ControllerInventaris instanceInventaris = new ControllerInventaris();
    private static ControllerTransactions instanceTransactions = new ControllerTransactions();

    private boolean isInited = false;

    public void Executor() {
        // if (System.getProperty("os.name").equalsIgnoreCase("Linux"))

        Scanner iMod = new Scanner(System.in);

        if (!isInited) {
            init();

            clearTerminal();
            isInited = true;
        }

        mainMenu();
        int choice = iMod.nextInt();

        switch (choice) {
        case 1:
            instanceInventaris.Exec(choice);
            clearTerminal();
            this.Executor();
            break;
        case 2:
            instanceInventaris.Exec(choice);
            clearTerminal();
            this.Executor();
            break;
        case 3:
            instanceKaryawan.Exec(choice);
            clearTerminal();
            this.Executor();
            break;
        case 4:
            instanceKaryawan.Exec(choice);
            clearTerminal();
            this.Executor();
            break;
        case 5:
            instanceTransactions.Exec();
            clearTerminal();
            this.Executor();
            break;
        case 6:
            clearTerminal();
            System.out.println("\n\n\n");
            instanceInventaris.printItems();
            this.Executor();
            break;
        case 7:
            clearTerminal();
            System.out.println("\n\n\n");
            instanceKaryawan.printAllKaryawan();
            this.Executor();
            break;
        case 8:
            System.exit(0);
            break;

        default:
            this.Executor();
            break;
        }

        iMod.close();
    }

    public static void mainMenu() {
        System.out.println(
                "1. Tambah Item\n2. Hapus Item\n3. Tambah Karyawan\n4. Hapus Karyawan\n5. Menu Transaksi\n6. Print Item\n7. Print Karyawan\n8. Exit\nInput [1~8]: ");
    }

    public void init() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Ban dalam", 45, "1pcs", 30000));
        items.add(new Item("Oli", 50, "500ml", 45000));
        items.add(new Item("Lampu depan (Putih)", 24, "1pcs", 15000));

        instanceInventaris.addBatchItem(items);

        List<Karyawan> karyawans = new ArrayList<>();
        karyawans.add(new Karyawan("Samsul", 'L', 1000000, "Montir"));
        karyawans.add(new Karyawan("Sadam", 'L', 750000, "Kasir"));
        karyawans.add(new Karyawan("Hussain", 'L', 500000, "Montir"));

        instanceKaryawan.addBatchKaryawan(karyawans);

        List<Transaction> transactions = new ArrayList<>();
        List<String> services = new ArrayList<>();
        HashMap<Item, Integer> consumedItems = new HashMap<>();

        services.add("Ganti Oli");
        services.add("Ganti Ban dalam");

        consumedItems.put(instanceInventaris.getItem(2), 2);
        consumedItems.put(instanceInventaris.getItem(1), 1);

        transactions.add(new Transaction(instanceKaryawan.getKaryawan(2), instanceKaryawan.getKaryawan(2),
                new Motor("N1234BD", 160, "km/h", "Samsul", false, "Honda", 3, 2, LampColor.YELLOW), services,
                consumedItems));
        transactions.add(new Transaction(instanceKaryawan.getKaryawan(2), instanceKaryawan.getKaryawan(2),
                new Motor("N1454BD", 160, "km/h", "Dimas", false, "Honda", 3, 2, LampColor.YELLOW), services,
                consumedItems));
        transactions.add(new Transaction(instanceKaryawan.getKaryawan(2), instanceKaryawan.getKaryawan(2),
                new Mobil("N4155BW", 240f, "km/h", "Dimas", "Toyota", 5f, 4, LampColor.WHITE, 1.2f, "Diesel"), services,
                consumedItems));

        instanceTransactions.addBatchTransactions(transactions);
    }

    public static void clearTerminal() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static ControllerKaryawan getInstanceKaryawan() {
        return instanceKaryawan;
    }

    public static ControllerInventaris getInstanceInventaris() {
        return instanceInventaris;
    }

    public static ControllerTransactions getInstanceTransactions() {
        return instanceTransactions;
    }
}
