import tkinter as tk
from tkinter import messagebox
from Db_connections import ssms_conn,pg_conn
from GUIs import CellarLocationGUI, InventoryGUI, RegionGUI, SupplierGUI, TransactionGUI, UserGUI, WinesGUI, Wine_typeGUI

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

def open_entity_gui(entity_gui_class):
    entity_gui = entity_gui_class()
    entity_gui.show()

def main():
    root = tk.Tk()
    root.title("Wine Cellar Management")
    root.geometry("500x800")

    # Create a scrollable frame
    scrollable_frame = create_scrollable_frame(root)

    entities_frame = tk.LabelFrame(scrollable_frame, text="Entities", padx=10, pady=10)
    entities_frame.pack(padx=10, pady=5, fill="both", expand=True)

    # Add buttons for each entity
    tk.Button(entities_frame, text="Cellar Location", command=lambda: open_entity_gui(CellarLocationGUI), width=25,
              height=2).pack(fill="x", pady=2)
    tk.Button(entities_frame, text="Inventory", command=lambda: open_entity_gui(InventoryGUI), width=25, height=2).pack(
        fill="x", pady=2)
    tk.Button(entities_frame, text="Region", command=lambda: open_entity_gui(RegionGUI), width=25, height=2).pack(
        fill="x", pady=2)
    tk.Button(entities_frame, text="Supplier", command=lambda: open_entity_gui(SupplierGUI), width=25, height=2).pack(
        fill="x", pady=2)
    tk.Button(entities_frame, text="Transaction", command=lambda: open_entity_gui(TransactionGUI), width=25,
              height=2).pack(fill="x", pady=2)
    tk.Button(entities_frame, text="User", command=lambda: open_entity_gui(UserGUI), width=25, height=2).pack(fill="x",
                                                                                                              pady=2)
    tk.Button(entities_frame, text="Wine", command=lambda: open_entity_gui(WinesGUI), width=25, height=2).pack(fill="x",
                                                                                                              pady=2)
    tk.Button(entities_frame, text="Wine Type", command=lambda: open_entity_gui(Wine_typeGUI), width=25, height=2).pack(
        fill="x", pady=2)

    # Exit Button
    exit_button = tk.Button(root, text="Exit", command=root.quit, width=10, height=1)
    exit_button.pack(pady=10)

    root.mainloop()

if __name__ == "__main__":
    main()


