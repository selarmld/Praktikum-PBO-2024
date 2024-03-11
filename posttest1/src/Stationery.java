public class Stationery {
    private String jenis;
    private String jumlah;
    private String harga;

    Stationery (String jenis, String jumlah, String harga) {
        this.jenis = jenis;
        this.jumlah = jumlah;
        this.harga = harga;
    }

    public String getjenis() {
        return jenis;
    }

    public String getjumlah() {
        return jumlah;
    }

    public String getharga() {
        return harga;
    }

    public void display() {
        System.out.printf("jenis: %s, jumlah: %s, harga: %s%n", jenis, jumlah, harga);
    }
}
    
