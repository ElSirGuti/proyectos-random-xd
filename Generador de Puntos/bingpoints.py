import webbrowser
import tkinter as tk

def busquedas_bing(i):
    edge = webbrowser.get('C:/Program Files (x86)/Microsoft/Edge/Application/msedge.exe %s')

    for x in range(i):
        edge.open('https://www.bing.com/search?q=' + str(x))

def on_entry_change(*args):
    # This function is called whenever the text in the entry field changes
    # The function should enable or disable the button depending on whether there is text in the entry field
    if entry_text.get():
        button.config(state=tk.NORMAL)
    else:
        button.config(state=tk.DISABLED)
    
def on_button_click():
    # This function is called when the button is clicked
    puntos = int(entry.get())
    busquedas = puntos // 5
    
    log_text.insert(tk.END, f"Button clicked, Search(es) about to be made: {busquedas}\n")
    busquedas_bing(busquedas)

def clear_entry():
    entry.delete(0, tk.END)

root = tk.Tk()
root.title("Microsoft Rewards Points Generator")
root.geometry("400x400")
root.resizable(False, False)
root.update_idletasks()
x = (root.winfo_screenwidth() - root.winfo_reqwidth()) // 2
y = (root.winfo_screenheight() - root.winfo_reqheight()) // 2
root.geometry("+{}+{}".format(x, y))

# Create a label
label = tk.Label(root, text="How many points you need to be generated?")
label.pack()

# Create an entry field that uses a StringVar to monitor changes to the text
entry_text = tk.StringVar()
entry_text.trace("w", on_entry_change)
entry = tk.Entry(root, textvariable=entry_text)
entry.pack()

# Create a button that is initially disabled
button = tk.Button(root, text="Generate!", state=tk.DISABLED, command=on_button_click)
button.pack()
clear = tk.Button(root, text="Clear", command=clear_entry)
clear.pack()

# Create a text area for the log
log_text = tk.Text(root)
log_text.pack()

root.mainloop()