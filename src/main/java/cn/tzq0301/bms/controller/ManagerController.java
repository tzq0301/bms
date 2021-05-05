package cn.tzq0301.bms.controller;

import cn.tzq0301.bms.entity.Book;
import cn.tzq0301.bms.result.CommonResult;
import cn.tzq0301.bms.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author TZQ
 * @Description TODO
 */
@RestController
@RequestMapping("/manager")
public class ManagerController {
    private final ManagerService managerService;

    @Autowired
    public ManagerController(@Qualifier("managerService") ManagerService managerService) {
        this.managerService = managerService;
    }

    @GetMapping("/find/title/{title}")
    public CommonResult<Book> findBookByTitle(@PathVariable("title") String title) {
        final Book book = managerService.findBookByTitle(title);
        if (book == null) {
            return CommonResult.error(null);
        }
        return CommonResult.success(book);
    }

    @GetMapping("/find/isbn/{isbn}")
    public CommonResult<Book> findBookByIsbn(@PathVariable("isbn") String isbn) {
        final Book book = managerService.findBookByIsbn(isbn);
        if (book == null) {
            return CommonResult.error(null);
        }
        return CommonResult.success(book);
    }
}
