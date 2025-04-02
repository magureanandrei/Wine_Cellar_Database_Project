
class Region:
    def __init__(self, region_id,name, country):
        self.name = name
        self.region_id = region_id
        self.country=country

    def get_region_id(self):
        return self.region_id

    def get_name(self):
        return self.name

    def get_country(self):
        return self.country

    def set_region_id(self, region_id):
        self.region_id = region_id

    def set_name(self, name):
        self.name = name

    def set_country(self, country):
        self.country = country

    def __str__(self):
        return f"Region: {self.name} ({self.country})"