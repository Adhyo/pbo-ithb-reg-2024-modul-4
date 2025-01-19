package Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MahasiswaSarjana extends Mahasiswa {
    private List<MatkulAmbil> matkulAmbil;
    
    public MahasiswaSarjana(String nama, String alamat, Date tanggalLahir, 
                           String telepon, String nim, String jurusan) {
        super(nama, alamat, tanggalLahir, telepon, nim, jurusan);
        this.matkulAmbil = new ArrayList<>();
    }
    
    public List<MatkulAmbil> getMatkulAmbil() { return matkulAmbil; }
    public void addMatkulAmbil(MatkulAmbil matkul) { 
        this.matkulAmbil.add(matkul); 
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("\nMatakuliah yang diambil:");
        for (MatkulAmbil ma : matkulAmbil) {
            sb.append("\n").append(ma.toString());
        }
        return sb.toString();
    }
}