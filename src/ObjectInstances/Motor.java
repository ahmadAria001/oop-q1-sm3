package ObjectInstances;

import ENUMS.LampColor;

public class Motor extends Kendaraan {
    private boolean status = false;
    private String merk;
    private float fuelCapacity;
    private int wheelAmount;
    private LampColor frontLampColor;
    private float oilCapacity;

    public Motor() {}

    public Motor(String noPol, float maxSpeed, String satuanKecepatan, String owner, boolean status, String merk,
            float fuelCapacity, int wheelAmount, LampColor frontLampColor) {
        super(noPol, maxSpeed, satuanKecepatan, owner);
        this.status = status;
        this.merk = merk;
        this.fuelCapacity = fuelCapacity;
        this.wheelAmount = wheelAmount;
        this.frontLampColor = frontLampColor;
    }

    public boolean isStatus() {
        return status;
    }

    public void setMenyala(boolean status) {
        this.status = status;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public float getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(float fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public int getWheelAmount() {
        return wheelAmount;
    }

    public void setWheelAmount(int wheelAmount) {
        this.wheelAmount = wheelAmount;
    }

    public LampColor getFrontLampColor() {
        return frontLampColor;
    }

    public void setFrontLampColor(LampColor frontLampColor) {
        this.frontLampColor = frontLampColor;
    }

    public float getOilCapacity() {
        return oilCapacity;
    }

    public void setOilCapacity(float oilCapacity) {
        this.oilCapacity = oilCapacity;
    }

    public void printMotor() {
        System.out.printf(
                "Jenis Kendaraan: Motor\nMerek: %s\nKapasitas Bensin: %.2f\nJumlah Roda: %s\nWarna Lampu depan: %s\nKapasitas oli: %.2f\nNo.Pol: %s\nMaximum Kecepatan: %.2f %s\nPemilik: %s\nStatus Mesin: %s",
                getMerk(), getFuelCapacity(), getWheelAmount(), getFrontLampColor(), getOilCapacity(), super.getNoPol(),
                super.getMaxSpeed(), super.getSatuanKecepatan(), super.getOwner(),
                super.isStatus() ? "Menyala" : "Mati");
    }
}