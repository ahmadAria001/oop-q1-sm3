package ObjectInstances;

public class Karyawan {
    private String nama;
    private char JK;
    private long gajiPokok;
    private String jabatan;
    
    public Karyawan(String nama, char JK, long gajiPokok, String jabatan) {
        this.nama = nama;
        this.JK = JK;
        this.gajiPokok = gajiPokok;
        this.jabatan = jabatan;
    }

    public Karyawan() {
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public char getJK() {
        return JK;
    }

    public void setJK(char jK) {
        JK = jK;
    }

    public long getGajiPokok() {
        return gajiPokok;
    }

    public void setGajiPokok(long gajiPokok) {
        this.gajiPokok = gajiPokok;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }
    
    public void printKaryawan() {
        System.out.printf("Nama Karyawan: %s\nJK: %s\nGaji Pokok: %s\nJabatan: %s\n",nama,JK,gajiPokok,jabatan);
    }
}
