package BankManageSystem;

public class CreditAccount extends Account {

    private double ceiling; // ceiling for credit
    @Override
    public boolean withdraw(double money) {
        /*
         * withdraw money <= balance+ceiling
         * 
         * Assume: balance 5000, ceiling 10,000
         * 
         * withdraw 3000
         * 
         * balance 2000, celing 10,000
         * 
         * withdraw 5000
         * 
         * balance -3000, ceiling 10,000
         */

         if(getBalance()+ceiling>=money){
             setBalance(getBalance()-money);
         }
        return false;
    }

    public double getCeiling() {
        return ceiling;
    }

    public void setCeiling(double ceiling) {
        this.ceiling = ceiling;
    }
    
    
}