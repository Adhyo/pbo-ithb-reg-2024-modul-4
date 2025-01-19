package Model;

import java.util.Date;

public class Presensi {
    private Date tanggal;
    private boolean hadir;

    public Presensi(Date tanggal, boolean hadir) {
        this.tanggal = tanggal;
        this.hadir = hadir;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public boolean isHadir() {
        return hadir;
    }

    public void setHadir(boolean hadir) {
        this.hadir = hadir;
    }

    @Override
    public String toString() {
        return "Tanggal: " + tanggal + ", Hadir: " + (hadir ? "Ya" : "Tidak");
    }
}

