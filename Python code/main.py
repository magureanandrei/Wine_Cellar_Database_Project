import tkinter as tk
from tkinter import messagebox
import pyodbc
import psycopg2

SSMS_CONN = "DRIVER={ODBC Driver 17 for SQL Server};SERVER=localhost;DATABASE=WineCellar;UID=abcd;PWD=1234;TrustServerCertificate=yes;"

ssms_conn = pyodbc.connect(SSMS_CONN)
pg_conn = psycopg2.connect(
    dbname="WineCellar",
    user="postgres",
    password="1234",
    host="localhost",
    port="5432"
)

def create_cellarlocation(location_id, section, rack_number, bottle_position):
    query = "INSERT INTO cellarlocation (location_id, section, rack_number, bottle_position) VALUES (?, ?, ?, ?)"
    values = (location_id, section, rack_number, bottle_position)

    with ssms_conn.cursor() as ssms_cursor, pg_conn.cursor() as pg_cursor:
        ssms_cursor.execute(query, values)
        pg_cursor.execute(query.replace("?", "%s"), values)
        ssms_conn.commit()
        pg_conn.commit()

    messagebox.showinfo("Success", "CellarLocation added successfully!")

def read_cellarlocations():
    query = "SELECT * FROM cellarlocation"

    with ssms_conn.cursor() as ssms_cursor, pg_conn.cursor() as pg_cursor:
        ssms_cursor.execute(query)
        pg_cursor.execute(query)
        ssms_results = ssms_cursor.fetchall()
        pg_results = pg_cursor.fetchall()

    messagebox.showinfo("CellarLocations: ", "\n".join([str(row) for row in ssms_results]))

def update_cellarlocation(location_id, section, rack_number, bottle_position):
    query = "UPDATE cellarlocation SET section = ?, rack_number = ?, bottle_position = ? WHERE location_id = ?"
    values = (location_id, section, rack_number, bottle_position)

    with ssms_conn.cursor() as ssms_cursor, pg_conn.cursor() as pg_cursor:
        ssms_cursor.execute(query, values)
        pg_cursor.execute(query.replace("?", "%s"), values)
        ssms_conn.commit()
        pg_conn.commit()

    messagebox.showinfo("Success", "CellarLocation updated successfully!")

def delete_cellarlocation(location_id):
    query = "DELETE FROM cellarlocation WHERE location_id = ?"

    with ssms_conn.cursor() as ssms_cursor, pg_conn.cursor() as pg_cursor:
        ssms_cursor.execute(query, (location_id,))
        pg_cursor.execute(query.replace("?", "%s"), (location_id,))
        ssms_conn.commit()
        pg_conn.commit()

    messagebox.showinfo("Success", "CellarLocation deleted successfully!")

def get_cellarlocation(location_id):
    query = "SELECT * FROM cellarlocation WHERE location_id = ?"

    with ssms_conn.cursor() as ssms_cursor, pg_conn.cursor() as pg_cursor:
        ssms_cursor.execute(query, (location_id,))
        pg_cursor.execute(query.replace("?", "%s"), (location_id,))
        ssms_result = ssms_cursor.fetchone()
        pg_result = pg_cursor.fetchone()

    messagebox.showinfo("CellarLocation: ", str(ssms_result))



def create_inventory(inventory_id,wine_id,location_id,quantity,bottle_size_ml):
    query = "INSERT INTO inventory (inventory_id,wine_id,location_id,quantity,bottle_size_ml) VALUES (?, ?, ?, ?, ?)"
    values = (inventory_id,wine_id,location_id,quantity,bottle_size_ml)

    with ssms_conn.cursor() as ssms_cursor, pg_conn.cursor() as pg_cursor:
        ssms_cursor.execute(query, values)
        pg_cursor.execute(query.replace("?", "%s"), values)
        ssms_conn.commit()
        pg_conn.commit()

    messagebox.showinfo("Success", "Inventory added successfully!")

def read_inventory():
    query = "SELECT * FROM inventory"

    with ssms_conn.cursor() as ssms_cursor, pg_conn.cursor() as pg_cursor:
        ssms_cursor.execute(query)
        pg_cursor.execute(query)
        ssms_results = ssms_cursor.fetchall()
        pg_results = pg_cursor.fetchall()

    messagebox.showinfo("Inventory: ", "\n".join([str(row) for row in ssms_results]))

def update_inventory(inventory_id,wine_id,location_id,quantity,bottle_size_ml):
    query = "UPDATE inventory SET wine_id = ?, location_id = ?, quantity = ?, bottle_size_ml = ? WHERE inventory_id = ?"
    values = (inventory_id,wine_id,location_id,quantity,bottle_size_ml)

    with ssms_conn.cursor() as ssms_cursor, pg_conn.cursor() as pg_cursor:
        ssms_cursor.execute(query, values)
        pg_cursor.execute(query.replace("?", "%s"), values)
        ssms_conn.commit()
        pg_conn.commit()

    messagebox.showinfo("Success", "Inventory updated successfully!")

def delete_inventory(inventory_id):
    query = "DELETE FROM inventory WHERE inventory_id = ?"

    with ssms_conn.cursor() as ssms_cursor, pg_conn.cursor() as pg_cursor:
        ssms_cursor.execute(query, (inventory_id,))
        pg_cursor.execute(query.replace("?", "%s"), (inventory_id,))
        ssms_conn.commit()
        pg_conn.commit()

    messagebox.showinfo("Success", "Inventory deleted successfully!")

def get_inventory(inventory_id):
    query = "SELECT * FROM inventory WHERE inventory_id = ?"

    with ssms_conn.cursor() as ssms_cursor, pg_conn.cursor() as pg_cursor:
        ssms_cursor.execute(query, (inventory_id,))
        pg_cursor.execute(query.replace("?", "%s"), (inventory_id,))
        ssms_result = ssms_cursor.fetchone()
        pg_result = pg_cursor.fetchone()

    messagebox.showinfo("Inventory: ", str(ssms_result))


def create_region(region_id,region_name,country):
    query = "INSERT INTO region (region_id,region_name,country) VALUES (?, ?, ?)"
    values = (region_id,region_name,country)

    with ssms_conn.cursor() as ssms_cursor, pg_conn.cursor() as pg_cursor:
        ssms_cursor.execute(query, values)
        pg_cursor.execute(query.replace("?", "%s"), values)
        ssms_conn.commit()
        pg_conn.commit()

    messagebox.showinfo("Success", "Region added successfully!")

def read_region():
    query = "SELECT * FROM region"

    with ssms_conn.cursor() as ssms_cursor, pg_conn.cursor() as pg_cursor:
        ssms_cursor.execute(query)
        pg_cursor.execute(query)
        ssms_results = ssms_cursor.fetchall()
        pg_results = pg_cursor.fetchall()

    messagebox.showinfo("Region: ", "\n".join([str(row) for row in ssms_results]))

