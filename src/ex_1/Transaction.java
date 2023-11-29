package ex_1;

public class Transaction implements Runnable{

    public final Account account;
    public final Operations operation;
    public final double amount;

    // constructors
    public Transaction(Account account, Operations operation, double amount ) {
        this.account = account;
        this.operation = operation;
        this.amount = amount;
    }

    // run method: Deposit or Withdraw
    public void run(){
        switch (operation) {
            case DEPOSIT:
                if(account.deposit(amount) > 0) {
                    System.out.printf("Deposited $%s to %s's account (id: %s).%n", amount, account.getName(), account.getId());
                } else
                    System.out.printf("Failed to deposit $%s to %s's account (id: %s).%n", amount, account.getName(), account.getId());
                break;
            case WITHDRAWAL:
                if(account.withdrawal(amount) > 0) {
                    System.out.printf("Withdrawn $%s from %s's account (id: %s).%n", amount, account.getName(), account.getId());
                } else
                    System.out.printf("Failed to withdraw $%s from %s's account (id: %s).%n", amount, account.getName(), account.getId());
                break;
        }
    }
}

