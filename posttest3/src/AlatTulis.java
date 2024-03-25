public class AlatTulis extends Stationery {
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

    @Override
    public void display() {
        System.out.printf("Jenis: %s, Jumlah: %s, Harga: %s, Alat Tulis: %s%n", getJenis(), getJumlah(), getHarga(), writingTool);
    }
}
