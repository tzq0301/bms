package cn.tzq0301.bms.controller;

import cn.tzq0301.bms.entity.Book;
import cn.tzq0301.bms.result.CommonResult;
import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ManagerControllerTest {
    @Test
    void findBookByTitle(@Autowired MockMvc mockMvc) throws Exception {
        Book book = new Book("0000000001", "High Performance MySQL",
                "978-7-121-19885-4", "Baron Scbwartz", "Publishing House of Electronics Industry", 3, 1, new BigDecimal(128));
        mockMvc.perform(get("/manager/find/title/High Performance MySQL"))
                .andExpect(status().isOk())
                .andExpect(content().json(JSON.toJSONString(CommonResult.success(book))));
    }
}