from .EntityGUI import EntityGUI
from Db_connections import ssms_conn, pg_conn
from Service import *
import tkinter as tk

class WinesGUI(EntityGUI):
    service=Service(ssms_conn,pg_conn)
    def __init__(self):
        super().__init__("Wines")
        self.add_button("Create Wine", self.create_wine_gui)
        self.add_button("Read Wine", self.read_wine_gui)
        self.add_button("Update Wine", self.update_wine_gui)
        self.add_button("Delete Wine", self.delete_wine_gui)
        self.add_button("Get Wine", self.get_wine_gui)

    def create_wine_gui(self):
        def submit():
            wine_id = entry_wine_id.get()
            name = entry_name.get()
            type_id = entry_type_id.get()
            region_id = entry_region_id.get()
            vintage_year = entry_vintage_year.get()
            alcohol_percentage = entry_alcohol_percentage.get()
            supplier_id = entry_supplier_id.get()
            self.service.create_wine(wine_id, name, type_id, region_id, vintage_year, alcohol_percentage, supplier_id)
            window.destroy()

        window = tk.Toplevel()
        window.title("Create Wine")
        window.geometry("400x400")

        frame = tk.Frame(window, padx=10, pady=10)
        frame.pack(expand=True, fill='both')

        entry_wine_id = self.create_labeled_entry(frame, "Wine ID:", 0)
        entry_name = self.create_labeled_entry(frame, "Name:", 1)
        entry_type_id = self.create_labeled_entry(frame, "Type ID:", 2)
        entry_region_id = self.create_labeled_entry(frame, "Region ID:", 3)
        entry_vintage_year = self.create_labeled_entry(frame, "Vintage Year:", 4)
        entry_alcohol_percentage = self.create_labeled_entry(frame, "Alcohol Percentage:", 5)
        entry_supplier_id = self.create_labeled_entry(frame, "Supplier ID:", 6)

        tk.Button(frame, text="Submit", command=submit, width=20, height=2).grid(row=7, column=0, columnspan=2, pady=10)

    def update_wine_gui(self):
        def submit():
            wine_id = entry_wine_id.get()
            name = entry_name.get()
            type_id = entry_type_id.get()
            region_id = entry_region_id.get()
            vintage_year = entry_vintage_year.get()
            alcohol_percentage = entry_alcohol_percentage.get()
            supplier_id = entry_supplier_id.get()
            self.service.update_wine(wine_id, name, type_id, region_id, vintage_year, alcohol_percentage, supplier_id)
            window.destroy()

        window = tk.Toplevel()
        window.title("Update Wine")
        window.geometry("400x400")

        frame = tk.Frame(window, padx=10, pady=10)
        frame.pack(expand=True, fill='both')

        entry_wine_id = self.create_labeled_entry(frame, "Wine ID:", 0)
        entry_name = self.create_labeled_entry(frame, "Name:", 1)
        entry_type_id = self.create_labeled_entry(frame, "Type ID:", 2)
        entry_region_id = self.create_labeled_entry(frame, "Region ID:", 3)
        entry_vintage_year = self.create_labeled_entry(frame, "Vintage Year:", 4)
        entry_alcohol_percentage = self.create_labeled_entry(frame, "Alcohol Percentage:", 5)
        entry_supplier_id = self.create_labeled_entry(frame, "Supplier ID:", 6)

        tk.Button(frame, text="Submit", command=submit, width=20, height=2).grid(row=7, column=0, columnspan=2, pady=10)

    def delete_wine_gui(self):
        def submit():
            wine_id = entry_wine_id.get()
            self.service.delete_wine(wine_id)
            window.destroy()

        window = tk.Toplevel()
        window.title("Delete Wine")
        window.geometry("400x200")

        frame = tk.Frame(window, padx=10, pady=10)
        frame.pack(expand=True, fill='both')

        entry_wine_id = self.create_labeled_entry(frame, "Wine ID:", 0)

        tk.Button(frame, text="Submit", command=submit, width=20, height=2).grid(row=1, column=0, columnspan=2, pady=10)

    def get_wine_gui(self):
        def submit():
            wine_id = entry_wine_id.get()
            self.service.get_wine(wine_id)
            window.destroy()

        window = tk.Toplevel()
        window.title("Get Wine")
        window.geometry("400x200")

        frame = tk.Frame(window, padx=10, pady=10)
        frame.pack(expand=True, fill='both')

        entry_wine_id = self.create_labeled_entry(frame, "Wine ID:", 0)

        tk.Button(frame, text="Submit", command=submit, width=20, height=2).grid(row=1, column=0, columnspan=2, pady=10)

    def read_wine_gui(self):
        self.service.read_wine()