def update_region(region_id,region_name,country):
    query = "UPDATE region SET region_name = ?, country = ? WHERE region_id = ?"
    values = (region_id,region_name,country)

    with ssms_conn.cursor() as ssms_cursor, pg_conn.cursor() as pg_cursor:
        ssms_cursor.execute(query, values)
        pg_cursor.execute(query.replace("?", "%s"), values)
        ssms_conn.commit()
        pg_conn.commit()

    messagebox.showinfo("Success", "Region updated successfully!")

def delete_region(region_id):
    query = "DELETE FROM region WHERE region_id = ?"

    with ssms_conn.cursor() as ssms_cursor, pg_conn.cursor() as pg_cursor:
        ssms_cursor.execute(query, (region_id,))
        pg_cursor.execute(query.replace("?", "%s"), (region_id,))
        ssms_conn.commit()
        pg_conn.commit()

    messagebox.showinfo("Success", "Region deleted successfully!")

def get_region(region_id):
    query = "SELECT * FROM region WHERE region_id = ?"

    with ssms_conn.cursor() as ssms_cursor, pg_conn.cursor() as pg_cursor:
        ssms_cursor.execute(query, (region_id,))
        pg_cursor.execute(query.replace("?", "%s"), (region_id,))
        ssms_result = ssms_cursor.fetchone()
        pg_result = pg_cursor.fetchone()

    messagebox.showinfo("Region: ", str(ssms_result))

def create_supplier(supplier_id, supplier_name, contact_email, phone, address):
    query = "INSERT INTO supplier (supplier_id, supplier_name, contact_email, phone, address) VALUES (?, ?, ?, ?, ?)"
    values = (supplier_id, supplier_name, contact_email, phone, address)

    with ssms_conn.cursor() as ssms_cursor, pg_conn.cursor() as pg_cursor:
        ssms_cursor.execute(query, values)
        pg_cursor.execute(query.replace("?", "%s"), values)
        ssms_conn.commit()
        pg_conn.commit()

    messagebox.showinfo("Success", "Supplier added successfully!")

def read_supplier():
    query = "SELECT * FROM supplier"

    with ssms_conn.cursor() as ssms_cursor, pg_conn.cursor() as pg_cursor:
        ssms_cursor.execute(query)
        pg_cursor.execute(query)
        ssms_results = ssms_cursor.fetchall()
        pg_results = pg_cursor.fetchall()

    messagebox.showinfo("Supplier: ", "\n".join([str(row) for row in ssms_results]))

def update_supplier(supplier_id, supplier_name, contact_email, phone, address):
    query = "UPDATE supplier SET supplier_name = ?, contact_email = ?, phone = ?, address = ? WHERE supplier_id = ?"
    values = (supplier_id, supplier_name, contact_email, phone, address)

    with ssms_conn.cursor() as ssms_cursor, pg_conn.cursor() as pg_cursor:
        ssms_cursor.execute(query, values)
        pg_cursor.execute(query.replace("?", "%s"), values)
        ssms_conn.commit()
        pg_conn.commit()

    messagebox.showinfo("Success", "Supplier updated successfully!")

def delete_supplier(supplier_id):
    query = "DELETE FROM supplier WHERE supplier_id = ?"

    with ssms_conn.cursor() as ssms_cursor, pg_conn.cursor() as pg_cursor:
        ssms_cursor.execute(query, (supplier_id,))
        pg_cursor.execute(query.replace("?", "%s"), (supplier_id,))
        ssms_conn.commit()
        pg_conn.commit()

    messagebox.showinfo("Success", "Supplier deleted successfully!")

def get_supplier(supplier_id):
    query = "SELECT * FROM supplier WHERE supplier_id = ?"

    with ssms_conn.cursor() as ssms_cursor, pg_conn.cursor() as pg_cursor:
        ssms_cursor.execute(query, (supplier_id,))
        pg_cursor.execute(query.replace("?", "%s"), (supplier_id,))
        ssms_result = ssms_cursor.fetchone()
        pg_result = pg_cursor.fetchone()

    messagebox.showinfo("Supplier: ", str(ssms_result))


def create_transaction(transaction_id, wine_id, transaction_type, date, quantity, price_per_bottle, user_id):
    query = "INSERT INTO transactions (transaction_id, wine_id, transaction_type, date, quantity, price_per_bottle, user_id) VALUES (?, ?, ?, ?, ?, ?, ?)"
    values = (transaction_id, wine_id, transaction_type, date, quantity, price_per_bottle, user_id)

    with ssms_conn.cursor() as ssms_cursor, pg_conn.cursor() as pg_cursor:
        ssms_cursor.execute(query, values)
        pg_cursor.execute(query.replace("?", "%s"), values)
        ssms_conn.commit()
        pg_conn.commit()

    messagebox.showinfo("Success", "Transaction added successfully!")

def read_transactions():
    query = "SELECT * FROM transactions"

    with ssms_conn.cursor() as ssms_cursor, pg_conn.cursor() as pg_cursor:
        ssms_cursor.execute(query)
        pg_cursor.execute(query)
        ssms_results = ssms_cursor.fetchall()
        pg_results = pg_cursor.fetchall()

    messagebox.showinfo("Transactions: ", "\n".join([str(row) for row in ssms_results]))

def update_transaction(transaction_id, wine_id, transaction_type, date, quantity, price_per_bottle, user_id):
    query = "UPDATE transactions SET wine_id = ?, transaction_type = ?, date = ?, quantity = ?, price_per_bottle = ?, user_id = ? WHERE transaction_id = ?"
    values = (wine_id, transaction_type, date, quantity, price_per_bottle, user_id, transaction_id)

    with ssms_conn.cursor() as ssms_cursor, pg_conn.cursor() as pg_cursor:
        ssms_cursor.execute(query, values)
        pg_cursor.execute(query.replace("?", "%s"), values)
        ssms_conn.commit()
        pg_conn.commit()

    messagebox.showinfo("Success", "Transaction updated successfully!")

def delete_transaction(transaction_id):
    query = "DELETE FROM transactions WHERE transaction_id = ?"

    with ssms_conn.cursor() as ssms_cursor, pg_conn.cursor() as pg_cursor:
        ssms_cursor.execute(query, (transaction_id,))
        pg_cursor.execute(query.replace("?", "%s"), (transaction_id,))
        ssms_conn.commit()
        pg_conn.commit()

    messagebox.showinfo("Success", "Transaction deleted successfully!")

def get_transaction(transaction_id):
    query = "SELECT * FROM transactions WHERE transaction_id = ?"

    with ssms_conn.cursor() as ssms_cursor, pg_conn.cursor() as pg_cursor:
        ssms_cursor.execute(query, (transaction_id,))
        pg_cursor.execute(query.replace("?", "%s"), (transaction_id,))
        ssms_result = ssms_cursor.fetchone()
        pg_result = pg_cursor.fetchone()

    messagebox.showinfo("Transaction: ", str(ssms_result))


