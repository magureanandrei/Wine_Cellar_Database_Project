from tkinter import messagebox
import Entities.CellarLocation

class CellarLocationRepo:
    def __init__(self, ssms_conn, pg_conn):
        self.ssms_conn = ssms_conn
        self.pg_conn = pg_conn

    def create_cellarlocation(self, cellarlocation):
        query = "INSERT INTO cellarlocation (location_id, section, rack_number, bottle_position) VALUES (?, ?, ?, ?)"
        values = (cellarlocation.location_id, cellarlocation.section, cellarlocation.rack_number, cellarlocation.bottle_position)

        with self.ssms_conn.cursor() as ssms_cursor, self.pg_conn.cursor() as pg_cursor:
            ssms_cursor.execute(query, values)
            pg_cursor.execute(query.replace("?", "%s"), values)
            self.ssms_conn.commit()
            self.pg_conn.commit()

        messagebox.showinfo("Success", "CellarLocation added successfully!")

    def read_cellarlocations(self):
        query = "SELECT * FROM cellarlocation"

        with self.ssms_conn.cursor() as ssms_cursor, self.pg_conn.cursor() as pg_cursor:
            ssms_cursor.execute(query)
            pg_cursor.execute(query)
            ssms_results = ssms_cursor.fetchall()
            pg_results = pg_cursor.fetchall()

        messagebox.showinfo("CellarLocations: ", "\n".join([str(row) for row in ssms_results]))

    def update_cellarlocation(self, cellarlocation):
        query = "UPDATE cellarlocation SET section = ?, rack_number = ?, bottle_position = ? WHERE location_id = ?"
        values = (cellarlocation.section, cellarlocation.rack_number, cellarlocation.bottle_position, cellarlocation.location_id)

        with self.ssms_conn.cursor() as ssms_cursor, self.pg_conn.cursor() as pg_cursor:
            ssms_cursor.execute(query, values)
            pg_cursor.execute(query.replace("?", "%s"), values)
            self.ssms_conn.commit()
            self.pg_conn.commit()

        messagebox.showinfo("Success", "CellarLocation updated successfully!")

    def delete_cellarlocation(self, location_id):
        query = "DELETE FROM cellarlocation WHERE location_id = ?"

        with self.ssms_conn.cursor() as ssms_cursor, self.pg_conn.cursor() as pg_cursor:
            ssms_cursor.execute(query, (location_id,))
            pg_cursor.execute(query.replace("?", "%s"), (location_id,))
            self.ssms_conn.commit()
            self.pg_conn.commit()

        messagebox.showinfo("Success", "CellarLocation deleted successfully!")

    def get_cellarlocation(self, location_id):
        query = "SELECT * FROM cellarlocation WHERE location_id = ?"

        with self.ssms_conn.cursor() as ssms_cursor, self.pg_conn.cursor() as pg_cursor:
            ssms_cursor.execute(query, (location_id,))
            pg_cursor.execute(query.replace("?", "%s"), (location_id,))
            ssms_result = ssms_cursor.fetchone()
            pg_result = pg_cursor.fetchone()

        messagebox.showinfo("CellarLocation: ", str(ssms_result))