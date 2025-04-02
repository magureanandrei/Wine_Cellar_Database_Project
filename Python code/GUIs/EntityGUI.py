
# entity_gui.py
import tkinter as tk

class EntityGUI:
    def __init__(self, title):
        self.window = tk.Toplevel()
        self.window.title(title)
        self.window.geometry("400x300")
        self.frame = tk.Frame(self.window, padx=10, pady=10)
        self.frame.pack(expand=True, fill='both')

    def add_button(self, text, command):
        tk.Button(self.frame, text=text, command=command, width=25, height=2).pack(fill="x", pady=2)

    def create_labeled_entry(self, parent, label_text, row):
        label = tk.Label(parent, text=label_text, anchor='w')
        entry = tk.Entry(parent)
        label.grid(row=row, column=0, sticky='w', padx=5, pady=5)
        entry.grid(row=row, column=1, padx=5, pady=5)
        return entry

    def show(self):
        self.window.mainloop()


