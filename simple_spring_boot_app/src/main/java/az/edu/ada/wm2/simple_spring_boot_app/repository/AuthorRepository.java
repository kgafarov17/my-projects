package az.edu.ada.wm2.simple_spring_boot_app.repository;

import az.edu.ada.wm2.simple_spring_boot_app.entity.Author;
/*import az.edu.ada.wm2.simple_spring_boot_app.entity.Book;*/
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository extends CrudRepository <Author, Long>{
    /*Optional<Author> findByBFirstNameAndCLastName(String bFirstName, String cLastName);*/
    Optional<Author> findById(Long id);

    void deleteById(Long id);

    @Query("SELECT a FROM Author a WHERE a.country LIKE '%Azerbaijan%'")
    Iterable<Author> getAzeriAuthors();

    @Query(value= "INSERT INTO BOOK_INFO VALUES (?1,?2)", nativeQuery = true)
    String insertBookToAuthor(Long author_id, Long book_id);
}
