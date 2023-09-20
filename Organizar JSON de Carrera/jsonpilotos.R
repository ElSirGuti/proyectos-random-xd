# Vamos a hacer un mini proyecto que consta de un dataframe con los resultados
# de una carrera de Assetto Corsa que acabo de terminar y vamos a hacer
# algunas operaciones :)

# Esto lo hago con la intencion de practicar mis conocimientos en las primeras
# dos unidades del curso de HarvardX en edX que pueden encontrar en el repo
# con el nombre de"HarvardX-Data-Science"

# Tambien hice un script en python que me permitio extraer toda la informacion
# del JSON que provee Content Manager al final de la carrera para no escribir
# uno por uno sino obtener toda la informacion de una vez :)

# Nombres de los pilotos
nombres <- c("Andres Gutierrez","James Calado","Sebastian Asch","Bart Blomme",
             "Francois Vilmot","Osian Patterson","Mads Mikkelsen","Enej Loznar",
             "James March","Franz Menzen","Dario Boksic","Volodymyr Gorban",
             "Shigeru Haruna","Valentin Delon","Julian Beck","Andrea Piccini",
             "Ferenc Rosicki","Marc Miclotte","Michel Boueri","Russell Gill",
             "Henning Floene","Rick Grimes","Thomas Poujol","Miguel Mussano",
             "Sigfrid Ziege","Michele Blanc","Hiroki Katsuta","Daniel Morad",
             "Steffen Huntemann","Pavexon")

# Posiciones finales
posiciones <- c(6,1,3,2,4,8,10,5,9,7,11,15,14,30,18,22,17,26,19,23,13,12,16,28,
                24,27,29,20,21,25)

# Marcas de los carros
marcas <- c("Porsche", "Ferrari", "Mercedes", "Audi", "Lamborghini", "Nissan", 
            "Mclaren", "Bmw", "Mclaren", "Bmw", "Mercedes", "Audi", "Nissan", 
            "Lamborghini", "Porsche", "Ferrari", "Audi", "Mclaren", "Ferrari", 
            "Mercedes", "Porsche", "Bmw", "Nissan", "Lamborghini", "Audi", 
            "Nissan", "Lamborghini", "Mercedes", "Bmw", "Mclaren")

# Modelos de los carros
modelos <- c("911 GT3 R 2016", "488 GT3", "AMG GT3", "R8 LMS", "HURACAN GT3", 
             "GTR GT3","650S GT3","Z4 GT3", "650S GT3", "Z4 GT3", "AMG GT3", 
             "R8 LMS", "GTR GT3", "HURACAN GT3", "911 GT3 R 2016", "488 GT3", 
             "R8 LMS", "650S GT3", "488 GT3", "AMG GT3", "911 GT3 R 2016", 
             "Z4 GT3", "GTR GT3", "HURACAN GT3", "R8 LMS", "GTR GT3", 
             "HURACAN GT3", "AMG GT3", "Z4 GT3", "650S GT3")

# Categorias de los carros
categorias <- c("GT3", "GT3", "GT3", "GT3", "GT3", "GT3", "GT3", "GT3", "GT3", 
                "GT3", "GT3", "GT3", "GT3", "GT3", "GT3", "GT3", "GT3", "GT3",
                "GT3", "GT3", "GT3", "GT3", "GT3", "GT3", "GT3", "GT3", "GT3", 
                "GT3", "GT3", "GT3")

# Hacemos el dataframe con todos estos datos
carrera <- data.frame(Nombre=nombres,Marca=marcas,Modelo=modelos,
                      Categoria=categorias,"Posicion_Final"=posiciones)

# Ahora probemos a ordenarlos de diferentes formas
# Empecemos por los nombres
ord_nombres <- carrera[order(nombres),]
ord_nombres

# Por marcas
ord_marcas <- carrera[order(marcas),]
ord_marcas

# Por modelos
ord_modelos <- carrera[order(modelos),]
ord_modelos

# Por categoria (solo hay una, pero si hubieran mas seria mas util)
ord_categorias <- carrera[order(categorias),]
ord_categorias

# Por posicion final (que en si es el mas util para saber el orden final)
ord_pos_final <- carrera[order(posiciones),]
ord_pos_final
