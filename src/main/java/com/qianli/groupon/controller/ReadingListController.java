package com.qianli.groupon.controller;

import com.qianli.groupon.modle.Book;
import com.qianli.groupon.service.ReadingListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author meng
 * @create 2017-07-24 22:47
 */

@Controller
@RequestMapping(value = "/readingList")
public class ReadingListController {

    @Autowired
    private ReadingListService readingListService;

    @GetMapping(value = "/{reader}")
    public String readersBooks(@PathVariable("reader") String reader, Model model) {
        List<Book> readingList = readingListService.findByReader(reader);
        if (readingList != null) {
            model.addAttribute("books", readingList);
        }
        return "readingList";
    }

    @PostMapping(value = "/{reader}")
    public String addToReadingList(@PathVariable("reader") String reader, Book book) {
        book.setReader(reader);
        readingListService.saveBook(book);
        return "redirect:/readingList/{reader}";
    }
}
