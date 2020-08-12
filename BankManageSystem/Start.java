package BankManageSystem;

import java.util.Scanner;

public class Start {
    private Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("************************Welcome to use bank management system**********************");
        new Start().showSystemMenu();
    }

    public void showSystemMenu(){
        System.out.println("------------------------------------------------------");
        System.out.println("1. Open an account\t\t2. Login");
        System.out.println("------------------------------------------------------");
        System.out.print("Please choose:");
        int choice = input.nextInt();
        switch(choice){
            case 1:
            register();
            break;
            case 2:
            login();
            break;
            default:
            System.out.println("Wrong input!");
            break;
        }
    }

    private void login(){
        System.out.print("Please input your account: ");
        int id = input.nextInt();
        System.out.print("Please input your password: ");
        String password = input.next();
        Account account = Bank.login(id,password);
        if(account != null){
            System.out.println("------------------------------------------------------");
            System.out.println("Welcome "+account.getName());
            new AccountMenu(account).showMainMenu();
        }else{
            System.out.println("Warm: Account or password is incorrect!");
            showSystemMenu(); //System return to main menu
        }
    }

    private void register(){
        System.out.print("Please choose the account you want to open. (1. Saving account 2. Credit account 3. saving account with loan 4. creait account with loan): ");
        int num = input.nextInt();
        Account account = null;
        switch(num){
            case 1:
            account = new SavingAccount();
            break;
            case 2:
            account = new CreditAccount();
            break;
            case 3:
            account = new LoanSavingAccount();
            break;
            case 4:
            account = new LoanCreditAccount();
            break;
        }
        System.out.print("Please input your name:");
        account.setName(input.next());
        

        while(true){
            System.out.print("Please input your password:");
            String password = input.next();
            System.out.print("Please confirm your password:");
            String rePassword = input.next();
            if(rePassword.equals(password)){
                account.setPassword(password);
                break;
            }else{
                System.out.println("Warm: two passwords are different. Please try again.");
            }
        }

        System.out.print("Please input your person ID:");
        account.setPersonID(input.next());
        System.out.print("Please input your email:");
        account.setEmail(input.next());        

        // check whether it is a credit account. only work for credit account
        if(account instanceof CreditAccount){
            System.out.print("Please input the credit ceiling:");
            CreditAccount creditAccount = (CreditAccount)account;
            creditAccount.setCeiling(input.nextDouble());
        }

        boolean flag = Bank.register(account);
        if(flag){
            System.out.println("You have opened your account successfully. Your account No. is: "+account.getId());
        }else{
            System.out.println("Fault to opne a new account.");
        }

        showSystemMenu();// return to main menu
    }
}