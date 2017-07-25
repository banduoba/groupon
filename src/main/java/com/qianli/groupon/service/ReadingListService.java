package com.qianli.groupon.service;

import com.qianli.groupon.model.Book;
import com.qianli.groupon.repository.ReadingListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author meng
 * @create 2017-07-24 22:43
 */

@Service
public class ReadingListService {
    @Autowired
    private ReadingListRepository readingListRepository;

    public List<Book> findByReader(String reader) {
        return readingListRepository.findByReader(reader);
    }

    public void saveBook(Book book) {
        readingListRepository.save(book);
    }

}
