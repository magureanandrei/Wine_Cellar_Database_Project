import Models.*;

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
                    case 9:
                        // Execută tranzacții concurente cu izolare SERIALIZABLE
                        //executeConcurrentTransactions();
                        break;
                    case 10:
                        // Exemplu de dirty write
                        //executeConcurrencyProblem();
                        break;
                    case 11:
                        //Lost Update
                        //executeLostUpdateProblem();
                        break;
                    case 12:
                        //Unrepeatable Reads
                        //executeUnrepeatableReadsProblem();
                        break;
                    case 13:
                        //Phantom Reads
                        //executePhantomReadsProblem();
                        break;
                    case 14:
                        //Dirty Reads
                        //executeDirtyReadsProblem();
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

}
