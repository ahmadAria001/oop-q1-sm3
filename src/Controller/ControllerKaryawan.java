package Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import ObjectInstances.Karyawan;

public class ControllerKaryawan {
    private HashMap<Integer, Karyawan> listKaryawan = new HashMap<>();
    private int idKaryawan = 1;

    public void Exec(int choice) {
        switch (choice) {
        case 3:
            addHandler();
            return;
        case 4:
            removeHandler();
            return;

        default:
            return;
        }
    }

    public void addHandler() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nama: ");
        String name = sc.nextLine();

        System.out.print("Jenis Kelamin: ");
        char jk = sc.next().toUpperCase().charAt(0);

        System.out.print("Gaji Pokok: ");
        long salary = sc.nextLong();
        
        sc.nextLine();

        System.out.println("Jabatan: ");
        String position = sc.nextLine();

        addKaryawan(new Karyawan(name, jk, salary, position));

        return;
    }

    public void removeHandler() {
        Scanner sc = new Scanner(System.in);

        System.out.print("1. Name\n2. ID\nInput[1/2]: ");
        int choice = sc.nextInt();

        if (choice > 2 || choice < 1) {

            return;
        }

        if (choice == 1) {
            printAllKaryawan();

            System.out.print("Nama: ");
            String name = sc.next();

            Karyawan removed = removeKaryawan(name);
            System.out.println(removed);

            System.out.println(removed != null ? "Removed: " + removed.getNama() : "Karyawan Tidak ditemukan!");
        } else if (choice == 2) {
            printAllKaryawan();

            System.out.print("ID: ");
            int id = sc.nextInt();

            if (id < 1) {

                return;
            }

            Karyawan removed = removeKaryawan(id);

            System.out.println(removed != null ? "Removed: " + removed.getNama() : "Karyawan Tidak ditemukan!");
            id = sc.nextInt();
        }

        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            System.err.println(e);
        }
        return;
    }

    public void printAllKaryawan() {
        for (int key : listKaryawan.keySet()) {
            System.out.printf("ID: %s\n", key);
            listKaryawan.get(key).printKaryawan();
        }
    }

    public List<Karyawan> getKaryawans() {
        List<Karyawan> retValue = new ArrayList<>();

        for (int key : listKaryawan.keySet()) {
            retValue.add(key, listKaryawan.get(key));
        }

        return retValue;
    }

    public Karyawan getKaryawan(String name) {
        Karyawan retValue = null;

        for (int key : listKaryawan.keySet()) {
            retValue = listKaryawan.get(key).getNama().equalsIgnoreCase(name) ? listKaryawan.get(key) : null;
        }

        return retValue;
    }

    public Karyawan getKaryawan(int id) {
        return listKaryawan.get(id);
    }

    public void addKaryawan(Karyawan karyawan) {
        this.listKaryawan.put(idKaryawan++, karyawan);
    }

    public void addBatchKaryawan(List<Karyawan> batchKaryawan) {
        for (int i = 0; i < batchKaryawan.size(); i++) {
            this.listKaryawan.put(idKaryawan++, batchKaryawan.get(i));
        }
    }

    public HashMap<Integer, Karyawan> getListKaryawan() {
        return listKaryawan;
    }

    public void setListKaryawan(HashMap<Integer, Karyawan> listKaryawan) {
        this.listKaryawan = listKaryawan;
    }

    public Karyawan removeKaryawan(int id) {
        Karyawan removed = null;
        try {
            removed = listKaryawan.remove(id);
        } catch (Exception e) {
            System.err.println(e);
        }

        return removed;
    }

    public Karyawan removeKaryawan(String name) {
        for (int key : listKaryawan.keySet()) {
            if (listKaryawan.get(key).getNama().equalsIgnoreCase(name)) {
                return listKaryawan.remove(key);
            }
        }

        return null;
    }
}
