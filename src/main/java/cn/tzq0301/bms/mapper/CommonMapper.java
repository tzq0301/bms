package cn.tzq0301.bms.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;

@Mapper
public interface CommonMapper {
    BigDecimal findDebtByReaderId(String readerId);
}
