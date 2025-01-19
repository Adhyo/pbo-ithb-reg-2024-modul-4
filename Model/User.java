package Model;

import java.util.Date;

public abstract class User {
    private String nama;
    private String alamat;
    private Date tanggalLahir;
    private String telepon;
    
    public User(String nama, String alamat, Date tanggalLahir, String telepon) {
        this.nama = nama;
        this.alamat = alamat;
        this.tanggalLahir = tanggalLahir;
        this.telepon = telepon;
    }

    
    
    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }
    public String getAlamat() { return alamat; }
    public void setAlamat(String alamat) { this.alamat = alamat; }
    public Date getTanggalLahir() { return tanggalLahir; }
    public void setTanggalLahir(Date tanggalLahir) { this.tanggalLahir = tanggalLahir; }
    public String getTelepon() { return telepon; }
    public void setTelepon(String telepon) { this.telepon = telepon; }
    
    @Override
    public String toString() {
        return "Nama: " + nama + "\nAlamat: " + alamat + 
               "\nTanggal Lahir: " + tanggalLahir + "\nTelepon: " + telepon;
    }
}
