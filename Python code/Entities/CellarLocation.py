
class CellarLocation:
    def __init__(self, location_id, section, rack_number, bottle_position):
        self.location_id = location_id
        self.section = section
        self.rack_number = rack_number
        self.bottle_position = bottle_position

    def get_location_id(self):
        return self.location_id

    def get_section(self):
        return self.section

    def get_rack_number(self):
        return self.rack_number

    def get_bottle_position(self):
        return self.bottle_position

    def set_location_id(self, location_id):
        self.location_id = location_id

    def set_section(self, section):
        self.section = section

    def set_rack_number(self, rack_number):
        self.rack_number = rack_number

    def set_bottle_position(self, bottle_position):
        self.bottle_position = bottle_position

    def __str__(self):
        return f"Location: {self.section}-{self.rack_number}-{self.bottle_position}"