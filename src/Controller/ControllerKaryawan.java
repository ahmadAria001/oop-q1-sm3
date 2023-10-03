package Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import ObjectInstances.Karyawan;

public class ControllerKaryawan {
    private HashMap <Integer,Karyawan> listKaryawan = new HashMap<>();
    private int idKaryawan = 1;
    
    public void showMenuKaryawan() {
        
    }

    public void Exec() {
        
    }

    public void printAllKaryawan() {
        for (int key : listKaryawan.keySet()) {
            System.out.printf("ID: %s\n",key);
            listKaryawan.get(key).printKaryawan();
        }
    }

    public List<Karyawan> getKaryawans() {
        List<Karyawan> retValue = new ArrayList<>();
        
        for (int key : listKaryawan.keySet()) {
            retValue.add(key,listKaryawan.get(key));
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

        printAllKaryawan();
    }

    public HashMap<Integer, Karyawan> getListKaryawan() {
        return listKaryawan;
    }

    public void setListKaryawan(HashMap<Integer, Karyawan> listKaryawan) {
        this.listKaryawan = listKaryawan;
    }

    public void removeKaryawan(int id) {
        listKaryawan.remove(id);
    }

    public void removeKaryawan(String name) {
        for (int key : listKaryawan.keySet()) {
            if (listKaryawan.get(key).getNama().equalsIgnoreCase(name))
            listKaryawan.remove(key);
        }
    }
}
