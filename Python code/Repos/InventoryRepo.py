from tkinter import messagebox
import Entities.Inventory

class InventoryRepo:
    def __init__(self,ssms_conn, pg_conn):
        self.ssms_conn = ssms_conn
        self.pg_conn = pg_conn


    def create_inventory(self, inventory):
        query = "INSERT INTO inventory (inventory_id,wine_id,location_id,quantity,bottle_size_ml) VALUES (?, ?, ?, ?, ?)"
        values = (inventory.inventory_id, inventory.wine_id, inventory.location_id, inventory.quantity, inventory.bottle_size_ml)

        with self.ssms_conn.cursor() as ssms_cursor, self.pg_conn.cursor() as pg_cursor:
            ssms_cursor.execute(query, values)
            pg_cursor.execute(query.replace("?", "%s"), values)
            self.ssms_conn.commit()
            self.pg_conn.commit()

        messagebox.showinfo("Success", "Inventory added successfully!")

    def read_inventory(self):
        query = "SELECT * FROM inventory"

        with self.ssms_conn.cursor() as ssms_cursor, self.pg_conn.cursor() as pg_cursor:
            ssms_cursor.execute(query)
            pg_cursor.execute(query)
            ssms_results = ssms_cursor.fetchall()
            pg_results = pg_cursor.fetchall()

        messagebox.showinfo("Inventory: ", "\n".join([str(row) for row in ssms_results]))

    def update_inventory(self,inventory):
        query = "UPDATE inventory SET wine_id = ?, location_id = ?, quantity = ?, bottle_size_ml = ? WHERE inventory_id = ?"
        values = (inventory.wine_id, inventory.location_id, inventory.quantity, inventory.bottle_size_ml, inventory.inventory_id)

        with self.ssms_conn.cursor() as ssms_cursor, self.pg_conn.cursor() as pg_cursor:
            ssms_cursor.execute(query, values)
            pg_cursor.execute(query.replace("?", "%s"), values)
            self.ssms_conn.commit()
            self.pg_conn.commit()

        messagebox.showinfo("Success", "Inventory updated successfully!")

    def delete_inventory(self,inventory_id):
        query = "DELETE FROM inventory WHERE inventory_id = ?"

        with self.ssms_conn.cursor() as ssms_cursor, self.pg_conn.cursor() as pg_cursor:
            ssms_cursor.execute(query, (inventory_id,))
            pg_cursor.execute(query.replace("?", "%s"), (inventory_id,))
            self.ssms_conn.commit()
            self.pg_conn.commit()

        messagebox.showinfo("Success", "Inventory deleted successfully!")

    def get_inventory(self,inventory_id):
        query = "SELECT * FROM inventory WHERE inventory_id = ?"

        with self.ssms_conn.cursor() as ssms_cursor, self.pg_conn.cursor() as pg_cursor:
            ssms_cursor.execute(query, (inventory_id,))
            pg_cursor.execute(query.replace("?", "%s"), (inventory_id,))
            ssms_result = ssms_cursor.fetchone()
            pg_result = pg_cursor.fetchone()

        messagebox.showinfo("Inventory: ", str(ssms_result))
