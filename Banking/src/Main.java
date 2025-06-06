import java.util.Scanner;

public class Main {

    static String back;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name;
        String password;
        String correctpass = "password1234";
        double balance = 100;
        int option;

        System.out.printf("Enter your full name: ");
        name = scanner.nextLine();

        do {
            System.out.printf("Enter your password: ");
            password = scanner.nextLine();

            if (!password.equals(correctpass)) {
                System.out.println("Wrong password, please try again.");
            }
            else {
                System.out.println("Welcome " + name);
            }

        } while (!password.equals(correctpass));

        do {
            do {
                System.out.println("What option would you like to do?");
                System.out.println("1. Deposit money");
                System.out.println("2. Withdraw money");
                System.out.println("3. Check balance");
                option = scanner.nextInt();

                switch (option) {
                    case 1 -> balance = deposit(balance);
                    case 2 -> balance = withdraw(balance);
                    case 3 -> check(balance);
                    default -> System.out.println("Not a valid option. Please try again.");
                }
            } while (option > 3 || option < 1);

            scanner.nextLine();
            System.out.printf("Would you like to continue? (Y/N): ");
            back = scanner.nextLine().toUpperCase();
        } while (back.equals("Y"));

        scanner.close();
    }

    static double deposit(double balance) {
        Scanner scanner = new Scanner(System.in);
        double deposit;
        do {
            System.out.printf("Enter the amount you would like to deposit: ");
            deposit = scanner.nextDouble();

            if (deposit < 0) {
                System.out.println("You are not allowed to deposit a negative number");
            }
            else if (deposit > 1000000) {
                System.out.println("You are not allowed to deposit more then 1 million.");
            }

        } while (deposit < 0 || deposit > 1000000);
        balance += deposit;
        System.out.printf("You have deposited %.2f euro's. Your total balance is now %.2f euro's\n\n", deposit, balance);
        return balance;
    }

    static double withdraw(double balance) {
        Scanner scanner = new Scanner(System.in);
        double withdraw;
        do {
            System.out.printf("Enter the amount you would like to withdraw: ");
            withdraw = scanner.nextDouble();

            if (withdraw > balance) {
                System.out.println("Insufficient balance. Please try again.");
            }

            else if (withdraw < 0) {
                System.out.println("You cannot withdraw a negative number.");
            }

        } while (withdraw > balance || withdraw < 0);
        balance -= withdraw;
        System.out.printf("You have withdrawed %.2f euro's. Your total balance is now %.2f euro's\n\n", withdraw, balance);
        return balance;
    }

    static void check(double balance) {
        System.out.println("Your total balance is " + balance + " euro's\n");
    }
}