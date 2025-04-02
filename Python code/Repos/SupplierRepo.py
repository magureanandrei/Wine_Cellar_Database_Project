from tkinter import messagebox
import Entities.Supplier

class SupplierRepo:
    def __init__(self,ssms_conn,pg_conn):
        self.ssms_conn = ssms_conn
        self.pg_conn = pg_conn


    def create_supplier(self,supplier):
        query = "INSERT INTO supplier (supplier_id, supplier_name, contact_email, phone, address) VALUES (?, ?, ?, ?, ?)"
        values = (supplier.supplier_id, supplier.supplier_name, supplier.contact_email, supplier.phone, supplier.address)

        with self.ssms_conn.cursor() as ssms_cursor, self.pg_conn.cursor() as pg_cursor:
            ssms_cursor.execute(query, values)
            pg_cursor.execute(query.replace("?", "%s"), values)
            self.ssms_conn.commit()
            self.pg_conn.commit()

        messagebox.showinfo("Success", "Supplier added successfully!")

    def read_supplier(self):
        query = "SELECT * FROM supplier"

        with self.ssms_conn.cursor() as ssms_cursor, self.pg_conn.cursor() as pg_cursor:
            ssms_cursor.execute(query)
            pg_cursor.execute(query)
            ssms_results = ssms_cursor.fetchall()
            pg_results = pg_cursor.fetchall()

        messagebox.showinfo("Supplier: ", "\n".join([str(row) for row in ssms_results]))

    def update_supplier(self,supplier):
        query = "UPDATE supplier SET supplier_name = ?, contact_email = ?, phone = ?, address = ? WHERE supplier_id = ?"
        values = (supplier.supplier_name, supplier.contact_email, supplier.phone, supplier.address, supplier.supplier_id)

        with self.ssms_conn.cursor() as ssms_cursor, self.pg_conn.cursor() as pg_cursor:
            ssms_cursor.execute(query, values)
            pg_cursor.execute(query.replace("?", "%s"), values)
            self.ssms_conn.commit()
            self.pg_conn.commit()

        messagebox.showinfo("Success", "Supplier updated successfully!")

    def delete_supplier(self,supplier_id):
        query = "DELETE FROM supplier WHERE supplier_id = ?"

        with self.ssms_conn.cursor() as ssms_cursor, self.pg_conn.cursor() as pg_cursor:
            ssms_cursor.execute(query, (supplier_id,))
            pg_cursor.execute(query.replace("?", "%s"), (supplier_id,))
            self.ssms_conn.commit()
            self.pg_conn.commit()

        messagebox.showinfo("Success", "Supplier deleted successfully!")

    def get_supplier(self,supplier_id):
        query = "SELECT * FROM supplier WHERE supplier_id = ?"

        with self.ssms_conn.cursor() as ssms_cursor, self.pg_conn.cursor() as pg_cursor:
            ssms_cursor.execute(query, (supplier_id,))
            pg_cursor.execute(query.replace("?", "%s"), (supplier_id,))
            ssms_result = ssms_cursor.fetchone()
            pg_result = pg_cursor.fetchone()

        messagebox.showinfo("Supplier: ", str(ssms_result))


