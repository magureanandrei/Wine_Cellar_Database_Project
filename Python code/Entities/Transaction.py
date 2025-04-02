
class Transaction:
    def __init__(self, transaction_id, wine_id, transaction_type, date, quantity, price_per_bottle, user_id):
        self.transaction_id = transaction_id
        self.wine_id = wine_id
        self.transaction_type = transaction_type
        self.date = date
        self.quantity = quantity
        self.price_per_bottle = price_per_bottle
        self.user_id = user_id

    def get_transaction_id(self):
        return self.transaction_id

    def get_wine_id(self):
        return self.wine_id

    def get_transaction_type(self):
        return self.transaction_type

    def get_date(self):
        return self.date

    def get_quantity(self):
        return self.quantity

    def get_price_per_bottle(self):
        return self.price_per_bottle

    def get_user_id(self):
        return self.user_id

    def set_transaction_id(self, transaction_id):
        self.transaction_id = transaction_id

    def set_wine_id(self, wine_id):
        self.wine_id = wine_id

    def set_transaction_type(self, transaction_type):
        self.transaction_type = transaction_type

    def set_date(self, date):
        self.date = date

    def set_quantity(self, quantity):
        self.quantity = quantity

    def set_price_per_bottle(self, price_per_bottle):
        self.price_per_bottle = price_per_bottle

    def set_user_id(self, user_id):
        self.user_id = user_id

    def __str__(self):
        return f"Transaction: {self.transaction_id}, {self.wine_id}, {self.transaction_type}, {self.date}, {self.quantity}, {self.price_per_bottle}, {self.user_id}"