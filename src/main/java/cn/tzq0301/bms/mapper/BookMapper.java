package cn.tzq0301.bms.mapper;

import cn.tzq0301.bms.entity.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BookMapper {
    Book findBookByTitle(@Param("title") String title);

    Book findBookByIsbn(@Param("isbn") String isbn);

    List<Book> listAllBorrowableBooks();

    List<Book> listBorrowedBooks();

    List<Book> listAllBooks();

    /**
     * Select whether the specific book had been saved into the database.
     *
     * @param isbn the isbn of the specific book
     * @return 1 if book had been saved into the database, 0 if not
     */
    int countBookAmountByIsbn(@Param("isbn") String isbn);

    void saveBook(Book book);

    long removeBookByIsbn(@Param("isbn") String isbn);

    /**
     * Remove the records in the 'borrow' table.
     *
     * @param isbn the isbn of the specific book
     */
    void removeBorrowRecordByIsbn(@Param("isbn") String isbn);

    Integer countBookLeftAmountByIsbn(@Param("isbn") String isbn);

    void updateBookLeftAmountByIsbn(@Param("isbn") String isbn, @Param("num") Integer num);
}
