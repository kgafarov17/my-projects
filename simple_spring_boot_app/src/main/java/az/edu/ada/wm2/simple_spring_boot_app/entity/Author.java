package az.edu.ada.wm2.simple_spring_boot_app.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;


@Entity
public class Author {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "FIRST_NAME")
    private String a_firstName; /*I put a_, b_ in front of attribute name because h2 db organizes them in alphabetic order*/
    @Column(name = "LAST_NAME")
    private String b_lastName;
    @Column(name = "COUNTRY")
    private String country;

    @OneToMany(mappedBy = "author", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Set<Book> books;

    public Author() {
    }

    public Author(String a_firstName, String b_lastName) {
        this.a_firstName = a_firstName;
        this.b_lastName = b_lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getA_firstName() {
        return a_firstName;
    }

    public void setA_firstName(String a_firstName) {
        this.a_firstName = a_firstName;
    }

    public String getB_lastName() {
        return b_lastName;
    }

    public void setB_lastName(String b_lastName) {
        this.b_lastName = b_lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
