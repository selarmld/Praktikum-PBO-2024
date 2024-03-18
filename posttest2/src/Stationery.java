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

    public void display() {
        System.out.printf("Jenis: %s, Jumlah: %s, Harga: %s%n", jenis, jumlah, harga);
    }
}
