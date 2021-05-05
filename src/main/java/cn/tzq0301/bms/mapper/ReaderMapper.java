package cn.tzq0301.bms.mapper;

import cn.tzq0301.bms.entity.Book;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReaderMapper {
    void borrowBookByIsbn(String isbn);

    void returnBookByIsbn(String isbn);

    void renewBookByIsbn(String isbn);

    List<Book> listAllBorrowedBooksByReaderId(String readerId);
}
