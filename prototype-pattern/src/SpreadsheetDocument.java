public class SpreadsheetDocument implements Document {
    public String[][] data;

    public SpreadsheetDocument(String[][] data) {
        this.data = data;
    }

    @Override
    public Document clone() {
        // Deep copy for the array
        String[][] clonedData = new String[data.length][];
        for (int i = 0; i < data.length; i++) {
            clonedData[i] = data[i].clone();
        }
        return new SpreadsheetDocument(clonedData);
    }

    @Override
    public void print() {
        System.out.println("Spreadsheet Document Content:");
        for (String[] row : data) {
            for (String cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}
