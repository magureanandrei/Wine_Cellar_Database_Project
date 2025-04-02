from tkinter import messagebox
import Entities.Supplier

class UserRepo:
    def __init__(self,ssms_conn,pg_conn):
        self.ssms_conn = ssms_conn
        self.pg_conn = pg_conn

    def create_user(self,user):
        query = "INSERT INTO users (user_id, username, password_hash, role) VALUES (?, ?, ?, ?)"
        values = (user.user_id, user.username, user.password_hash, user.role)

        with self.ssms_conn.cursor() as ssms_cursor, self.pg_conn.cursor() as pg_cursor:
            ssms_cursor.execute(query, values)
            pg_cursor.execute(query.replace("?", "%s"), values)
            self.ssms_conn.commit()
            self.pg_conn.commit()

        messagebox.showinfo("Success", "User added successfully!")

    def read_users(self):
        query = "SELECT * FROM users"

        with self.ssms_conn.cursor() as ssms_cursor, self.pg_conn.cursor() as pg_cursor:
            ssms_cursor.execute(query)
            pg_cursor.execute(query)
            ssms_results = ssms_cursor.fetchall()
            pg_results = pg_cursor.fetchall()

        messagebox.showinfo("Users: ", "\n".join([str(row) for row in ssms_results]))

    def update_user(self, user):
        query = "UPDATE users SET username = ?, password_hash = ?, role = ? WHERE user_id = ?"
        values = (user.username, user.password_hash, user.role, user.user_id)

        with self.ssms_conn.cursor() as ssms_cursor, self.pg_conn.cursor() as pg_cursor:
            ssms_cursor.execute(query, values)
            pg_cursor.execute(query.replace("?", "%s"), values)
            self.ssms_conn.commit()
            self.pg_conn.commit()

        messagebox.showinfo("Success", "User updated successfully!")

    def delete_user(self,user_id):
        query = "DELETE FROM users WHERE user_id = ?"

        with self.ssms_conn.cursor() as ssms_cursor, self.pg_conn.cursor() as pg_cursor:
            ssms_cursor.execute(query, (user_id,))
            pg_cursor.execute(query.replace("?", "%s"), (user_id,))
            self.ssms_conn.commit()
            self.pg_conn.commit()

        messagebox.showinfo("Success", "User deleted successfully!")

    def get_user(self,user_id):
        query = "SELECT * FROM users WHERE user_id = ?"

        with self.ssms_conn.cursor() as ssms_cursor, self.pg_conn.cursor() as pg_cursor:
            ssms_cursor.execute(query, (user_id,))
            pg_cursor.execute(query.replace("?", "%s"), (user_id,))
            ssms_result = ssms_cursor.fetchone()
            pg_result = pg_cursor.fetchone()

        messagebox.showinfo("User: ", str(ssms_result))

