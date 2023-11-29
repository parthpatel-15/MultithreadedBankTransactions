# MultithreadedBankTransactions
This Java application extends the original multithreaded ATM system by introducing an Operation enum to represent transaction types (deposit or withdrawal) and refactoring the code to incorporate improved class structures.
# Project Structure:
<img width="457" alt="Screenshot 2023-11-29 at 12 23 40 AM" src="https://github.com/parthpatel-15/MultithreadedBankTransactions/assets/79576096/492a5a8e-d5b1-4977-a163-c757752eb188">

# Account.java:
Represents a bank account with methods for deposit and withdrawal.
Constructors: Supports both default and user-specified initial balances.
Methods: deposit and withdrawal update the account balance based on the provided amount.
# Transaction.java:
Implements Runnable for concurrent execution.
Represents a transaction (deposit or withdrawal) associated with a specific account.
The run method performs the specified operation and prints transaction details.
# Operation.java:
Enum defining two operations: DEPOSIT and WITHDRAWAL.
# AccountTest.java:
The main class simulating bank transactions using multiple threads.
Creates instances of the Account class with initial balances.
Defines a list of transactions with associated accounts, operations, and amounts.
Uses an ExecutorService to execute transactions concurrently.
Prints the updated account balances after the transactions are completed.
# Usage:
Launches the application to simulate bank transactions concurrently.
Threads perform random deposit or withdraw actions with random amounts.
Outputs the results, including the updated account balances after each transaction.
# Multithreading:
Utilizes multithreading to perform bank transactions concurrently.
The ExecutorService efficiently manages thread execution.
# Enhancements:
Improved class structure with the addition of the Account class.
Introduction of the Operation enum to represent transaction types.

#OUTPUT: 
<img width="1440" alt="Screenshot 2023-11-29 at 12 26 21 AM" src="https://github.com/parthpatel-15/MultithreadedBankTransactions/assets/79576096/10130d89-e8f0-48ae-959f-fe622ea82e65">


