package BankManageSystem;

public class SavingAccount extends Account {
    public boolean withdraw(double money){
        if(getBalance() >= money){
            setBalance(getBalance()-money);
            return true;
        }
        return false;
    }

}