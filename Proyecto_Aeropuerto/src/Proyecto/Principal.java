package Proyecto;

import java.util.Scanner;

public class Principal {
    static Scanner entrada = new Scanner(System.in);
    final static int num = 4; // Numero de aeropuertos
    static Aeropuerto aeropuertos[] = new Aeropuerto[num];
    
    public static void main(String[] args){
        
        
        insertarDatosAeropuertos(aeropuertos);
        menu();
    }
    
    public static void insertarDatosAeropuertos(Aeropuerto aero[]){
        aero[0] = new AeropuertoPublico(800000, "Simon Bolivar International Airport", "Caracas", "Venezuela");
        aero[0].insertarCompañia(new Compañia("Avior Airlines"));
        aero[0].insertarCompañia(new Compañia("Conviasa"));
        aero[0].getCompañia("Avior Airlines").insertarVuelo(new Vuelo("AI20", "Caracas", "Barcelona", 300.00, 150));
        aero[0].getCompañia("Avior Airlines").insertarVuelo(new Vuelo("AI21", "Caracas", "Valencia", 150.00, 100));
        aero[0].getCompañia("Conviasa").insertarVuelo(new Vuelo("CO11", "Caracas", "Maracaibo", 200.00, 85));
        aero[0].getCompañia("Avior Airlines").getVuelo("AI20").insertarPasajero(new Pasajero("Andres", "30662790", "Venezolano"));
        aero[0].getCompañia("Avior Airlines").getVuelo("AI20").insertarPasajero(new Pasajero("Nikol", "34227728", "Colombiana"));
        aero[0].getCompañia("Conviasa").getVuelo("CO11").insertarPasajero(new Pasajero("Ilan", "183829", "Venezolano"));
        aero[0].getCompañia("Conviasa").getVuelo("CO11").insertarPasajero(new Pasajero("Airton", "143659", "Venezolano"));
    
        aero[1] = new AeropuertoPublico(60000, "Arturo Michelena International Airport", "Valencia", "Venezuela");
        aero[1].insertarCompañia(new Compañia("Turpial Airlines"));
        aero[1].insertarCompañia(new Compañia("LASER"));
        aero[1].getCompañia("Turpial Airlines").insertarVuelo(new Vuelo("TU20", "Valencia", "Santo Domingo", 300.00, 150));
        aero[1].getCompañia("Turpial Airlines").insertarVuelo(new Vuelo("TU21", "Valencia", "San Paulo", 150.00, 100));
        aero[1].getCompañia("LASER").insertarVuelo(new Vuelo("LA11", "Valencia", "Maracaibo", 200.00, 85));
        aero[1].getCompañia("Turpial Airlines").getVuelo("TU20").insertarPasajero(new Pasajero("Marco", "2346456", "Ecuatoriano"));
        aero[1].getCompañia("Turpial Airlines").getVuelo("TU21").insertarPasajero(new Pasajero("Pepe", "4265376", "Mexicano"));
        aero[1].getCompañia("LASER").getVuelo("LA11").insertarPasajero(new Pasajero("Bruno", "183829", "Estadounidense"));
        
        aero[2] = new AeropuertoPublico(7000000, "Del Caribe Santiago Marino International Airport", "Porlamar", "Venezuela");
        aero[2].insertarCompañia(new Compañia("Aserca Airlines"));
        aero[2].insertarCompañia(new Compañia("Santa Barbara Airlines"));
        aero[2].getCompañia("Aserca Airlines").insertarVuelo(new Vuelo("AS20", "Porlamar", "Ciudad Juarez", 300.00, 150));
        aero[2].getCompañia("Aserca Airlines").insertarVuelo(new Vuelo("AS21", "Porlamar", "Madrid", 150.00, 100));
        aero[2].getCompañia("Santa Barbara Airlines").insertarVuelo(new Vuelo("SB11", "Porlamar", "Maracaibo", 200.00, 85));
        aero[2].getCompañia("Aserca Airlines").getVuelo("AS20").insertarPasajero(new Pasajero("Mr Danger", "246523", "Juarez"));
        aero[2].getCompañia("Aserca Airlines").getVuelo("AS21").insertarPasajero(new Pasajero("Juan", "2356436", "Español"));
        aero[2].getCompañia("Santa Barbara Airlines").getVuelo("SB11").insertarPasajero(new Pasajero("Ricardo", "352423", "Marroqui"));
        
        aero[3] = new AeropuertoPrivado("La Chinita International Airport", "Maracaibo", "Venezuela");
        aero[3].insertarCompañia(new Compañia("Venezolana"));
        aero[3].insertarCompañia(new Compañia("Avianca"));
        String empresas [] = {"Savoy", "Nestle"};
        ((AeropuertoPrivado)aero[3]).insertarEmpresas(empresas);
        aero[3].getCompañia("Venezolana").insertarVuelo(new Vuelo("VE20", "Maracaibo", "Caracas", 300.00, 150));
        aero[3].getCompañia("Venezolana").insertarVuelo(new Vuelo("VE21", "Maracaibo", "Merida", 150.00, 100));
        aero[3].getCompañia("Avianca").insertarVuelo(new Vuelo("AV11", "Maracaibo", "Rio Hacha", 200.00, 85));
        aero[3].getCompañia("Venezolana").getVuelo("VE20").insertarPasajero(new Pasajero("Luxia", "4235435", "Venezolana"));
        aero[3].getCompañia("Venezolana").getVuelo("VE21").insertarPasajero(new Pasajero("Mario", "762345675", "Italiano"));
        aero[3].getCompañia("Avianca").getVuelo("AV11").insertarPasajero(new Pasajero("Paco", "3465436", "Español"));
    }
    
