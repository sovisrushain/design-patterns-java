public class PrototypePatternRealLifeDemo {
    public static void main(String[] args) {
        // Create initial documents
        WordDocument wordDoc = new WordDocument("Hello, this is a Word document.");
        PDFDocument pdfDoc = new PDFDocument("This is a PDF document.");
        SpreadsheetDocument sheetDoc = new SpreadsheetDocument(new String[][]{
                {"A1", "B1", "C1"},
                {"A2", "B2", "C2"},
                {"A3", "B3", "C3"}
        });

        // Clone documents
        Document clonedWordDoc = wordDoc.clone();
        Document clonedPdfDoc = pdfDoc.clone();
        Document clonedSheetDoc = sheetDoc.clone();

        // Print cloned documents
        clonedWordDoc.print();
        clonedPdfDoc.print();
        clonedSheetDoc.print();

        // Modify cloned documents
        System.out.println("\nModifying cloned documents...\n");
        ((WordDocument) clonedWordDoc).text = "Modified Word document.";
        ((PDFDocument) clonedPdfDoc).text = "Modified PDF document.";
        ((SpreadsheetDocument) clonedSheetDoc).data[0][0] = "ModifiedA1";

        // Print original and modified cloned documents
        System.out.println("Original Documents:");
        wordDoc.print();
        pdfDoc.print();
        sheetDoc.print();

        System.out.println("\nCloned and Modified Documents:");
        clonedWordDoc.print();
        clonedPdfDoc.print();
        clonedSheetDoc.print();
    }
}
