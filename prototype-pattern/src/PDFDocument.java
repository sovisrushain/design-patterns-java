public class PDFDocument implements Document {
    public String text;

    public PDFDocument(String text) {
        this.text = text;
    }

    @Override
    public Document clone() {
        return new PDFDocument(this.text); // Shallow copy
    }

    @Override
    public void print() {
        System.out.println("PDF Document Content: " + text);
    }
}
