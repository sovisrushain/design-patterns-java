public class WordDocument implements Document {
    public String text;

    public WordDocument(String text) {
        this.text = text;
    }

    @Override
    public Document clone() {
        return new WordDocument(this.text); // Shallow copy
    }

    @Override
    public void print() {
        System.out.println("Word Document Content: " + text);
    }
}
