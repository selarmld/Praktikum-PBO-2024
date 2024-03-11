import java.io.*;
import java.util.*;

public class App {
    private static InputStreamReader p = new InputStreamReader(System.in);
    private static BufferedReader input = new BufferedReader(p);
    private static ArrayList<Stationery> DataStationery = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        clearScreen();
        System.out.println("Selamat datang di toko stationery");
        Thread.sleep(2000); // Beri jeda 2 detik sebelum menampilkan menu

        while (true) {
            clearScreen();
            System.out.println("\nMenu Utama");
            System.out.println("1. Tambah Data stationery");
            System.out.println("2. Tampilkan Data Stationery");
            System.out.println("3. Update Data Stationery");
            System.out.println("4. Hapus Data Stationery");
            System.out.println("5. Keluar");
            System.out.print("Masukkan pilihan >>> ");
            int pilihan = Integer.parseInt(input.readLine());

            switch (pilihan) {
                case 1:
                    tambahData();
                    break;
                case 2:
                    displayData();
                    break;
                case 3:
                    updateData();
                    break;
                case 4:
                    deleteData();
                    break;
                case 5:
                    System.out.println("Keluar program...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Pilihan tidak ada. Silakan coba lagi.");
                    Thread.sleep(2000); // Beri jeda sebelum membersihkan layar
                    break;
            }
        }
    }

    private static void clearScreen() {
        try {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            System.out.println("Error clearing screen: " + e.getMessage());
        }
    }

    static void tambahData() throws IOException {
        clearScreen();
        String lanjut;
        do {
            System.out.println("\nTambah Data");
            String jenis = "", jumlah = "", harga = "";

            while (jenis.trim().isEmpty()) {
                System.out.print("Masukkan jenis alat tulis>>> ");
                jenis = input.readLine();
                if (jenis.trim().isEmpty()) {
                    System.out.println("jenis tidak boleh kosong.");
                }
            }

            while (jumlah.trim().isEmpty()) {
                System.out.print("Masukkan jumlah>>> ");
                jumlah = input.readLine();
                if (jumlah.trim().isEmpty()) {
                    System.out.println("jumlah tidak boleh kosong.");
                }
            }

            while (harga.trim().isEmpty()) {
                System.out.print("Masukkan harga >>> ");
                harga = input.readLine();
                if (harga.trim().isEmpty()) {
                    System.out.println("harga tidak boleh kosong.");
                }
            }

            Stationery trf = new Stationery(jenis, jumlah, harga);
            DataStationery.add(trf);
            System.out.print("Tambah data lagi? (y/n) >>> ");
            lanjut = input.readLine();
        } while (lanjut.equalsIgnoreCase("y"));
        System.out.println("Data telah ditambahkan!");
    }

    static void displayData() throws IOException {
        clearScreen();
        if (DataStationery.isEmpty()) {
            System.out.println("Tidak ada data untuk ditampilkan.");
            return;
        }

        System.out.printf("%-3s | %-20s | %-15s | %-20s%n", "No", "jenis", "Jumlah", "harga");
        System.out.println("-----------------------------------------------------------------");

        int nomor = 1;
        for (Stationery trf : DataStationery) {
            System.out.printf("%-3d | %-20s | %-15s | %-20s%n", nomor++, trf.getjenis(), trf.getJumlah(), trf.getharga());
        }
        System.out.println("Tekan Enter untuk kembali ke menu utama...");
        input.readLine();
    }

    static void updateData() throws IOException {
        clearScreen();
        if (DataStationery.isEmpty()) {
            System.out.println("Tidak ada data untuk diperbarui.");
            return;
        }
        displayData();
        System.out.print("Masukkan nomor data yang ingin diupdate: ");
        int index = Integer.parseInt(input.readLine()) - 1;
        if (index >= 0 && index < DataStationery.size()) {
            String jenis, jumlah, harga;
            System.out.print("Masukkan jenis baru >>> ");
            jenis = input.readLine();
            System.out.print("Masukkan jumlah baru >>> ");
            jumlah = input.readLine();
            System.out.print("Masukkan harga baru >>> ");
            harga = input.readLine();

            Stationery stt = new Stationery(jenis, jumlah, harga);
            DataStationery.set(index, stt);
            System.out.println("Data berhasil diupdate.");
        } else {
            System.out.println("Nomor data tidak valid.");
        }
    }

    static void deleteData() throws IOException {
        clearScreen();
        if (DataStationery.isEmpty()) {
            System.out.println("Tidak ada data untuk dihapus.");
            return;
        }
        displayData();
        System.out.print("Masukkan nomor data yang ingin dihapus: ");
        int index = Integer.parseInt(input.readLine()) - 1;
        if (index >= 0 && index < DataStationery.size()) {
            DataStationery.remove(index);
            System.out.println("Data berhasil dihapus.");
        } else {
            System.out.println("Nomor data tidak valid.");
        }
    }
}

class Stationery {
    private String jenis;
    private String jumlah;
    private String harga;

    public Stationery(String jenis, String jumlah, String harga) {
        this.jenis = jenis;
        this.jumlah = jumlah;
        this.harga = harga;
    }

    public String getjenis() {
        return jenis;
    }

    public String getJumlah() {
        return jumlah;
    }

    public String getharga() {
        return harga;
    }
}
