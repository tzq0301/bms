package cn.tzq0301.bms.service;

import cn.tzq0301.bms.entity.Book;

import java.math.BigDecimal;
import java.util.List;

public interface ReaderService {
    void borrowBookByIsbn(String isbn);

    void returnBookByIsbn(String isbn);

    void renewBookByIsbn(String isbn);

    Book findBookByTitle(String title);

    Book findBookByIsbn(String isbn);

    List<Book> listAllBorrowableBooks();

    List<Book> listAllBooks();

    List<Book> listAllBorrowedBooksByReaderId(String readerId);

    BigDecimal findDebtByReaderId(String readerId);
}
