package BankManageSystem;

public interface Loanable {

    // loan
    boolean requestLoan(double money);

    // return
    boolean payLoan(double money);

    // get loan information
    double getLoan();
}