package Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Dosen extends Staff {
    private String departemen;
    private List<MatkulAjar> matkulAjar;
    
    public Dosen(String nama, String alamat, Date tanggalLahir, 
                 String telepon, String nik, String departemen) {
        super(nama, alamat, tanggalLahir, telepon, nik);
        this.departemen = departemen;
        this.matkulAjar = new ArrayList<>();
    }
    
    public String getDepartemen() { return departemen; }
    public void setDepartemen(String departemen) { 
        this.departemen = departemen; 
    }
    public List<MatkulAjar> getMatkulAjar() { return matkulAjar; }
    public void addMatkulAjar(MatkulAjar matkul) { 
        this.matkulAjar.add(matkul); 
    }
    
    public abstract double hitungGaji();
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("\nDepartemen: ").append(departemen);
        sb.append("\nMatakuliah yang diajar:");
        for (MatkulAjar ma : matkulAjar) {
            sb.append("\n").append(ma.toString());
        }
        return sb.toString();
    }
}