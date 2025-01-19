package View;

import Model.*;

import javax.swing.JOptionPane;

public class SIAView {
    public int showMainMenu() {
        String[] options = {
            "Print User Data",
            "Print Nilai Akhir",
            "Print Rata-Rata Nilai Akhir",
            "Print Mahasiswa Tidak Lulus",
            "Print Matakuliah yang Diambil",
            "Print Total Jam Mengajar Dosen",
            "Print Gaji Staff",
            "Keluar"
        };
        
        int choice = JOptionPane.showOptionDialog(
            null,
            "Pilih menu:",
            "Sistem Informasi Akademik",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.INFORMATION_MESSAGE,
            null,
            options,
            options[0]
        );
        
        return choice;
    }
    
    public String getUserInput(String prompt) {
        return JOptionPane.showInputDialog(prompt);
    }
    
    public void showUserData(User user) {
        JOptionPane.showMessageDialog(
            null,
            user.toString(),
            "User Data",
            JOptionPane.INFORMATION_MESSAGE
        );
    }
    
    public void showNilaiAkhir(Mahasiswa mhs, MataKuliah matkul, double nilaiAkhir) {
        String message = "";
        if (matkul != null) {
            message = String.format(
                "Nilai Akhir %s untuk matakuliah %s: %.2f",
                mhs.getNama(), matkul.getNama(), nilaiAkhir
            );
        } else {
            message = String.format(
                "Nilai Akhir %s: %.2f",
                mhs.getNama(), nilaiAkhir
            );
        }
        JOptionPane.showMessageDialog(
            null,
            message,
            "Nilai Akhir",
            JOptionPane.INFORMATION_MESSAGE
        );
    }
    
    public void showRataNilaiAkhir(String kodeMK, double rataNilaiAkhir) {
        JOptionPane.showMessageDialog(
            null,
            String.format("Rata-Rata Nilai Akhir untuk matakuliah %s: %.2f", kodeMK, rataNilaiAkhir),
            "Rata-Rata Nilai Akhir",
            JOptionPane.INFORMATION_MESSAGE
        );
    }
    
    public void showTidakLulus(String kodeMK, int totalTidakLulus, int totalMahasiswa) {
        JOptionPane.showMessageDialog(
            null,
            String.format("%d dari %d mahasiswa tidak lulus matakuliah %s", totalTidakLulus, totalMahasiswa, kodeMK),
            "Mahasiswa Tidak Lulus",
            JOptionPane.INFORMATION_MESSAGE
        );
    }
    
    public void showMatkulAmbil(Mahasiswa mhs) {
        StringBuilder message = new StringBuilder();
        message.append("Matakuliah yang diambil oleh ").append(mhs.getNama()).append(":\n");
        
        if (mhs instanceof MahasiswaSarjana) {
            for (MatkulAmbil ma : ((MahasiswaSarjana) mhs).getMatkulAmbil()) {
                message.append(ma.toString()).append("\n");
            }
        } else if (mhs instanceof MahasiswaMagister) {
            for (MatkulAmbil ma : ((MahasiswaMagister) mhs).getMatkulAmbil()) {
                message.append(ma.toString()).append("\n");
            }
        }
        
        JOptionPane.showMessageDialog(
            null,
            message.toString(),
            "Matakuliah yang Diambil",
            JOptionPane.INFORMATION_MESSAGE
        );
    }
    
    public void showTotalJamMengajar(Dosen dosen, int totalJamMengajar) {
        JOptionPane.showMessageDialog(
            null,
            String.format("Total jam mengajar dosen %s: %d jam", dosen.getNama(), totalJamMengajar),
            "Total Jam Mengajar",
            JOptionPane.INFORMATION_MESSAGE
        );
    }
    
    public void showGaji(Staff staff, double gaji) {
        String message = String.format("Gaji %s: Rp %.2f", staff.getNama(), gaji);
        JOptionPane.showMessageDialog(
            null,
            message,
            "Gaji Staff",
            JOptionPane.INFORMATION_MESSAGE
        );
    }
    
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(
            null,
            message,
            "Pesan",
            JOptionPane.INFORMATION_MESSAGE
        );
    }
}