def create_user(user_id, username, password_hash, role):
    query = "INSERT INTO users (user_id, username, password_hash, role) VALUES (?, ?, ?, ?)"
    values = (user_id, username, password_hash, role)

    with ssms_conn.cursor() as ssms_cursor, pg_conn.cursor() as pg_cursor:
        ssms_cursor.execute(query, values)
        pg_cursor.execute(query.replace("?", "%s"), values)
        ssms_conn.commit()
        pg_conn.commit()

    messagebox.showinfo("Success", "User added successfully!")

def read_users():
    query = "SELECT * FROM users"

    with ssms_conn.cursor() as ssms_cursor, pg_conn.cursor() as pg_cursor:
        ssms_cursor.execute(query)
        pg_cursor.execute(query)
        ssms_results = ssms_cursor.fetchall()
        pg_results = pg_cursor.fetchall()

    messagebox.showinfo("Users: ", "\n".join([str(row) for row in ssms_results]))

def update_user(user_id, username, password_hash, role):
    query = "UPDATE users SET username = ?, password_hash = ?, role = ? WHERE user_id = ?"
    values = (username, password_hash, role, user_id)

    with ssms_conn.cursor() as ssms_cursor, pg_conn.cursor() as pg_cursor:
        ssms_cursor.execute(query, values)
        pg_cursor.execute(query.replace("?", "%s"), values)
        ssms_conn.commit()
        pg_conn.commit()

    messagebox.showinfo("Success", "User updated successfully!")

def delete_user(user_id):
    query = "DELETE FROM users WHERE user_id = ?"

    with ssms_conn.cursor() as ssms_cursor, pg_conn.cursor() as pg_cursor:
        ssms_cursor.execute(query, (user_id,))
        pg_cursor.execute(query.replace("?", "%s"), (user_id,))
        ssms_conn.commit()
        pg_conn.commit()

    messagebox.showinfo("Success", "User deleted successfully!")

def get_user(user_id):
    query = "SELECT * FROM users WHERE user_id = ?"

    with ssms_conn.cursor() as ssms_cursor, pg_conn.cursor() as pg_cursor:
        ssms_cursor.execute(query, (user_id,))
        pg_cursor.execute(query.replace("?", "%s"), (user_id,))
        ssms_result = ssms_cursor.fetchone()
        pg_result = pg_cursor.fetchone()

    messagebox.showinfo("User: ", str(ssms_result))


def create_wine(wine_id, name, type_id, region_id, vintage_year, alcohol_percentage, supplier_id):
    query = "INSERT INTO wines (wine_id, name, type_id, region_id, vintage_year, alcohol_percentage, supplier_id) VALUES (?, ?, ?, ?, ?, ?, ?)"
    values = (wine_id, name, type_id, region_id, vintage_year, alcohol_percentage, supplier_id)

    with ssms_conn.cursor() as ssms_cursor, pg_conn.cursor() as pg_cursor:
        ssms_cursor.execute(query, values)
        pg_cursor.execute(query.replace("?", "%s"), values)
        ssms_conn.commit()
        pg_conn.commit()

    messagebox.showinfo("Success", "Wine added successfully!")

def read_wines():
    query = "SELECT * FROM wines"

    with ssms_conn.cursor() as ssms_cursor, pg_conn.cursor() as pg_cursor:
        ssms_cursor.execute(query)
        pg_cursor.execute(query)
        ssms_results = ssms_cursor.fetchall()
        pg_results = pg_cursor.fetchall()

    messagebox.showinfo("Wines: ", "\n".join([str(row) for row in ssms_results]))

def update_wine(wine_id, name, type_id, region_id, vintage_year, alcohol_percentage, supplier_id):
    query = "UPDATE wines SET name = ?, type_id = ?, region_id = ?, vintage_year = ?, alcohol_percentage = ?, supplier_id = ? WHERE wine_id = ?"
    values = (name, type_id, region_id, vintage_year, alcohol_percentage, supplier_id, wine_id)

    with ssms_conn.cursor() as ssms_cursor, pg_conn.cursor() as pg_cursor:
        ssms_cursor.execute(query, values)
        pg_cursor.execute(query.replace("?", "%s"), values)
        ssms_conn.commit()
        pg_conn.commit()

    messagebox.showinfo("Success", "Wine updated successfully!")

def delete_wine(wine_id):
    query = "DELETE FROM wines WHERE wine_id = ?"

    with ssms_conn.cursor() as ssms_cursor, pg_conn.cursor() as pg_cursor:
        ssms_cursor.execute(query, (wine_id,))
        pg_cursor.execute(query.replace("?", "%s"), (wine_id,))
        ssms_conn.commit()
        pg_conn.commit()

    messagebox.showinfo("Success", "Wine deleted successfully!")

def get_wine(wine_id):
    query = "SELECT * FROM wines WHERE wine_id = ?"

    with ssms_conn.cursor() as ssms_cursor, pg_conn.cursor() as pg_cursor:
        ssms_cursor.execute(query, (wine_id,))
        pg_cursor.execute(query.replace("?", "%s"), (wine_id,))
        ssms_result = ssms_cursor.fetchone()
        pg_result = pg_cursor.fetchone()

    messagebox.showinfo("Wine: ", str(ssms_result))


def create_wine_type(type_id, type_name):
    query = "INSERT INTO winetype (type_id, type_name) VALUES (?, ?)"
    values = (type_id, type_name)

    with ssms_conn.cursor() as ssms_cursor, pg_conn.cursor() as pg_cursor:
        ssms_cursor.execute(query, values)
        pg_cursor.execute(query.replace("?", "%s"), values)
        ssms_conn.commit()
        pg_conn.commit()

    messagebox.showinfo("Success", "WineType added successfully!")

def read_wine_types():
    query = "SELECT * FROM winetype"

    with ssms_conn.cursor() as ssms_cursor, pg_conn.cursor() as pg_cursor:
        ssms_cursor.execute(query)
        pg_cursor.execute(query)
        ssms_results = ssms_cursor.fetchall()
        pg_results = pg_cursor.fetchall()

    messagebox.showinfo("WineTypes: ", "\n".join([str(row) for row in ssms_results]))

def update_wine_type(type_id, type_name):
    query = "UPDATE winetype SET type_name = ? WHERE type_id = ?"
    values = (type_name, type_id)

    with ssms_conn.cursor() as ssms_cursor, pg_conn.cursor() as pg_cursor:
        ssms_cursor.execute(query, values)
        pg_cursor.execute(query.replace("?", "%s"), values)
        ssms_conn.commit()
        pg_conn.commit()

    messagebox.showinfo("Success", "WineType updated successfully!")

def delete_wine_type(type_id):
    query = "DELETE FROM winetype WHERE type_id = ?"

    with ssms_conn.cursor() as ssms_cursor, pg_conn.cursor() as pg_cursor:
        ssms_cursor.execute(query, (type_id,))
        pg_cursor.execute(query.replace("?", "%s"), (type_id,))
        ssms_conn.commit()
        pg_conn.commit()

    messagebox.showinfo("Success", "WineType deleted successfully!")

