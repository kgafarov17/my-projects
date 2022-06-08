package az.edu.ada.wm2.simple_spring_boot_app.repository;

import az.edu.ada.wm2.simple_spring_boot_app.entity.Author;
import az.edu.ada.wm2.simple_spring_boot_app.entity.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
    Optional<Book> findById(Long id);

    void deleteById(Long id);

    @Query(value = "SELECT b FROM Book b WHERE b.bookGenre LIKE '%Tragedy%'")
    Iterable<Book> getTragedies();
}
