package pojo;

/**
 *
 * @author Kevin
 */
public class Book {

    private long id;
    private String semester;
    private String email;
    private String course;
    private String isbn;
    private int amount;

    public Book() {
        id = 0;
        semester = "none";
        email = "none";
        course = "none";
        isbn = "none";
        amount = 0;
    }

    public Book(long id, String semester, String email, String course, String isbn, int amount) {
        this.id = id;
        this.semester = semester;
        this.email = email;
        this.course = course;
        this.isbn = isbn;
        this.amount=amount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    
    public int getAmount() {
        return amount;
    }
    
    public void setAmount(int amount){
        this.amount=amount;
    }

    @Override
    public String toString() {
        return (id + ", " + semester + ", " + email + ", " + course + ", " + isbn + ", " + amount);
    }
}
