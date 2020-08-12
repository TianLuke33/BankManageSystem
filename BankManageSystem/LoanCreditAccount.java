package BankManageSystem;

public class LoanCreditAccount extends CreditAccount implements Loanable {

    private double loanAmount;

     @Override
    public double getLoan() {
        // TODO Auto-generated method stub
        return this.loanAmount;
    }

    @Override
    public boolean payLoan(double money) {
        // TODO Auto-generated method stub
        // check balabce > loan money

        if (getBalance()>=money){
            setBalance(getBalance()-money);
            loanAmount -= money;
            return true;
        }
        return false;
    }

    @Override
    public boolean requestLoan(double money) {
        // TODO Auto-generated method stub
        this.loanAmount += money;
        return true;
    }
    
}