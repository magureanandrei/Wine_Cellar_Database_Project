import Models.*;
import Service.Service;

public class Main {
    public static void main(String[] args) throws Exception {
        // Create services
        final String dbUrl = "jdbc:postgresql://localhost:5432/WineCellar?currentSchema=public&user=postgres&password=1234";
        final String dbUrl2 = "jdbc:sqlserver://localhost:1433;database=WineCellar;user=abcd;password=1234;trustServerCertificate=true";
        Service postgresqlService = new Service(dbUrl);
        Service ssmsService = new Service(dbUrl2);

        //clearAllTables(postgresqlService, ssmsService);

        // Add sample data
        //addSampleData(postgresqlService, ssmsService,dbUrl2);

        // Run UI
        UI ui = new UI();
        ui.run();
    }

    private static void addSampleData(Service postgresqlService, Service ssmsService, String dbUrlssms) throws Exception {
        // Add Wine Types
        WineType[] wineTypes = {
                new WineType(1, "Red"),
                new WineType(2, "White"),
                new WineType(3, "Rosé"),
                new WineType(4, "Sparkling")
        };

        CellarLocation[] cellarLocations = {
                new CellarLocation(1, "Main Cellar", 1, 1),
                new CellarLocation(2, "Reserve Cellar", 3, 2),
                new CellarLocation(3, "Aging Room", 2, 3),
                new CellarLocation(4, "Display Area", 5, 4)
        };

        // Add Regions
        Region[] regions = {
                new Region(1, "Bordeaux", "France"),
                new Region(2, "Tuscany", "Italy"),
                new Region(3, "Napa Valley", "USA"),
                new Region(4, "Mendoza", "Argentina")
        };

        // Add Suppliers
        Supplier[] suppliers = {
                new Supplier(1, "French Vineyards Ltd.", "french.vineyards@contact.com", "+33142758933", "25 Rue du Vin"),
                new Supplier(2, "Italian Wine Imports", "italian.wineimports@gmail.com", "+39055293781", "17 Via Roma"),
                new Supplier(3, "California Wine Co.", "california.wineco@work.com", "+17075559876", "1050 Napa Highway"),
                new Supplier(4, "Argentinian Estates", "argentinian.estates@info.com", "+542615448732", "42 Calle Mendoza")
        };

        // Add Wines
        Wines[] wines = {
                new Wines(1, "Château Margaux", 1, 1, 2015, 13, 1),
                new Wines(2, "Chianti Classico", 1, 2, 2018, 14, 2),
                new Wines(3, "Chardonnay Reserve", 2, 3, 2019, 12, 3),
                new Wines(4, "Malbec Premium", 1, 4, 2017, 13, 2),
                new Wines(5, "Prosecco Extra Dry", 4, 2, 2020, 11, 1),
                new Wines(6, "Cabernet Sauvignon", 1, 3, 2016, 14, 3),
                new Wines(7, "Pinot Grigio", 2, 2, 2021, 12, 2),
                new Wines(8, "Malbec Reserve", 1, 4, 2015, 14, 4)
        };

        // Add Users
        Users[] users = {
                new Users(1, "admin", "admin123", "admin"),
                new Users(2, "sommelier", "wine123", "staff"),
                new Users(3, "customer", "pass123", "customer"),
                new Users(4, "manager", "mgr456", "admin"),
                new Users(5, "cellarmaster", "cellar789", "staff")
        };

        // Add Transactions
        Transactions[] transactions = {
                new Transactions(1, 1, "purchase", "2023-10-15", 24, 65, 2),
                new Transactions(2, 3, "sale", "2023-10-18", 6, 45, 3),
                new Transactions(3, 5, "purchase", "2023-10-20", 36, 22, 2),
                new Transactions(4, 2, "sale", "2023-10-22", 12, 37, 3),
                new Transactions(5, 6, "purchase", "2023-11-05", 18, 42, 4),
                new Transactions(6, 4, "sale", "2023-11-10", 3, 55, 5),
                new Transactions(7, 7, "purchase", "2023-11-15", 30, 18, 2),
                new Transactions(8, 8, "purchase", "2023-11-20", 12, 75, 1)
        };

        Inventory[] inventories = {
                new Inventory(1, 1, 1, 24, 750),    // Château Margaux in Main Cellar
                new Inventory(2, 2, 1, 18, 750),    // Chianti Classico in Main Cellar
                new Inventory(3, 3, 2, 36, 750),    // Chardonnay Reserve in Reserve Cellar
                new Inventory(4, 4, 2, 12, 750),    // Malbec Premium in Reserve Cellar
                new Inventory(5, 5, 3, 42, 750),    // Prosecco Extra Dry in Aging Room
                new Inventory(6, 6, 3, 15, 1500),   // Cabernet Sauvignon in Aging Room (magnum size)
                new Inventory(7, 7, 4, 30, 375),    // Pinot Grigio in Display Area (half bottles)
                new Inventory(8, 8, 4, 6, 750)      // Malbec Reserve in Display Area
        };



        // Insert data into both services
        // For Wine Types
            for (WineType wt : wineTypes) {
                ssmsService.createWineType(wt);
                postgresqlService.createWineType(wt);// Make sure this uses the SAME connection
            }


// For Regions
        for (Region r : regions) {
            postgresqlService.createRegion(r);
            ssmsService.createRegion(r);
        }

// For CellarLocations
        for (CellarLocation cl : cellarLocations) {
            postgresqlService.createCellarLocation(cl);
            ssmsService.createCellarLocation(cl);
        }

// For Suppliers
        for (Supplier s : suppliers) {
            postgresqlService.createSupplier(s);
            ssmsService.createSupplier(s);
        }

// For Wines
        for (Wines w : wines) {
            postgresqlService.createWine(w);
            ssmsService.createWine(w);
        }

// For Users
        for (Users u : users) {
            postgresqlService.createUser(u);
            ssmsService.createUser(u);
        }

// For Transactions
        for (Transactions t : transactions) {
            postgresqlService.createTransaction(t);
            ssmsService.createTransaction(t);
        }

        for (Inventory inv : inventories) {
            postgresqlService.createInventory(inv);
            ssmsService.createInventory(inv);
        }

        System.out.println("Sample data added successfully!");
    }
    private static void clearAllTables(Service postgresqlService, Service ssmsService) {
        try {
            // Clear tables in reverse order of dependencies
            postgresqlService.executeStatement("DELETE FROM transactions");
            ssmsService.executeStatement("DELETE FROM transactions");

            postgresqlService.executeStatement("DELETE FROM users");
            ssmsService.executeStatement("DELETE FROM users");

            postgresqlService.executeStatement("DELETE FROM wines");
            ssmsService.executeStatement("DELETE FROM wines");

            postgresqlService.executeStatement("DELETE FROM supplier");
            ssmsService.executeStatement("DELETE FROM supplier");

            postgresqlService.executeStatement("DELETE FROM cellarlocation");
            ssmsService.executeStatement("DELETE FROM cellarlocation");

            postgresqlService.executeStatement("DELETE FROM region");
            ssmsService.executeStatement("DELETE FROM region");

            postgresqlService.executeStatement("DELETE FROM winetype");
            ssmsService.executeStatement("DELETE FROM winetype");

            System.out.println("All tables cleared successfully!");
        } catch (Exception e) {
            System.err.println("Error clearing tables: " + e.getMessage());
            e.printStackTrace();
        }
    }
}