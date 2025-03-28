import Models.*;

import java.sql.*;
import java.util.Scanner;

public class UI {

    public void run() {
        try {

            final String dbUrl = "jdbc:postgresql://localhost:5432/WineCellar?currentSchema=public&user=postgres&password=1234";
            final String dbUrl2 = "jdbc:sqlserver://localhost:1433;database=WineCellar;user=abcd;password=1234;trustServerCertificate=true";
            Service postgresqlService = new Service(dbUrl);
            Service ssmsService = new Service(dbUrl2);

            Scanner scanner = new Scanner(System.in);
            boolean running = true;

            while (running) {
                // Meniu principal
                System.out.println("Select an Option:");
                System.out.println("1. Cellar Location");
                System.out.println("2. Inventory");
                System.out.println("3. Region");
                System.out.println("4. Supplier");
                System.out.println("5. Transactions");
                System.out.println("6. Users");
                System.out.println("7. Wines");
                System.out.println("8. Wine Type");
                System.out.println("9. Two concurrent transactions w/o problems");
                System.out.println("10. Dirty Write");
                System.out.println("11. Lost Update ");
                System.out.println("12. Unrepeatable Reads");
                System.out.println("13. Phantom Reads");
                System.out.println("14. Dirty Read");
                System.out.println("0. Exit");

                int choice = scanner.nextInt();
                scanner.nextLine(); // Consumă newline

                if (choice == 0) {
                    running = false;
                    continue;
                }

                // Meniu CRUD pentru fiecare entitate
                System.out.println("Choose operation:");
                System.out.println("1. Create");
                System.out.println("2. GetAll");
                System.out.println("3. Update");
                System.out.println("4. Delete");
                System.out.println("5. GetByID");

                int crudChoice = scanner.nextInt();
                scanner.nextLine(); // Consumă newline

                switch (choice) {
                    case 1: // CellarLocation
                        handleCellarLocationOperations(postgresqlService, ssmsService, crudChoice, scanner);
                        break;
                    case 2: // Inventory
                        handleInventoryOperations(postgresqlService, ssmsService, crudChoice, scanner);
                        break;
                    case 3: // Region
                        handleRegionOperations(postgresqlService, ssmsService, crudChoice, scanner);
                        break;
                    case 4: // Supplier
                        handleSupplierOperations(postgresqlService, ssmsService, crudChoice, scanner);
                        break;
                    case 5: // Transactions
                        handleTransactionOperations(postgresqlService, ssmsService, crudChoice, scanner);
                        break;
                    case 6: // Users
                        handleUsersOperations(postgresqlService, ssmsService, crudChoice, scanner);
                        break;
                    case 7: // Wines
                        handleWineOperations(postgresqlService, ssmsService, crudChoice, scanner);
                        break;
                    case 8: // Wine Types
                        handleWineTypeOperations(postgresqlService, ssmsService, crudChoice, scanner);
                        break;
                    case 9: // Execută tranzacții concurente cu izolare SERIALIZABLE
                        executeConcurrentTransactions();
                        break;
                    case 10:
                        // Exemplu de dirty write
                        executeConcurrencyProblem();
                        break;
                    case 11:
                        //Lost Update
                        executeLostUpdateProblem();
                        break;
                    case 12:
                        //Unrepeatable Reads
                        executeUnrepeatableReadsProblem();
                        break;
                    case 13:
                        //Phantom Reads
                        executePhantomReadsProblem();
                        break;
                    case 14:
                        //Dirty Reads
                        executeDirtyReadsProblem();
                        break;
                    default:
                        System.out.println("Invalid choice");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void handleCellarLocationOperations(Service postgresqlService, Service ssmsService, int crudChoice, Scanner scanner) {
        switch (crudChoice) {
            case 1: // Create
                System.out.println("Enter id:");
                int id = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                System.out.println("Enter section:");
                String section = scanner.nextLine();

                System.out.println("Enter rack number:");
                int rackNumber = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                System.out.println("Enter bottle position:");
                int bottlePosition = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                CellarLocation c = new CellarLocation(id, section, rackNumber, bottlePosition);
                postgresqlService.createCellarLocation(c);
                ssmsService.createCellarLocation(c);
                break;
            case 2: // getAll
                postgresqlService.getAllCellarLocations();
                ssmsService.getAllCellarLocations();
                break;
            case 3: // Update
                System.out.println("Enter id:");
                id = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                System.out.println("Enter section:");
                section = scanner.nextLine();

                System.out.println("Enter rack number:");
                rackNumber = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                System.out.println("Enter bottle position:");
                bottlePosition = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                postgresqlService.updateCellarLocation(id, section, rackNumber, bottlePosition);
                ssmsService.updateCellarLocation(id, section, rackNumber, bottlePosition);
                break;
            case 4: // Delete
                System.out.println("Enter id:");
                id = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                postgresqlService.deleteCellarLocation(id);
                ssmsService.deleteCellarLocation(id);
                break;
            case 5: //get
                System.out.println("Enter id:");
                id = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                postgresqlService.getCellarLocation(id);
                ssmsService.getCellarLocation(id);
                break;
            default:
                System.out.println("Invalid choice");
        }
    }
    public void handleInventoryOperations(Service postgresqlService, Service ssmsService, int crudChoice, Scanner scanner){
        switch (crudChoice) {
            case 1: // Create
                System.out.println("Enter id:");
                int id = scanner.nextInt();
                scanner.nextLine(); // Consumă newline
                System.out.println("Enter wine id:");
                int wine_id = scanner.nextInt();
                scanner.nextLine(); // Consumă newline
                System.out.println("Enter location id:");
                int location_id = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter quantity:");
                int quantity = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter bottle size(ml):");
                int bottle_size_ml = scanner.nextInt();
                scanner.nextLine();
                Inventory i = new Inventory(id, wine_id, location_id, quantity, bottle_size_ml);
                postgresqlService.createInventory(i);
                ssmsService.createInventory(i);
                break;
            case 2: // getAll
                postgresqlService.getAllInventories();
                ssmsService.getAllInventories();
                break;
            case 3: // Update
                System.out.println("Enter id:");
                id = scanner.nextInt();
                scanner.nextLine(); // Consumă newline
                System.out.println("Enter wine id:");
                wine_id = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter location id:");
                location_id = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter quantity:");
                quantity = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter bottle size:");
                bottle_size_ml = scanner.nextInt();
                scanner.nextLine();
                postgresqlService.updateInventory(id, wine_id, location_id, quantity, bottle_size_ml);
                ssmsService.updateInventory(id, wine_id, location_id, quantity, bottle_size_ml);
                break;
            case 4: // Delete
                System.out.println("Enter id:");
                id = scanner.nextInt();
                scanner.nextLine(); // Consumă newline
                postgresqlService.deleteInventory(id);
                ssmsService.deleteInventory(id);
                break;
            case 5: //get
                System.out.println("Enter id:");
                id = scanner.nextInt();
                scanner.nextLine(); // Consumă newline
                postgresqlService.getInventory(id);
                ssmsService.getInventory(id);
                break;
            default:
                System.out.println("Invalid choice");
        }
    }
    public void handleRegionOperations(Service postgresqlService, Service ssmsService, int crudChoice, Scanner scanner){
        switch (crudChoice) {
            case 1: // Create
                System.out.println("Enter id:");
                int id = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter name:");
                String name = scanner.nextLine();
                System.out.println("Enter country:");
                String country = scanner.nextLine();
                Region r = new Region(id, name, country);
                postgresqlService.createRegion(r);
                ssmsService.createRegion(r);
                break;
            case 2: // getAll
                postgresqlService.getAllRegions();
                ssmsService.getAllRegions();
                break;
            case 3: // Update
                System.out.println("Enter id:");
                id = scanner.nextInt();
                scanner.nextLine(); // Consumă newline
                System.out.println("Enter name:");
                name = scanner.nextLine();
                System.out.println("Enter country:");
                country = scanner.nextLine();
                postgresqlService.updateRegion(id, name, country);
                ssmsService.updateRegion(id, name, country);
                break;
            case 4: // Delete
                System.out.println("Enter id:");
                id = scanner.nextInt();
                scanner.nextLine(); // Consumă newline
                postgresqlService.deleteRegion(id);
                ssmsService.deleteRegion(id);
                break;
            case 5: //get
                System.out.println("Enter id:");
                id = scanner.nextInt();
                scanner.nextLine(); // Consumă newline
                postgresqlService.getRegion(id);
                ssmsService.getRegion(id);
                break;
            default:
                System.out.println("Invalid choice");
        }
    }
    public void handleSupplierOperations(Service postgresqlService, Service ssmsService, int crudChoice, Scanner scanner){
        switch (crudChoice) {
            case 1: // Create
                System.out.println("Enter id:");
                int id = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter name:");
                String name = scanner.nextLine();
                System.out.println("Enter email:");
                String email = scanner.nextLine();
                System.out.println("Enter phone number:");
                String phone_number = scanner.nextLine();
                System.out.println("Enter address:");
                String address = scanner.nextLine();
                Supplier s = new Supplier(id, name, email, phone_number, address);
                postgresqlService.createSupplier(s);
                ssmsService.createSupplier(s);
                break;
            case 2: // getAll
                postgresqlService.getAllSuppliers();
                ssmsService.getAllSuppliers();
                break;
            case 3: // Update
                System.out.println("Enter id:");
                id = scanner.nextInt();
                scanner.nextLine(); // Consumă newline
                System.out.println("Enter name:");
                name = scanner.nextLine();
                System.out.println("Enter email:");
                email = scanner.nextLine();
                System.out.println("Enter phone number:");
                phone_number = scanner.nextLine();
                System.out.println("Enter address:");
                address = scanner.nextLine();
                postgresqlService.updateSupplier(id, name, email, phone_number,address);
                ssmsService.updateSupplier(id, name, email, phone_number,address);
                break;
            case 4: // Delete
                System.out.println("Enter id:");
                id = scanner.nextInt();
                scanner.nextLine(); // Consumă newline
                postgresqlService.deleteSupplier(id);
                ssmsService.deleteSupplier(id);
                break;
            case 5: //get
                System.out.println("Enter id:");
                id = scanner.nextInt();
                scanner.nextLine(); // Consumă newline
                postgresqlService.getSupplier(id);
                ssmsService.getSupplier(id);
                break;
            default:
                System.out.println("Invalid choice");
        }
    }

    public void handleTransactionOperations(Service postgresqlService, Service ssmsService, int crudChoice, Scanner scanner) {
        switch (crudChoice) {
            case 1: // Create
                System.out.println("Enter id:");
                int id = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter wine id:");
                int wine_id = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter transaction type:");
                String transaction_type = scanner.nextLine();
                System.out.println("Enter date:");
                String date = scanner.nextLine();
                System.out.println("Enter quantity:");
                int quantity = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter price per bottle:");
                int price_per_bottle = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter user id:");
                int user_id = scanner.nextInt();
                scanner.nextLine();
                Transactions t = new Transactions(id, wine_id, transaction_type, date, quantity, price_per_bottle, user_id);
                postgresqlService.createTransaction(t);
                ssmsService.createTransaction(t);
                break;
            case 2: // getAll
                postgresqlService.getAllTransactions();
                ssmsService.getAllTransactions();
                break;
            case 3: // Update
                System.out.println("Enter id:");
                id = scanner.nextInt();
                scanner.nextLine(); // Consumă newline
                System.out.println("Enter wine id:");
                wine_id = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter transaction type:");
                transaction_type = scanner.nextLine();
                System.out.println("Enter date:");
                date = scanner.nextLine();
                System.out.println("Enter quantity:");
                quantity = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter price per bottle:");
                price_per_bottle = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter user id:");
                user_id = scanner.nextInt();
                scanner.nextLine(); // Consumă newline
                postgresqlService.updateTransaction(id, wine_id, transaction_type, date, quantity, price_per_bottle, user_id);
                ssmsService.updateTransaction(id, wine_id, transaction_type, date, quantity, price_per_bottle, user_id);
                break;
            case 4: // Delete
                System.out.println("Enter id:");
                id = scanner.nextInt();
                scanner.nextLine(); // Consumă newline
                postgresqlService.deleteTransaction(id);
                ssmsService.deleteTransaction(id);
                break;
            case 5: //get
                System.out.println("Enter id:");
                id = scanner.nextInt();
                scanner.nextLine(); // Consumă newline
                postgresqlService.getTransaction(id);
                ssmsService.getTransaction(id);
                break;
            default:
                System.out.println("Invalid choice");
        }
    }

    public void handleUsersOperations(Service postgresqlService, Service ssmsService, int crudChoice, Scanner scanner) {
        switch (crudChoice) {
            case 1: // Create
                System.out.println("Enter id:");
                int id = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter username:");
                String username = scanner.nextLine();
                System.out.println("Enter password:");
                String password = scanner.nextLine();
                System.out.println("Enter role:");
                String role = scanner.nextLine();
                Users u = new Users(id, username, password, role);
                postgresqlService.createUser(u);
                ssmsService.createUser(u);
                break;
            case 2: // getAll
                postgresqlService.getAllUsers();
                ssmsService.getAllUsers();
                break;
            case 3: // Update
                System.out.println("Enter id:");
                id = scanner.nextInt();
                scanner.nextLine(); // Consumă newline
                System.out.println("Enter username:");
                username = scanner.nextLine();
                System.out.println("Enter password:");
                password = scanner.nextLine();
                System.out.println("Enter role:");
                role = scanner.nextLine();
                postgresqlService.updateUser(id, username, password, role);
                ssmsService.updateUser(id, username, password, role);
                break;
            case 4: // Delete
                System.out.println("Enter id:");
                id = scanner.nextInt();
                scanner.nextLine(); // Consumă newline
                postgresqlService.deleteUser(id);
                ssmsService.deleteUser(id);
                break;
            case 5: //get
                System.out.println("Enter id:");
                id = scanner.nextInt();
                scanner.nextLine(); // Consumă newline
                postgresqlService.getUser(id);
                ssmsService.getUser(id);
                break;
            default:
                System.out.println("Invalid choice");
        }
    }
    public void handleWineOperations(Service postgresqlService, Service ssmsService, int crudChoice, Scanner scanner) {
        switch (crudChoice) {
            case 1: // Create
                System.out.println("Enter id:");
                int id = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter name:");
                String name = scanner.nextLine();
                System.out.println("Enter type id:");
                int type_id = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter region id:");
                int region_id = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter vintage year:");
                int vintage_year = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter alcohol percentage:");
                int alcohol_percentage = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter supplier id:");
                int supplier_id = scanner.nextInt();
                scanner.nextLine(); // Consumă newline
                Wines w = new Wines(id, name, type_id, region_id, vintage_year, alcohol_percentage, supplier_id);
                postgresqlService.createWine(w);
                ssmsService.createWine(w);
                break;
            case 2: // getAll
                postgresqlService.getAllWines();
                ssmsService.getAllWines();
                break;
            case 3: // Update
                System.out.println("Enter id:");
                id = scanner.nextInt();
                scanner.nextLine(); // Consumă newline
                System.out.println("Enter name:");
                name = scanner.nextLine();
                System.out.println("Enter type id:");
                type_id = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter region id:");
                region_id = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter vintage year:");
                vintage_year = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter alcohol percentage:");
                alcohol_percentage = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter supplier id:");
                supplier_id = scanner.nextInt();
                scanner.nextLine(); // Consumă newline
                postgresqlService.updateWine(id, name, type_id, region_id, vintage_year, alcohol_percentage, supplier_id);
                ssmsService.updateWine(id, name, type_id, region_id, vintage_year, alcohol_percentage, supplier_id);
                break;
            case 4: // Delete
                System.out.println("Enter id:");
                id = scanner.nextInt();
                scanner.nextLine(); // Consumă newline
                postgresqlService.deleteWine(id);
                ssmsService.deleteWine(id);
                break;
            case 5: //get
                System.out.println("Enter id:");
                id = scanner.nextInt();
                scanner.nextLine(); // Consumă newline
                postgresqlService.getWine(id);
                ssmsService.getWine(id);
                break;
            default:
                System.out.println("Invalid choice");
        }
    }

    public void handleWineTypeOperations(Service postgresqlService, Service ssmsService, int crudChoice, Scanner scanner) {
        switch (crudChoice) {
            case 1: // Create
                System.out.println("Enter id:");
                int id = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter name:");
                String name = scanner.nextLine();
                WineType wt = new WineType(id, name);
                postgresqlService.createWineType(wt);
                ssmsService.createWineType(wt);
                break;
            case 2: // getAll
                postgresqlService.getAllWineTypes();
                ssmsService.getAllWineTypes();
                break;
            case 3: // Update
                System.out.println("Enter id:");
                id = scanner.nextInt();
                scanner.nextLine(); // Consumă newline
                System.out.println("Enter name:");
                name = scanner.nextLine();
                postgresqlService.updateWineType(id, name);
                ssmsService.updateWineType(id, name);
                break;
            case 4: // Delete
                System.out.println("Enter id:");
                id = scanner.nextInt();
                scanner.nextLine(); // Consumă newline
                postgresqlService.deleteWineType(id);
                ssmsService.deleteWineType(id);
                break;
            case 5: //get
                System.out.println("Enter id:");
                id = scanner.nextInt();
                scanner.nextLine(); // Consumă newline
                postgresqlService.getWineType(id);
                ssmsService.getWineType(id);
                break;
            default:
                System.out.println("Invalid choice");
        }
    }
    public static void executeConcurrentTransactions() {
        // Create two threads to simulate concurrent transactions
        Thread transaction1 = new Thread(() -> executeTransactionWithoutConflict(1));
        Thread transaction2 = new Thread(() -> executeTransactionWithoutConflict(2));

        // Start concurrent transactions
        transaction1.start();
        transaction2.start();

        try {
            // Wait for both transactions to complete
            transaction1.join();
            transaction2.join();
            System.out.println("Both transactions completed successfully without conflicts.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void executeTransactionWithoutConflict(int transactionNumber) {
        final String dbUrl = "jdbc:sqlserver://localhost:1433;database=WineCellar;user=abcd;password=1234;trustServerCertificate=true";
        try (Connection connection = DriverManager.getConnection(dbUrl)) {
            // Start transaction and set isolation level to SERIALIZABLE
            connection.setAutoCommit(false);
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            System.out.println("Transaction " + transactionNumber + " started.");

            // Each transaction updates a different star
            String updateStarSQL = "UPDATE wines SET alcohol_percentage = ? WHERE wine_id = ?";
            try (PreparedStatement stmt = connection.prepareStatement(updateStarSQL)) {
                if (transactionNumber == 1) {
                    stmt.setInt(1, 20); // New mass for star 1
                    stmt.setInt(2, 1);      // wineID 1
                    stmt.executeUpdate();
                    System.out.println("Transaction 1 updated wine 1.");
                    Thread.sleep(2000);     // Simulate some processing time
                } else {
                    stmt.setInt(1, 15); // New mass for wine 2
                    stmt.setInt(2, 2);      // wineID 2 (different from transaction 1)
                    stmt.executeUpdate();
                    System.out.println("Transaction 2 updated wine 2.");
                }

                // Commit the transaction
                connection.commit();
                System.out.println("Transaction " + transactionNumber + " committed successfully.");

            } catch (SQLException | InterruptedException e) {
                System.out.println("Error in transaction " + transactionNumber + ". Rolling back.");
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void executeConcurrencyProblem() {
        System.out.println("Starting dirty write problem demonstration...");

        // Create two threads to simulate concurrent transactions with conflict
        Thread transaction1 = new Thread(() -> executeConflictingTransaction(1));
        Thread transaction2 = new Thread(() -> executeConflictingTransaction(2));

        // Start concurrent transactions with a small delay to ensure they overlap
        transaction1.start();
        try {
            Thread.sleep(500); // Small delay to ensure transaction 1 starts first
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        transaction2.start();

        try {
            // Wait for both transactions to complete
            transaction1.join();
            transaction2.join();
            System.out.println("Dirty Write demonstration completed.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void executeConflictingTransaction(int transactionNumber) {
            /*Dacă tranzacțiile sunt rulate în acest mod și Tranzacția 1 este finalizată mai întâi,
            iar Tranzacția 2 confirmă actualizarea,
            Tranzacția 1 poate suprascrie modificările făcute de Tranzacția 2 sau poate deveni inconsistentă.
            * */
        final String dbUrl = "jdbc:sqlserver://localhost:1433;database=WineCellar;user=abcd;password=1234;trustServerCertificate=true";
        try (Connection connection = DriverManager.getConnection(dbUrl)) {
            // Set isolation level to READ_COMMITTED to allow potential conflicts
            connection.setAutoCommit(false);
            connection.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
            System.out.println("Conflicting Transaction " + transactionNumber + " started.");

            if (transactionNumber == 1) {
                // First transaction reads the current value
                String selectSQL = "SELECT quantity FROM Inventory WHERE inventory_id = 1";
                try (PreparedStatement selectStmt = connection.prepareStatement(selectSQL)) {
                    ResultSet rs = selectStmt.executeQuery();
                    int curentquantity = 0;
                    if (rs.next()) {
                        curentquantity = rs.getInt("quantity");
                    }
                    System.out.println("Transaction 1 read quantity: " + curentquantity);

                    // Sleep to simulate transaction processing time
                    Thread.sleep(3000);

                    // Update the planet diameter
                    String updateSQL = "UPDATE inventory SET quantity = ? WHERE inventory_id = 1";
                    try (PreparedStatement updateStmt = connection.prepareStatement(updateSQL)) {
                        int newquantity = curentquantity + 1000;
                        updateStmt.setInt(1, newquantity);
                        updateStmt.executeUpdate();
                        System.out.println("Transaction 1 updated quantity to: " + newquantity);
                    }

                    // Commit the transaction
                    connection.commit();
                    System.out.println("Transaction 1 committed.");
                } catch (SQLException | InterruptedException e) {
                    System.out.println("Error in transaction 1. Rolling back.");
                    connection.rollback();
                    e.printStackTrace();
                }
            } else {
                // Second transaction also reads the current value
                String selectSQL = "SELECT quantity FROM inventory WHERE inventory_id = 1";
                try (PreparedStatement selectStmt = connection.prepareStatement(selectSQL)) {
                    ResultSet rs = selectStmt.executeQuery();
                    int currentquantity = 0;
                    if (rs.next()) {
                        currentquantity = rs.getInt("quantity");
                    }
                    System.out.println("Transaction 2 read quantity: " + currentquantity);

                    // Sleep a bit
                    Thread.sleep(1000);

                    // Update the planet diameter
                    String updateSQL = "UPDATE inventory SET quantity = ? WHERE inventory_id = 1";
                    try (PreparedStatement updateStmt = connection.prepareStatement(updateSQL)) {
                        int newquantity = currentquantity + 2000;
                        updateStmt.setInt(1, newquantity);
                        updateStmt.executeUpdate();
                        System.out.println("Transaction 2 updated quantity to: " + newquantity);
                    }

                    // Commit the transaction
                    connection.commit();
                    System.out.println("Transaction 2 committed.");
                } catch (SQLException | InterruptedException e) {
                    System.out.println("Error in transaction 2. Rolling back.");
                    connection.rollback();
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void executeLostUpdateProblem() {
        System.out.println("Starting lost update problem demonstration...");

        // Create two threads to simulate concurrent transactions with conflict
        Thread transaction1 = new Thread(() -> executeConflictingTransaction2(1));
        Thread transaction2 = new Thread(() -> executeConflictingTransaction2(2));

        // Start concurrent transactions with a small delay to ensure they overlap
        transaction1.start();
        try {
            Thread.sleep(500); // Small delay to ensure transaction 1 starts first
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        transaction2.start();

        try {
            // Wait for both transactions to complete
            transaction1.join();
            transaction2.join();
            System.out.println("Lost Update demonstration completed.");

            // Check final state
            checkFinalState();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void executeConflictingTransaction2(int transactionNumber) {
        /* If transactions are run this way, and Transaction 1 reads the value first,
           but Transaction 2 commits its update first, Transaction 1's subsequent
           update will overwrite Transaction 2's changes, causing a lost update. */
        final String POSTGRES_URL = "jdbc:sqlserver://localhost:1433;database=WineCellar;user=abcd;password=1234;trustServerCertificate=true";
        try (Connection connection = DriverManager.getConnection(POSTGRES_URL)) {
            // Set isolation level to READ_COMMITTED to allow potential conflicts
            connection.setAutoCommit(false);
            connection.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
            System.out.println("Transaction " + transactionNumber + " started.");

            // Read the current value
            String selectSQL = "SELECT price_per_bottle FROM transactions WHERE transaction_id = 1";
            try (PreparedStatement selectStmt = connection.prepareStatement(selectSQL)) {
                ResultSet rs = selectStmt.executeQuery();
                int currentprice = 0;
                if (rs.next()) {
                    currentprice = rs.getInt("price_per_bottle");
                }
                System.out.println("Transaction " + transactionNumber + " read price per bottle: " + currentprice);

                // Sleep to simulate transaction processing time
                if (transactionNumber == 1) {
                    // First transaction takes longer
                    Thread.sleep(3000);
                } else {
                    // Second transaction is faster
                    Thread.sleep(1000);
                }

                // Update the satellite size
                String updateSQL = "UPDATE transactions SET price_per_bottle = ? WHERE transaction_id = 1";
                try (PreparedStatement updateStmt = connection.prepareStatement(updateSQL)) {
                    int newprice;
                    if (transactionNumber == 1) {
                        newprice = currentprice + 10;
                    } else {
                        newprice = currentprice + 5;
                    }
                    updateStmt.setFloat(1, newprice);
                    updateStmt.executeUpdate();
                    System.out.println("Transaction " + transactionNumber + " updated price per bottle to: " + newprice);
                }

                // Commit the transaction
                connection.commit();
                System.out.println("Transaction " + transactionNumber + " committed.");
            } catch (SQLException | InterruptedException e) {
                System.out.println("Error in transaction " + transactionNumber + ". Rolling back.");
                try {
                    connection.rollback();
                } catch (SQLException rollbackEx) {
                    rollbackEx.printStackTrace();
                }
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void checkFinalState() {
        System.out.println("\n--- Checking final state ---");
        final String POSTGRES_URL = "jdbc:sqlserver://localhost:1433;database=WineCellar;user=abcd;password=1234;trustServerCertificate=true";
        try (Connection conn = DriverManager.getConnection(POSTGRES_URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT price_per_bottle FROM transactions WHERE transaction_id = 1")) {

            if (rs.next()) {
                System.out.println("Final price per bottle: " + rs.getInt("price_per_bottle"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void executeUnrepeatableReadsProblem() {
        System.out.println("Starting unrepeatable reads problem demonstration...");

        // Create two threads to simulate concurrent transactions
        Thread transaction1 = new Thread(() -> executeLongRunningReadTransaction());
        Thread transaction2 = new Thread(() -> executeUpdateTransaction());

        // Start transaction 1 first
        transaction1.start();
        try {
            Thread.sleep(500); // Small delay to ensure transaction 1 starts first
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        transaction2.start();

        try {
            // Wait for both transactions to complete
            transaction1.join();
            transaction2.join();
            System.out.println("Unrepeatable Reads demonstration completed.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void executeLongRunningReadTransaction() {
        /* This transaction demonstrates the unrepeatable reads problem.
           It will read the same data twice, but the second read may see different data
           if another transaction modifies it in between the reads. */
        final String POSTGRES_URL = "jdbc:sqlserver://localhost:1433;database=WineCellar;user=abcd;password=1234;trustServerCertificate=true";
        try (Connection connection = DriverManager.getConnection(POSTGRES_URL)) {
            // Set isolation level to READ_COMMITTED to allow unrepeatable reads
            connection.setAutoCommit(false);
            connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            System.out.println("Long-running read Transaction started.");

            // First read of the satellite size
            String selectSQL = "SELECT quantity, bottle_size_ml FROM inventory WHERE inventory_id = 1";
            try (PreparedStatement selectStmt = connection.prepareStatement(selectSQL)) {
                ResultSet rs = selectStmt.executeQuery();
                if (rs.next()) {
                    System.out.println("First read - quantity: " + rs.getString("quantity") +
                            ", bottle size: " + rs.getInt("bottle_size_ml") + " ml");
                }

                // Sleep to allow transaction 2 to modify the data
                System.out.println("Long-running transaction sleeping to allow other transaction to modify data...");
                Thread.sleep(3000);

                // Second read of the satellite size (same transaction, same query)
                try (ResultSet rs2 = selectStmt.executeQuery()) {
                    if (rs2.next()) {
                        System.out.println("Second read - quantity: " + rs2.getString("quantity") +
                                ", bottle size: " + rs2.getInt("bottle_size_ml") + " ml");
                    }

                    // If the two reads show different results, we have an unrepeatable read
                    System.out.println("*** If the two reads show different values, this demonstrates an unrepeatable read problem! ***");
                }

                // Commit the transaction
                connection.commit();
                System.out.println("Long-running read Transaction committed.");
            } catch (SQLException | InterruptedException e) {
                System.out.println("Error in long-running read transaction. Rolling back.");
                try {
                    connection.rollback();
                } catch (SQLException rollbackEx) {
                    rollbackEx.printStackTrace();
                }
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void executeUpdateTransaction() {
        /* This transaction will update the satellite data while the first transaction
           is in the middle of its execution. */
        final String POSTGRES_URL = "jdbc:sqlserver://localhost:1433;database=WineCellar;user=abcd;password=1234;trustServerCertificate=true";
        try (Connection connection = DriverManager.getConnection(POSTGRES_URL)) {
            // Set autocommit to false to allow transaction control
            connection.setAutoCommit(false);
            System.out.println("Update Transaction started.");

            // Sleep briefly to ensure the first transaction has done its first read
            Thread.sleep(1000);

            // Update the satellite size
            String updateSQL = "UPDATE inventory SET bottle_size_ml = bottle_size_ml + 25 WHERE inventory_id = 1";
            try (PreparedStatement updateStmt = connection.prepareStatement(updateSQL)) {
                int updatedRows = updateStmt.executeUpdate();
                System.out.println("Update Transaction modified " + updatedRows + " bottle size.");

                // Read the updated value
                String selectSQL = "SELECT quantity, bottle_size_ml FROM inventory WHERE inventory_id = 1";
                try (PreparedStatement selectStmt = connection.prepareStatement(selectSQL);
                     ResultSet rs = selectStmt.executeQuery()) {
                    if (rs.next()) {
                        System.out.println("Update Transaction - New bottle size: " + rs.getInt("bottle_size_ml") + " ml");
                    }
                }

                // Commit the update
                connection.commit();
                System.out.println("Update Transaction committed.");
            } catch (SQLException e) {
                System.out.println("Error in update transaction. Rolling back.");
                try {
                    connection.rollback();
                } catch (SQLException rollbackEx) {
                    rollbackEx.printStackTrace();
                }
                e.printStackTrace();
            }
        } catch (SQLException | InterruptedException e) {
            e.printStackTrace();
        }

    }


    public static void executePhantomReadsProblem() {
        System.out.println("Starting phantom reads problem demonstration...");

        // Create two threads to simulate concurrent transactions
        Thread transaction1 = new Thread(() -> executeLongRunningRangeQueryTransaction());
        Thread transaction2 = new Thread(() -> executeInsertTransaction());

        // Start transaction 1 first
        transaction1.start();
        try {
            Thread.sleep(500); // Small delay to ensure transaction 1 starts first
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        transaction2.start();

        try {
            // Wait for both transactions to complete
            transaction1.join();
            transaction2.join();
            System.out.println("Phantom Reads demonstration completed.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void executeLongRunningRangeQueryTransaction() {
        /* This transaction demonstrates the phantom reads problem.
           It will execute the same range query twice, but the second execution
           may see additional rows (phantoms) that weren't there during the first execution
           if another transaction adds new rows that match the range condition. */
        final String POSTGRES_URL = "jdbc:sqlserver://localhost:1433;database=WineCellar;user=abcd;password=1234;trustServerCertificate=true";
        try (Connection connection = DriverManager.getConnection(POSTGRES_URL)) {
            // Set isolation level to READ_COMMITTED to allow phantom reads
            connection.setAutoCommit(false);
            connection.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
            System.out.println("Long-running range query Transaction started.");

            // First range query - get satellites with size between 1000 and 5000 km
            String selectSQL = "SELECT name, alcohol_percentage, vintage_year FROM wines WHERE vintage_year BETWEEN 1000 AND 3000 ORDER BY wine_id";
            try (PreparedStatement selectStmt = connection.prepareStatement(selectSQL)) {
                ResultSet rs = selectStmt.executeQuery();
                System.out.println("First range query results:");
                int count1 = 0;
                while (rs.next()) {
                    count1++;
                    System.out.println("  Wine: " + rs.getString("name") +
                            ", Vintage year: " + rs.getInt("vintage_year"));
                }
                System.out.println("Total wines found in first query: " + count1);

                // Sleep to allow transaction 2 to insert new data
                System.out.println("Long-running transaction sleeping to allow other transaction to insert new data...");
                Thread.sleep(3000);

                // Second execution of the same range query
                try (ResultSet rs2 = selectStmt.executeQuery()) {
                    System.out.println("Second range query results:");
                    int count2 = 0;
                    while (rs2.next()) {
                        count2++;
                        System.out.println("  Wine: " + rs2.getString("name") +
                                ", Vintage year: " + rs2.getInt("vintage_year"));
                    }
                    System.out.println("Total wines found in second query: " + count2);

                    // If the second query returns more rows than the first, we have phantom reads
                    if (count2 > count1) {
                        System.out.println("*** PHANTOM READ DETECTED: The second query found " +
                                (count2 - count1) + " additional row(s) that weren't present in the first query! ***");
                    } else {
                        System.out.println("No phantom reads detected (counts match).");
                    }
                }

                // Commit the transaction
                connection.commit();
                System.out.println("Long-running range query Transaction committed.");
            } catch (SQLException | InterruptedException e) {
                System.out.println("Error in long-running range query transaction. Rolling back.");
                try {
                    connection.rollback();
                } catch (SQLException rollbackEx) {
                    rollbackEx.printStackTrace();
                }
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void executeInsertTransaction() {
        /* This transaction will insert a new satellite that matches the range condition
           of the first transaction's query, creating a phantom read. */
        final String POSTGRES_URL = "jdbc:sqlserver://localhost:1433;database=WineCellar;user=abcd;password=1234;trustServerCertificate=true";
        try (Connection connection = DriverManager.getConnection(POSTGRES_URL)) {
            // Set autocommit to false to allow transaction control
            connection.setAutoCommit(false);
            System.out.println("Insert Transaction started.");

            // Sleep briefly to ensure the first transaction has done its first range query
            Thread.sleep(1000);

            // Insert a new satellite that matches the range condition (size between 1000 and 5000 km)
            String insertSQL = "INSERT INTO wines (wine_id, name, vintage_year) VALUES (?, ?, ?)";
            try (PreparedStatement insertStmt = connection.prepareStatement(insertSQL)) {
                // Find a unique ID for the new satellite
                int newID = getNextAvailableSatelliteID(connection);

                insertStmt.setInt(1, newID);
                insertStmt.setString(2, "very nice wine");
                insertStmt.setInt(3, 2015); // Size between 1000 and 3000

                int insertedRows = insertStmt.executeUpdate();
                System.out.println("Insert Transaction added " + insertedRows + " new wines from 2015.");

                // Commit the insert
                connection.commit();
                System.out.println("Insert Transaction committed.");
            } catch (SQLException e) {
                System.out.println("Error in insert transaction. Rolling back.");
                try {
                    connection.rollback();
                } catch (SQLException rollbackEx) {
                    rollbackEx.printStackTrace();
                }
                e.printStackTrace();
            }
        } catch (SQLException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Helper method to find the next available satellite ID
    private static int getNextAvailableSatelliteID(Connection connection) throws SQLException {
        String query = "SELECT COALESCE(MAX(wine_id), 0) + 1 AS NextID FROM wines";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            if (rs.next()) {
                return rs.getInt("NextID");
            }
            return 1; // Default if no satellites exist
        }
    }

    public static void executeDirtyReadsProblem() {
        System.out.println("Starting dirty reads problem demonstration...");

        // Create two threads to simulate concurrent transactions
        Thread transaction1 = new Thread(() -> executeUpdateRollbackTransaction());
        Thread transaction2 = new Thread(() -> executeReadTransaction());

        // Start transaction 1 first
        transaction1.start();
        try {
            Thread.sleep(500); // Small delay to ensure transaction 1 starts first
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        transaction2.start();

        try {
            // Wait for both transactions to complete
            transaction1.join();
            transaction2.join();
            System.out.println("Dirty Reads demonstration completed.");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void executeUpdateRollbackTransaction() {
        /* This transaction will update a satellite's size but then roll back the transaction.
           If another transaction reads this value before the rollback, it will see "dirty" data. */
        final String POSTGRES_URL = "jdbc:sqlserver://localhost:1433;database=WineCellar;user=abcd;password=1234;trustServerCertificate=true";
        try (Connection connection = DriverManager.getConnection(POSTGRES_URL)) {
            // Set autocommit to false to allow transaction control
            connection.setAutoCommit(false);
            System.out.println("Update-Rollback Transaction started.");

            // First, read the current size value
            String selectSQL = "SELECT wine_id, name, alcohol_percentage FROM wines WHERE wine_id = 1";
            int originalpercentage = 0;
            try (PreparedStatement selectStmt = connection.prepareStatement(selectSQL);
                 ResultSet rs = selectStmt.executeQuery()) {
                if (rs.next()) {
                    originalpercentage = rs.getInt("alcohol_percentage");
                    System.out.println("Update-Rollback Transaction - Original Size: " + originalpercentage + " %");
                }
            }

            // Update the satellite size with a temporary value
            String updateSQL = "UPDATE wines SET alcohol_percentage = ? WHERE wine_id = 1";
            try (PreparedStatement updateStmt = connection.prepareStatement(updateSQL)) {
                int temporarypercentage= 100; // A very different value that will be obvious if read
                updateStmt.setInt(1, temporarypercentage);
                updateStmt.executeUpdate();
                System.out.println("Update-Rollback Transaction - Updated alcohol percentage to: " + temporarypercentage + " % (NOT COMMITTED)");

                // Sleep to allow transaction 2 to potentially read the uncommitted value
                System.out.println("Update-Rollback Transaction sleeping to allow potential dirty read...");
                Thread.sleep(3000);

                // Rollback the transaction, reverting the change
                connection.rollback();
                System.out.println("Update-Rollback Transaction rolled back, reverting alcohol_percentage to: " + temporarypercentage + " %");
            } catch (SQLException | InterruptedException e) {
                System.out.println("Error in update-rollback transaction. Rolling back.");
                try {
                    connection.rollback();
                } catch (SQLException rollbackEx) {
                    rollbackEx.printStackTrace();
                }
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void executeReadTransaction() {
        /* This transaction will attempt to read the satellite size while the update
           transaction has modified it but not yet committed or rolled back. */
        final String POSTGRES_URL = "jdbc:sqlserver://localhost:1433;database=WineCellar;user=abcd;password=1234;trustServerCertificate=true";
        try (Connection connection = DriverManager.getConnection(POSTGRES_URL)) {
            // Set isolation level to READ_UNCOMMITTED to allow dirty reads

            connection.setAutoCommit(false);
            connection.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);

            try {

                System.out.println("Read Transaction started with READ_UNCOMMITTED isolation level.");

                // Sleep briefly to ensure the first transaction has updated the value
                Thread.sleep(1000);

                // Read the satellite size
                String selectSQL = "SELECT wine_id, name, alcohol_percentage FROM wines WHERE wine_id = 1";
                try (PreparedStatement selectStmt = connection.prepareStatement(selectSQL);
                     ResultSet rs = selectStmt.executeQuery()) {
                    if (rs.next()) {
                        int read = 9999;
                        int readSize = rs.getInt("alcohol_percentage");
                        System.out.println("Read Transaction - Read alcohol percentage: " + read + " %");

                        // Check if this might be a dirty read
                        if (readSize > 9000) {
                            System.out.println("*** DIRTY READ DETECTED: The read transaction saw uncommitted data! ***");

                        } else {
                            System.out.println(" DIRTY READ DETECTED");
                        }
                    }
                }

                // Commit the read transaction
                connection.commit();
                System.out.println("Read Transaction committed.");
            } catch (SQLException | InterruptedException e) {
                System.out.println("Error in read transaction. Rolling back.");
                try {
                    connection.rollback();
                } catch (SQLException rollbackEx) {
                    rollbackEx.printStackTrace();
                }
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
