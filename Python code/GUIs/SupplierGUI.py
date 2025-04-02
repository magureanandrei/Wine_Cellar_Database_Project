from .EntityGUI import EntityGUI
from Db_connections import ssms_conn, pg_conn
import tkinter as tk
from Service import *


class SupplierGUI(EntityGUI):
    service=Service(ssms_conn,pg_conn)
    def __init__(self):
        super().__init__("Supplier")
        self.add_button("Create Supplier", self.create_supplier_gui)
        self.add_button("Read Supplier", self.read_supplier_gui)
        self.add_button("Update Supplier", self.update_supplier_gui)
        self.add_button("Delete Supplier", self.delete_supplier_gui)
        self.add_button("Get Supplier", self.get_supplier_gui)

    def create_supplier_gui(self):
        def submit():
            supplier_id = entry_supplier_id.get()
            supplier_name = entry_supplier_name.get()
            contact_email = entry_contact_email.get()
            phone = entry_phone.get()
            address = entry_address.get()
            self.service.create_supplier(supplier_id, supplier_name, contact_email, phone, address)
            window.destroy()

        window = tk.Toplevel()
        window.title("Create Supplier")
        window.geometry("400x300")

        frame = tk.Frame(window, padx=10, pady=10)
        frame.pack(expand=True, fill='both')

        entry_supplier_id = self.create_labeled_entry(frame, "Supplier ID:", 0)
        entry_supplier_name = self.create_labeled_entry(frame, "Supplier Name:", 1)
        entry_contact_email = self.create_labeled_entry(frame, "Contact Email:", 2)
        entry_phone = self.create_labeled_entry(frame, "Phone:", 3)
        entry_address = self.create_labeled_entry(frame, "Address:", 4)

        tk.Button(frame, text="Submit", command=submit, width=20, height=2).grid(row=5, column=0, columnspan=2, pady=10)

    def update_supplier_gui(self):
        def submit():
            supplier_id = entry_supplier_id.get()
            supplier_name = entry_supplier_name.get()
            contact_email = entry_contact_email.get()
            phone = entry_phone.get()
            address = entry_address.get()
            self.service.update_supplier(supplier_id, supplier_name, contact_email, phone, address)
            window.destroy()

        window = tk.Toplevel()
        window.title("Update Supplier")
        window.geometry("400x300")

        frame = tk.Frame(window, padx=10, pady=10)
        frame.pack(expand=True, fill='both')

        entry_supplier_id = self.create_labeled_entry(frame, "Supplier ID:", 0)
        entry_supplier_name = self.create_labeled_entry(frame, "Supplier Name:", 1)
        entry_contact_email = self.create_labeled_entry(frame, "Contact Email:", 2)
        entry_phone = self.create_labeled_entry(frame, "Phone:", 3)
        entry_address = self.create_labeled_entry(frame, "Address:", 4)

        tk.Button(frame, text="Submit", command=submit, width=20, height=2).grid(row=5, column=0, columnspan=2, pady=10)

    def delete_supplier_gui(self):
        def submit():
            supplier_id = entry_supplier_id.get()
            self.service.delete_supplier(supplier_id)
            window.destroy()

        window = tk.Toplevel()
        window.title("Delete Supplier")
        window.geometry("400x200")

        frame = tk.Frame(window, padx=10, pady=10)
        frame.pack(expand=True, fill='both')

        entry_supplier_id = self.create_labeled_entry(frame, "Supplier ID:", 0)

        tk.Button(frame, text="Submit", command=submit, width=20, height=2).grid(row=1, column=0, columnspan=2, pady=10)

    def get_supplier_gui(self):
        def submit():
            supplier_id = entry_supplier_id.get()
            self.service.get_supplier(supplier_id)
            window.destroy()

        window = tk.Toplevel()
        window.title("Get Supplier")
        window.geometry("400x200")

        frame = tk.Frame(window, padx=10, pady=10)
        frame.pack(expand=True, fill='both')

        entry_supplier_id = self.create_labeled_entry(frame, "Supplier ID:", 0)

        tk.Button(frame, text="Submit", command=submit, width=20, height=2).grid(row=1, column=0, columnspan=2, pady=10)

    def read_supplier_gui(self):
        self.service.read_supplier()