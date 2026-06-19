package library;
import java.time.LocalDate;

public class Loan {

    private final Book book;
    private final Member member;
    private final LocalDate borrowDate;
    private final LocalDate dueDate;

    public Loan(Book book, Member member,
            LocalDate borrowDate,
            LocalDate dueDate) {

        this.book = book;
        this.member = member;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
    }

    public Book getBook() {
        return book;
    }

    public Member getMember() {
        return member;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "Book=" + book.getTitle() +
                ", Member=" + member.getName() +
                ", BorrowDate=" + borrowDate +
                ", DueDate=" + dueDate +
                '}';
    }
}