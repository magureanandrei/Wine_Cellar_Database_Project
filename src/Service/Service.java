package Service;

import Models.*;
import Repos.*;

import javax.print.CancelablePrintJob;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Service {
    private Connection connection;
    private final Repository<CellarLocation> cellarLocationRepo;
    private final Repository<Inventory> inventoryRepo;
    private final Repository<Region> regionrepo;
    private final Repository<Supplier> supplierRepo;
    private final Repository<Transactions> transactionsRepo;
    private final Repository<Users> userrepo;
    private final Repository<Wines> winerepo;
    private final Repository<WineType> wineTypeRepo;

    public Service(String dbUrl) throws Exception {
        this.connection= DriverManager.getConnection(dbUrl);
        this.cellarLocationRepo = new DBCellarLocationRepo(dbUrl);
        this.inventoryRepo = new DBInventoryRepo(dbUrl);
        this.regionrepo = new DBRegionRepo(dbUrl);
        this.supplierRepo = new DBSupplierRepo(dbUrl);
        this.transactionsRepo = new DBTransactionsRepo(dbUrl);
        this.userrepo = new DBUsersRepo(dbUrl);
        this.winerepo = new DBWinesRepo(dbUrl);
        this.wineTypeRepo = new DBWineTypeRepo(dbUrl);
    }

    public Connection getConnection(String dbUrl) throws SQLException {
        return DriverManager.getConnection(dbUrl);
    }


    public void createWine(Wines wine){
        winerepo.create(wine);
    }

    public Wines getWine(int id){
        return winerepo.get(id);
    }

        public void updateWine(int wine_id, String newName, int newTypeID, int newRegionID,int  newVintageYear, int alcoholPercentage, int supplierID) {
            Wines wine = winerepo.get(wine_id);
            if (wine == null) {
                System.out.println("Wine with ID " + wine_id + " not found.");
                return;
            }
            wine.setName(newName);
            wine.setType_id(newTypeID);
            wine.setRegion_id(newRegionID);
            wine.setVintage_year(newVintageYear);
            wine.setAlcohol_percentage(alcoholPercentage);
            wine.setSupplier_id(supplierID);
            winerepo.update(wine);
            System.out.println("Wine updated successfully.");
        }

    public void deleteWine(int id){
        winerepo.delete(id);
    }

    public List<Wines> getAllWines(){
        return winerepo.getAll();
    }

    public void createWineType(WineType wineType){
        wineTypeRepo.create(wineType);
    }

    public WineType getWineType(int id){
        return wineTypeRepo.get(id);
    }

    public void updateWineType(int winetype_id, String newName) {
        WineType wineType = wineTypeRepo.get(winetype_id);
        if (wineType == null) {
            System.out.println("WineType with ID " + winetype_id + " not found.");
            return;
        }
        wineType.setName(newName);
        wineTypeRepo.update(wineType);
        System.out.println("WineType updated successfully.");
        
    }

    public void deleteWineType(int id){
        wineTypeRepo.delete(id);
    }

    public List<WineType> getAllWineTypes(){
        return wineTypeRepo.getAll();
    }

    public void createRegion(Region region){
        regionrepo.create(region);
    }

    public Region getRegion(int id){
        return regionrepo.get(id);
    }

    public void updateRegion(int region_id, String newRegionName, String newRegionCountry) {
        Region region = regionrepo.get(region_id);
        if (region == null) {
            System.out.println("Region with ID " + region_id + " not found.");
            return;
        }
        region.setRegion_name(newRegionName);
        region.setCountry(newRegionCountry);
        regionrepo.update(region);
        System.out.println("Region updated successfully.");

    }

    public void deleteRegion(int id){
        regionrepo.delete(id);
    }

    public List<Region> getAllRegions(){
        return regionrepo.getAll();
    }

    public void createSupplier(Supplier supplier){
        supplierRepo.create(supplier);
    }

    public Supplier getSupplier(int id){
        return supplierRepo.get(id);
    }

    public void updateSupplier(int supplier_id, String newName,String newEmail, String newPhone,String newAddress) {
        Supplier supplier = supplierRepo.get(supplier_id);
        if (supplier == null) {
            System.out.println("Supplier with ID " + supplier_id + " not found.");
            return;
        }
        supplier.setSupplier_name(newName);
        supplier.setAddress(newAddress);
        supplier.setPhone(newPhone);
        supplier.setContact_email(newEmail);
        supplierRepo.update(supplier);
        System.out.println("Supplier updated successfully.");

    }

    public void deleteSupplier(int id){
        supplierRepo.delete(id);
    }

    public List<Supplier> getAllSuppliers(){
        return supplierRepo.getAll();
    }

    public void createCellarLocation(CellarLocation cellarLocation){
        cellarLocationRepo.create(cellarLocation);
    }

    public CellarLocation getCellarLocation(int id){
        return cellarLocationRepo.get(id);
    }

    public void updateCellarLocation(int location_id, String newSection, int newRackNumber, int newBottlePosition) {
        CellarLocation cellarLocation = cellarLocationRepo.get(location_id);
        if (cellarLocation == null) {
            System.out.println("CellarLocation with ID " + location_id + " not found.");
            return;
        }
        cellarLocation.setSection(newSection);
        cellarLocation.setRack_number(newRackNumber);
        cellarLocation.setBottle_position(newBottlePosition);
        cellarLocationRepo.update(cellarLocation);
        System.out.println("CellarLocation updated successfully.");

    }

    public void deleteCellarLocation(int id){
        cellarLocationRepo.delete(id);
    }

    public List<CellarLocation> getAllCellarLocations(){
        return cellarLocationRepo.getAll();
    }

    public void createInventory(Inventory inventory){
        inventoryRepo.create(inventory);
    }

    public Inventory getInventory(int id){
        return inventoryRepo.get(id);
    }

    public void updateInventory(int inventory_id, int newWine_id, int newLocation_id, int newQuantity, int newBottle_size_ml) {
        Inventory inventory = inventoryRepo.get(inventory_id);
        if (inventory == null) {
            System.out.println("Inventory with ID " + inventory_id + " not found.");
            return;
        }
        inventory.setWine_id(newWine_id);
        inventory.setLocation_id(newLocation_id);
        inventory.setQuantity(newQuantity);
        inventory.setBottle_size_ml(newBottle_size_ml);
        inventoryRepo.update(inventory);
        System.out.println("Inventory updated successfully.");
    }

    public void deleteInventory(int id){
        inventoryRepo.delete(id);
    }

    public List<Inventory> getAllInventories(){
        return inventoryRepo.getAll();
    }

    public void createTransaction(Transactions transaction){
        transactionsRepo.create(transaction);
    }

    public Transactions getTransaction(int id){
        return transactionsRepo.get(id);
    }

    public void updateTransaction(int transaction_id, int newWine_id, String newTransactionType, String newDate, int newQuantity, int newPricePerBottle, int newUserID) {
        Transactions transaction = transactionsRepo.get(transaction_id);
        if (transaction == null) {
            System.out.println("Transaction with ID " + transaction_id + " not found.");
            return;
        }
        transaction.setWine_id(newWine_id);
        transaction.setTransaction_type(newTransactionType);
        transaction.setDate(newDate);
        transaction.setQuantity(newQuantity);
        transaction.setPrice_per_bottle(newPricePerBottle);
        transaction.setUser_id(newUserID);
        transactionsRepo.update(transaction);
        System.out.println("Transaction updated successfully.");

    }

    public void deleteTransaction(int id){
        transactionsRepo.delete(id);
    }

    public List<Transactions> getAllTransactions(){
        return transactionsRepo.getAll();
    }

    public void createUser(Users user){
        userrepo.create(user);
    }

    public Users getUser(int id){
        return userrepo.get(id);
    }

    public void updateUser(int user_id, String newName, String newPasswordHash, String newRole) {
        Users user = userrepo.get(user_id);
        if (user == null) {
            System.out.println("User with ID " + user_id + " not found.");
            return;
        }
        user.setUsername(newName);
        user.setPassword_hash(newPasswordHash);
        user.setRole(newRole);
        userrepo.update(user);
        System.out.println("User updated successfully.");

    }

    public void deleteUser(int id){
        userrepo.delete(id);
    }

    public List<Users> getAllUsers(){
        return userrepo.getAll();
    }

    public void executeStatement(String sql) {
        try {
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            System.out.println("Executed: " + sql);
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
