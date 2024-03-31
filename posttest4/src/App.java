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
        String lanjut = "y"; 
        do {
            System.out.println("\nTambah Data");
            System.out.println("1. Alat Tulis");
            System.out.println("2. Alat Menggambar");
            System.out.print("Pilih jenis alat (1/2): ");
            int jenisAlat;
            try {
                jenisAlat = Integer.parseInt(input.readLine());
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid. Masukkan nomor 1 atau 2.");
                continue; 
            }
    
            String jenis, jumlah, harga;
            if (jenisAlat == 1) {
                jenis = "Alat Tulis";
                System.out.print("Masukkan nama alat tulis : ");
                String ATK = input.readLine();
                jumlah = promptInput(input, "Masukkan jumlah: ");
                harga = promptInput(input, "Masukkan harga: ");
                AlatTulis alatTulis = new AlatTulis(jenis, jumlah, harga, ATK);
                dataStationery.add(alatTulis);
            } else if (jenisAlat == 2) {
                jenis = "Alat Menggambar";
                System.out.print("Masukkan nama alat menggambar: ");
                String AMM = input.readLine();
                jumlah = promptInput(input, "Masukkan jumlah: ");
                harga = promptInput(input, "Masukkan harga: ");
                AlatMenggambar alatMenggambar = new AlatMenggambar(jenis, jumlah, harga, AMM);
                dataStationery.add(alatMenggambar);
            } else {
                System.out.println("Pilihan tidak valid.");
                continue; 
            }
    
            System.out.print("Tambah data lagi? (y/n) >>> ");
            lanjut = input.readLine();
        } while (lanjut.equalsIgnoreCase("y")); // Ensure lanjut is initialized before the loop
        System.out.println("Data telah ditambahkan!");
    }
    
    private static String promptInput(BufferedReader input, String prompt) throws IOException {
        String inputString;
        do {
            System.out.print(prompt);
            inputString = input.readLine().trim();
        } while (inputString.isEmpty());
        return inputString;
    }

    // private static void displayData(BufferedReader input, ArrayList<Stationery> dataStationery) throws IOException {
    //     clearScreen();
    //     if (dataStationery.isEmpty()) {
    //         System.out.println("Tidak ada data untuk ditampilkan.");
    //         pause(2000);
    //         return;
    //     }
    
    //     System.out.printf("%-3s | %-20s | %-15s | %-20s | %-20s%n", "No", "Jenis", "Jumlah", "Harga", "Keterangan");
    //     System.out.println("-----------------------------------------------------------------------------------");
    
    //     int nomor = 1;
    //     for (Stationery stationery : dataStationery) {
    //         stationery.display(null, null);
    //     }
    //     System.out.println("Tekan Enter untuk kembali ke menu utama...");
    //     input.readLine();
    // }

    private static void displayData(BufferedReader input, ArrayList<Stationery> dataStationery) throws IOException {
        clearScreen();
        if (dataStationery.isEmpty()) {
            System.out.println("Tidak ada data untuk ditampilkan.");
            pause(2000);
            return;
        }

        System.out.printf("%-3s | %-20s | %-15s | %-20s | %-20s%n", "No", "Jenis", "Jumlah", "Harga", "Keterangan");
        System.out.println("-----------------------------------------------------------------------------------");

        int nomor = 1;
        for (Stationery stationery : dataStationery) {
            String jenis = "";
            if (stationery instanceof AlatTulis) {
                jenis = "Alat Tulis";
            } else if (stationery instanceof AlatMenggambar) {
                jenis = "Alat Menggambar";
            }

            String keterangan = "";
            if (stationery instanceof AlatTulis) {
                keterangan = ((AlatTulis) stationery).getWritingTool();
            } else if (stationery instanceof AlatMenggambar) {
                keterangan = ((AlatMenggambar) stationery).getDrawingTools();
            }

            System.out.printf("%-3d | %-20s | %-15s | %-20s | %-20s%n", nomor++, jenis, stationery.getJumlah(), stationery.getHarga(), keterangan);
        }
        System.out.println("Tekan Enter untuk kembali ke menu utama...");
        input.readLine(); // Perhatikan bahwa input harus dideklarasikan sebagai variabel kelas atau dideklarasikan sebagai variabel lokal di dalam metode main
    }    

    private static void updateData(BufferedReader input, ArrayList<Stationery> dataStationery) throws IOException {
        clearScreen();
        if (dataStationery.isEmpty()) {
            System.out.println("Tidak ada data untuk diperbarui.");
            return;
        }
        displayData(input, dataStationery);
        System.out.print("Masukkan nomor data yang ingin diupdate: ");
        int index;
        try {
            index = Integer.parseInt(input.readLine()) - 1;
        } catch (NumberFormatException e) {
            System.out.println("Input tidak valid. Masukkan nomor data.");
            return;
        }
        if (index >= 0 && index < dataStationery.size()) {
            Stationery selectedStationery = dataStationery.get(index);
            String jumlah, harga;
            System.out.print("Masukkan jumlah baru >>> ");
            jumlah = input.readLine();
            System.out.print("Masukkan harga baru >>> ");
            harga = input.readLine();
    
            selectedStationery.setJumlah(jumlah);
            selectedStationery.setHarga(harga);
    
            if (selectedStationery instanceof AlatTulis) {
                System.out.print("Masukkan alat tulis baru >>> ");
                ((AlatTulis) selectedStationery).setWritingTool(input.readLine());
            } else if (selectedStationery instanceof AlatMenggambar) {
                System.out.print("Masukkan alat menggambar baru >>> ");
                ((AlatMenggambar) selectedStationery).setDrawingTools(input.readLine());
            }
    
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
    private String jenis;
    private String jumlah;
    private String harga;

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

    public void display(String writingTool, String drawingTools) {
        System.out.printf("Jenis: %s, Jumlah: %s, Harga: %s%n", jenis, jumlah, harga);
    }
}

class AlatTulis extends Stationery {
    private String writingTool;

    public AlatTulis(String jenis, String jumlah, String harga, String writingTool) {
        super(jenis, jumlah, harga);
        this.writingTool = writingTool;
    }

    public String getWritingTool() {
        return writingTool;
    }

    public void setWritingTool(String writingTool) {
        this.writingTool = writingTool;
    }
}

class AlatMenggambar extends Stationery {
    private String drawingTools;

    public AlatMenggambar(String jenis, String jumlah, String harga, String drawingTools) {
        super(jenis, jumlah, harga);
        this.drawingTools = drawingTools;
    }

    public String getDrawingTools() {
        return drawingTools;
    }

    public void setDrawingTools(String drawingTools) {
        this.drawingTools = drawingTools;
    }
}
