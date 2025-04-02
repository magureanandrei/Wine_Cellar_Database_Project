from .EntityGUI import EntityGUI
from Db_connections import ssms_conn, pg_conn
from Service import *
import tkinter as tk

class RegionGUI(EntityGUI):
    service=Service(ssms_conn,pg_conn)
    def __init__(self):
        super().__init__("Region")
        self.add_button("Create Region", self.create_region_gui)
        self.add_button("Read Region", self.read_region_gui)
        self.add_button("Update Region", self.update_region_gui)
        self.add_button("Delete Region", self.delete_region_gui)
        self.add_button("Get Region", self.get_region_gui)

    def create_region_gui(self):
        def submit():
            region_id = entry_region_id.get()
            region_name = entry_region_name.get()
            country = entry_country.get()
            self.service.create_region(region_id, region_name, country)
            window.destroy()

        window = tk.Toplevel()
        window.title("Create Region")
        window.geometry("400x300")

        frame = tk.Frame(window, padx=10, pady=10)
        frame.pack(expand=True, fill='both')

        entry_region_id = self.create_labeled_entry(frame, "Region ID:", 0)
        entry_region_name = self.create_labeled_entry(frame, "Region Name:", 1)
        entry_country = self.create_labeled_entry(frame, "Country:", 2)

        tk.Button(frame, text="Submit", command=submit, width=20, height=2).grid(row=3, column=0, columnspan=2, pady=10)

    def update_region_gui(self):
        def submit():
            region_id = entry_region_id.get()
            region_name = entry_region_name.get()
            country = entry_country.get()
            self.service.update_region(region_id, region_name, country)
            window.destroy()

        window = tk.Toplevel()
        window.title("Update Region")
        window.geometry("400x300")

        frame = tk.Frame(window, padx=10, pady=10)
        frame.pack(expand=True, fill='both')

        entry_region_id = self.create_labeled_entry(frame, "Region ID:", 0)
        entry_region_name = self.create_labeled_entry(frame, "Region Name:", 1)
        entry_country = self.create_labeled_entry(frame, "Country:", 2)

        tk.Button(frame, text="Submit", command=submit, width=20, height=2).grid(row=3, column=0, columnspan=2, pady=10)

    def delete_region_gui(self):
        def submit():
            region_id = entry_region_id.get()
            self.service.delete_region(region_id)
            window.destroy()

        window = tk.Toplevel()
        window.title("Delete Region")
        window.geometry("400x200")

        frame = tk.Frame(window, padx=10, pady=10)
        frame.pack(expand=True, fill='both')

        entry_region_id = self.create_labeled_entry(frame, "Region ID:", 0)

        tk.Button(frame, text="Submit", command=submit, width=20, height=2).grid(row=1, column=0, columnspan=2, pady=10)

    def get_region_gui(self):
        def submit():
            region_id = entry_region_id.get()
            self.service.get_region(region_id)
            window.destroy()

        window = tk.Toplevel()
        window.title("Get Region")
        window.geometry("400x200")

        frame = tk.Frame(window, padx=10, pady=10)
        frame.pack(expand=True, fill='both')

        entry_region_id = self.create_labeled_entry(frame, "Region ID:", 0)

        tk.Button(frame, text="Submit", command=submit, width=20, height=2).grid(row=1, column=0, columnspan=2, pady=10)


    def read_region_gui(self):
        self.service.read_region()

