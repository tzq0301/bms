package cn.tzq0301.bms.service.impl;

import cn.tzq0301.bms.entity.Book;
import cn.tzq0301.bms.mapper.BookMapper;
import cn.tzq0301.bms.mapper.CommonMapper;
import cn.tzq0301.bms.mapper.ReaderMapper;
import cn.tzq0301.bms.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author TZQ
 * @Description TODO
 */
@Service("readerService")
public class ReaderServiceImpl implements ReaderService {
    private final ReaderMapper readerMapper;
    private final BookMapper bookMapper;
    private final CommonMapper commonMapper;

    @Autowired
    public ReaderServiceImpl(
            @Qualifier("readerMapper") ReaderMapper readerMapper,
            @Qualifier("bookMapper") BookMapper bookMapper,
            @Qualifier("commonMapper") CommonMapper commonMapper) {
        this.readerMapper = readerMapper;
        this.bookMapper = bookMapper;
        this.commonMapper = commonMapper;
    }

    @Override
    public void borrowBookByIsbn(String isbn) {
        readerMapper.borrowBookByIsbn(isbn);
    }

    @Override
    public void returnBookByIsbn(String isbn) {
        readerMapper.returnBookByIsbn(isbn);
    }

    @Override
    public void renewBookByIsbn(String isbn) {
        readerMapper.renewBookByIsbn(isbn);
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
    public List<Book> listAllBooks() {
        return bookMapper.listAllBooks();
    }

    @Override
    public List<Book> listAllBorrowedBooksByReaderId(String readerId) {
        return readerMapper.listAllBorrowedBooksByReaderId(readerId);
    }

    @Override
    public BigDecimal findDebtByReaderId(String readerId) {
        return commonMapper.findDebtByReaderId(readerId);
    }
}
