package cn.tzq0301.bms.mapper;

import cn.tzq0301.bms.entity.Reader;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface ManagerMapper {
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
