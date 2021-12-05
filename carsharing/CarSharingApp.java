package carsharing;

import java.util.Scanner;

public class CarSharingApp {

    private static CompanyDaoImpl database;
    public static Scanner scanner = new Scanner(System.in);

    /**
     * Constructor which create database, initialize database and start main menu
     */
    public CarSharingApp() {
        H2Database.createDB();
        database = new CompanyDaoImpl();
        mainMenu();
    }

    /**
     * Print a main menu and direct to chosen by user action
     */
    private static void mainMenu() {
        int action;
        do {
            System.out.println("1. Log in as a manager\n0. Exit");
            action = scanner.nextInt();
            scanner.nextLine();
            if (1 == action) managerMenu();
        } while (action != 0);
    }

    /**
     * Print a manager menu and direct to chosen by user action
     */
    private static void managerMenu() {
        int action;
        do {
            System.out.println("1. Company list\n2. Create a company\n0. Back");
            action = scanner.nextInt();
            scanner.nextLine();
            if (1 == action) printCompaniesList();
            if (2 == action) createCompany();
        } while (action != 0);
    }

    /**
     * Print the full list of companies from database
     */
    private static void printCompaniesList() {
        if (database.size() == 0) {
            System.out.println("The company list is empty!");
        } else {
            System.out.println("Company list:");
            int n = 1;
            database.getAllCompanies()
                    .forEach(x -> System.out.println((x.getId() + 1) + ". " + x.getName()));
        }
        System.out.println("\n");
    }

    /**
     * Create a new company and add it to database
     */
    private static void createCompany() {
        System.out.println("Enter the company name:");
        Company newComp = new Company(database.size(), scanner.nextLine());
        database.addCompany(newComp);
        System.out.println("The company was created!\n");
    }

}
