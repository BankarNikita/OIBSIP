package main;

import java.util.Scanner;

public class ATM {
    Scanner sc = new Scanner(System.in);
    int id = 101;
    double amount = 3000;
    int withdrawlAmount;
    int depositAmount, transaction, transferAmount;

    public void login() {

        System.out.println("\twelcome!!!");
        System.out.print("Enter your customer id:");
        id = sc.nextInt();
        if (id == 101) {
            System.out.println("Login Successful");
            menu();
        } else {
            System.out.println("Login failed  try again!!");
            login();
        }
    }

    void menu() {
        int ch;
        do {
            System.out.println("\nSelect your choice:\n \n1.Transaction history\t\t2.Withdraw ");
            System.out.println("3.Deposit \t\t\t4.Transfer \n5.View balance \t\t\t6.Quit\n");
            System.out.print("Enter choice:");
            ch = sc.nextInt();
            switch (ch) {
                case 1:
                    Transactionhistory();
                    break;
                case 2:
                    Withdrawl();
                    break;
                case 3:
                    Deposit();
                    break;
                case 4:
                    Transfer();
                    break;
                case 5:
                    viewBalance();
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Enter valid choice");
                    break;
            }
        } while (ch <= 6);
    }

    void Transactionhistory() {
        if (transaction > 0)
            System.out.println("You deposited Rs." + transaction);
        else if (transaction < 0)
            System.out.println("You withdrawn Rs." + (-1 * transaction));
        else
            System.out.println("You have not done any transaction yet");

    }

    void Withdrawl() {
        System.out.print("Enter withdraw Amount:");
        withdrawlAmount = sc.nextInt();

        System.out.println("Withdrawl successful");
        System.out.println("Remaining balance:" + ((amount + depositAmount) - withdrawlAmount));

        transaction = withdrawlAmount;
    }

    void Deposit() {
        System.out.print("Enter deposit Amount:");
        depositAmount = sc.nextInt();
        System.out.println("Deposit Sccessful");
        System.out.println("Available balance:" + ((amount - withdrawlAmount) + depositAmount));
        transaction = depositAmount;
    }

    void Transfer() {
        System.out.print("Enter transfer amount:");
        transferAmount = sc.nextInt();
        if (transferAmount > 3000) {
            System.out.println("Insufficient");
        } else
            System.out.println("Transfer Successful");
    }

    void viewBalance() {
        double c = (amount - withdrawlAmount) + depositAmount;
        System.out.println("Amount available:" + c);

    }
}