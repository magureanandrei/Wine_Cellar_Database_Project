
class Wine_Type:
    def __init__(self, wine_type_id, wine_type_name):
        self.wine_type_id = wine_type_id
        self.wine_type_name = wine_type_name

    def get_wine_type_id(self):
        return self.wine_type_id

    def get_wine_type_name(self):
        return self.wine_type_name

    def set_wine_type_id(self, wine_type_id):
        self.wine_type_id = wine_type_id

    def set_wine_type_name(self, wine_type_name):
        self.wine_type_name = wine_type_name

    def __str__(self):
        return f'Wine_Type(wine_type_id={self.wine_type_id}, wine_type_name={self.wine_type_name})'
