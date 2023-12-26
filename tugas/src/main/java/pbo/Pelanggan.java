package tugas.src.main.java.pbo;

public class Pelanggan {
    private String namaPelanggan;
    private String noHp;
    private String alamat;

    public Pelanggan(String namaPelanggan, String noHp, String alamat) {
        this.namaPelanggan = namaPelanggan;
        this.noHp = noHp;
        this.alamat = alamat;
    }

    public String getNamaPelanggan() {
        return namaPelanggan;
    }

    public String getNoHp() {
        return noHp;
    }

    public String getAlamat() {
        return alamat;
    }
}