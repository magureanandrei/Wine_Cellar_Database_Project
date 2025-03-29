import Models.*;

import java.sql.*;
import java.util.Scanner;
import Controller.TransactionController;
import Controller.CRUDController;


public class UI {

    public void run() {
        try {
            Scanner scanner = new Scanner(System.in);
            boolean running = true;

            while (running) {
                // Meniu principal
                System.out.println("Select an Option:");
                System.out.println("1. CRUD Operations on Entities");
                System.out.println("2. Two concurrent transactions w/o problems");
                System.out.println("3. Dirty Write");
                System.out.println("4. Lost Update ");
                System.out.println("5. Unrepeatable Reads");
                System.out.println("6. Phantom Reads");
                System.out.println("7. Dirty Read");
                System.out.println("0. Exit");

                int choice = scanner.nextInt();
                scanner.nextLine(); // Consumă newline

                if (choice == 0) {
                    running = false;
                    continue;
                }

                if (choice == 1 ) {
                    System.out.println("Choose entity:");
                    System.out.println("1. CellarLocation");
                    System.out.println("2. Inventory");
                    System.out.println("3. Region");
                    System.out.println("4. Supplier");
                    System.out.println("5. Transactions");
                    System.out.println("6. Users");
                    System.out.println("7. Wines");
                    System.out.println("8. Wine Types");

                    int entityChoice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    System.out.println("Choose operation:");
                    System.out.println("1. Create");
                    System.out.println("2. GetAll");
                    System.out.println("3. Update");
                    System.out.println("4. Delete");
                    System.out.println("5. GetByID");

                    int crudChoice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    switch (entityChoice) {
                        case 1: // CellarLocation
                            CRUDController.handleCellarLocationOperations(crudChoice, scanner);
                            break;
                        case 2: // Inventory
                            CRUDController.handleInventoryOperations(crudChoice, scanner);
                            break;
                        case 3: // Region
                            CRUDController.handleRegionOperations(crudChoice, scanner);
                            break;
                        case 4: // Supplier
                            CRUDController.handleSupplierOperations(crudChoice, scanner);
                            break;
                        case 5: // Transactions
                            CRUDController.handleTransactionOperations(crudChoice, scanner);
                            break;
                        case 6: // Users
                            CRUDController.handleUsersOperations(crudChoice, scanner);
                            break;
                        case 7: // Wines
                            CRUDController.handleWineOperations(crudChoice, scanner);
                            break;
                        case 8: // Wine Types
                            CRUDController.handleWineTypeOperations(crudChoice, scanner);
                            break;
                        default:
                            System.out.println("Invalid choice");
                    }
                } else if (choice >= 2 && choice <= 7) {
                    // Execute transaction demonstrations directly without CRUD menu
                    switch (choice) {
                        case 2: // Execute concurrent transactions with SERIALIZABLE isolation
                            TransactionController.executeConcurrentTransactions();
                            break;
                        case 3: // Dirty write example
                            TransactionController.executeConcurrencyProblem();
                            break;
                        case 4: // Lost Update
                            TransactionController.executeLostUpdateProblem();
                            break;
                        case 5: // Unrepeatable Reads
                            TransactionController.executeUnrepeatableReadsProblem();
                            break;
                        case 6: // Phantom Reads
                            TransactionController.executePhantomReadsProblem();
                            break;
                        case 7: // Dirty Reads
                            TransactionController.executeDirtyReadsProblem();
                            break;
                        default:
                            System.out.println("Invalid choice");
                    }
                } else {
                    System.out.println("Invalid choice");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
