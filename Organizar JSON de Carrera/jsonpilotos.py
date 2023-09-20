import json
def extraer_nombres(documento):
  nombres = []
  datos = json.loads(documento)
  for item in datos["players"]: # accede a la lista de jugadores
    if "name" in item:
      nombres.append(item["name"])
  return ",".join('"' + nombre + '"' for nombre in nombres)

def extraer_carros(documento):
  marcas = [] # crea una lista vacía para las marcas
  modelos = [] # crea una lista vacía para los modelos
  categorias = [] # crea una lista vacía para las categorías
  datos = json.loads(documento)
  for item in datos["players"]: # accede a la lista de jugadores
    if "car" in item:
      carro = item["car"] # obtiene el nombre del carro
      carro = carro.replace("ks_", "") # elimina el prefijo "ks_"
      carro = carro.split("_") # divide el nombre del carro por los guiones bajos
      marca = carro[0].title() # toma la primera palabra como la marca y la pone en mayúscula
      categoria = carro[-1].upper() # toma la última palabra como la categoría y la pone en mayúscula
      modelo = " ".join(carro[1:-1]).upper() # toma lo que quede en el medio como el modelo y lo pone en mayúscula
      marcas.append(marca) # agrega la marca a la lista de marcas
      modelos.append(modelo) # agrega el modelo a la lista de modelos
      categorias.append(categoria) # agrega la categoría a la lista de categorías
  print(f"Marca: {', '.join(chr (34) + marca + chr (34) for marca in marcas)}") # imprime las marcas separadas por comas y entre comillas usando chr (34)
  print(f"Modelo: {', '.join(chr (34) + modelo + chr (34) for modelo in modelos)}") # imprime los modelos separados por comas y entre comillas usando chr (34)
  print(f"Categoría: {', '.join(chr (34) + categoria + chr (34) for categoria in categorias)}") # imprime las categorías separadas por comas y entre comillas usando chr (34)

with open("230919-221021.json", "r") as f:
  documento = f.read()
  nombres = extraer_nombres(documento)
  print(nombres)
  extraer_carros(documento)

