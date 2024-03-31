public class Stationery {
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

    // Overloading method display() dengan parameter yang berbeda
    public void display() {
        System.out.printf("Jenis: %s, Jumlah: %s, Harga: %s%n", jenis, jumlah, harga);
    }

    // Overloading method display() dengan tambahan parameter writingTool
    public void display(String writingTool) {
        System.out.printf("Jenis: %s, Jumlah: %s, Harga: %s, Alat Tulis: %s%n", jenis, jumlah, harga, writingTool);
    }

    // Overloading method display() dengan tambahan parameter drawingTools
    public void display(int drawingTools) {
        System.out.printf("Jenis: %s, Jumlah: %s, Harga: %s, Alat Menggambar: %d%n", jenis, jumlah, harga, drawingTools);
    }
}
