package lv.sda.books;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class ApplicationTest {
    @Test
    public void findByIsbnTest(){
        Bookstore bs = new Bookstore("src\\test\\resources\\TestBookList.csv");
        assertEquals(true, bs.findByIsbn("140449493"));
    }
}
