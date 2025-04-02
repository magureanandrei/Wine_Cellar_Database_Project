from .EntityGUI import EntityGUI
from Db_connections import ssms_conn,pg_conn
from Service import *
import tkinter as tk

class UserGUI(EntityGUI):
    service=Service(ssms_conn,pg_conn)
    def __init__(self):
        super().__init__("User")
        self.add_button("Create User", self.create_user_gui)
        self.add_button("Read User", self.read_user_gui)
        self.add_button("Update User", self.update_user_gui)
        self.add_button("Delete User", self.delete_user_gui)
        self.add_button("Get User", self.get_user_gui)

    def create_user_gui(self):
        def submit():
            user_id = entry_user_id.get()
            username = entry_username.get()
            password_hash = entry_password_hash.get()
            role = entry_role.get()
            self.service.create_user(user_id, username, password_hash, role)
            window.destroy()

        window = tk.Toplevel()
        window.title("Create User")
        window.geometry("400x300")

        frame = tk.Frame(window, padx=10, pady=10)
        frame.pack(expand=True, fill='both')

        entry_user_id = self.create_labeled_entry(frame, "User ID:", 0)
        entry_username = self.create_labeled_entry(frame, "Username:", 1)
        entry_password_hash = self.create_labeled_entry(frame, "Password Hash:", 2)
        entry_role = self.create_labeled_entry(frame, "Role:", 3)

        tk.Button(frame, text="Submit", command=submit, width=20, height=2).grid(row=4, column=0, columnspan=2, pady=10)

    def update_user_gui(self):
        def submit():
            user_id = entry_user_id.get()
            username = entry_username.get()
            password_hash = entry_password_hash.get()
            role = entry_role.get()
            self.service.update_user(user_id, username, password_hash, role)
            window.destroy()

        window = tk.Toplevel()
        window.title("Update User")
        window.geometry("400x300")

        frame = tk.Frame(window, padx=10, pady=10)
        frame.pack(expand=True, fill='both')

        entry_user_id = self.create_labeled_entry(frame, "User ID:", 0)
        entry_username = self.create_labeled_entry(frame, "Username:", 1)
        entry_password_hash = self.create_labeled_entry(frame, "Password Hash:", 2)
        entry_role = self.create_labeled_entry(frame, "Role:", 3)

        tk.Button(frame, text="Submit", command=submit, width=20, height=2).grid(row=4, column=0, columnspan=2, pady=10)

    def delete_user_gui(self):
        def submit():
            user_id = entry_user_id.get()
            self.service.delete_user(user_id)
            window.destroy()

        window = tk.Toplevel()
        window.title("Delete User")
        window.geometry("400x200")

        frame = tk.Frame(window, padx=10, pady=10)
        frame.pack(expand=True, fill='both')

        entry_user_id = self.create_labeled_entry(frame, "User ID:", 0)

        tk.Button(frame, text="Submit", command=submit, width=20, height=2).grid(row=1, column=0, columnspan=2, pady=10)

    def get_user_gui(self):
        def submit():
            user_id = entry_user_id.get()
            self.service.get_user(user_id)
            window.destroy()

        window = tk.Toplevel()
        window.title("Get User")
        window.geometry("400x200")

        frame = tk.Frame(window, padx=10, pady=10)
        frame.pack(expand=True, fill='both')

        entry_user_id = self.create_labeled_entry(frame, "User ID:", 0)

        tk.Button(frame, text="Submit", command=submit, width=20, height=2).grid(row=1, column=0, columnspan=2, pady=10)


    def read_user_gui(self):
        self.service.read_user()
