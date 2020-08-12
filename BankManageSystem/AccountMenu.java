package BankManageSystem;

import java.util.Scanner;

public class AccountMenu {
    private Scanner input = new Scanner(System.in);
    private Account account;

    public AccountMenu(){

    }

    public AccountMenu(Account account){
        this.account = account;
    }
    public void showMainMenu(){
        System.out.println("------------------------------------------------------");
        System.out.println("1. deposit\t\t2. withdraw\t\t3. chack balance\t\t4. transfer\t\t5. loan\t\t6. pay back\t\t7. change password\t\t8. logout");
        System.out.println("------------------------------------------------------");
        System.out.print("Please choose: ");
        int choice = input.nextInt();

        switch(choice){
            case 1: //deposit
            deposit();
            break;
            case 2:
            withdraw();
            break;
            case 3:
            queryBalance();
            break;
            case 4:
            transfer();
            break;
            case 5:
            requestLoan();
            break;
            case 6:
            payLoan();
            break;
            case 7:
            modifyPassword();
            break;
            case 8:
            logout();
            break;
        }
    }

    private void modifyPassword() {
        System.out.println("------------------------------------------------------");
        System.out.print("Please input your password: ");
        String oldPassword = input.next();
        System.out.print("Please input your new password: ");
        String newPassword = input.next();
        System.out.print("Please input your new password again: ");
        String rePassword = input.next();
        if(!oldPassword.equals(account.getPassword())){
            System.out.println("Warm: wrong password!");
        }else{
            if(!rePassword.equals(newPassword)){
                System.out.println("Passwords don't match each other.");
            }else{
                account.setPassword(newPassword);
                System.out.println("Successfully modified password!");
                System.out.println("Please login again.");
                new Start().showSystemMenu();
            }
        }
        showMainMenu();
    }

    private void payLoan() {
        System.out.println("------------------------------------------------------");
        if(account instanceof Loanable){
            System.out.print("Please input amount money you want to pay back: ");
            int money = input.nextInt();
            Loanable loan = (Loanable)account;
            if(loan.requestLoan(money)){
                System.out.println("Pay back loan successed. Your current balance is: "+account.getBalance()+" Your total loan is: "+loan.getLoan());
            }else{
                System.out.println("Fault to pay back loan.");
            }
        }else{
            System.out.println("This account cannot loan.");
        }
    }

    private void requestLoan() {
        System.out.println("------------------------------------------------------");
        // check whether is loan account
        if(account instanceof Loanable){
            System.out.println("Please input amount money need to loan: ");
            int money = input.nextInt();
            Loanable loan = (Loanable)account;
            if (loan.requestLoan(money)){
                System.out.println("Loaning successfully. Your total loan is: "+loan.getLoan());
            }else{
                System.out.println("Fault to loan.");
            }
            //((Loanable) account).requestLoan(money);
        }else{
            System.out.println("This account cannot loan.");
        }
        showMainMenu();
    }

    private void transfer() {
        System.out.println("------------------------------------------------------");
        System.out.print("Please input account number you want to transfer into: ");
        int id = input.nextInt();
        System.out.print("Please input amount of money you want to transfer: ");
        int money = input.nextInt();
        Account destAccount = Bank.findById(id);
        if(destAccount==null){
            System.out.println("Warm: account is not exist");
        }else{
            if(account.getBalance()<money){
                System.out.println("Don't have enough money. Your balance is: "+account.getBalance());
            }else{
                account.setBalance(account.getBalance()-money);
                destAccount.setBalance(destAccount.getBalance()+money);
                System.out.println("Transfer successfully. Your balance is: "+account.getBalance());
            }
        }
        showMainMenu();
    }

    private void queryBalance() {
        System.out.println("------------------------------------------------------");
        System.out.println("Your account balance is: "+account.getBalance());
        showMainMenu();
    }

    private void withdraw() {
        System.out.println("------------------------------------------------------");
        System.out.print("Please input amount of money you want to withdraw: ");
        int money = input.nextInt();
        if(account.withdraw(money)){
            System.out.println("Withdraw successfully!");
        }else{
            System.out.println("Fault to withdraw!");
        }
        showMainMenu();
    }

    private void logout() {
        System.out.println("Logout successfully!");
        new Start().showSystemMenu();
    }

    private void deposit() {
        System.out.println("------------------------------------------------------");
        System.out.print("Please input amount money you want to deposit: ");
        int money = input.nextInt();
        account.deposit(money);
        System.out.println("Deposit successfully!");
        showMainMenu();
    }


}