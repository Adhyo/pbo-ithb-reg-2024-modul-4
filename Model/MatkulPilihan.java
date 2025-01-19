package Model;

public class MatkulPilihan extends MataKuliah {
    private int minimumMahasiswa;
    
    public MatkulPilihan(String kode, int sks, String nama, int minimumMahasiswa) {
        super(kode, sks, nama);
        this.minimumMahasiswa = minimumMahasiswa;
    }
    
    public int getMinimumMahasiswa() { return minimumMahasiswa; }
    public void setMinimumMahasiswa(int minimumMahasiswa) { 
        this.minimumMahasiswa = minimumMahasiswa; 
    }
    
    @Override
    public String toString() {
        return super.toString() + ", Minimum Mahasiswa: " + minimumMahasiswa;
    }
}