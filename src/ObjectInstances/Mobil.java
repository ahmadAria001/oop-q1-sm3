package ObjectInstances;

public class Mobil extends Kendaraan{
    private boolean menyala = false;
    private String merk;
    private float fuelCapacity;
    private int wheelAmount;
    private String frontLampColor;
    private float oilCapacity;
    private String jenisMesin;
    
    public Mobil() {
    }

    public Mobil(boolean menyala, String merk, float fuelCapacity, int wheelAmount, String frontLampColor,
            float oilCapacity, String jenisMesin) {
        this.menyala = menyala;
        this.merk = merk;
        this.fuelCapacity = fuelCapacity;
        this.wheelAmount = wheelAmount;
        this.frontLampColor = frontLampColor;
        this.oilCapacity = oilCapacity;
        this.jenisMesin = jenisMesin;
    }

    public boolean isMenyala() {
        return menyala;
    }

    public void setMenyala(boolean menyala) {
        this.menyala = menyala;
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

    public String getFrontLampColor() {
        return frontLampColor;
    }

    public void setFrontLampColor(String frontLampColor) {
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

    
}
