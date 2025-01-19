package Model;

import java.util.ArrayList;
import java.util.List;

public class MatkulAjar {
    private MataKuliah matkul;
    private List<PresensiStaff> presensiList;
    
    public MatkulAjar(MataKuliah matkul) {
        this.matkul = matkul;
        this.presensiList = new ArrayList<>();
    }
    
    public MataKuliah getMatkul() { return matkul; }
    public void setMatkul(MataKuliah matkul) { this.matkul = matkul; }
    
    public List<PresensiStaff> getPresensiList() { return presensiList; }
    public void addPresensi(PresensiStaff presensi) { 
        this.presensiList.add(presensi); 
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(matkul.toString());
        sb.append("\nPresensi Staff:");
        for (PresensiStaff p : presensiList) {
            sb.append("\n  ").append(p.toString());
        }
        return sb.toString();
    }
}
