package az.edu.ada.wm2.simple_spring_boot_app.bean;

public class BookBean {
    private String bookName;
    private String bookGenre;

    public BookBean() {
    }

    public BookBean(String bookName, String bookGenre) {
        this.bookName = bookName;
        this.bookGenre = bookGenre;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookGenre() {
        return bookGenre;
    }

    public void setBookGenre(String bookGenre) {
        this.bookGenre = bookGenre;
    }
}
