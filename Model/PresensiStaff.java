package Model;

import java.util.Date;

public class PresensiStaff {
    private Date tanggal;
    private String status; 

    public PresensiStaff(Date tanggal, String status) {
        this.tanggal = tanggal;
        this.status = status;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Tanggal: " + tanggal + ", Status: " + status;
    }
}
