package BankManageSystem;

public class Bank {
    static Account[] accounts = new Account[100];

    static int index = 0;

    /*
     * Open account
     */
    public static boolean register(Account account){
        if(index < accounts.length){
            accounts[index++] = account;
            return true;
        }
        return false;
    }

    /*
     * Log in
     */
    public static Account login(long id, String password){
        for(int i = 0;i<index;i++){
            if(accounts[i].getId()==id && accounts[i].getPassword().equals(password)){
                return accounts[i];
            }
        }
        return null;
    }

      /*
       * sum loan money
       */
    public static double getTotalLoan(){
        double sum=0;
        for(int i = 0;i<index;i++){
            if(accounts[i] instanceof Loanable){
                Loanable loan=(Loanable)accounts[i];
                sum+=loan.getLoan();
            }
        }
        return sum;
    }
    /*
     * Query account through account ID
     * check whether this account is exist or not
     */
    public static Account findById(long id){
        for(int i=0;i<index;i++){
            if(accounts[i].getId()==id){
                return accounts[i];
            }
        }
        return null;
    }
}