def get_wine_type(type_id):
    query = "SELECT * FROM winetype WHERE type_id = ?"

    with ssms_conn.cursor() as ssms_cursor, pg_conn.cursor() as pg_cursor:
        ssms_cursor.execute(query, (type_id,))
        pg_cursor.execute(query.replace("?", "%s"), (type_id,))
        ssms_result = ssms_cursor.fetchone()
        pg_result = pg_cursor.fetchone()

    messagebox.showinfo("WineType: ", str(ssms_result))



def create_labeled_entry(parent, label_text, row):
    label = tk.Label(parent, text=label_text, anchor='w')
    entry = tk.Entry(parent)
    label.grid(row=row, column=0, sticky='w', padx=5, pady=5)
    entry.grid(row=row, column=1, padx=5, pady=5)
    return entry


def create_cellarlocation_gui():
    def submit():
        location_id = entry_location_id.get()
        section = entry_section.get()
        rack_number = entry_rack_number.get()
        bottle_position = entry_bottle_position.get()
        create_cellarlocation(location_id, section, rack_number, bottle_position)
        window.destroy()  # Close the window after submission

    window = tk.Toplevel()
    window.title("Create CellarLocation")
    window.geometry("400x300")

    frame = tk.Frame(window, padx=10, pady=10)
    frame.pack(expand=True, fill='both')

    entry_location_id = create_labeled_entry(frame, "Location ID:", 0)
    entry_section = create_labeled_entry(frame, "Section:", 1)
    entry_rack_number = create_labeled_entry(frame, "Rack Number:", 2)
    entry_bottle_position = create_labeled_entry(frame, "Bottle position(int):", 3)


    tk.Button(frame, text="Submit", command=submit, width=20, height=2).grid(row=4, column=0, columnspan=2, pady=10)

def update_cellarlocation_gui():
    def submit():
        location_id = entry_location_id.get()
        section = entry_section.get()
        rack_number = entry_rack_number.get()
        bottle_position = entry_bottle_position.get()
        update_cellarlocation(location_id, section, rack_number, bottle_position)
        window.destroy()  # Close the window after submission

    window = tk.Toplevel()
    window.title("Update CellarLocation")
    window.geometry("400x300")

    frame = tk.Frame(window, padx=10, pady=10)
    frame.pack(expand=True, fill='both')

    entry_location_id = create_labeled_entry(frame, ":", 0)
    entry_section = create_labeled_entry(frame, "First Name:", 1)
    entry_rack_number = create_labeled_entry(frame, "Last Name:", 2)
    entry_bottle_position = create_labeled_entry(frame, "Department ID:", 3)

    tk.Button(frame, text="Submit", command=submit, width=20, height=2).grid(row=4, column=0, columnspan=2, pady=10)

def delete_cellarlocation_gui():
    def submit():
        location_id = entry_location_id.get()
        delete_cellarlocation(location_id)
        window.destroy()  # Close the window after submission

    window = tk.Toplevel()
    window.title("Delete CellarLocation")
    window.geometry("400x200")

    frame = tk.Frame(window, padx=10, pady=10)
    frame.pack(expand=True, fill='both')

    entry_location_id = create_labeled_entry(frame, "ID:", 0)

    tk.Button(frame, text="Submit", command=submit, width=20, height=2).grid(row=1, column=0, columnspan=2, pady=10)

def get_cellarlocation_gui():
    def submit():
        location_id = entry_location_id.get()
        get_cellarlocation(location_id)
        window.destroy()  # Close the window after submission

    window = tk.Toplevel()
    window.title("Get CellarLocation")
    window.geometry("400x200")

    frame = tk.Frame(window, padx=10, pady=10)
    frame.pack(expand=True, fill='both')

    entry_location_id = create_labeled_entry(frame, "ID:", 0)

    tk.Button(frame, text="Submit", command=submit, width=20, height=2).grid(row=1, column=0, columnspan=2, pady=10)



def create_supplier_gui():
    def submit():
        supplier_id = entry_supplier_id.get()
        supplier_name = entry_supplier_name.get()
        contact_email = entry_contact_email.get()
        phone = entry_phone.get()
        address = entry_address.get()
        create_supplier(supplier_id, supplier_name, contact_email, phone, address)
        window.destroy()

    window = tk.Toplevel()
    window.title("Create Supplier")
    window.geometry("400x300")

    frame = tk.Frame(window, padx=10, pady=10)
    frame.pack(expand=True, fill='both')

    entry_supplier_id = create_labeled_entry(frame, "Supplier ID:", 0)
    entry_supplier_name = create_labeled_entry(frame, "Supplier Name:", 1)
    entry_contact_email = create_labeled_entry(frame, "Contact Email:", 2)
    entry_phone = create_labeled_entry(frame, "Phone:", 3)
    entry_address = create_labeled_entry(frame, "Address:", 4)

    tk.Button(frame, text="Submit", command=submit, width=20, height=2).grid(row=5, column=0, columnspan=2, pady=10)

def update_supplier_gui():
    def submit():
        supplier_id = entry_supplier_id.get()
        supplier_name = entry_supplier_name.get()
        contact_email = entry_contact_email.get()
        phone = entry_phone.get()
        address = entry_address.get()
        update_supplier(supplier_id, supplier_name, contact_email, phone, address)
        window.destroy()

    window = tk.Toplevel()
    window.title("Update Supplier")
    window.geometry("400x300")

    frame = tk.Frame(window, padx=10, pady=10)
    frame.pack(expand=True, fill='both')

    entry_supplier_id = create_labeled_entry(frame, "Supplier ID:", 0)
    entry_supplier_name = create_labeled_entry(frame, "Supplier Name:", 1)
    entry_contact_email = create_labeled_entry(frame, "Contact Email:", 2)
    entry_phone = create_labeled_entry(frame, "Phone:", 3)
    entry_address = create_labeled_entry(frame, "Address:", 4)

    tk.Button(frame, text="Submit", command=submit, width=20, height=2).grid(row=5, column=0, columnspan=2, pady=10)

def delete_supplier_gui():
    def submit():
        supplier_id = entry_supplier_id.get()
        delete_supplier(supplier_id)
        window.destroy()

    window = tk.Toplevel()
    window.title("Delete Supplier")
    window.geometry("400x200")

    frame = tk.Frame(window, padx=10, pady=10)
    frame.pack(expand=True, fill='both')

    entry_supplier_id = create_labeled_entry(frame, "Supplier ID:", 0)

    tk.Button(frame, text="Submit", command=submit, width=20, height=2).grid(row=1, column=0, columnspan=2, pady=10)

