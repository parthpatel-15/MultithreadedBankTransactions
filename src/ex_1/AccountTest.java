package ex_1;


import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class AccountTest {

    public static void main(String[] args) {
        // create accounts
        Account ac1 = new Account(1, "Jess", 4000);
        Account ac2 = new Account(2, "Ken", 400);
        Account ac3 = new Account(3, "Leo", 1250);
        System.out.println("Accounts initialized.");
        System.out.println(ac1.getId() + "  " + ac1.getName() + "  " + ac1.getBalance());
        System.out.println(ac2.getId() + "  " + ac2.getName() + "  " + ac2.getBalance());
        System.out.println(ac3.getId() + "  " + ac3.getName() + "  " + ac3.getBalance() + "\n\n");

        //
        ArrayList<Transaction> trList = new ArrayList<Transaction>();
        trList.add(new Transaction(ac1, Operations.WITHDRAWAL, 2000));
        trList.add(new Transaction(ac2, Operations.DEPOSIT, 40));
        trList.add(new Transaction(ac3, Operations.DEPOSIT, 250));
        trList.add(new Transaction(ac1, Operations.WITHDRAWAL, 2001));
        trList.add(new Transaction(ac3, Operations.WITHDRAWAL, 1250));
        trList.add(new Transaction(ac3, Operations.WITHDRAWAL, 10));

        // create ExecutorService to manage threads
        ExecutorService executorService = Executors.newCachedThreadPool();
        // start the three PrintTasks
        for (Transaction tr : trList) {
            executorService.execute(tr);
        }

        // shut down ExecutorService--it decides when to shut down threads
        executorService.shutdown();

        try {
            // wait to finish executing
            boolean tasksEnded = executorService.awaitTermination(1, TimeUnit.SECONDS);
            if (tasksEnded) {
                System.out.printf("\n\nAll transactions are executed. New account balances are as follows: \n");
                System.out.println(ac1.getId() + "  " + ac1.getName() + "  " + ac1.getBalance());
                System.out.println(ac2.getId() + "  " + ac2.getName() + "  " + ac2.getBalance());
                System.out.println(ac3.getId() + "  " + ac3.getName() + "  " + ac3.getBalance() + "\n\n");
            }
        } catch (InterruptedException ex) {
            System.out.println("Interrupted while waiting for tasks to finish.");
        }
    }
}

