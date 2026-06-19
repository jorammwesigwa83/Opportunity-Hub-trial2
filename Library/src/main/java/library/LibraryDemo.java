package library;
public class LibraryDemo {

    public static void main(String[] args) {

        Library library = new Library();

        Book b1 = new Book(
                "ISBN001",
                "Java Programming",
                "James Gosling");

        Book b2 = new Book(
                "ISBN002",
                "Database Systems",
                "Elmasri");

        Book b3 = new Book(
                "ISBN003",
                "Computer Networks",
                "Tanenbaum");

        library.addBook(b1);
        library.addBook(b2);
        library.addBook(b3);

        Member m1 = new Member("M001", "John");
        Member m2 = new Member("M002", "Sarah");

        library.registerMember(m1);
        library.registerMember(m2);

        System.out.println("INITIAL LIBRARY STATE");
        library.displayLibraryState();

        System.out.println("\n--- LENDING BOOKS ---");

        library.lendBook("ISBN001", "M001");

        library.lendBook("ISBN001", "M002");

        library.lendBook("ISBN002", "M002");

        System.out.println("\nAFTER LENDING");
        library.displayLibraryState();

        System.out.println("\n--- RETURNING BOOK ---");

        library.returnBook("ISBN001");

        System.out.println("\nFINAL LIBRARY STATE");
        library.displayLibraryState();
    }
}