def get_supplier_gui():
    def submit():
        supplier_id = entry_supplier_id.get()
        get_supplier(supplier_id)
        window.destroy()

    window = tk.Toplevel()
    window.title("Get Supplier")
    window.geometry("400x200")

    frame = tk.Frame(window, padx=10, pady=10)
    frame.pack(expand=True, fill='both')

    entry_supplier_id = create_labeled_entry(frame, "Supplier ID:", 0)

    tk.Button(frame, text="Submit", command=submit, width=20, height=2).grid(row=1, column=0, columnspan=2, pady=10)


def create_transaction_gui():
    def submit():
        transaction_id = entry_transaction_id.get()
        wine_id = entry_wine_id.get()
        transaction_type = entry_transaction_type.get()
        date = entry_date.get()
        quantity = entry_quantity.get()
        price_per_bottle = entry_price_per_bottle.get()
        user_id = entry_user_id.get()
        create_transaction(transaction_id, wine_id, transaction_type, date, quantity, price_per_bottle, user_id)
        window.destroy()

    window = tk.Toplevel()
    window.title("Create Transaction")
    window.geometry("400x400")

    frame = tk.Frame(window, padx=10, pady=10)
    frame.pack(expand=True, fill='both')

    entry_transaction_id = create_labeled_entry(frame, "Transaction ID:", 0)
    entry_wine_id = create_labeled_entry(frame, "Wine ID:", 1)
    entry_transaction_type = create_labeled_entry(frame, "Transaction Type:", 2)
    entry_date = create_labeled_entry(frame, "Date:", 3)
    entry_quantity = create_labeled_entry(frame, "Quantity:", 4)
    entry_price_per_bottle = create_labeled_entry(frame, "Price per Bottle:", 5)
    entry_user_id = create_labeled_entry(frame, "User ID:", 6)

    tk.Button(frame, text="Submit", command=submit, width=20, height=2).grid(row=7, column=0, columnspan=2, pady=10)

def update_transaction_gui():
    def submit():
        transaction_id = entry_transaction_id.get()
        wine_id = entry_wine_id.get()
        transaction_type = entry_transaction_type.get()
        date = entry_date.get()
        quantity = entry_quantity.get()
        price_per_bottle = entry_price_per_bottle.get()
        user_id = entry_user_id.get()
        update_transaction(transaction_id, wine_id, transaction_type, date, quantity, price_per_bottle, user_id)
        window.destroy()

    window = tk.Toplevel()
    window.title("Update Transaction")
    window.geometry("400x400")

    frame = tk.Frame(window, padx=10, pady=10)
    frame.pack(expand=True, fill='both')

    entry_transaction_id = create_labeled_entry(frame, "Transaction ID:", 0)
    entry_wine_id = create_labeled_entry(frame, "Wine ID:", 1)
    entry_transaction_type = create_labeled_entry(frame, "Transaction Type:", 2)
    entry_date = create_labeled_entry(frame, "Date:", 3)
    entry_quantity = create_labeled_entry(frame, "Quantity:", 4)
    entry_price_per_bottle = create_labeled_entry(frame, "Price per Bottle:", 5)
    entry_user_id = create_labeled_entry(frame, "User ID:", 6)

    tk.Button(frame, text="Submit", command=submit, width=20, height=2).grid(row=7, column=0, columnspan=2, pady=10)

def delete_transaction_gui():
    def submit():
        transaction_id = entry_transaction_id.get()
        delete_transaction(transaction_id)
        window.destroy()

    window = tk.Toplevel()
    window.title("Delete Transaction")
    window.geometry("400x200")

    frame = tk.Frame(window, padx=10, pady=10)
    frame.pack(expand=True, fill='both')

    entry_transaction_id = create_labeled_entry(frame, "Transaction ID:", 0)

    tk.Button(frame, text="Submit", command=submit, width=20, height=2).grid(row=1, column=0, columnspan=2, pady=10)

def get_transaction_gui():
    def submit():
        transaction_id = entry_transaction_id.get()
        get_transaction(transaction_id)
        window.destroy()

    window = tk.Toplevel()
    window.title("Get Transaction")
    window.geometry("400x200")

    frame = tk.Frame(window, padx=10, pady=10)
    frame.pack(expand=True, fill='both')

    entry_transaction_id = create_labeled_entry(frame, "Transaction ID:", 0)

    tk.Button(frame, text="Submit", command=submit, width=20, height=2).grid(row=1, column=0, columnspan=2, pady=10)

def create_user_gui():
    def submit():
        user_id = entry_user_id.get()
        username = entry_username.get()
        password_hash = entry_password_hash.get()
        role = entry_role.get()
        create_user(user_id, username, password_hash, role)
        window.destroy()

    window = tk.Toplevel()
    window.title("Create User")
    window.geometry("400x300")

    frame = tk.Frame(window, padx=10, pady=10)
    frame.pack(expand=True, fill='both')

    entry_user_id = create_labeled_entry(frame, "User ID:", 0)
    entry_username = create_labeled_entry(frame, "Username:", 1)
    entry_password_hash = create_labeled_entry(frame, "Password Hash:", 2)
    entry_role = create_labeled_entry(frame, "Role:", 3)

    tk.Button(frame, text="Submit", command=submit, width=20, height=2).grid(row=4, column=0, columnspan=2, pady=10)

def update_user_gui():
    def submit():
        user_id = entry_user_id.get()
        username = entry_username.get()
        password_hash = entry_password_hash.get()
        role = entry_role.get()
        update_user(user_id, username, password_hash, role)
        window.destroy()

    window = tk.Toplevel()
    window.title("Update User")
    window.geometry("400x300")

    frame = tk.Frame(window, padx=10, pady=10)
    frame.pack(expand=True, fill='both')

    entry_user_id = create_labeled_entry(frame, "User ID:", 0)
    entry_username = create_labeled_entry(frame, "Username:", 1)
    entry_password_hash = create_labeled_entry(frame, "Password Hash:", 2)
    entry_role = create_labeled_entry(frame, "Role:", 3)

    tk.Button(frame, text="Submit", command=submit, width=20, height=2).grid(row=4, column=0, columnspan=2, pady=10)

def delete_user_gui():
    def submit():
        user_id = entry_user_id.get()
        delete_user(user_id)
        window.destroy()

    window = tk.Toplevel()
    window.title("Delete User")
    window.geometry("400x200")

    frame = tk.Frame(window, padx=10, pady=10)
    frame.pack(expand=True, fill='both')

    entry_user_id = create_labeled_entry(frame, "User ID:", 0)

    tk.Button(frame, text="Submit", command=submit, width=20, height=2).grid(row=1, column=0, columnspan=2, pady=10)

def get_user_gui():
    def submit():
        user_id = entry_user_id.get()
        get_user(user_id)
        window.destroy()

    window = tk.Toplevel()
    window.title("Get User")
    window.geometry("400x200")

    frame = tk.Frame(window, padx=10, pady=10)
    frame.pack(expand=True, fill='both')

    entry_user_id = create_labeled_entry(frame, "User ID:", 0)

    tk.Button(frame, text="Submit", command=submit, width=20, height=2).grid(row=1, column=0, columnspan=2, pady=10)


