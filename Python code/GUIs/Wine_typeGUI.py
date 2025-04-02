from .EntityGUI import EntityGUI
from Db_connections import ssms_conn, pg_conn
from Service import *
import tkinter as tk

class Wine_typeGUI(EntityGUI):
    service=Service(ssms_conn,pg_conn)
    def __init__(self):
        super().__init__("Wine Type")
        self.add_button("Create Wine Type", self.create_wine_type_gui)
        self.add_button("Read Wine Type", self.read_wine_type_gui)
        self.add_button("Update Wine Type", self.update_wine_type_gui)
        self.add_button("Delete Wine Type", self.delete_wine_type_gui)
        self.add_button("Get Wine Type", self.get_wine_type_gui)

    def create_wine_type_gui(self):
        def submit():
            type_id = entry_type_id.get()
            type_name = entry_type_name.get()
            self.service.create_wine_type(type_id, type_name)
            window.destroy()

        window = tk.Toplevel()
        window.title("Create Wine Type")
        window.geometry("400x200")

        frame = tk.Frame(window, padx=10, pady=10)
        frame.pack(expand=True, fill='both')

        entry_type_id = self.create_labeled_entry(frame, "Type ID:", 0)
        entry_type_name = self.create_labeled_entry(frame, "Type Name:", 1)

        tk.Button(frame, text="Submit", command=submit, width=20, height=2).grid(row=2, column=0, columnspan=2, pady=10)

    def update_wine_type_gui(self):
        def submit():
            type_id = entry_type_id.get()
            type_name = entry_type_name.get()
            self.service.update_wine_type(type_id, type_name)
            window.destroy()

        window = tk.Toplevel()
        window.title("Update Wine Type")
        window.geometry("400x200")

        frame = tk.Frame(window, padx=10, pady=10)
        frame.pack(expand=True, fill='both')

        entry_type_id = self.create_labeled_entry(frame, "Type ID:", 0)
        entry_type_name = self.create_labeled_entry(frame, "Type Name:", 1)

        tk.Button(frame, text="Submit", command=submit, width=20, height=2).grid(row=2, column=0, columnspan=2, pady=10)

    def delete_wine_type_gui(self):
        def submit():
            type_id = entry_type_id.get()
            self.service.delete_wine_type(type_id)
            window.destroy()

        window = tk.Toplevel()
        window.title("Delete Wine Type")
        window.geometry("400x200")

        frame = tk.Frame(window, padx=10, pady=10)
        frame.pack(expand=True, fill='both')

        entry_type_id = self.create_labeled_entry(frame, "Type ID:", 0)

        tk.Button(frame, text="Submit", command=submit, width=20, height=2).grid(row=1, column=0, columnspan=2, pady=10)

    def get_wine_type_gui(self):
        def submit():
            type_id = entry_type_id.get()
            self.service.get_wine_type(type_id)
            window.destroy()

        window = tk.Toplevel()
        window.title("Get Wine Type")
        window.geometry("400x200")

        frame = tk.Frame(window, padx=10, pady=10)
        frame.pack(expand=True, fill='both')

        entry_type_id = self.create_labeled_entry(frame, "Type ID:", 0)

        tk.Button(frame, text="Submit", command=submit, width=20, height=2).grid(row=1, column=0, columnspan=2, pady=10)

    def read_wine_type_gui(self):
        self.service.read_wine_type()
