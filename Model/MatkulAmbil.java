package Model;

import java.util.ArrayList;
import java.util.List;

public class MatkulAmbil {
    private MataKuliah matkul;
    private List<Presensi> presensiList;
    private double n1;
    private double n2;
    private double n3;
    
    public MatkulAmbil(MataKuliah matkul) {
        this.matkul = matkul;
        this.presensiList = new ArrayList<>();
    }
    
    public MataKuliah getMatkul() { return matkul; }
    public void setMatkul(MataKuliah matkul) { this.matkul = matkul; }
    
    public List<Presensi> getPresensiList() { return presensiList; }
    public void addPresensi(Presensi presensi) { 
        this.presensiList.add(presensi); 
    }
    
    public double getN1() { return n1; }
    public void setN1(double n1) { this.n1 = n1; }
    public double getN2() { return n2; }
    public void setN2(double n2) { this.n2 = n2; }
    public double getN3() { return n3; }
    public void setN3(double n3) { this.n3 = n3; }
    
    public double hitungNilaiAkhir() {
        return (n1 + n2 + n3) / 3;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(matkul.toString());
        sb.append("\nNilai: N1=").append(n1)
          .append(", N2=").append(n2)
          .append(", N3=").append(n3)
          .append(", NA=").append(hitungNilaiAkhir());
        sb.append("\nPresensi:");
        for (Presensi p : presensiList) {
            sb.append("\n  ").append(p.toString());
        }
        return sb.toString();
    }
}