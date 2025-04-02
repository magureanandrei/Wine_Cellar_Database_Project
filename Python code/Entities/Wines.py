
class Wines:
    def __init__(self, wine_id, name, type_id, region_id, vinatage_year, alcohol_percentage, supplier_id):
        self.wine_id = wine_id
        self.name = name
        self.type_id = type_id
        self.region_id = region_id
        self.vinatage_year = vinatage_year
        self.alcohol_percentage = alcohol_percentage
        self.supplier_id = supplier_id

    def get_wine_id(self):
        return self.wine_id

    def get_name(self):
        return self.name

    def get_type_id(self):
        return self.type_id

    def get_region_id(self):
        return self.region_id

    def get_vinatage_year(self):
        return self.vinatage_year

    def get_alcohol_percentage(self):
        return self.alcohol_percentage

    def get_supplier_id(self):
        return self.supplier_id

    def set_wine_id(self, wine_id):
        self.wine_id = wine_id

    def set_name(self, name):
        self.name = name

    def set_type_id(self, type_id):
        self.type_id = type_id

    def set_region_id(self, region_id):
        self.region_id = region_id

    def set_vinatage_year(self, vinatage_year):
        self.vinatage_year = vinatage_year

    def set_alcohol_percentage(self, alcohol_percentage):
        self.alcohol_percentage = alcohol_percentage

    def set_supplier_id(self, supplier_id):
        self.supplier_id = supplier_id

    def __str__(self):
        return f"Wine: ID: {self.wine_id}, Name: {self.name}, Type ID: {self.type_id}, Region ID: {self.region_id}, Vintage Year: {self.vinatage_year}, Alcohol Percentage: {self.alcohol_percentage}, Supplier ID: {self.supplier_id}"