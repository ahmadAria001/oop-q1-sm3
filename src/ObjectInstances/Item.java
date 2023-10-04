package ObjectInstances;

public class Item {
    private String namaBarang;
    private int stok;
    private String satuan;
    private long hargaSatuan;

    public Item() {}

    public Item(String namaBarang, int stok, String satuan, long hargaSatuan) {
        this.namaBarang = namaBarang;
        this.stok = stok;
        this.satuan = satuan;
        this.hargaSatuan = hargaSatuan;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public String getSatuan() {
        return satuan;
    }

    public void setSatuan(String satuan) {
        this.satuan = satuan;
    }

    public long getHargaSatuan() {
        return hargaSatuan;
    }

    public void setHargaSatuan(long hargaSatuan) {
        this.hargaSatuan = hargaSatuan;
    }

    public void printItem() {
        System.out.printf("Nama Barang: %s\nStock: %s\nHarga: %s\nSatuan: %s\n", getNamaBarang(), getStok(),
                getHargaSatuan(), getSatuan());
    }
}
