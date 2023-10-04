package Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import ENUMS.LampColor;
import ObjectInstances.Item;
import ObjectInstances.Karyawan;
import ObjectInstances.Mobil;
import ObjectInstances.Motor;
import ObjectInstances.Transaction;
import Utilities.Container;

public class ControllerTransactions {
    private HashMap<Integer, Transaction> listTransaction = new HashMap<>();
    private int idTransaction = 1;

    public void Exec() {
        Container.clearTerminal();

        Scanner sc = new Scanner(System.in);

        System.out.print("1. Tambah Transaksi\n2. Hapus Transaksi\n3. Print Transaksi\nInput[1~3]: ");
        int choice = sc.nextInt();

        switch (choice) {
        case 1:
            addHandler();
            break;
        case 2:
            removeHandler();
            break;
        case 3:
            printTransaction();
            try {
                Thread.sleep(5000);
            } catch (Exception e) {
                System.err.println(e);
            }
            break;

        default:
            return;
        }

    }

    public void addHandler() {
        Scanner sc = new Scanner(System.in);
        Scanner choiceHandler = new Scanner(System.in);

        Container.getInstanceKaryawan().printAllKaryawan();

        System.out.print("Kasir\nID: ");
        Karyawan cashier = Container.getInstanceKaryawan().getKaryawan(sc.nextInt());

        System.out.println("\n\n");

        System.out.print("Montir\nID: ");
        Karyawan engineer = Container.getInstanceKaryawan().getKaryawan(sc.nextInt());

        System.out.println("\n\n");

        Motor mtr = null;
        Mobil mbl = null;

        System.out.print("Kendaraan\n1. Motor\n2. Mobil\nInput[1/2]: ");
        int choice = choiceHandler.nextInt();

        if (choice == 1) {
            sc.nextLine();

            System.out.println("No.pol: ");
            String nopol = sc.nextLine();

            System.out.println("Kecepatan Maximum: ");
            float maxSpeed = sc.nextFloat();

            sc.nextLine();

            System.out.println("Pemilik: ");
            String owner = sc.nextLine();

            System.out.println("Merk: ");
            String brand = sc.nextLine();

            mtr = new Motor(nopol, maxSpeed, "km/h", owner, false, brand, 4f, 2, LampColor.WHITE);
        } else if (choice == 2) {
            sc.nextLine();

            System.out.println("No.pol: ");
            String nopol = sc.nextLine();

            System.out.println("Kecepatan Maximum: ");
            float maxSpeed = sc.nextFloat();

            sc.nextLine();

            System.out.println("Satuan Kecepatan: ");
            String unitSpeed = sc.nextLine();

            System.out.println("Pemilik: ");
            String owner = sc.nextLine();

            System.out.println("Merk: ");
            String brand = sc.nextLine();

            System.out.println("Jenis Mesin: ");
            String machineType = sc.nextLine();

            mbl = new Mobil(nopol, maxSpeed, unitSpeed, owner, brand, 10f, 4, LampColor.WHITE, 500f, machineType);
        } else
            return;

        System.out.println("\n\n");
        boolean isContinueServices = false;
        List<String> serviceIn = new ArrayList<>();

        int ctrI = 0;

        do {
            if (ctrI > 0)
                sc.nextLine();

            System.out.println("Masukkan layanan: ");
            serviceIn.add(sc.nextLine());

            System.out.println("Mau  Melanjutkan[Y/N]?");
            isContinueServices = sc.next().toLowerCase().charAt(0) == 'y';
            ctrI++;
        } while (isContinueServices);

        System.out.println("\n\n");
        boolean isContinueItems = false;
        HashMap<Item, Integer> itemConsumed = new HashMap<>();
        do {
            Container.getInstanceInventaris().printItems();

            System.out.print("Masukkan Item yang terpakai(ID): ");
            Item itemContent = Container.getInstanceInventaris().getItem(sc.nextInt());

            System.out.print("Jumlah dipakai: ");
            int amount = sc.nextInt();

            System.out.println("Mau  Melanjutkan[Y/N]?");
            isContinueItems = sc.next().toLowerCase().charAt(0) == 'y';

            if (itemConsumed == null && !isContinueItems)
                break;

            itemConsumed.put(itemContent, amount);
        } while (isContinueItems);

        addTransactions(new Transaction(cashier, engineer, mtr == null ? mbl : mtr, serviceIn, itemConsumed));
        return;
    }

    public void removeHandler() {
        Scanner sc = new Scanner(System.in);

        printTransaction();

        System.out.print("ID: ");
        int id = sc.nextInt();

        Transaction removed = removeTransaction(id);

        System.out.println(removed != null ? "Berhasil menghapus transaksi" : "Transaksi Tidak ditemukan!");

        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            System.err.println(e);
        }
        return;
    }

    public HashMap<Integer, Transaction> getListTransaction() {
        return listTransaction;
    }

    public void setListTransaction(HashMap<Integer, Transaction> listTransaction) {
        this.listTransaction = listTransaction;
    }

    public int getIdTransaction() {
        return idTransaction;
    }

    public void setIdTransaction(int idTransaction) {
        this.idTransaction = idTransaction;
    }

    public void addBatchTransactions(List<Transaction> transactions) {
        for (int i = 0; i < transactions.size(); i++) {
            listTransaction.put(idTransaction++, transactions.get(i));
        }
    }

    public void addTransactions(Transaction transactions) {
        listTransaction.put(idTransaction++, transactions);
    }

    public Transaction removeTransaction(int id) {
        return listTransaction.remove(id);
    }

    public void printTransaction() {
        System.out.println("Daftar Transaksi:");
        System.out.println("-------------------------------------------------------------------");
        for (int key : this.listTransaction.keySet()) {
            System.out.println("ID: " + key);
            this.listTransaction.get(key).printTransaction();
        }

    }
}
