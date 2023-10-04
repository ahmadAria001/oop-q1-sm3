package ObjectInstances;

import ENUMS.LampColor;

public class Mobil extends Kendaraan {
    private String merk;
    private float fuelCapacity;
    private int wheelAmount;
    private LampColor frontLampColor;
    private float oilCapacity;
    private String jenisMesin;

    public Mobil() {}

    public Mobil(String noPol, float maxSpeed, String satuanKecepatan, String owner, String merk, float fuelCapacity,
            int wheelAmount, LampColor frontLampColor, float oilCapacity, String jenisMesin) {
        super(noPol, maxSpeed, satuanKecepatan, owner);
        this.merk = merk;
        this.fuelCapacity = fuelCapacity;
        this.wheelAmount = wheelAmount;
        this.frontLampColor = frontLampColor;
        this.oilCapacity = oilCapacity;
        this.jenisMesin = jenisMesin;
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

    public String getJenisMesin() {
        return jenisMesin;
    }

    public void setJenisMesin(String jenisMesin) {
        this.jenisMesin = jenisMesin;
    }

    public void printMobil() {
        System.out.printf(
                "Jenis Kendaraan: Motor\nMerek: %s\nKapasitas Bensin: %.2f\nJumlah Roda: %s\nWarna Lampu depan: %s\nKapasitas oli: %.2f\nJenis Mesin: %s\nNo.Pol: %s\nMaximum Kecepatan: %.2f %s\nPemilik: %s\nStatus Mesin: %s",
                getMerk(), getFuelCapacity(), getWheelAmount(), getFrontLampColor(), getOilCapacity(), getJenisMesin(),
                super.getNoPol(), super.getMaxSpeed(), super.getSatuanKecepatan(), super.getOwner(),
                super.isStatus() ? "Menyala" : "Mati");
    }
}
