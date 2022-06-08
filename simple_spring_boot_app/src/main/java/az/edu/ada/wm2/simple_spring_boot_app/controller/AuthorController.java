package az.edu.ada.wm2.simple_spring_boot_app.controller;

import az.edu.ada.wm2.simple_spring_boot_app.entity.Author;
import az.edu.ada.wm2.simple_spring_boot_app.entity.Book;
import az.edu.ada.wm2.simple_spring_boot_app.service.AuthorService;
import az.edu.ada.wm2.simple_spring_boot_app.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

@Controller
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @Autowired
    private BookService bookService;

    @GetMapping("")
    public String getAuthors(Model model){

        List<Author> authors = authorService.getAuthorList();

        model.addAttribute("authors", authors);

        return "author_list";
    }

    @GetMapping("/{id}")
    public String getAuthorById(Model model, @PathVariable Long id){
        model.addAttribute("author", authorService.getById(id));

        return "author_view";
    }

    @GetMapping("/edit/{id}")
    public String updateById(Model model, @PathVariable Long id){
        model.addAttribute("author", authorService.getById(id));

        List<Book> books = bookService.getBookList();

        model.addAttribute("books", books);

        return "author_new";
    }

    @GetMapping("/new")
    public String addNewAuthor(Model model){
        model.addAttribute("author", new Author());

        return "author_new";
    }

    @GetMapping("/back")
    public String getAuthors(){
        return "home";
    }

    @PostMapping("/save")
    public String saveChanges(Model model, Author author){
        Author updatedAuthor = authorService.save(author);

        model.addAttribute("author", updatedAuthor);

        return "author_view";
    }

    @GetMapping("/delete/{id}")
    public String deleteAuthor(@PathVariable Long id){
        authorService.deleteById(id);
        return "author_deleted";
    }

    @GetMapping("/azerbaijan")
    public String getAzeriAuthors(Model model){
        model.addAttribute("authors", authorService.getAzeriAuthors());

        return "author_list";
    }



    /*Incorrect*/
    /*@GetMapping("/book/{id}")
    public String addBook(Model model,@PathVariable Long id){
        model.addAttribute("author", authorService.getById(id));

        List<Book> books = bookService.getBookList();

        model.addAttribute("books", books);

        return "author_book";
    }*/


    /*Incorrect*/
    /*@PostMapping("/newBook/{id}/{book_id}")
    public String addBookToAuthor(@PathVariable Long id, @PathVariable Long book_id){
        authorService.addBookToAuthor(id, book_id);

        return "author_view";*/

}
