package ObjectInstances;

public abstract class Kendaraan {
    private String noPol;
    private float maxSpeed;
    private String satuanKecepatan;
    private String owner;
    
    public Kendaraan() {
    }

    public Kendaraan(String noPol, float maxSpeed, String satuanKecepatan, String owner) {
        this.noPol = noPol;
        this.maxSpeed = maxSpeed;
        this.satuanKecepatan = satuanKecepatan;
        this.owner = owner;
    }

    public String getNoPol() {
        return noPol;
    }

    public void setNoPol(String noPol) {
        this.noPol = noPol;
    }

    public float getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(float maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public String getSatuanKecepatan() {
        return satuanKecepatan;
    }

    public void setSatuanKecepatan(String satuanKecepatan) {
        this.satuanKecepatan = satuanKecepatan;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    

}
