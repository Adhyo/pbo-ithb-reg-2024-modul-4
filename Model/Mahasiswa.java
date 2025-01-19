package Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Mahasiswa extends User {
    private String nim;
    private String jurusan;
    private List<MatkulAmbil> matkulAmbilList;
    
    public Mahasiswa(String nama, String alamat, Date tanggalLahir, 
                    String telepon, String nim, String jurusan) {
        super(nama, alamat, tanggalLahir, telepon);
        this.nim = nim;
        this.jurusan = jurusan;
        this.matkulAmbilList = new ArrayList<>();
    }
    
    public String getNim() { return nim; }
    public void setNim(String nim) { this.nim = nim; }
    public String getJurusan() { return jurusan; }
    public void setJurusan(String jurusan) { this.jurusan = jurusan; }
    public List<MatkulAmbil> getMatkulAmbilList() {
        return matkulAmbilList;
    }

    
    @Override
    public String toString() {
        return super.toString() + "\nNIM: " + nim + "\nJurusan: " + jurusan;
    }
}

