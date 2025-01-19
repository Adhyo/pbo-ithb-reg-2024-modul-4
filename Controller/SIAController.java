package Controller;

import Model.*;
import View.SIAView;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SIAController {
    public static List<User> users = new ArrayList<>();
    private SIAView view;
    
    public SIAController() {
        this.view = new SIAView();
    }
    
    public void run() {
        int choice;
        do {
            choice = view.showMainMenu();
            switch (choice) {
                case 0:
                    printUserData();
                    break;
                case 1:
                    printNilaiAkhir();
                    break;
                case 2:
                    printRataNilaiAkhir();
                    break;
                case 3:
                    printTidakLulus();
                    break;
                case 4:
                    printMatkulAmbil();
                    break;
                case 5:
                    printTotalJamMengajar();
                    break;
                case 6:
                    printGajiStaff();
                    break;
                case 7:
                    view.showMessage("Terima kasih, sampai jumpa!");
                    break;
                default:
                    view.showMessage("Pilihan tidak valid, silakan coba lagi.");
            }
        } while (choice != 7);
    }
    
    private void printUserData() {
        String nama = view.getUserInput("Masukkan nama:");
        User user = findUserByName(nama);
        System.out.println();
        if (user != null) {
            view.showUserData(user);
        } else {
            view.showMessage("User tidak ditemukan.");
        }
    }
    
    private void printNilaiAkhir() {
        String nim = view.getUserInput("Masukkan NIM:");
        String kodeMK = view.getUserInput("Masukkan Kode Matakuliah:");
        MahasiswaSarjana mhs = findMahasiswaSarjanaByNIM(nim);
        MahasiswaMagister mhsM = findMahasiswaMagisterByNIM(nim);
        MahasiswaDoktor mhsD = findMahasiswaDoktorByNIM(nim);
        
        if (mhs != null) {
            MatkulAmbil matkulAmbil = findMatkulAmbilByNIMAndKode(mhs, kodeMK);
            if (matkulAmbil != null) {
                double nilaiAkhir = matkulAmbil.hitungNilaiAkhir();
                view.showNilaiAkhir(mhs, matkulAmbil.getMatkul(), nilaiAkhir);
            } else {
                view.showMessage("Data matakuliah tidak ditemukan.");
            }
        } else if (mhsM != null) {
            MatkulAmbil matkulAmbil = findMatkulAmbilByNIMAndKode(mhsM, kodeMK);
            if (matkulAmbil != null) {
                double nilaiAkhir = matkulAmbil.hitungNilaiAkhir();
                view.showNilaiAkhir(mhsM, matkulAmbil.getMatkul(), nilaiAkhir);
            } else {
                view.showMessage("Data matakuliah tidak ditemukan.");
            }
        } else if (mhsD != null) {
            double nilaiAkhir = (mhsD.getNilaiSidang1() + mhsD.getNilaiSidang2() + mhsD.getNilaiSidang3()) / 3;
            view.showNilaiAkhir(mhsD, null, nilaiAkhir);
        } else {
            view.showMessage("Mahasiswa tidak ditemukan.");
        }
    }
    
    private void printRataNilaiAkhir() {
        String kodeMK = view.getUserInput("Masukkan Kode Matakuliah:");
        double rataNilaiAkhir = calculateAverageNilaiAkhir(kodeMK);
        view.showRataNilaiAkhir(kodeMK, rataNilaiAkhir);
    }
    
    private void printTidakLulus() {
        String kodeMK = view.getUserInput("Masukkan Kode Matakuliah:");
        int totalTidakLulus = countTidakLulus(kodeMK);
        int totalMahasiswa = countMahasiswaByKodeMK(kodeMK);
        view.showTidakLulus(kodeMK, totalTidakLulus, totalMahasiswa);
    }
    
    private void printMatkulAmbil() {
        String nim = view.getUserInput("Masukkan NIM:");
        Mahasiswa mhs = findMahasiswaByNIM(nim);
        if (mhs != null) {
            view.showMatkulAmbil(mhs);
        } else {
            view.showMessage("Mahasiswa tidak ditemukan.");
        }
    }
    
    private void printTotalJamMengajar() {
        String nik = view.getUserInput("Masukkan NIK Dosen:");
        Dosen dosen = findDosenByNIK(nik);
        if (dosen != null) {
            int totalJamMengajar = calculateTotalJamMengajar(dosen);
            view.showTotalJamMengajar(dosen, totalJamMengajar);
        } else {
            view.showMessage("Dosen tidak ditemukan.");
        }
    }
    
    private void printGajiStaff() {
        String nik = view.getUserInput("Masukkan NIK Staff:");
        Staff staff = findStaffByNIK(nik);
        if (staff != null) {
            double gaji = calculateGaji(staff);
            view.showGaji(staff, gaji);
        } else {
            view.showMessage("Staff tidak ditemukan.");
        }
    }
    
    
    private User findUserByName(String nama) {
        for (User user : users) {
            if (user.getNama().equalsIgnoreCase(nama)) {
                return user;
            }
        }
        return null;
    }
    
    private MahasiswaSarjana findMahasiswaSarjanaByNIM(String nim) {
        for (User user : users) {
            if (user instanceof MahasiswaSarjana) {
                MahasiswaSarjana mhs = (MahasiswaSarjana) user;
                if (mhs.getNim().equalsIgnoreCase(nim)) {
                    return mhs;
                }
            }
        }
        return null;
    }
    
    
    private MahasiswaMagister findMahasiswaMagisterByNIM(String nim) {
        for (User user : users) {
            if (user instanceof MahasiswaMagister) {
                MahasiswaMagister mhs = (MahasiswaMagister) user;
                if (mhs.getNim().equalsIgnoreCase(nim)) {
                    return mhs;
                }
            }
        }
        return null;
    }
    
    
    private MahasiswaDoktor findMahasiswaDoktorByNIM(String nim) {
        for (User user : users) {
            if (user instanceof MahasiswaDoktor) {
                MahasiswaDoktor mhs = (MahasiswaDoktor) user;
                if (mhs.getNim().equalsIgnoreCase(nim)) {
                    return mhs;
                }
            }
        }
        return null;
    }
    
    
    private MatkulAmbil findMatkulAmbilByNIMAndKode(Mahasiswa mhs, String kodeMK) {
        return null;
    }
    
    private Mahasiswa findMahasiswaByNIM(String nim) {
        for (User user : users) {
            if (user instanceof Mahasiswa) {
                Mahasiswa mhs = (Mahasiswa) user;
                if (mhs.getNim().equalsIgnoreCase(nim)) {
                    return mhs;
                }
            }
        }
        return null;
    }
    
    private Dosen findDosenByNIK(String nik) {
        for (User user : users) {
            if (user instanceof Dosen) {
                Dosen dosen = (Dosen) user;
                if (dosen.getNik().equalsIgnoreCase(nik)) {
                    return dosen;
                }
            }
        }
        return null;
    }
    
    private Staff findStaffByNIK(String nik) {
        for (User user : users) {
            if (user instanceof Staff) {
                Staff staff = (Staff) user;
                if (staff.getNik().equalsIgnoreCase(nik)) {
                    return staff;
                }
            }
        }
        return null;
    }
    
    private double calculateAverageNilaiAkhir(String kodeMK) {
        int count = 0;
        double totalNilai = 0.0;
        
        for (User user : users) {
            if (user instanceof Mahasiswa) {
                Mahasiswa mhs = (Mahasiswa) user;
                for (MatkulAmbil matkulAmbil : mhs.getMatkulAmbilList()) {
                    if (matkulAmbil.getMatkul().getKode().equalsIgnoreCase(kodeMK)) {
                        totalNilai += matkulAmbil.hitungNilaiAkhir();
                        count++;
                    }
                }
            }
        }
        
        return (count > 0) ? (totalNilai / count) : 0.0;
    }
    
    private int countTidakLulus(String kodeMK) {
        int count = 0;
        for (User user : users) {
            if (user instanceof Mahasiswa) {
                Mahasiswa mhs = (Mahasiswa) user;
                for (MatkulAmbil matkulAmbil : mhs.getMatkulAmbilList()) {
                    if (matkulAmbil.getMatkul().getKode().equalsIgnoreCase(kodeMK) && matkulAmbil.hitungNilaiAkhir() < 56) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private int countMahasiswaByKodeMK(String kodeMK) {
        int count = 0;
        for (User user : users) {
            if (user instanceof Mahasiswa) {
                Mahasiswa mhs = (Mahasiswa) user;
                for (MatkulAmbil matkulAmbil : mhs.getMatkulAmbilList()) {
                    if (matkulAmbil.getMatkul().getKode().equalsIgnoreCase(kodeMK)) {
                        count++;
                        break;
                    }
                }
            }
        }
        return count;
    }
    
    private int calculateTotalJamMengajar(Dosen dosen) {
        int totalJam = 0;
        for (MatkulAjar matkul : dosen.getMatkulAjar()) {
            for (PresensiStaff presensi : matkul.getPresensiList()) {
                if ("Hadir".equalsIgnoreCase(presensi.getStatus())) {
                    totalJam += matkul.getMatkul().getSks();
                }
            }
        }
        return totalJam;
    }
    
    private double calculateGaji(Staff staff) {
        int unit = 0;
        for (PresensiStaff presensi : staff.getPresensiList()) {
            if ("Hadir".equalsIgnoreCase(presensi.getStatus())) {
                unit++;
            }
        }
        
        if (staff instanceof Karyawan) {
            return (unit / 22.0) * ((Karyawan) staff).getSalary();
        } else if (staff instanceof DosenTetap) {
            return ((DosenTetap) staff).getSalary() + (unit * 25000);
        } else if (staff instanceof DosenHonorer) {
            return unit * ((DosenHonorer) staff).getHonorPerSKS();
        }
        return 0.0;
    }
}