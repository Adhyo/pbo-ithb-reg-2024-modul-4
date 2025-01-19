package Model;

import java.util.Date;

public class DosenHonorer extends Dosen {
    private double honorPerSKS;
    
    public DosenHonorer(String nama, String alamat, Date tanggalLahir, 
                        String telepon, String nik, String departemen, double honorPerSKS) {
        super(nama, alamat, tanggalLahir, telepon, nik, departemen);
        this.honorPerSKS = honorPerSKS;
    }
    
    public double getHonorPerSKS() { return honorPerSKS; }
    public void setHonorPerSKS(double honorPerSKS) { 
        this.honorPerSKS = honorPerSKS; 
    }
    
    @Override
    public double hitungGaji() {
        int totalSKS = 0;
        for (MatkulAjar ma : getMatkulAjar()) {
            totalSKS += ma.getMatkul().getSks();
        }
        return honorPerSKS * totalSKS;
    }
    
    @Override
    public String toString() {
        return super.toString() + "\nHonor per SKS: " + honorPerSKS;
    }
}