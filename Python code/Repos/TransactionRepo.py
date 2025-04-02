from tkinter import messagebox
import Entities.Transaction

class TransactionRepo:
    def __init__(self,ssms_conn,pg_conn):
        self.ssms_conn = ssms_conn
        self.pg_conn = pg_conn

    def create_transaction(self,transaction):
        query = "INSERT INTO transactions (transaction_id, wine_id, transaction_type, date, quantity, price_per_bottle, user_id) VALUES (?, ?, ?, ?, ?, ?, ?)"
        values = (transaction.transaction_id, transaction.wine_id, transaction.transaction_type, transaction.date, transaction.quantity, transaction.price_per_bottle, transaction.user_id)

        with self.ssms_conn.cursor() as ssms_cursor, self.pg_conn.cursor() as pg_cursor:
            ssms_cursor.execute(query, values)
            pg_cursor.execute(query.replace("?", "%s"), values)
            self.ssms_conn.commit()
            self.pg_conn.commit()

        messagebox.showinfo("Success", "Transaction added successfully!")

    def read_transactions(self):
        query = "SELECT * FROM transactions"

        with self.ssms_conn.cursor() as ssms_cursor, self.pg_conn.cursor() as pg_cursor:
            ssms_cursor.execute(query)
            pg_cursor.execute(query)
            ssms_results = ssms_cursor.fetchall()
            pg_results = pg_cursor.fetchall()

        messagebox.showinfo("Transactions: ", "\n".join([str(row) for row in ssms_results]))

    def update_transaction(self,transaction):
        query = "UPDATE transactions SET wine_id = ?, transaction_type = ?, date = ?, quantity = ?, price_per_bottle = ?, user_id = ? WHERE transaction_id = ?"
        values = (transaction.wine_id, transaction.transaction_type, transaction.date, transaction.quantity, transaction.price_per_bottle, transaction.user_id, transaction.transaction_id)

        with self.ssms_conn.cursor() as ssms_cursor, self.pg_conn.cursor() as pg_cursor:
            ssms_cursor.execute(query, values)
            pg_cursor.execute(query.replace("?", "%s"), values)
            self.ssms_conn.commit()
            self.pg_conn.commit()

        messagebox.showinfo("Success", "Transaction updated successfully!")

    def delete_transaction(self,transaction_id):
        query = "DELETE FROM transactions WHERE transaction_id = ?"

        with self.ssms_conn.cursor() as ssms_cursor, self.pg_conn.cursor() as pg_cursor:
            ssms_cursor.execute(query, (transaction_id,))
            pg_cursor.execute(query.replace("?", "%s"), (transaction_id,))
            self.ssms_conn.commit()
            self.pg_conn.commit()

        messagebox.showinfo("Success", "Transaction deleted successfully!")

    def get_transaction(self,transaction_id):
        query = "SELECT * FROM transactions WHERE transaction_id = ?"

        with self.ssms_conn.cursor() as ssms_cursor, self.pg_conn.cursor() as pg_cursor:
            ssms_cursor.execute(query, (transaction_id,))
            pg_cursor.execute(query.replace("?", "%s"), (transaction_id,))
            ssms_result = ssms_cursor.fetchone()
            pg_result = pg_cursor.fetchone()

        messagebox.showinfo("Transaction: ", str(ssms_result))


