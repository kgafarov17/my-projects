package az.edu.ada.wm2.simple_spring_boot_app.controller;

import az.edu.ada.wm2.simple_spring_boot_app.bean.AuthorBean;
import az.edu.ada.wm2.simple_spring_boot_app.bean.BookBean;
import az.edu.ada.wm2.simple_spring_boot_app.entity.Author;
import az.edu.ada.wm2.simple_spring_boot_app.entity.Book;
import az.edu.ada.wm2.simple_spring_boot_app.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("")
    public String getBooks(Model model){

        List<Book> books = bookService.getBookList();

        model.addAttribute("books", books);

        return "book_list";
    }

    @GetMapping("/{id}")
    public String getBookById(Model model, @PathVariable Long id){
        model.addAttribute("book", bookService.getById(id));

        return "book_view";
    }

    @GetMapping("/edit/{id}")
    public String updateById(Model model, @PathVariable Long id){
        model.addAttribute("book", bookService.getById(id));

        return "book_new";
    }

    @GetMapping("/new")
    public String addNewBook(Model model){
        model.addAttribute("book", new Book());

        return "book_new";
    }

    @PostMapping("/save")
    public String saveChanges(Model model, Book book){
        Book updatedBook = bookService.save(book);

        model.addAttribute("book", updatedBook);

        return "book_view";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id){
        bookService.deleteById(id);
        return "book_deleted";
    }

    @GetMapping("/tragedy")
    public String getTragedies(Model model){
        model.addAttribute("books", bookService.getTragedies());

        return "book_list";
    }
}