def create_wine_gui():
    def submit():
        wine_id = entry_wine_id.get()
        name = entry_name.get()
        type_id = entry_type_id.get()
        region_id = entry_region_id.get()
        vintage_year = entry_vintage_year.get()
        alcohol_percentage = entry_alcohol_percentage.get()
        supplier_id = entry_supplier_id.get()
        create_wine(wine_id, name, type_id, region_id, vintage_year, alcohol_percentage, supplier_id)
        window.destroy()

    window = tk.Toplevel()
    window.title("Create Wine")
    window.geometry("400x400")

    frame = tk.Frame(window, padx=10, pady=10)
    frame.pack(expand=True, fill='both')

    entry_wine_id = create_labeled_entry(frame, "Wine ID:", 0)
    entry_name = create_labeled_entry(frame, "Name:", 1)
    entry_type_id = create_labeled_entry(frame, "Type ID:", 2)
    entry_region_id = create_labeled_entry(frame, "Region ID:", 3)
    entry_vintage_year = create_labeled_entry(frame, "Vintage Year:", 4)
    entry_alcohol_percentage = create_labeled_entry(frame, "Alcohol Percentage:", 5)
    entry_supplier_id = create_labeled_entry(frame, "Supplier ID:", 6)

    tk.Button(frame, text="Submit", command=submit, width=20, height=2).grid(row=7, column=0, columnspan=2, pady=10)

def update_wine_gui():
    def submit():
        wine_id = entry_wine_id.get()
        name = entry_name.get()
        type_id = entry_type_id.get()
        region_id = entry_region_id.get()
        vintage_year = entry_vintage_year.get()
        alcohol_percentage = entry_alcohol_percentage.get()
        supplier_id = entry_supplier_id.get()
        update_wine(wine_id, name, type_id, region_id, vintage_year, alcohol_percentage, supplier_id)
        window.destroy()

    window = tk.Toplevel()
    window.title("Update Wine")
    window.geometry("400x400")

    frame = tk.Frame(window, padx=10, pady=10)
    frame.pack(expand=True, fill='both')

    entry_wine_id = create_labeled_entry(frame, "Wine ID:", 0)
    entry_name = create_labeled_entry(frame, "Name:", 1)
    entry_type_id = create_labeled_entry(frame, "Type ID:", 2)
    entry_region_id = create_labeled_entry(frame, "Region ID:", 3)
    entry_vintage_year = create_labeled_entry(frame, "Vintage Year:", 4)
    entry_alcohol_percentage = create_labeled_entry(frame, "Alcohol Percentage:", 5)
    entry_supplier_id = create_labeled_entry(frame, "Supplier ID:", 6)

    tk.Button(frame, text="Submit", command=submit, width=20, height=2).grid(row=7, column=0, columnspan=2, pady=10)

def delete_wine_gui():
    def submit():
        wine_id = entry_wine_id.get()
        delete_wine(wine_id)
        window.destroy()

    window = tk.Toplevel()
    window.title("Delete Wine")
    window.geometry("400x200")

    frame = tk.Frame(window, padx=10, pady=10)
    frame.pack(expand=True, fill='both')

    entry_wine_id = create_labeled_entry(frame, "Wine ID:", 0)

    tk.Button(frame, text="Submit", command=submit, width=20, height=2).grid(row=1, column=0, columnspan=2, pady=10)

def get_wine_gui():
    def submit():
        wine_id = entry_wine_id.get()
        get_wine(wine_id)
        window.destroy()

    window = tk.Toplevel()
    window.title("Get Wine")
    window.geometry("400x200")

    frame = tk.Frame(window, padx=10, pady=10)
    frame.pack(expand=True, fill='both')

    entry_wine_id = create_labeled_entry(frame, "Wine ID:", 0)

    tk.Button(frame, text="Submit", command=submit, width=20, height=2).grid(row=1, column=0, columnspan=2, pady=10)



def create_wine_type_gui():
    def submit():
        type_id = entry_type_id.get()
        type_name = entry_type_name.get()
        create_wine_type(type_id, type_name)
        window.destroy()

    window = tk.Toplevel()
    window.title("Create Wine Type")
    window.geometry("400x200")

    frame = tk.Frame(window, padx=10, pady=10)
    frame.pack(expand=True, fill='both')

    entry_type_id = create_labeled_entry(frame, "Type ID:", 0)
    entry_type_name = create_labeled_entry(frame, "Type Name:", 1)

    tk.Button(frame, text="Submit", command=submit, width=20, height=2).grid(row=2, column=0, columnspan=2, pady=10)

def update_wine_type_gui():
    def submit():
        type_id = entry_type_id.get()
        type_name = entry_type_name.get()
        update_wine_type(type_id, type_name)
        window.destroy()

    window = tk.Toplevel()
    window.title("Update Wine Type")
    window.geometry("400x200")

    frame = tk.Frame(window, padx=10, pady=10)
    frame.pack(expand=True, fill='both')

    entry_type_id = create_labeled_entry(frame, "Type ID:", 0)
    entry_type_name = create_labeled_entry(frame, "Type Name:", 1)

    tk.Button(frame, text="Submit", command=submit, width=20, height=2).grid(row=2, column=0, columnspan=2, pady=10)

def delete_wine_type_gui():
    def submit():
        type_id = entry_type_id.get()
        delete_wine_type(type_id)
        window.destroy()

    window = tk.Toplevel()
    window.title("Delete Wine Type")
    window.geometry("400x200")

    frame = tk.Frame(window, padx=10, pady=10)
    frame.pack(expand=True, fill='both')

    entry_type_id = create_labeled_entry(frame, "Type ID:", 0)

    tk.Button(frame, text="Submit", command=submit, width=20, height=2).grid(row=1, column=0, columnspan=2, pady=10)

def get_wine_type_gui():
    def submit():
        type_id = entry_type_id.get()
        get_wine_type(type_id)
        window.destroy()

    window = tk.Toplevel()
    window.title("Get Wine Type")
    window.geometry("400x200")

    frame = tk.Frame(window, padx=10, pady=10)
    frame.pack(expand=True, fill='both')

    entry_type_id = create_labeled_entry(frame, "Type ID:", 0)

    tk.Button(frame, text="Submit", command=submit, width=20, height=2).grid(row=1, column=0, columnspan=2, pady=10)

def create_region_gui():
    def submit():
        region_id = entry_region_id.get()
        region_name = entry_region_name.get()
        country = entry_country.get()
        create_region(region_id, region_name, country)
        window.destroy()

    window = tk.Toplevel()
    window.title("Create Region")
    window.geometry("400x300")

    frame = tk.Frame(window, padx=10, pady=10)
    frame.pack(expand=True, fill='both')

    entry_region_id = create_labeled_entry(frame, "Region ID:", 0)
    entry_region_name = create_labeled_entry(frame, "Region Name:", 1)
    entry_country = create_labeled_entry(frame, "Country:", 2)

    tk.Button(frame, text="Submit", command=submit, width=20, height=2).grid(row=3, column=0, columnspan=2, pady=10)

