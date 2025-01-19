package Model;

import java.util.List;
import java.util.Date;

public abstract class Staff extends User {
    private String nik;

    public Staff(String nama, String alamat, Date tanggalLahir, 
                String telepon, String nik) {
        super(nama, alamat, tanggalLahir, telepon);
        this.nik = nik;
    }

    public String getNik() { return nik; }
    public void setNik(String nik) { this.nik = nik; }
    
    public List<PresensiStaff> getPresensiList() {
        return null; 
    }

    @Override
    public String toString() {
        return super.toString() + "\nNIK: " + nik;
    }
}