    public static void menu(){
        String nombreAeropuerto, nombreCompañia, origen, destino;
        int opcion;
        Aeropuerto aeropuerto;
        Compañia compañia;
        
        do{
            System.out.println("\t.:MENU:.");
            System.out.println("1. Ver Aeropuertos gestionados (Publicos o Privados)");
            System.out.println("2. Ver empresas(Privado) o subvencion(Publicos)");
            System.out.println("3. Lista de companias de un aeropuerto");
            System.out.println("4. Lista de vuelos por compania");
            System.out.println("5. Listar posibles vuelos de Origen a Destino");
            System.out.println("6. Salir");
            System.out.print("Opcion: ");
            opcion = entrada.nextInt();
            
            switch(opcion){
                case 1: //Ver Aeropuertos gestionados (Públicos o Privados)
                    System.out.println("");
                    mostrarDatosAeropuertos(aeropuertos);
                    break;
                case 2: //Ver empresas(Privado) o subvención(Públicos)
                    System.out.println("");
                    mostrarPatrocinio(aeropuertos);
                    break;
                case 3: //Lista de compañías de un aeropuerto
                    entrada.nextLine();
                    System.out.print("\nDigite el nombre del Aeropuerto: ");
                    nombreAeropuerto = entrada.nextLine();
                    aeropuerto = buscarAeropuerto(nombreAeropuerto, aeropuertos);
                    if(aeropuerto==null){
                        System.out.println("El aeropuerto no existe\n");
                    }else{
                        mostrarCompañias(aeropuerto);
                        System.out.println("");
                    }
                    break;
                case 4: //Lista de vuelos por compañía
                    entrada.nextLine();
                    System.out.print("\nDigite el nombre del Aeropuerto: ");
                    nombreAeropuerto = entrada.nextLine();
                    aeropuerto = buscarAeropuerto(nombreAeropuerto, aeropuertos);
                    if(aeropuerto==null){
                        System.out.println("El aeropuerto no existe\n");
                    }else{
                        mostrarCompañias(aeropuerto);
                        System.out.print("Digite el nombre de la compania: ");
                        nombreCompañia = entrada.nextLine();
                        compañia = aeropuerto.getCompañia(nombreCompañia);
                        mostrarVuelos(compañia);
                    }
                    break;
                case 5: //Listar posibles vuelos de Origen a Destino
                    entrada.nextLine();
                    System.out.print("\nDigite la ciudad de Origen: ");
                    origen = entrada.nextLine();
                    System.out.print("\nDigite la ciudad de Destino: ");
                    destino = entrada.nextLine();
                    mostrarVueloOrigenDestino(origen, destino,aeropuertos);
                    break;
                case 6: //Salir
                    System.out.println("Programa Finalizado");
                    break; 
                default: System.out.println("Error se equivoco de opcion");
            }
                    
        }while(opcion!=6);
    }
    
    public static void mostrarDatosAeropuertos(Aeropuerto aeropuertos[]){
        for (int i = 0; i < aeropuertos.length; i++) {
            if(aeropuertos[i] instanceof AeropuertoPrivado){
                System.out.println("Aeropuerto Privado");
                System.out.println("Nombre: " + aeropuertos[i].getNombre());
                System.out.println("Ciudad: " + aeropuertos[i].getCiudad());
                System.out.println("Pais: " + aeropuertos[i].getPais());
            }else{
                System.out.println("Aeropuerto Publico");
                System.out.println("Nombre: " + aeropuertos[i].getNombre());
                System.out.println("Ciudad: " + aeropuertos[i].getCiudad());
                System.out.println("Pais: " + aeropuertos[i].getPais()); 
            }
            System.out.println("");
        }
    }
    
