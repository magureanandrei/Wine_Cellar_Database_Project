package Controller;

import Models.*;
import Service.Service;
import java.util.Scanner;

public class CRUDController {

    static final String dbUrl = "jdbc:postgresql://localhost:5432/WineCellar?currentSchema=public&user=postgres&password=1234";
    static final String dbUrl2 = "jdbc:sqlserver://localhost:1433;database=WineCellar;user=abcd;password=1234;trustServerCertificate=true";
    private static final Service postgresqlService;

    static {
        try {
            postgresqlService = new Service(dbUrl);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static final Service ssmsService;
    static {
        try {
            ssmsService = new Service(dbUrl2);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public CRUDController() throws Exception {
    }


    public static void handleCellarLocationOperations(int crudChoice, Scanner scanner) {
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
                System.out.println("Cellar location added successfully!");
                break;
            case 2: // getAll
                System.out.println("All Cellar Locations: " + postgresqlService.getAllCellarLocations());
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
                System.out.println("Cellar location updated successfully!");
                break;
            case 4: // Delete
                System.out.println("Enter id:");
                id = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                postgresqlService.deleteCellarLocation(id);
                ssmsService.deleteCellarLocation(id);
                System.out.println("Cellar location deleted successfully!");
                break;
            case 5: //get
                System.out.println("Enter id:");
                id = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                System.out.println("Cellar Location: "+postgresqlService.getCellarLocation(id));
                ssmsService.getCellarLocation(id);
                break;
            default:
                System.out.println("Invalid choice");
        }
    }
    public static void handleInventoryOperations(int crudChoice, Scanner scanner){
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
                System.out.println("Inventory item added successfully!");
                break;
            case 2: // getAll
                System.out.println("All inventory items: " + postgresqlService.getAllInventories());
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
                System.out.println("Inventory updated successfully!");
                break;
            case 4: // Delete
                System.out.println("Enter id:");
                id = scanner.nextInt();
                scanner.nextLine(); // Consumă newline
                postgresqlService.deleteInventory(id);
                ssmsService.deleteInventory(id);
                System.out.println("Inventory deleted successfully!");
                break;
            case 5: //get
                System.out.println("Enter id:");
                id = scanner.nextInt();
                scanner.nextLine(); // Consumă newline
                System.out.println("Inventory item: "+postgresqlService.getInventory(id));
                ssmsService.getInventory(id);
                break;
            default:
                System.out.println("Invalid choice");
        }
    }
    public static void handleRegionOperations(int crudChoice, Scanner scanner){
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
                System.out.println("Region added successfully!");
                break;
            case 2: // getAll
                System.out.println("All Regions: " + postgresqlService.getAllRegions());
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
                System.out.println("Region updated successfully!");
                break;
            case 4: // Delete
                System.out.println("Enter id:");
                id = scanner.nextInt();
                scanner.nextLine(); // Consumă newline
                postgresqlService.deleteRegion(id);
                ssmsService.deleteRegion(id);
                System.out.println("Region deleted successfully!");
                break;
            case 5: //get
                System.out.println("Enter id:");
                id = scanner.nextInt();
                scanner.nextLine(); // Consumă newline
                System.out.println("Region: "+ postgresqlService.getRegion(id));
                ssmsService.getRegion(id);
                break;
            default:
                System.out.println("Invalid choice");
        }
    }
    public static void handleSupplierOperations(int crudChoice, Scanner scanner){
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
                System.out.println("Supplier added successfully!");
                break;
            case 2: // getAll
                System.out.println("All Suppliers: " + postgresqlService.getAllSuppliers());
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
                System.out.println("Supplier updated successfully!");
                break;
            case 4: // Delete
                System.out.println("Enter id:");
                id = scanner.nextInt();
                scanner.nextLine(); // Consumă newline
                postgresqlService.deleteSupplier(id);
                ssmsService.deleteSupplier(id);
                System.out.println("Supplier deleted successfully!");
                break;
            case 5: //get
                System.out.println("Enter id:");
                id = scanner.nextInt();
                scanner.nextLine(); // Consumă newline
                System.out.println("Supplier: " + postgresqlService.getSupplier(id));
                ssmsService.getSupplier(id);
                break;
            default:
                System.out.println("Invalid choice");
        }
    }

