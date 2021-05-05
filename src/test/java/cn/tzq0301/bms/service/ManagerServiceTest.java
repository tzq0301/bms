package cn.tzq0301.bms.service;

import cn.tzq0301.bms.entity.Book;
import cn.tzq0301.bms.mapper.BookMapper;
import org.apache.catalina.Manager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ManagerServiceTest {
    @Autowired
    ManagerService managerService;

    @Autowired
    BookMapper bookMapper;

    @Test
    void findBookByTitle() {
    }

    @Test
    void findBookByIsbn() {
    }

    @Test
    void listAllBorrowableBooks() {
    }

    @Test
    void listBorrowedBooks() {
    }

    @Test
    void listAllBooks() {
    }

    @Test
    @Transactional
    void saveBook() {
        final Book newBook = new Book("0000000004", "Modern Java in Action", "978-7-115-52148-4",
                "Raoul-Gabriel Urma", "Posts & Telecom Press", 4, 4, new BigDecimal(119));

        assertEquals(1, managerService.saveBook(newBook));

        final Book book = managerService.findBookByTitle("Modern Java in Action");
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
        String isbn = "978-7-111-59971-5";
        assertEquals(1, managerService.removeBookByIsbn(isbn));
    }

    @Test
    @Transactional
    void updateBookTitleByIsbn() {
        assertEquals(0, managerService.updateBookLeftAmountByIsbn("978-7-111-59971-5", 6));
        assertEquals(5, bookMapper.countBookLeftAmountByIsbn("978-7-111-59971-5"));
    }

    @Test
    void findDebtByReaderId() {
    }

    @Test
    void findReaderByReaderId() {
    }

    @Test
    void listAllReaders() {
    }

    @Test
    void saveReader() {
    }

    @Test
    void deleteReaderByReaderId() {
    }

    @Test
    void updateReaderNameByReaderId() {
    }

    @Test
    void updateReaderDebtByReaderId() {
    }
}