    public static void mostrarPatrocinio(Aeropuerto aeropuertos[]){
        String empresas[];
        for (int i = 0; i < aeropuertos.length; i++) {
            if(aeropuertos[i] instanceof AeropuertoPrivado){
                System.out.println("Aeropuerto Privado "+aeropuertos[i].getNombre());
                empresas = ((AeropuertoPrivado)aeropuertos[i]).getListaEmpresas();
                for (int j = 0; j < empresas.length; j++) {
                    System.out.println(empresas[j]);
                }
            }else{
                System.out.println("Aeropuerto Publico "+aeropuertos[i].getNombre());
                System.out.println("Subvencion: "+((AeropuertoPublico)aeropuertos[i]).getSubvencion());
            }
            System.out.println("");
        }
    }
    
    public static Aeropuerto buscarAeropuerto(String nombre, Aeropuerto aeropuertos[]){
        boolean encontrado = false;
        int i=0;
        Aeropuerto aero=null;
        while((!encontrado) && (i<aeropuertos.length)){
            if(nombre.equals(aeropuertos[i].getNombre())){
                encontrado = true;
                aero = aeropuertos[i];
            }
            i++;
        }
        return aero;
    }
    
    public static void mostrarCompañias(Aeropuerto aeropuerto){
        System.out.println("\nLas companias del aeropuerto: " +aeropuerto.getNombre());
        for (int i = 0; i < aeropuerto.getNumCompañia(); i++) {
            System.out.println(aeropuerto.getCompañia(i).getNombre());
        }
    }
    
    public static void mostrarVuelos(Compañia compañia){
        Vuelo vuelo;
        System.out.println("Los vuelos de la compania: " + compañia.getNombre());
        for (int i = 0; i < compañia.getNumVuelo(); i++) {
            vuelo = compañia.getVuelo(i);
            System.out.println("Identificador: "+vuelo.getIdentificador());
            System.out.println("Ciudad Origen: "+vuelo.getCiudadOrigen());
            System.out.println("Ciudad Destino: "+vuelo.getCiudadDestino());
            System.out.println("Precio: $"+vuelo.getPrecio());
            System.out.println("");
        }
    }
    
    public static Vuelo[] buscarVuelosOrigenDestino(String origen, String destino, Aeropuerto aeropuerto[]){
        Vuelo vuelo;
        int contador = 0;
        Vuelo listaVuelos[];
        
        for (int i = 0; i < aeropuertos.length; i++) { //Recorremos los aeropuertos
            for (int j = 0; j < aeropuertos[i].getNumCompañia(); j++) { //Recorremos las compañias
                for (int k = 0; k < aeropuertos[i].getCompañia(j).getNumVuelo(); k++) { //Recorremos los vuelos
                    vuelo = aeropuertos[i].getCompañia(j).getVuelo(k);
                    if ((origen.equals(vuelo.getCiudadOrigen())) && (destino.equals(vuelo.getCiudadDestino()))) {
                        contador++;
                    }
                }
            }
        }
        listaVuelos = new Vuelo[contador];
        int q=0;
        
        for (int i = 0; i < aeropuertos.length; i++) {
            for (int j = 0; j < aeropuertos[i].getNumCompañia(); j++) {
                for (int k = 0; k < aeropuertos[i].getCompañia(j).getNumVuelo(); k++) {
                    vuelo = aeropuertos[i].getCompañia(j).getVuelo(k);
                    if ((origen.equals(vuelo.getCiudadOrigen()) && (destino.equals(vuelo.getCiudadDestino())))) {
                        listaVuelos[q] = vuelo;
                        q++;
                    }
                }
            }
        }
        return listaVuelos; 
    }

    public static void mostrarVueloOrigenDestino(String origen, String destino, Aeropuerto aeropuertos[]){
        Vuelo vuelos[];
        vuelos = buscarVuelosOrigenDestino(origen,destino,aeropuertos);
        if (vuelos.length == 0) {
            System.out.println("No existen vuelos de esa ciudad origen a destino");
        } else {
            System.out.println("Vuelos encontrados: ");
            for (int i = 0; i < vuelos.length; i++) {
                System.out.println("Identificador: "+vuelos[i].getIdentificador());
                System.out.println("Ciudad Origen: "+vuelos[i].getCiudadOrigen());
                System.out.println("Ciudad Destino: "+vuelos[i].getCiudadDestino());
                System.out.println("Precio: "+vuelos[i].getPrecio());
            }
        }
    }
}
