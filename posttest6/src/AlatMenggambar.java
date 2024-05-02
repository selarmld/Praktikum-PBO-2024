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

    @Override
    public void displayDetails() {
        System.out.printf("%-20s | %-15s | %-20s | %-20s%n", getJenis(), getJumlah(), getHarga(), getDrawingTools());
    }
}