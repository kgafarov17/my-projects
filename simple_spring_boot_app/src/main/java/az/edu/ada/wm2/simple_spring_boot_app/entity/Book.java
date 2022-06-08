package az.edu.ada.wm2.simple_spring_boot_app.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Book {
    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="BOOK_NAME")
    private String a_bookName;
    @Column(name="BOOK_GENRE")
    private String bookGenre;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private  Author author;

    public Book() {
    }

    public Book(String a_bookName, String bookGenre) {
        this.a_bookName = a_bookName;
        this.bookGenre = bookGenre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getA_bookName() {
        return a_bookName;
    }

    public void setA_bookName(String a_bookName) {
        this.a_bookName = a_bookName;
    }

    public String getBookGenre() {
        return bookGenre;
    }

    public void setBookGenre(String bookGenre) {
        this.bookGenre = bookGenre;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
