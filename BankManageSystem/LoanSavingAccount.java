package BankManageSystem;

public class LoanSavingAccount extends SavingAccount implements Loanable {

    private double loanAmount; // sum for loan

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