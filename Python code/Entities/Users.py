
class Users:
    def __init__(self, user_id,name,password_hash,role):
        self.user_id = user_id
        self.name = name
        self.password_hash = password_hash
        self.role = role

    def get_user_id(self):
        return self.user_id

    def get_name(self):
        return self.name

    def get_password_hash(self):
        return self.password_hash

    def get_role(self):
        return self.role

    def set_user_id(self, user_id):
        self.user_id = user_id

    def set_name(self, name):
        self.name = name

    def set_password_hash(self, password_hash):
        self.password_hash = password_hash

    def set_role(self, role):
        self.role = role

    def __str__(self):
        return f'User: {self.user_id}, {self.name}, {self.password_hash}, {self.role}'