def update_region_gui():
    def submit():
        region_id = entry_region_id.get()
        region_name = entry_region_name.get()
        country = entry_country.get()
        update_region(region_id, region_name, country)
        window.destroy()

    window = tk.Toplevel()
    window.title("Update Region")
    window.geometry("400x300")

    frame = tk.Frame(window, padx=10, pady=10)
    frame.pack(expand=True, fill='both')

    entry_region_id = create_labeled_entry(frame, "Region ID:", 0)
    entry_region_name = create_labeled_entry(frame, "Region Name:", 1)
    entry_country = create_labeled_entry(frame, "Country:", 2)

    tk.Button(frame, text="Submit", command=submit, width=20, height=2).grid(row=3, column=0, columnspan=2, pady=10)

def delete_region_gui():
    def submit():
        region_id = entry_region_id.get()
        delete_region(region_id)
        window.destroy()

    window = tk.Toplevel()
    window.title("Delete Region")
    window.geometry("400x200")

    frame = tk.Frame(window, padx=10, pady=10)
    frame.pack(expand=True, fill='both')

    entry_region_id = create_labeled_entry(frame, "Region ID:", 0)

    tk.Button(frame, text="Submit", command=submit, width=20, height=2).grid(row=1, column=0, columnspan=2, pady=10)

def get_region_gui():
    def submit():
        region_id = entry_region_id.get()
        get_region(region_id)
        window.destroy()

    window = tk.Toplevel()
    window.title("Get Region")
    window.geometry("400x200")

    frame = tk.Frame(window, padx=10, pady=10)
    frame.pack(expand=True, fill='both')

    entry_region_id = create_labeled_entry(frame, "Region ID:", 0)

    tk.Button(frame, text="Submit", command=submit, width=20, height=2).grid(row=1, column=0, columnspan=2, pady=10)



def create_inventory_gui():
    def submit():
        inventory_id = entry_inventory_id.get()
        wine_id = entry_wine_id.get()
        location_id = entry_location_id.get()
        quantity = entry_quantity.get()
        bottle_size_ml = entry_bottle_size_ml.get()
        create_inventory(inventory_id, wine_id, location_id, quantity, bottle_size_ml)
        window.destroy()

    window = tk.Toplevel()
    window.title("Create Inventory")
    window.geometry("400x300")

    frame = tk.Frame(window, padx=10, pady=10)
    frame.pack(expand=True, fill='both')

    entry_inventory_id = create_labeled_entry(frame, "Inventory ID:", 0)
    entry_wine_id = create_labeled_entry(frame, "Wine ID:", 1)
    entry_location_id = create_labeled_entry(frame, "Location ID:", 2)
    entry_quantity = create_labeled_entry(frame, "Quantity:", 3)
    entry_bottle_size_ml = create_labeled_entry(frame, "Bottle Size (ml):", 4)

    tk.Button(frame, text="Submit", command=submit, width=20, height=2).grid(row=5, column=0, columnspan=2, pady=10)

def update_inventory_gui():
    def submit():
        inventory_id = entry_inventory_id.get()
        wine_id = entry_wine_id.get()
        location_id = entry_location_id.get()
        quantity = entry_quantity.get()
        bottle_size_ml = entry_bottle_size_ml.get()
        update_inventory(inventory_id, wine_id, location_id, quantity, bottle_size_ml)
        window.destroy()

    window = tk.Toplevel()
    window.title("Update Inventory")
    window.geometry("400x300")

    frame = tk.Frame(window, padx=10, pady=10)
    frame.pack(expand=True, fill='both')

    entry_inventory_id = create_labeled_entry(frame, "Inventory ID:", 0)
    entry_wine_id = create_labeled_entry(frame, "Wine ID:", 1)
    entry_location_id = create_labeled_entry(frame, "Location ID:", 2)
    entry_quantity = create_labeled_entry(frame, "Quantity:", 3)
    entry_bottle_size_ml = create_labeled_entry(frame, "Bottle Size (ml):", 4)

    tk.Button(frame, text="Submit", command=submit, width=20, height=2).grid(row=5, column=0, columnspan=2, pady=10)

def delete_inventory_gui():
    def submit():
        inventory_id = entry_inventory_id.get()
        delete_inventory(inventory_id)
        window.destroy()

    window = tk.Toplevel()
    window.title("Delete Inventory")
    window.geometry("400x200")

    frame = tk.Frame(window, padx=10, pady=10)
    frame.pack(expand=True, fill='both')

    entry_inventory_id = create_labeled_entry(frame, "Inventory ID:", 0)

    tk.Button(frame, text="Submit", command=submit, width=20, height=2).grid(row=1, column=0, columnspan=2, pady=10)

def get_inventory_gui():
    def submit():
        inventory_id = entry_inventory_id.get()
        get_inventory(inventory_id)
        window.destroy()

    window = tk.Toplevel()
    window.title("Get Inventory")
    window.geometry("400x200")

    frame = tk.Frame(window, padx=10, pady=10)
    frame.pack(expand=True, fill='both')

    entry_inventory_id = create_labeled_entry(frame, "Inventory ID:", 0)

    tk.Button(frame, text="Submit", command=submit, width=20, height=2).grid(row=1, column=0, columnspan=2, pady=10)


def read_cellarlocations_gui():
    read_cellarlocations()

def read_suppliers_gui():
    read_supplier()

def read_transactions_gui():
    read_transactions()

def read_users_gui():
    read_users()

def read_wines_gui():
    read_wines()

def read_wine_types_gui():
    read_wine_types()

def read_regions_gui():
    read_region()

def read_inventory_gui():
    read_inventory()

def create_scrollable_frame(root):
    canvas = tk.Canvas(root)
    scrollbar = tk.Scrollbar(root, orient="vertical", command=canvas.yview)
    scrollable_frame = tk.Frame(canvas)

    scrollable_frame.bind(
        "<Configure>",
        lambda e: canvas.configure(
            scrollregion=canvas.bbox("all")
        )
    )

    canvas.create_window((0, 0), window=scrollable_frame, anchor="nw")
    canvas.configure(yscrollcommand=scrollbar.set)

    canvas.pack(side="left", fill="both", expand=True)
    scrollbar.pack(side="right", fill="y")

    return scrollable_frame

