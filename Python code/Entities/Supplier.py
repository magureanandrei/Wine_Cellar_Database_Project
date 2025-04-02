
class Supplier:
    def __init__(self, supplier_id, supplier_name, email, phone,address):
        self.supplier_id = supplier_id
        self.supplier_name=supplier_name
        self.address = address
        self.phone = phone
        self.email = email

    def get_supplier_id(self):
        return self.supplier_id

    def get_supplier_name(self):
        return self.supplier_name

    def get_address(self):
        return self.address

    def get_phone(self):
        return self.phone

    def get_email(self):
        return self.email

    def set_supplier_id(self, supplier_id):
        self.supplier_id = supplier_id

    def set_supplier_name(self, supplier_name):
        self.supplier_name = supplier_name

    def set_address(self, address):
        self.address = address

    def set_phone(self, phone):
        self.phone = phone

    def set_email(self, email):
        self.email = email

    def __str__(self):
        return f"Supplier ID: {self.supplier_id}, Name: {self.supplier_name}, Address: {self.address}, Phone: {self.phone}, Email: {self.email}"