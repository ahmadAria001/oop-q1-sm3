import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Controller.ControllerInventaris;
import Controller.ControllerKaryawan;
import Controller.ControllerTransactions;
import ObjectInstances.Item;
import ObjectInstances.Karyawan;
import ObjectInstances.Motor;
import ObjectInstances.Transaction;

public class Container {
    private ControllerKaryawan instanceKaryawan = new ControllerKaryawan();
    private ControllerInventaris instanceInventaris = new ControllerInventaris();
    private ControllerTransactions instanceTransactions = new ControllerTransactions();

    private boolean isInited = false;

    public void Executor() {
        boolean continueActions = false;
        Scanner sc = new Scanner(System.in);
        
        if (!isInited) {
            init();

            isInited = true;
        }

        do {
            // instanceKaryawan.printAllKaryawan();

            System.out.println("Continue?[Y/N]");
            continueActions = sc.next().toLowerCase().charAt(0) == 'y';
        } while (continueActions);
        sc.close();
    }

    public void init() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Ban dalam", 45, "1pcs" , 30000));
        items.add(new Item("Oli", 50, "500ml" , 45000));
        items.add(new Item("Lampu depan (Putih)", 24, "1pcs" , 15000));

        instanceInventaris.addBatchItem(items);

        List<Karyawan> karyawans = new ArrayList<>();
        karyawans.add(new Karyawan("Samsul", 'L', 1000000, "Montir"));
        karyawans.add(new Karyawan("Sadam", 'L', 750000, "Kasir"));
        karyawans.add(new Karyawan("Hussain", 'L', 500000, "Montir"));

        instanceKaryawan.addBatchKaryawan(karyawans);

        List<Transaction> transactions = new ArrayList<>();
        List<String> services = new ArrayList<>();
        services.add("Ganti Oli");
        services.add("Ganti");
        transactions.add(
            new Transaction(instanceKaryawan.getKaryawan(2), instanceKaryawan.getKaryawan(2),
            new Motor("N1234BD", 160, "km/h", "Samsul", false, "Honda", 3, 2, "Yellow"),
            services)
        );
        
    }
}
