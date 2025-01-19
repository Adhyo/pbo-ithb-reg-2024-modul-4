package Model;

import java.util.Date;

public class MahasiswaMagister extends MahasiswaSarjana {
    private String judulTesis;
    
    public MahasiswaMagister(String nama, String alamat, Date tanggalLahir, 
                            String telepon, String nim, String jurusan, String judulTesis) {
        super(nama, alamat, tanggalLahir, telepon, nim, jurusan);
        this.judulTesis = judulTesis;
    }
    
    public String getJudulTesis() { return judulTesis; }
    public void setJudulTesis(String judulTesis) { 
        this.judulTesis = judulTesis; 
    }
    
    @Override
    public String toString() {
        return super.toString() + "\nJudul Tesis: " + judulTesis;
    }
}

