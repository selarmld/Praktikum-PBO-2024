import java.io.*;
import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        InputStreamReader p = new InputStreamReader(System.in);
        BufferedReader input = new BufferedReader(p);
        ArrayList<Stationery> dataStationery = new ArrayList<>();

        clearScreen();
        System.out.println("Selamat datang di toko stationery");
        pause(2000);

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
                    tambahData(input, dataStationery);
                    break;
                case 2:
                    displayData(input, dataStationery);
                    break;
                case 3:
                    updateData(input, dataStationery);
                    break;
                case 4:
                    deleteData(input, dataStationery);
                    break;
                case 5:
                    System.out.println("Keluar program...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Pilihan tidak ada. Silakan coba lagi.");
                    pause(2000);
                    break;
            }
        }
    }

    public static void clearScreen() {
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

    private static void pause(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void tambahData(BufferedReader input, ArrayList<Stationery> dataStationery) throws IOException {
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
            dataStationery.add(trf);
            System.out.print("Tambah data lagi? (y/n) >>> ");
            lanjut = input.readLine();
        } while (lanjut.equalsIgnoreCase("y"));
        System.out.println("Data telah ditambahkan!");
    }

    private static void displayData(BufferedReader input, ArrayList<Stationery> dataStationery) throws IOException {
        clearScreen();
        if (dataStationery.isEmpty()) {
            System.out.println("Tidak ada data untuk ditampilkan.");
            pause(2000);
            return;
        }

        System.out.printf("%-3s | %-20s | %-15s | %-20s%n", "No", "jenis", "Jumlah", "harga");
        System.out.println("-----------------------------------------------------------------");

        int nomor = 1;
        for (Stationery trf : dataStationery) {
            System.out.printf("%-3d | %-20s | %-15s | %-20s%n", nomor++, trf.getJenis(), trf.getJumlah(), trf.getHarga());
        }
        System.out.println("Tekan Enter untuk kembali ke menu utama...");
        input.readLine();
    }

    private static void updateData(BufferedReader input, ArrayList<Stationery> dataStationery) throws IOException {
        clearScreen();
        if (dataStationery.isEmpty()) {
            System.out.println("Tidak ada data untuk diperbarui.");
            return;
        }
        displayData(input, dataStationery);
        System.out.print("Masukkan nomor data yang ingin diupdate: ");
        int index = Integer.parseInt(input.readLine()) - 1;
        if (index >= 0 && index < dataStationery.size()) {
            String jenis, jumlah, harga;
            System.out.print("Masukkan jenis baru >>> ");
            jenis = input.readLine();
            System.out.print("Masukkan jumlah baru >>> ");
            jumlah = input.readLine();
            System.out.print("Masukkan harga baru >>> ");
            harga = input.readLine();

            dataStationery.get(index).setJenis(jenis);
            dataStationery.get(index).setJumlah(jumlah);
            dataStationery.get(index).setHarga(harga);
            System.out.println("Data berhasil diupdate.");
        } else {
            System.out.println("Nomor data tidak valid.");
        }
    }

    private static void deleteData(BufferedReader input, ArrayList<Stationery> dataStationery) throws IOException {
        clearScreen();
        if (dataStationery.isEmpty()) {
            System.out.println("Tidak ada data untuk dihapus.");
            return;
        }
        displayData(input, dataStationery);
        System.out.print("Masukkan nomor data yang ingin dihapus: ");
        int index = Integer.parseInt(input.readLine()) - 1;
        if (index >= 0 && index < dataStationery.size()) {
            dataStationery.remove(index);
            System.out.println("Data berhasil dihapus.");
        } else {
            System.out.println("Nomor data tidak valid.");
        }
    }
}

class Stationery {
    public String jenis;
    private String jumlah;
    protected String harga;

    public Stationery(String jenis, String jumlah, String harga) {
        this.jenis = jenis;
        this.jumlah = jumlah;
        this.harga = harga;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getJumlah() {
        return jumlah;
    }

    public void setJumlah(String jumlah) {
        this.jumlah = jumlah;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public void display() {
        System.out.printf("Jenis: %s, Jumlah: %s, Harga: %s%n", jenis, jumlah, harga);
    }
}
