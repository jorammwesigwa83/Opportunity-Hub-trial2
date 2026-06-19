package library;
import java.util.ArrayList;

public class Member {

    private final String memberId;
    private final String name;
    private final ArrayList<Loan> loans;

    public Member(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
        loans = new ArrayList<>();
    }

    public String getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Loan> getLoans() {
        return loans;
    }

    public void addLoan(Loan loan) {
        loans.add(loan);
    }

    public void removeLoan(Loan loan) {
        loans.remove(loan);
    }

    @Override
    public String toString() {
        return "Member{" +
                "ID='" + memberId + '\'' +
                ", Name='" + name + '\'' +
                ", Active Loans=" + loans.size() +
                '}';
    }

}
