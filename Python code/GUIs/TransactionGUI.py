from .EntityGUI import EntityGUI
from Db_connections import ssms_conn, pg_conn
import tkinter as tk
from Service import *


class TransactionGUI(EntityGUI):
    service=Service(ssms_conn,pg_conn)
    def __init__(self):
        super().__init__("Transaction")
        self.add_button("Create Transaction", self.create_transaction_gui)
        self.add_button("Read Transaction", self.read_transaction_gui)
        self.add_button("Update Transaction", self.update_transaction_gui)
        self.add_button("Delete Transaction", self.delete_transaction_gui)
        self.add_button("Get Transaction", self.get_transaction_gui)

    def create_transaction_gui(self):
        def submit():
            transaction_id = entry_transaction_id.get()
            wine_id = entry_wine_id.get()
            transaction_type = entry_transaction_type.get()
            date = entry_date.get()
            quantity = entry_quantity.get()
            price_per_bottle = entry_price_per_bottle.get()
            user_id = entry_user_id.get()
            self.service.create_transaction(transaction_id, wine_id, transaction_type, date, quantity, price_per_bottle, user_id)
            window.destroy()

        window = tk.Toplevel()
        window.title("Create Transaction")
        window.geometry("400x400")

        frame = tk.Frame(window, padx=10, pady=10)
        frame.pack(expand=True, fill='both')

        entry_transaction_id = self.create_labeled_entry(frame, "Transaction ID:", 0)
        entry_wine_id = self.create_labeled_entry(frame, "Wine ID:", 1)
        entry_transaction_type = self.create_labeled_entry(frame, "Transaction Type:", 2)
        entry_date = self.create_labeled_entry(frame, "Date:", 3)
        entry_quantity = self.create_labeled_entry(frame, "Quantity:", 4)
        entry_price_per_bottle = self.create_labeled_entry(frame, "Price per Bottle:", 5)
        entry_user_id = self.create_labeled_entry(frame, "User ID:", 6)

        tk.Button(frame, text="Submit", command=submit, width=20, height=2).grid(row=7, column=0, columnspan=2, pady=10)

    def update_transaction_gui(self):
        def submit():
            transaction_id = entry_transaction_id.get()
            wine_id = entry_wine_id.get()
            transaction_type = entry_transaction_type.get()
            date = entry_date.get()
            quantity = entry_quantity.get()
            price_per_bottle = entry_price_per_bottle.get()
            user_id = entry_user_id.get()
            self.service.update_transaction(transaction_id, wine_id, transaction_type, date, quantity, price_per_bottle, user_id)
            window.destroy()

        window = tk.Toplevel()
        window.title("Update Transaction")
        window.geometry("400x400")

        frame = tk.Frame(window, padx=10, pady=10)
        frame.pack(expand=True, fill='both')

        entry_transaction_id = self.create_labeled_entry(frame, "Transaction ID:", 0)
        entry_wine_id = self.create_labeled_entry(frame, "Wine ID:", 1)
        entry_transaction_type = self.create_labeled_entry(frame, "Transaction Type:", 2)
        entry_date = self.create_labeled_entry(frame, "Date:", 3)
        entry_quantity = self.create_labeled_entry(frame, "Quantity:", 4)
        entry_price_per_bottle = self.create_labeled_entry(frame, "Price per Bottle:", 5)
        entry_user_id = self.create_labeled_entry(frame, "User ID:", 6)

        tk.Button(frame, text="Submit", command=submit, width=20, height=2).grid(row=7, column=0, columnspan=2, pady=10)

    def delete_transaction_gui(self):
        def submit():
            transaction_id = entry_transaction_id.get()
            self.service.delete_transaction(transaction_id)
            window.destroy()

        window = tk.Toplevel()
        window.title("Delete Transaction")
        window.geometry("400x200")

        frame = tk.Frame(window, padx=10, pady=10)
        frame.pack(expand=True, fill='both')

        entry_transaction_id = self.create_labeled_entry(frame, "Transaction ID:", 0)

        tk.Button(frame, text="Submit", command=submit, width=20, height=2).grid(row=1, column=0, columnspan=2, pady=10)

    def get_transaction_gui(self):
        def submit():
            transaction_id = entry_transaction_id.get()
            self.service.get_transaction(transaction_id)
            window.destroy()

        window = tk.Toplevel()
        window.title("Get Transaction")
        window.geometry("400x200")

        frame = tk.Frame(window, padx=10, pady=10)
        frame.pack(expand=True, fill='both')

        entry_transaction_id = self.create_labeled_entry(frame, "Transaction ID:", 0)

        tk.Button(frame, text="Submit", command=submit, width=20, height=2).grid(row=1, column=0, columnspan=2, pady=10)

    def read_transaction_gui(self):
        self.service.read_transaction()
