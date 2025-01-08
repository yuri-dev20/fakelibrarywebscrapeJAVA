package app.Books;

public class Book {
    private String bookName;
    private Double bookPrice;

    public Book(String bookName, Double bookPrice) {
        this.bookName = bookName;
        this.bookPrice = bookPrice;
    }

    public Double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(Double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    @Override
    public String toString() {
        return "Book: " +
                bookName +
                " £" +
                bookPrice;
    }
}
