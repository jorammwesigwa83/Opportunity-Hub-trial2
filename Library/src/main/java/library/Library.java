package library;
import java.time.LocalDate;
import java.util.ArrayList;

public class Library {

    private final ArrayList<Book> books;
    private final ArrayList<Member> members;
    private final ArrayList<Loan> loans;

    public Library() {
        books = new ArrayList<>();
        members = new ArrayList<>();
        loans = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void registerMember(Member member) {
        members.add(member);
    }

    public void lendBook(String isbn, String memberId) {

        Book foundBook = null;
        Member foundMember = null;

        for (Book b : books) {
            if (b.getIsbn().equals(isbn)) {
                foundBook = b;
            }
        }

        for (Member m : members) {
            if (m.getMemberId().equals(memberId)) {
                foundMember = m;
            }
        }

        if (foundBook == null || foundMember == null) {
            System.out.println("Book or Member not found.");
            return;
        }

        if (!foundBook.isAvailable()) {
            System.out.println("Lending Rejected: Book already on loan.");
            return;
        }

        Loan loan = new Loan(
                foundBook,
                foundMember,
                LocalDate.now(),
                LocalDate.now().plusDays(14));

        loans.add(loan);
        foundMember.addLoan(loan);
        foundBook.setAvailable(false);

        System.out.println("Book lent successfully.");
    }

    public void returnBook(String isbn) {

        Loan activeLoan = null;

        for (Loan l : loans) {
            if (l.getBook().getIsbn().equals(isbn)) {
                activeLoan = l;
                break;
            }
        }

        if (activeLoan != null) {

            activeLoan.getBook().setAvailable(true);
            activeLoan.getMember().removeLoan(activeLoan);
            loans.remove(activeLoan);

            System.out.println("Book returned successfully.");
        } else {
            System.out.println("No active loan found.");
        }
    }

    public void searchBook(String title) {

        for (Book b : books) {

            if (b.getTitle().equalsIgnoreCase(title)) {
                System.out.println(b);
                return;
            }
        }

        System.out.println("Book not found.");
    }

    public void displayLibraryState() {

        System.out.println("\n===== BOOKS =====");

        for (Book b : books) {
            System.out.println(b);
        }

        System.out.println("\n===== MEMBERS =====");

        for (Member m : members) {
            System.out.println(m);
        }

        System.out.println("\n===== ACTIVE LOANS =====");

        for (Loan l : loans) {
            System.out.println(l);
        }
    }
}