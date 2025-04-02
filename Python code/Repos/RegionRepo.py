from tkinter import messagebox
import Entities.Region


class RegionRepo:
    def __init__(self,ssms_conn,pg_conn):
        self.ssms_conn = ssms_conn
        self.pg_conn = pg_conn

    def create_region(self,region):
        query = "INSERT INTO region (region_id,region_name,country) VALUES (?, ?, ?)"
        values = (region.region_id, region.region_name, region.country)

        with self.ssms_conn.cursor() as ssms_cursor, self.pg_conn.cursor() as pg_cursor:
            ssms_cursor.execute(query, values)
            pg_cursor.execute(query.replace("?", "%s"), values)
            self.ssms_conn.commit()
            self.pg_conn.commit()

        messagebox.showinfo("Success", "Region added successfully!")

    def read_region(self):
        query = "SELECT * FROM region"

        with self.ssms_conn.cursor() as ssms_cursor, self.pg_conn.cursor() as pg_cursor:
            ssms_cursor.execute(query)
            pg_cursor.execute(query)
            ssms_results = ssms_cursor.fetchall()
            pg_results = pg_cursor.fetchall()

        messagebox.showinfo("Region: ", "\n".join([str(row) for row in ssms_results]))

    def update_region(self,region):
        query = "UPDATE region SET region_name = ?, country = ? WHERE region_id = ?"
        values = (region.region_name, region.country, region.region_id)

        with self.ssms_conn.cursor() as ssms_cursor, self.pg_conn.cursor() as pg_cursor:
            ssms_cursor.execute(query, values)
            pg_cursor.execute(query.replace("?", "%s"), values)
            self.ssms_conn.commit()
            self.pg_conn.commit()

        messagebox.showinfo("Success", "Region updated successfully!")

    def delete_region(self,region_id):
        query = "DELETE FROM region WHERE region_id = ?"

        with self.ssms_conn.cursor() as ssms_cursor, self.pg_conn.cursor() as pg_cursor:
            ssms_cursor.execute(query, (region_id,))
            pg_cursor.execute(query.replace("?", "%s"), (region_id,))
            self.ssms_conn.commit()
            self.pg_conn.commit()

        messagebox.showinfo("Success", "Region deleted successfully!")

    def get_region(self,region_id):
        query = "SELECT * FROM region WHERE region_id = ?"

        with self.ssms_conn.cursor() as ssms_cursor, self.pg_conn.cursor() as pg_cursor:
            ssms_cursor.execute(query, (region_id,))
            pg_cursor.execute(query.replace("?", "%s"), (region_id,))
            ssms_result = ssms_cursor.fetchone()
            pg_result = pg_cursor.fetchone()

        messagebox.showinfo("Region: ", str(ssms_result))
