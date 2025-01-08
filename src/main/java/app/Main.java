package app;
import app.Books.Book;
import app.WebScrapper.BookScrapper;

public class Main {
    public static void main(String[] args) {
        System.out.println("Web Scrapping");
        String url = "https://books.toscrape.com/catalogue/page-1.html";

        BookScrapper.fecthBookData(url);
        for (Book b : BookScrapper.getMostCostBooks()) {
            System.out.println(b);
        }
    }
}
