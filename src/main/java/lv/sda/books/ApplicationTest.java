package lv.sda.books;

import lv.sda.books.Book;
import lv.sda.books.Bookstore;
import org.testng.annotations.Test;

public class ApplicationTest {

    @Test
    public void removeBookTest(){
    }

    @Test
    public void findBookByISBN(){
        Bookstore br2 = new Bookstore();
        Book testBook = new Book("1","test","test","test","test",100,2021);
        br2.addBook(testBook);
        br2.findByIsbn("1");
    }

    @Test
    public void findBookByTitle(){

    }
}
