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

    @Override
    public void displayDetails() {
        System.out.printf("%-20s | %-15s | %-20s | %-20s%n", getJenis(), getJumlah(), getHarga(), getWritingTool());
    }
}