    public static void handleTransactionOperations(int crudChoice, Scanner scanner) {
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
                System.out.println("Transaction added successfully!");
                break;
            case 2: // getAll
                System.out.println("All Transactions: " + postgresqlService.getAllTransactions());
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
                System.out.println("Transaction updated successfully!");
                break;
            case 4: // Delete
                System.out.println("Enter id:");
                id = scanner.nextInt();
                scanner.nextLine(); // Consumă newline
                postgresqlService.deleteTransaction(id);
                ssmsService.deleteTransaction(id);
                System.out.println("Transaction deleted successfully!");
                break;
            case 5: //get
                System.out.println("Enter id:");
                id = scanner.nextInt();
                scanner.nextLine(); // Consumă newline
                System.out.println("Transaction: " + postgresqlService.getTransaction(id));
                ssmsService.getTransaction(id);
                break;
            default:
                System.out.println("Invalid choice");
        }
    }

    public static void handleUsersOperations(int crudChoice, Scanner scanner) {
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
                System.out.println("User added successfully!");
                break;
            case 2: // getAll
                System.out.println("All Users: " + postgresqlService.getAllUsers());
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
                System.out.println("User updated successfully!");
                break;
            case 4: // Delete
                System.out.println("Enter id:");
                id = scanner.nextInt();
                scanner.nextLine(); // Consumă newline
                postgresqlService.deleteUser(id);
                ssmsService.deleteUser(id);
                System.out.println("User deleted successfully!");
                break;
            case 5: //get
                System.out.println("Enter id:");
                id = scanner.nextInt();
                scanner.nextLine(); // Consumă newline
                System.out.println("User: " + postgresqlService.getUser(id));
                ssmsService.getUser(id);
                break;
            default:
                System.out.println("Invalid choice");
        }
    }
    public static void handleWineOperations(int crudChoice, Scanner scanner) {
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
                System.out.println("Wine added successfully!");
                break;
            case 2: // getAll
                System.out.println("All Wines: " + postgresqlService.getAllWines());
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
                System.out.println("Wine updated successfully!");
                break;
            case 4: // Delete
                System.out.println("Enter id:");
                id = scanner.nextInt();
                scanner.nextLine(); // Consumă newline
                postgresqlService.deleteWine(id);
                ssmsService.deleteWine(id);
                System.out.println("Wine deleted successfully!");
                break;
            case 5: //get
                System.out.println("Enter id:");
                id = scanner.nextInt();
                scanner.nextLine(); // Consumă newline
                System.out.println("Wine: " + postgresqlService.getWine(id));
                ssmsService.getWine(id);
                break;
            default:
                System.out.println("Invalid choice");
        }
    }

    public static void handleWineTypeOperations(int crudChoice, Scanner scanner) {
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
                System.out.println("Wine type added successfully!");
                break;
            case 2: // getAll
                System.out.println("All Wine Types: " + postgresqlService.getAllWineTypes());
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
                System.out.println("Wine Type updated successfully!");
                break;
            case 4: // Delete
                System.out.println("Enter id:");
                id = scanner.nextInt();
                scanner.nextLine(); // Consumă newline
                postgresqlService.deleteWineType(id);
                ssmsService.deleteWineType(id);
                System.out.println("Wine Type deleted successfully!");
                break;
            case 5: //get
                System.out.println("Enter id:");
                id = scanner.nextInt();
                scanner.nextLine(); // Consumă newline
                System.out.println("Wine Type: " + postgresqlService.getWineType(id));
                ssmsService.getWineType(id);
                break;
            default:
                System.out.println("Invalid choice");
        }
    }
}
