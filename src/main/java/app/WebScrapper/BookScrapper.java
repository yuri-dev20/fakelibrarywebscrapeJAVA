package app.WebScrapper;
import app.Books.Book;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BookScrapper {
    private static List<Book> bookList = new ArrayList<>();

    public static List<Book> getBookList() {
        return bookList;
    }

    // fetch and parse a HTML document from the web
    public static Document fecthData(String url) {

        try {
            return Jsoup.connect(url).get();

        } catch (IOException e) {
            System.out.println("An error ocurred: " + e.getMessage());
            return null;

        }
    }

    public static void fecthBookData(String url) {
        Document doc = fecthData(url);

        Elements el = doc.getElementsByClass("current");
        String urlCompletion = el.text().trim().substring(10);

        for (int i = 1; i <= Integer.parseInt(urlCompletion) + 1; i++) {
            Elements contents = doc.getElementsByClass("product_pod");
                /*System.out.print("Title Book: " + content.getElementsByTag("h3").text());
                System.out.println("Price: " + content.getElementsByClass("price_color").text();*/
            for (Element content : contents) {
                String bookTitle = content.getElementsByTag("a").attr("title");
                Double bookPrice = Double
                        .parseDouble(content.getElementsByClass("price_color")
                                .text()
                                .substring(1));

                bookList.add(new Book(bookTitle, bookPrice));
            }

            url = "https://books.toscrape.com/catalogue/page-" + i + ".html";
            doc = fecthData(url);
        }
        System.out.println(url);
    }

    public static List<Book> getMostCostBooks() {
        bookList = bookList.stream()
                .sorted(Comparator.comparingDouble(Book::getBookPrice).reversed())
                .collect(Collectors.toList());

        return bookList;
    }
}
