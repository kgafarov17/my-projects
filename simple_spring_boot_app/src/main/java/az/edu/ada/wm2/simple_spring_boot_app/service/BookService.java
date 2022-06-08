package az.edu.ada.wm2.simple_spring_boot_app.service;

import az.edu.ada.wm2.simple_spring_boot_app.bean.AuthorBean;
import az.edu.ada.wm2.simple_spring_boot_app.bean.BookBean;
import az.edu.ada.wm2.simple_spring_boot_app.entity.Author;
import az.edu.ada.wm2.simple_spring_boot_app.entity.Book;
import az.edu.ada.wm2.simple_spring_boot_app.repository.AuthorRepository;
import az.edu.ada.wm2.simple_spring_boot_app.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getBookList() {
        List<Book> books = (List<Book>) bookRepository.findAll();

        return books;
    }

    public Book getById(Long id) {
        Optional<Book> book1 = bookRepository.findById(id);

        if (book1.isPresent())
            return book1.get();


        return new Book("no", "data");
    }

    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public void deleteById(Long id) {

        bookRepository.deleteById(id);
    }

    public List<Book> getTragedies() {
        return (List<Book>) bookRepository.getTragedies();

    }
}
