package com.group.libraryapp.repository.book;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Primary
@Repository
public class BookMemoryRepository implements BookRepository{

//    private final List<Book> books = new ArrayList<Book>();

    @Override
    public void saveBook() {
        // books.add(new Book());
        System.out.println("memo !");
    }
}
