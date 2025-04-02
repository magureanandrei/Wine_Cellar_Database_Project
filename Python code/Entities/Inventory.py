class Inventory:
    def __init__(self, inventory_id, wine_id, location_id, quantity, bottle_size_ml):
        self.inventory_id = inventory_id
        self.wine_id = wine_id
        self.location_id = location_id
        self.quantity = quantity
        self.bottle_size_ml = bottle_size_ml

    def get_inventory_id(self):
        return self.inventory_id

    def get_wine_id(self):
        return self.wine_id

    def get_location_id(self):
        return self.location_id

    def get_quantity(self):
        return self.quantity

    def get_bottle_size_ml(self):
        return self.bottle_size_ml

    def set_inventory_id(self, inventory_id):
        self.inventory_id = inventory_id

    def set_wine_id(self, wine_id):
        self.wine_id = wine_id

    def set_location_id(self, location_id):
        self.location_id = location_id

    def set_quantity(self, quantity):
        self.quantity = quantity

    def set_bottle_size_ml(self, bottle_size_ml):
        self.bottle_size_ml = bottle_size_ml

    def __str__(self):
        return f"Inventory: {self.wine_id} ({self.quantity} bottles)"