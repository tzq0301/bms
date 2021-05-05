package cn.tzq0301.bms.service;

import cn.tzq0301.bms.entity.Book;
import cn.tzq0301.bms.entity.Reader;

import java.math.BigDecimal;
import java.util.List;

public interface ManagerService {
    Book findBookByTitle(String title);

    Book findBookByIsbn(String isbn);

    List<Book> listAllBorrowableBooks();

    List<Book> listBorrowedBooks();

    List<Book> listAllBooks();

    /**
     * Save book into database.
     *
     * @param book is the book to save into the database
     * @return 1 if success, 0 if fail
     */
    int saveBook(Book book);

    long removeBookByIsbn(String isbn);

    int updateBookLeftAmountByIsbn(String isbn, int num);

    BigDecimal findDebtByReaderId(String readerId);

    Reader findReaderByReaderId(String readerId);

    List<Reader> listAllReaders();

    void saveReader(Reader reader);

    void deleteReaderByReaderId(String readerId);

    void updateReaderNameByReaderId(String readerId, String newName);

    /**
     * Update the debt of the specific reader by readerId.
     *
     * @param readerId is the readerId
     * @param positiveChange will be plus to the origin debt of the specific reader
     */
    void updateReaderDebtByReaderId(String readerId, BigDecimal positiveChange);
}
