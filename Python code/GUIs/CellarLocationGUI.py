from .EntityGUI import EntityGUI
import tkinter as tk
from Db_connections import ssms_conn, pg_conn
from Service import *

class CellarLocationGUI(EntityGUI):
    service = Service(ssms_conn, pg_conn)
    def __init__(self):
        super().__init__("Cellar Location")
        self.add_button("Create Cellar Location", self.create_cellarlocation_gui)
        self.add_button("Read all Cellar Locations", self.read_cellarlocations_gui)
        self.add_button("Update Cellar Location", self.update_cellarlocation_gui)
        self.add_button("Delete Cellar Location", self.delete_cellarlocation_gui)
        self.add_button("Get Cellar Location", self.get_cellarlocation_gui)

    def create_cellarlocation_gui(self):
        def submit():
            location_id = entry_location_id.get()
            section = entry_section.get()
            rack_number = entry_rack_number.get()
            bottle_position = entry_bottle_position.get()
            self.service.create_cellar_location(location_id, section, rack_number, bottle_position)
            window.destroy()  # Close the window after submission

        window = tk.Toplevel()
        window.title("Create CellarLocation")
        window.geometry("400x300")

        frame = tk.Frame(window, padx=10, pady=10)
        frame.pack(expand=True, fill='both')

        entry_location_id = self.create_labeled_entry(frame, "Location ID:", 0)
        entry_section = self.create_labeled_entry(frame, "Section:", 1)
        entry_rack_number = self.create_labeled_entry(frame, "Rack Number:", 2)
        entry_bottle_position = self.create_labeled_entry(frame, "Bottle position(int):", 3)

        tk.Button(frame, text="Submit", command=submit, width=20, height=2).grid(row=4, column=0, columnspan=2, pady=10)

    def update_cellarlocation_gui(self):
        def submit():
            location_id = entry_location_id.get()
            section = entry_section.get()
            rack_number = entry_rack_number.get()
            bottle_position = entry_bottle_position.get()
            self.service.update_cellar_location(location_id, section, rack_number, bottle_position)
            window.destroy()  # Close the window after submission

        window = tk.Toplevel()
        window.title("Update CellarLocation")
        window.geometry("400x300")

        frame = tk.Frame(window, padx=10, pady=10)
        frame.pack(expand=True, fill='both')

        entry_location_id = self.create_labeled_entry(frame, "Location ID:", 0)
        entry_section = self.create_labeled_entry(frame, "First Name:", 1)
        entry_rack_number = self.create_labeled_entry(frame, "Last Name:", 2)
        entry_bottle_position = self.create_labeled_entry(frame, "Department ID:", 3)

        tk.Button(frame, text="Submit", command=submit, width=20, height=2).grid(row=4, column=0, columnspan=2, pady=10)

    def delete_cellarlocation_gui(self):
        def submit():
            location_id = entry_location_id.get()
            self.service.delete_cellar_location(location_id)
            window.destroy()  # Close the window after submission

        window = tk.Toplevel()
        window.title("Delete CellarLocation")
        window.geometry("400x200")

        frame = tk.Frame(window, padx=10, pady=10)
        frame.pack(expand=True, fill='both')

        entry_location_id = self.create_labeled_entry(frame, "ID:", 0)

        tk.Button(frame, text="Submit", command=submit, width=20, height=2).grid(row=1, column=0, columnspan=2, pady=10)

    def get_cellarlocation_gui(self):
        def submit():
            location_id = entry_location_id.get()
            self.service.get_cellar_location(location_id)
            window.destroy()  # Close the window after submission

        window = tk.Toplevel()
        window.title("Get CellarLocation")
        window.geometry("400x200")

        frame = tk.Frame(window, padx=10, pady=10)
        frame.pack(expand=True, fill='both')

        entry_location_id = self.create_labeled_entry(frame, "ID:", 0)

        tk.Button(frame, text="Submit", command=submit, width=20, height=2).grid(row=1, column=0, columnspan=2, pady=10)

    def read_cellarlocations_gui(self):
        self.service.read_cellar_locations()
