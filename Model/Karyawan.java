package Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Karyawan extends Staff {
    private double salary;
    private List<PresensiStaff> presensiList;
    
    public Karyawan(String nama, String alamat, Date tanggalLahir, 
                    String telepon, String nik, double salary) {
        super(nama, alamat, tanggalLahir, telepon, nik);
        this.salary = salary;
        this.presensiList = new ArrayList<>();
    }
    
    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }
    public void addPresensi(PresensiStaff presensi) { 
        this.presensiList.add(presensi); 
    }

    @Override
    public List<PresensiStaff> getPresensiList() {
        return presensiList;
    }

    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("\nSalary: ").append(salary);
        sb.append("\nPresensi:");
        for (PresensiStaff ps : presensiList) {
            sb.append("\n").append(ps.toString());
        }
        return sb.toString();
    }
}
