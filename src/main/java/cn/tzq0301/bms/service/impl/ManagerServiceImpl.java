package cn.tzq0301.bms.service.impl;

import cn.tzq0301.bms.entity.Book;
import cn.tzq0301.bms.entity.Reader;
import cn.tzq0301.bms.mapper.BookMapper;
import cn.tzq0301.bms.mapper.CommonMapper;
import cn.tzq0301.bms.mapper.ManagerMapper;
import cn.tzq0301.bms.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author TZQ
 * @Description TODO
 */
@Service("managerService")
public class ManagerServiceImpl implements ManagerService {
    private final ManagerMapper managerMapper;
    private final BookMapper bookMapper;
    private final CommonMapper commonMapper;

    @Autowired
    public ManagerServiceImpl(
            @Qualifier("managerMapper") ManagerMapper managerMapper,
            @Qualifier("bookMapper") BookMapper bookMapper,
            @Qualifier("commonMapper") CommonMapper commonMapper) {
        this.managerMapper = managerMapper;
        this.bookMapper = bookMapper;
        this.commonMapper = commonMapper;
    }

    @Override
    public Book findBookByTitle(String title) {
        return bookMapper.findBookByTitle(title);
    }

    @Override
    public Book findBookByIsbn(String isbn) {
        return bookMapper.findBookByIsbn(isbn);
    }

    @Override
    public List<Book> listAllBorrowableBooks() {
        return bookMapper.listAllBorrowableBooks();
    }

    @Override
    public List<Book> listBorrowedBooks() {
        return bookMapper.listBorrowedBooks();
    }

    @Override
    public List<Book> listAllBooks() {
        return bookMapper.listAllBooks();
    }

    @Override
    public int saveBook(Book book) {
        // The specific book had been saved into the database.
        if (bookMapper.countBookAmountByIsbn(book.getIsbn()) == 1) {
            return 0;
        }
        bookMapper.saveBook(book);
        return 1;
    }

    @Override
    public long removeBookByIsbn(String isbn) {
        // If the specific book had not been saved into the database, no deletion is required.
        bookMapper.removeBorrowRecordByIsbn(isbn);
        return bookMapper.removeBookByIsbn(isbn);
    }

    @Override
    public int updateBookLeftAmountByIsbn(String isbn, int num) {
        if (num > bookMapper.countBookLeftAmountByIsbn(isbn)) {
            return 0;
        }
        bookMapper.updateBookLeftAmountByIsbn(isbn, num);
        return 1;
    }

    @Override
    public BigDecimal findDebtByReaderId(String readerId) {
        return commonMapper.findDebtByReaderId(readerId);
    }

    @Override
    public Reader findReaderByReaderId(String readerId) {
        return managerMapper.findReaderByReaderId(readerId);
    }

    @Override
    public List<Reader> listAllReaders() {
        return managerMapper.listAllReaders();
    }

    @Override
    public void saveReader(Reader reader) {
        managerMapper.saveReader(reader);
    }

    @Override
    public void deleteReaderByReaderId(String readerId) {
        managerMapper.deleteReaderByReaderId(readerId);
    }

    @Override
    public void updateReaderNameByReaderId(String readerId, String newName) {
        managerMapper.updateReaderNameByReaderId(readerId, newName);
    }

    @Override
    public void updateReaderDebtByReaderId(String readerId, BigDecimal positiveChange) {
        managerMapper.updateReaderDebtByReaderId(readerId, positiveChange);
    }
}