def main():
    root = tk.Tk()
    root.title("Wine Cellar Management")
    root.geometry("500x800")

    # Create a scrollable frame
    scrollable_frame = create_scrollable_frame(root)

    # Create a frame for each section inside the scrollable frame
    cellarlocation_frame = tk.LabelFrame(scrollable_frame, text="Cellar Locations", padx=10, pady=10)
    inventory_frame = tk.LabelFrame(scrollable_frame, text="Inventory", padx=10, pady=10)
    region_frame = tk.LabelFrame(scrollable_frame, text="Region", padx=10, pady=10)
    supplier_frame = tk.LabelFrame(scrollable_frame, text="Supplier", padx=10, pady=10)
    transaction_frame = tk.LabelFrame(scrollable_frame, text="Transaction", padx=10, pady=10)
    user_frame = tk.LabelFrame(scrollable_frame, text="User", padx=10, pady=10)
    wine_frame = tk.LabelFrame(scrollable_frame, text="Wine", padx=10, pady=10)
    wine_type_frame = tk.LabelFrame(scrollable_frame, text="Wine Type", padx=10, pady=10)

    cellarlocation_frame.pack(padx=10, pady=5, fill="both", expand=True)
    inventory_frame.pack(padx=10, pady=5, fill="both", expand=True)
    region_frame.pack(padx=10, pady=5, fill="both", expand=True)
    supplier_frame.pack(padx=10, pady=5, fill="both", expand=True)
    transaction_frame.pack(padx=10, pady=5, fill="both", expand=True)
    user_frame.pack(padx=10, pady=5, fill="both", expand=True)
    wine_frame.pack(padx=10, pady=5, fill="both", expand=True)
    wine_type_frame.pack(padx=10, pady=5, fill="both", expand=True)

    # Add buttons to the frames
    tk.Button(cellarlocation_frame, text="Create Cellar Location", command=create_cellarlocation_gui, width=25, height=2).pack(fill="x", pady=2)
    tk.Button(cellarlocation_frame, text="Read Cellar Location", command=read_cellarlocations_gui, width=25, height=2).pack(fill="x", pady=2)
    tk.Button(cellarlocation_frame, text="Update Cellar Location", command=update_cellarlocation_gui, width=25, height=2).pack(fill="x", pady=2)
    tk.Button(cellarlocation_frame, text="Delete Cellar Location", command=delete_cellarlocation_gui, width=25, height=2).pack(fill="x", pady=2)
    tk.Button(cellarlocation_frame, text="Get Cellar Location", command=get_cellarlocation_gui, width=25, height=2).pack(fill="x", pady=2)

    tk.Button(inventory_frame, text="Create Inventory", command=create_inventory_gui, width=25, height=2).pack(fill="x", pady=2)
    tk.Button(inventory_frame, text="Read Inventory", command=read_inventory_gui, width=25, height=2).pack(fill="x", pady=2)
    tk.Button(inventory_frame, text="Update Inventory", command=update_inventory_gui, width=25, height=2).pack(fill="x", pady=2)
    tk.Button(inventory_frame, text="Delete Inventory", command=delete_inventory_gui, width=25, height=2).pack(fill="x", pady=2)
    tk.Button(inventory_frame, text="Get Inventory", command=get_inventory_gui, width=25, height=2).pack(fill="x", pady=2)

    tk.Button(region_frame, text="Create Region", command=create_region_gui, width=25, height=2).pack(fill="x", pady=2)
    tk.Button(region_frame, text="Read Region", command=read_regions_gui, width=25, height=2).pack(fill="x", pady=2)
    tk.Button(region_frame, text="Update Region", command=update_region_gui, width=25, height=2).pack(fill="x", pady=2)
    tk.Button(region_frame, text="Delete Region", command=delete_region_gui, width=25, height=2).pack(fill="x", pady=2)
    tk.Button(region_frame, text="Get Region", command=get_region_gui, width=25, height=2).pack(fill="x", pady=2)

    tk.Button(supplier_frame, text="Create Supplier", command=create_supplier_gui, width=25, height=2).pack(fill="x", pady=2)
    tk.Button(supplier_frame, text="Read Supplier", command=read_suppliers_gui, width=25, height=2).pack(fill="x", pady=2)
    tk.Button(supplier_frame, text="Update Supplier", command=update_supplier_gui, width=25, height=2).pack(fill="x", pady=2)
    tk.Button(supplier_frame, text="Delete Supplier", command=delete_supplier_gui, width=25, height=2).pack(fill="x", pady=2)
    tk.Button(supplier_frame, text="Get Supplier", command=get_supplier_gui, width=25, height=2).pack(fill="x", pady=2)

    tk.Button(transaction_frame, text="Create Transaction", command=create_transaction_gui, width=25, height=2).pack(fill="x", pady=2)
    tk.Button(transaction_frame, text="Read Transactions", command=read_transactions_gui, width=25, height=2).pack(fill="x", pady=2)
    tk.Button(transaction_frame, text="Update Transaction", command=update_transaction_gui, width=25, height=2).pack(fill="x", pady=2)
    tk.Button(transaction_frame, text="Delete Transaction", command=delete_transaction_gui, width=25, height=2).pack(fill="x", pady=2)
    tk.Button(transaction_frame, text="Get Transaction", command=get_transaction_gui, width=25, height=2).pack(fill="x", pady=2)

    tk.Button(user_frame, text="Create User", command=create_user_gui, width=25, height=2).pack(fill="x", pady=2)
    tk.Button(user_frame, text="Read Users", command=read_users_gui, width=25, height=2).pack(fill="x", pady=2)
    tk.Button(user_frame, text="Update User", command=update_user_gui, width=25, height=2).pack(fill="x", pady=2)
    tk.Button(user_frame, text="Delete User", command=delete_user_gui, width=25, height=2).pack(fill="x", pady=2)
    tk.Button(user_frame, text="Get User", command=get_user_gui, width=25, height=2).pack(fill="x", pady=2)

    tk.Button(wine_frame, text="Create Wine", command=create_wine_gui, width=25, height=2).pack(fill="x", pady=2)
    tk.Button(wine_frame, text="Read Wines", command=read_wines_gui, width=25, height=2).pack(fill="x", pady=2)
    tk.Button(wine_frame, text="Update Wine", command=update_wine_gui, width=25, height=2).pack(fill="x", pady=2)
    tk.Button(wine_frame, text="Delete Wine", command=delete_wine_gui, width=25, height=2).pack(fill="x", pady=2)
    tk.Button(wine_frame, text="Get Wine", command=get_wine_gui, width=25, height=2).pack(fill="x", pady=2)

    tk.Button(wine_type_frame, text="Create Wine Type", command=create_wine_type_gui, width=25, height=2).pack(fill="x", pady=2)
    tk.Button(wine_type_frame, text="Read Wine Types", command=read_wine_types_gui, width=25, height=2).pack(fill="x", pady=2)
    tk.Button(wine_type_frame, text="Update Wine Type", command=update_wine_type_gui, width=25, height=2).pack(fill="x", pady=2)
    tk.Button(wine_type_frame, text="Delete Wine Type", command=delete_wine_type_gui, width=25, height=2).pack(fill="x", pady=2)
    tk.Button(wine_type_frame, text="Get Wine Type", command=get_wine_type_gui, width=25, height=2).pack(fill="x", pady=2)

    # Exit Button
    exit_button = tk.Button(root, text="Exit", command=root.quit, width=10, height=1)
    exit_button.pack(pady=10)

    root.mainloop()

if __name__ == "__main__":
    main()


