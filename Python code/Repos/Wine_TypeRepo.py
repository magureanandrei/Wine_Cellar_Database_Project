from tkinter import messagebox
import Entities.Wine_Type

class Wine_TypeRepo:
    def __init__(self,ssms_conn,pg_conn):
        self.ssms_conn = ssms_conn
        self.pg_conn = pg_conn

    def create_wine_type(self,wine_type):
        query = "INSERT INTO winetype (type_id, type_name) VALUES (?, ?)"
        values = (wine_type.type_id, wine_type.type_name)

        with self.ssms_conn.cursor() as ssms_cursor, self.pg_conn.cursor() as pg_cursor:
            ssms_cursor.execute(query, values)
            pg_cursor.execute(query.replace("?", "%s"), values)
            self.ssms_conn.commit()
            self.pg_conn.commit()

        messagebox.showinfo("Success", "WineType added successfully!")

    def read_wine_types(self):
        query = "SELECT * FROM winetype"

        with self.ssms_conn.cursor() as ssms_cursor, self.pg_conn.cursor() as pg_cursor:
            ssms_cursor.execute(query)
            pg_cursor.execute(query)
            ssms_results = ssms_cursor.fetchall()
            pg_results = pg_cursor.fetchall()

        messagebox.showinfo("WineTypes: ", "\n".join([str(row) for row in ssms_results]))

    def update_wine_type(self,wine_type):
        query = "UPDATE winetype SET type_name = ? WHERE type_id = ?"
        values = (wine_type.type_name, wine_type.type_id)

        with self.ssms_conn.cursor() as ssms_cursor, self.pg_conn.cursor() as pg_cursor:
            ssms_cursor.execute(query, values)
            pg_cursor.execute(query.replace("?", "%s"), values)
            self.ssms_conn.commit()
            self.pg_conn.commit()

        messagebox.showinfo("Success", "WineType updated successfully!")

    def delete_wine_type(self,type_id):
        query = "DELETE FROM winetype WHERE type_id = ?"

        with self.ssms_conn.cursor() as ssms_cursor, self.pg_conn.cursor() as pg_cursor:
            ssms_cursor.execute(query, (type_id,))
            pg_cursor.execute(query.replace("?", "%s"), (type_id,))
            self.ssms_conn.commit()
            self.pg_conn.commit()

        messagebox.showinfo("Success", "WineType deleted successfully!")

    def get_wine_type(self,type_id):
        query = "SELECT * FROM winetype WHERE type_id = ?"

        with self.ssms_conn.cursor() as ssms_cursor, self.pg_conn.cursor() as pg_cursor:
            ssms_cursor.execute(query, (type_id,))
            pg_cursor.execute(query.replace("?", "%s"), (type_id,))
            ssms_result = ssms_cursor.fetchone()
            pg_result = pg_cursor.fetchone()

        messagebox.showinfo("WineType: ", str(ssms_result))

