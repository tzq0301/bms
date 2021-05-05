package cn.tzq0301.bms.mapper;

import cn.tzq0301.bms.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookMapperTest {
    @Autowired
    BookMapper mapper;

    @Test
    void findBookByTitle() {
        final Book book = mapper.findBookByTitle("High Performance MySQL");
        assertEquals("0000000001", book.getBookId());
        assertEquals("High Performance MySQL", book.getTitle());
        assertEquals("978-7-121-19885-4", book.getIsbn());
        assertEquals("Baron Scbwartz", book.getAuthor());
        assertEquals(3, book.getTotalAmount());
        assertEquals(1, book.getLeftAmount());
        assertEquals(new BigDecimal(128), book.getPrice());
    }

    @Test
    void findBookByIsbn() {
        final Book book = mapper.findBookByIsbn("978-7-121-19885-4");
        assertEquals("0000000001", book.getBookId());
        assertEquals("High Performance MySQL", book.getTitle());
        assertEquals("978-7-121-19885-4", book.getIsbn());
        assertEquals("Baron Scbwartz", book.getAuthor());
        assertEquals(3, book.getTotalAmount());
        assertEquals(1, book.getLeftAmount());
        assertEquals(new BigDecimal(128), book.getPrice());
    }

    @Test
    void listAllBorrowableBooks() {
        final List<Book> books = mapper.listAllBorrowableBooks();
        books.forEach(System.out::println);
    }

    @Test
    void listBorrowedBooks() {
        final List<Book> books = mapper.listBorrowedBooks();
        books.forEach(System.out::println);
    }

    @Test
    void listAllBooks() {
        final List<Book> books = mapper.listAllBooks();
        books.forEach(System.out::println);
    }

    @Test
    void countBookTotalAmountByIsbn() {
        assertEquals(1, mapper.countBookAmountByIsbn("978-7-121-19885-4"));
        assertEquals(1, mapper.countBookAmountByIsbn("978-7-111-59971-5"));
        assertEquals(1, mapper.countBookAmountByIsbn("978-7-111-37004-8"));
    }

    @Test
    @Transactional
    void saveBook() {
        final Book newBook = new Book("0000000004", "Modern Java in Action", "978-7-115-52148-4",
                "Raoul-Gabriel Urma", "Posts & Telecom Press", 4, 4, new BigDecimal(119));
        mapper.saveBook(newBook);

        final Book book = mapper.findBookByTitle("Modern Java in Action");
        assertEquals("0000000004", book.getBookId());
        assertEquals("Modern Java in Action", book.getTitle());
        assertEquals("978-7-115-52148-4", book.getIsbn());
        assertEquals("Raoul-Gabriel Urma", book.getAuthor());
        assertEquals(4, book.getTotalAmount());
        assertEquals(4, book.getLeftAmount());
        assertEquals(new BigDecimal(119), book.getPrice());
    }

    @Test
    @Transactional
    void removeBookByIsbn() {

    }

    @Test
    void countBookLeftAmountByIsbn() {
        assertEquals(1, mapper.countBookLeftAmountByIsbn("978-7-121-19885-4"));
        assertEquals(5, mapper.countBookLeftAmountByIsbn("978-7-111-59971-5"));
    }

    @Test
    @Transactional
    void updateBookLeftAmountByIsbn() {
        assertEquals(5, mapper.countBookLeftAmountByIsbn("978-7-111-59971-5"));
        mapper.updateBookLeftAmountByIsbn("978-7-111-59971-5", 2);
        assertEquals(3, mapper.countBookLeftAmountByIsbn("978-7-111-59971-5"));
    }
}