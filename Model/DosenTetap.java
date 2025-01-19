package Model;

import java.util.Date;

public class DosenTetap extends Dosen {
    private double salary;
    
    public DosenTetap(String nama, String alamat, Date tanggalLahir, 
                      String telepon, String nik, String departemen, double salary) {
        super(nama, alamat, tanggalLahir, telepon, nik, departemen);
        this.salary = salary;
    }
    
    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }
    
    @Override
    public double hitungGaji() {
        return salary;
    }
    
    @Override
    public String toString() {
        return super.toString() + "\nSalary: " + salary;
    }
}