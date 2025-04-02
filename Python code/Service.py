from Entities.CellarLocation import CellarLocation
from Entities.Inventory import Inventory
from Entities.Region import Region
from Entities.Supplier import Supplier
from Entities.Transaction import Transaction
from Entities.Users import Users
from Entities.Wines import Wines
from Entities.Wine_Type import Wine_Type
from Repos.CellarLocationRepo import CellarLocationRepo
from Repos.InventoryRepo import InventoryRepo
from Repos.RegionRepo import RegionRepo
from Repos.SupplierRepo import SupplierRepo
from Repos.TransactionRepo import TransactionRepo
from Repos.UserRepo import UserRepo
from Repos.WinesRepo import WinesRepo
from Repos.Wine_TypeRepo import Wine_TypeRepo

class Service:
    def __init__(self, ssms_conn, pg_conn):
        self.cellar_location_repo = CellarLocationRepo(ssms_conn, pg_conn)
        self.inventory_repo = InventoryRepo(ssms_conn, pg_conn)
        self.region_repo = RegionRepo(ssms_conn, pg_conn)
        self.supplier_repo = SupplierRepo(ssms_conn, pg_conn)
        self.transaction_repo = TransactionRepo(ssms_conn, pg_conn)
        self.user_repo = UserRepo(ssms_conn, pg_conn)
        self.wine_repo = WinesRepo(ssms_conn, pg_conn)
        self.wine_type_repo = Wine_TypeRepo(ssms_conn, pg_conn)

    def create_cellar_location(self, location_id, section, rack_number, bottle_position):
        cellar_location = CellarLocation(location_id,section,rack_number,bottle_position)
        self.cellar_location_repo.create_cellarlocation(cellar_location)

    def read_cellar_locations(self):
        self.cellar_location_repo.read_cellarlocations()

    def update_cellar_location(self, location_id, section, rack_number, bottle_position):
        cellar_location = CellarLocation(location_id,section,rack_number,bottle_position)
        self.cellar_location_repo.update_cellarlocation(cellar_location)

    def delete_cellar_location(self, location_id):
        self.cellar_location_repo.delete_cellarlocation(location_id)

    def get_cellar_location(self, location_id):
        self.cellar_location_repo.get_cellarlocation(location_id)

    def create_inventory(self, inventory_id, wine_id, location_id, quantity, bottle_size_ml):
        inventory = Inventory(inventory_id, wine_id, location_id, quantity, bottle_size_ml)
        self.inventory_repo.create_inventory(inventory)

    def read_inventory(self):
        self.inventory_repo.read_inventory()

    def update_inventory(self, inventory_id, wine_id, location_id, quantity, bottle_size_ml):
        inventory = Inventory(inventory_id, wine_id, location_id, quantity, bottle_size_ml)
        self.inventory_repo.update_inventory(inventory)

    def delete_inventory(self, inventory_id):
        self.inventory_repo.delete_inventory(inventory_id)

    def get_inventory(self, inventory_id):
        self.inventory_repo.get_inventory(inventory_id)

    def create_region(self, region_id, region_name,country):
        region=Region(region_id, region_name,country)
        self.region_repo.create_region(region)

    def read_region(self):
        self.region_repo.read_region()

    def update_region(self, region_id, region_name,country):
        region=Region(region_id, region_name,country)
        self.region_repo.update_region(region)

    def delete_region(self, region_id):
        self.region_repo.delete_region(region_id)

    def get_region(self, region_id):
        self.region_repo.get_region(region_id)

    def create_supplier(self, supplier_id, supplier_name, supplier_email, supplier_phone, supplier_address):
        supplier = Supplier(supplier_id, supplier_name, supplier_email, supplier_phone, supplier_address)
        self.supplier_repo.create_supplier(supplier)

    def read_supplier(self):
        self.supplier_repo.read_supplier()

    def update_supplier(self, supplier_id, supplier_name, supplier_email, supplier_phone, supplier_address):
        supplier = Supplier(supplier_id, supplier_name, supplier_email, supplier_phone, supplier_address)
        self.supplier_repo.update_supplier(supplier)

    def delete_supplier(self, supplier_id):
        self.supplier_repo.delete_supplier(supplier_id)

    def get_supplier(self, supplier_id):
        self.supplier_repo.get_supplier(supplier_id)

    def create_transaction(self, transaction_id, transaction_wine_id, transaction_type,transaction_date, transaction_quantity, price_per_bottle, user_id):
        transaction = Transaction(transaction_id, transaction_wine_id, transaction_type, transaction_date, transaction_quantity, price_per_bottle, user_id)
        self.transaction_repo.create_transaction(transaction)

    def read_transaction(self):
        self.transaction_repo.read_transactions()

    def update_transaction(self, transaction_id, transaction_wine_id, transaction_type,transaction_date, transaction_quantity, price_per_bottle, user_id):
        transaction = Transaction(transaction_id, transaction_wine_id, transaction_type, transaction_date, transaction_quantity, price_per_bottle, user_id)
        self.transaction_repo.update_transaction(transaction)

    def delete_transaction(self, transaction_id):
        self.transaction_repo.delete_transaction(transaction_id)

    def get_transaction(self, transaction_id):
        self.transaction_repo.get_transaction(transaction_id)

    def create_user(self, user_id, user_name, user_hash, user_role):
        user = Users(user_id, user_name, user_hash, user_role)
        self.user_repo.create_user(user)

    def read_user(self):
        self.user_repo.read_users()

    def update_user(self, user_id, user_name, user_hash, user_role):
        user = Users(user_id, user_name, user_hash, user_role)
        self.user_repo.update_user(user)

    def delete_user(self, user_id):
        self.user_repo.delete_user(user_id)

    def get_user(self, user_id):
        self.user_repo.get_user(user_id)

    def create_wine(self, wine_id, wine_name, wine_type_id, wine_region_id, vintage_year, alcohol_percentage, supplier_id):
        wine = Wines(wine_id, wine_name, wine_type_id, wine_region_id, vintage_year, alcohol_percentage, supplier_id)
        self.wine_repo.create_wine(wine)

    def read_wine(self):
        self.wine_repo.read_wines()

    def update_wine(self, wine_id, wine_name, wine_type_id, wine_region_id, vintage_year, alcohol_percentage, supplier_id):
        wine = Wines(wine_id, wine_name, wine_type_id, wine_region_id, vintage_year, alcohol_percentage, supplier_id)
        self.wine_repo.update_wine(wine)

    def delete_wine(self, wine_id):
        self.wine_repo.delete_wine(wine_id)

    def get_wine(self, wine_id):
        self.wine_repo.get_wine(wine_id)

    def create_wine_type(self, type_id, type_name):
        wine_type = Wine_Type(type_id, type_name)
        self.wine_type_repo.create_wine_type(wine_type)

    def read_wine_type(self):
        self.wine_type_repo.read_wine_types()

    def update_wine_type(self, type_id, type_name):
        wine_type = Wine_Type(type_id, type_name)
        self.wine_type_repo.update_wine_type(wine_type)

    def delete_wine_type(self, type_id):
        self.wine_type_repo.delete_wine_type(type_id)

    def get_wine_type(self, type_id):
        self.wine_type_repo.get_wine_type(type_id)








