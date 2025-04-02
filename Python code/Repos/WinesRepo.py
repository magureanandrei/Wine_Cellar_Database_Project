from tkinter import messagebox


class WinesRepo:
    def __init__(self,ssms_conn,pg_conn):
        self.ssms_conn = ssms_conn
        self.pg_conn = pg_conn

    def create_wine(self,wine):
        query = "INSERT INTO wines (wine_id, name, type_id, region_id, vintage_year, alcohol_percentage, supplier_id) VALUES (?, ?, ?, ?, ?, ?, ?)"
        values = (wine.wine_id, wine.name, wine.type_id, wine.region_id, wine.vintage_year, wine.alcohol_percentage, wine.supplier_id)

        with self.ssms_conn.cursor() as ssms_cursor, self.pg_conn.cursor() as pg_cursor:
            ssms_cursor.execute(query, values)
            pg_cursor.execute(query.replace("?", "%s"), values)
            self.ssms_conn.commit()
            self.pg_conn.commit()

        messagebox.showinfo("Success", "Wine added successfully!")

    def read_wines(self):
        query = "SELECT * FROM wines"

        with self.ssms_conn.cursor() as ssms_cursor, self.pg_conn.cursor() as pg_cursor:
            ssms_cursor.execute(query)
            pg_cursor.execute(query)
            ssms_results = ssms_cursor.fetchall()
            pg_results = pg_cursor.fetchall()

        messagebox.showinfo("Wines: ", "\n".join([str(row) for row in ssms_results]))

    def update_wine(self,wine):
        query = "UPDATE wines SET name = ?, type_id = ?, region_id = ?, vintage_year = ?, alcohol_percentage = ?, supplier_id = ? WHERE wine_id = ?"
        values = (wine.name, wine.type_id, wine.region_id, wine.vintage_year, wine.alcohol_percentage, wine.supplier_id, wine.wine_id)

        with self.ssms_conn.cursor() as ssms_cursor, self.pg_conn.cursor() as pg_cursor:
            ssms_cursor.execute(query, values)
            pg_cursor.execute(query.replace("?", "%s"), values)
            self.ssms_conn.commit()
            self.pg_conn.commit()

        messagebox.showinfo("Success", "Wine updated successfully!")

    def delete_wine(self,wine_id):
        query = "DELETE FROM wines WHERE wine_id = ?"

        with self.ssms_conn.cursor() as ssms_cursor, self.pg_conn.cursor() as pg_cursor:
            ssms_cursor.execute(query, (wine_id,))
            pg_cursor.execute(query.replace("?", "%s"), (wine_id,))
            self.ssms_conn.commit()
            self.pg_conn.commit()

        messagebox.showinfo("Success", "Wine deleted successfully!")

    def get_wine(self,wine_id):
        query = "SELECT * FROM wines WHERE wine_id = ?"

        with self.ssms_conn.cursor() as ssms_cursor, self.pg_conn.cursor() as pg_cursor:
            ssms_cursor.execute(query, (wine_id,))
            pg_cursor.execute(query.replace("?", "%s"), (wine_id,))
            ssms_result = ssms_cursor.fetchone()
            pg_result = pg_cursor.fetchone()

        messagebox.showinfo("Wine: ", str(ssms_result))

