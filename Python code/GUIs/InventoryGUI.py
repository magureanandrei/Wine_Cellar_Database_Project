from .EntityGUI import EntityGUI
from Db_connections import ssms_conn, pg_conn
from Service import *
import tkinter as tk


class InventoryGUI(EntityGUI):
    service_instance = Service(ssms_conn, pg_conn)
    def __init__(self):
        super().__init__("Inventory")
        self.add_button("Create Inventory", self.create_inventory_gui)
        self.add_button("Read Inventory", self.read_inventory_gui)
        self.add_button("Update Inventory", self.update_inventory_gui)
        self.add_button("Delete Inventory", self.delete_inventory_gui)
        self.add_button("Get Inventory", self.get_inventory_gui)

    def create_inventory_gui(self):
        def submit():
            inventory_id = entry_inventory_id.get()
            wine_id = entry_wine_id.get()
            location_id = entry_location_id.get()
            quantity = entry_quantity.get()
            bottle_size_ml = entry_bottle_size_ml.get()
            self.service_instance.create_inventory(inventory_id, wine_id, location_id, quantity, bottle_size_ml)
            window.destroy()

        window = tk.Toplevel()
        window.title("Create Inventory")
        window.geometry("400x300")

        frame = tk.Frame(window, padx=10, pady=10)
        frame.pack(expand=True, fill='both')

        entry_inventory_id = self.create_labeled_entry(frame, "Inventory ID:", 0)
        entry_wine_id = self.create_labeled_entry(frame, "Wine ID:", 1)
        entry_location_id = self.create_labeled_entry(frame, "Location ID:", 2)
        entry_quantity =self.create_labeled_entry(frame, "Quantity:", 3)
        entry_bottle_size_ml = self.create_labeled_entry(frame, "Bottle Size (ml):", 4)

        tk.Button(frame, text="Submit", command=submit, width=20, height=2).grid(row=5, column=0, columnspan=2, pady=10)

    def update_inventory_gui(self):
        def submit():
            inventory_id = entry_inventory_id.get()
            wine_id = entry_wine_id.get()
            location_id = entry_location_id.get()
            quantity = entry_quantity.get()
            bottle_size_ml = entry_bottle_size_ml.get()
            self.service_instance.update_inventory(inventory_id, wine_id, location_id, quantity, bottle_size_ml)
            window.destroy()

        window = tk.Toplevel()
        window.title("Update Inventory")
        window.geometry("400x300")

        frame = tk.Frame(window, padx=10, pady=10)
        frame.pack(expand=True, fill='both')

        entry_inventory_id = self.create_labeled_entry(frame, "Inventory ID:", 0)
        entry_wine_id = self.create_labeled_entry(frame, "Wine ID:", 1)
        entry_location_id = self.create_labeled_entry(frame, "Location ID:", 2)
        entry_quantity = self.create_labeled_entry(frame, "Quantity:", 3)
        entry_bottle_size_ml = self.create_labeled_entry(frame, "Bottle Size (ml):", 4)

        tk.Button(frame, text="Submit", command=submit, width=20, height=2).grid(row=5, column=0, columnspan=2, pady=10)

    def delete_inventory_gui(self):
        def submit():
            inventory_id = entry_inventory_id.get()
            self.service_instance.delete_inventory(inventory_id)
            window.destroy()

        window = tk.Toplevel()
        window.title("Delete Inventory")
        window.geometry("400x200")

        frame = tk.Frame(window, padx=10, pady=10)
        frame.pack(expand=True, fill='both')

        entry_inventory_id = self.create_labeled_entry(frame, "Inventory ID:", 0)

        tk.Button(frame, text="Submit", command=submit, width=20, height=2).grid(row=1, column=0, columnspan=2, pady=10)

    def get_inventory_gui(self):
        def submit():
            inventory_id = entry_inventory_id.get()
            self.service_instance.get_inventory(inventory_id)
            window.destroy()

        window = tk.Toplevel()
        window.title("Get Inventory")
        window.geometry("400x200")

        frame = tk.Frame(window, padx=10, pady=10)
        frame.pack(expand=True, fill='both')

        entry_inventory_id = self.create_labeled_entry(frame, "Inventory ID:", 0)

        tk.Button(frame, text="Submit", command=submit, width=20, height=2).grid(row=1, column=0, columnspan=2, pady=10)

    def read_inventory_gui(self):
        self.service_instance.read_inventory()
