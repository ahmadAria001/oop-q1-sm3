package ObjectInstances;

import java.util.ArrayList;
import java.util.List;

public class Transaction {
    private Karyawan cashier;
    private Karyawan engineer;
    private Kendaraan vehicle;
    private List<String> services = new ArrayList<>();
    
    public Transaction() {
    }

    public Transaction(Karyawan cashier, Karyawan engineer) {
        this.cashier = cashier;
        this.engineer = engineer;
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
}
