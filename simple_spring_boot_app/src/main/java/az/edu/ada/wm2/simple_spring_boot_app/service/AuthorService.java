package az.edu.ada.wm2.simple_spring_boot_app.service;

import az.edu.ada.wm2.simple_spring_boot_app.entity.Author;
import az.edu.ada.wm2.simple_spring_boot_app.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> getAuthorList(){
        List<Author> authors = (List<Author>) authorRepository.findAll();

        return authors;
    }

    public Author getById(Long id){
        Optional<Author> author1 = authorRepository.findById(id);

        if(author1.isPresent())
            return author1.get();


        return new Author("no", "data");
    }

    public Author save(Author author){
        return authorRepository.save(author);
    }

    public void deleteById(Long id) {

        authorRepository.deleteById(id);
    }

    public List<Author> getAzeriAuthors() {
        return (List<Author>) authorRepository.getAzeriAuthors();
    }

    /*Incorrect
    public String addBookToAuthor(Long author_id, Long book_id){
        return authorRepository.insertBookToAuthor(author_id, book_id);
    }*/
}
