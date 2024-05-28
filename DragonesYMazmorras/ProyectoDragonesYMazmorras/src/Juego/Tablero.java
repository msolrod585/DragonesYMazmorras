package Juego;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/*
 * 
 */
public class Tablero {
	public static final String RESET = "\033[0m";
	public static final String RED = "\033[0;31m";
	public static final String GREEN = "\033[0;32m";
	public static final String YELLOW = "\033[0;33m";
	public static final String BLUE = "\033[0;34m";

	public static void main(String[] args) {

		List<Raza> razasDisponibles = new ArrayList<>();

		Raza raza1 = new Raza("Elfo", 100, 30, "Élfico", true, "Mediano");
		Raza raza2 =new Raza("Enano", 150, 20, "Enánico", false, "Pequeño");
		Raza raza3 = (new Raza("Humano", 80, 40, "Común", false, "Mediano"));
		Raza raza4 =(new Raza("Orco", 60, 35, "Orco", false, "Grande"));
		Raza raza5 =(new Raza("Hada", 200, 25, "Feérico", true, "Pequeño"));
		Raza raza6 =(new Raza("Gnomo", 120, 20, "Gnómico", false, "Pequeño"));
		Raza raza7 =(new Raza("Troll", 40, 25, "Trol", false, "Grande"));
		Raza raza8 =(new Raza("Dragón", 1000, 50, "Dragónico", true, "Enorme"));
		Raza raza9 =(new Raza("Naga", 300, 40, "Nagático", true, "Grande"));
		Raza raza10 =(new Raza("Elfo Oscuro", 120, 35, "Élfico Oscuro", true, "Mediano"));

		List<Armas> armas = new ArrayList<>();

		Armas arma1 = new Armas("Espada", 10, 100, 50);
		Armas arma2 = new Armas("Arco", 5, 80, 30);
		Armas arma3 = new Armas("Daga", 3, 50, 20);
		Armas arma4 = new Armas("Hacha", 12, 120, 60);
		Armas arma5 = new Armas("Martillo", 15, 150, 70);
		Armas arma6 = new Armas("Maza", 14, 140, 65);
		Armas arma7 = new Armas("Ballesta", 8, 90, 40);
		Armas arma8 = new Armas("Espada Larga", 18, 180, 80);
		Armas arma9 = new Armas("Lanza", 10, 100, 55);
		Armas arma10 = new Armas("Báculo", 6, 70, 25);
		armas.add(arma10);
		armas.add(arma9);
		armas.add(arma8);
		armas.add(arma7);
		armas.add(arma6);
		armas.add(arma5);
		armas.add(arma4);
		armas.add(arma3);
		armas.add(arma2);
		armas.add(arma1);

		List<Clase> clasesDisponibles = new ArrayList<Clase>();
		clasesDisponibles.add(new Clase("Guerrero", "Tanking", false));
		clasesDisponibles.add(new Clase("Mago", "DPS", true));
		clasesDisponibles.add(new Clase("Sacerdote", "Soporte", true));
		clasesDisponibles.add(new Clase("Cazador", "DPS", false));
		clasesDisponibles.add(new Clase("Paladín", "Tanking", false));
		clasesDisponibles.add(new Clase("Ladrón", "DPS", false));
		clasesDisponibles.add(new Clase("Chamán", "Soporte", true));
		clasesDisponibles.add(new Clase("Brujo", "DPS", true));
		clasesDisponibles.add(new Clase("Caballero de la Muerte", "Tanking", false));
		clasesDisponibles.add(new Clase("Monje", "DPS", false));

		List<Jugable> personajesJugables = new ArrayList<>();

        Suministro suministro1 = new Suministro("Pan", 5, "Hierbas");
        Suministro suministro2 = new Suministro("Fruta", 3, "Piedras");
        Suministro suministro3 = new Suministro("Carne", 7, "Hongos");
        Suministro suministro4 = new Suministro("Pescado", 4, "Minerales");
        Suministro suministro5 = new Suministro("Vegetales", 6, "Raíces");

        List<Equipamiento> equiposDisponibles = new ArrayList<Equipamiento>();
       
        Equipamiento equipamiento1 = new Equipamiento("Mochila", 2, suministro1);
        Equipamiento equipamiento2 = new Equipamiento("Caja de herramientas", 8, suministro2);
        Equipamiento equipamiento3 = new Equipamiento("Botiquín", 4, suministro3);
        Equipamiento equipamiento4 = new Equipamiento("Mapa", 1, suministro4);
        Equipamiento equipamiento5 = new Equipamiento("Linterna", 3, suministro5);
        Equipamiento equipamiento6 = new Equipamiento("Martillo", 6, suministro1);
        Equipamiento equipamiento7 = new Equipamiento("Cuerda", 2, suministro2);
        Equipamiento equipamiento8 = new Equipamiento("Brujula", 1, suministro3);
        Equipamiento equipamiento9 = new Equipamiento("Botas", 4, suministro4);
        Equipamiento equipamiento10 = new Equipamiento("Cuchillo", 2, suministro5);
        equiposDisponibles.add(equipamiento10);
        equiposDisponibles.add(equipamiento9);
        equiposDisponibles.add(equipamiento8);
        equiposDisponibles.add(equipamiento7);
        equiposDisponibles.add(equipamiento6);
        equiposDisponibles.add(equipamiento5);
        equiposDisponibles.add(equipamiento4);
        equiposDisponibles.add(equipamiento3);
        equiposDisponibles.add(equipamiento2);
        equiposDisponibles.add(equipamiento1);
        
        
        List<NoJugable> enemigos = new ArrayList<>();
        enemigos.add(new NoJugable("Orco Guerrero", 8, raza1, arma1, new Atributo(), 101, false, "Fuego"));
        enemigos.add(new NoJugable("Elfo Arquero", 9, raza2, arma2, new Atributo(), 102, false, "Agua"));
        enemigos.add(new NoJugable("Goblin Ladrón", 7, raza3, arma3, new Atributo(), 103, false, "Tierra"));
        enemigos.add(new NoJugable("Enano Guerrero", 10, raza4, arma4, new Atributo(), 104, true, "Roca"));
        enemigos.add(new NoJugable("Trol Berserker", 12, raza5, arma5, new Atributo(), 105, true, "Ácido"));
        enemigos.add(new NoJugable("Hombre Bestia Salvaje", 15, raza6, arma6, new Atributo(), 106, true, "Rayos"));
        enemigos.add(new NoJugable("Gnomo Ingeniero", 10, raza7, arma7, new Atributo(), 107, false, "Magia"));
        enemigos.add(new NoJugable("No Muerto Caballero", 11, raza8, arma8, new Atributo(), 108, true, "Ninguna"));
        enemigos.add(new NoJugable("Dragón Anciano", 20, raza9, arma9, new Atributo(), 109, true, "Fuego"));
        enemigos.add(new NoJugable("Ogro Jefe", 14, raza10, arma10, new Atributo(), 110, true, "Hierro"));
        
        
		List<Jugable> Party = new ArrayList<>();


		List<Mazmorra> Mazmorras = new ArrayList<>();
		Mazmorra facil = new Mazmorra(3, "Fácil", 3);
		Mazmorra medio = new Mazmorra(4, "Medio", 8);
		Mazmorra dificil = new Mazmorra(5, "Dificil", 12);
		Mazmorra pesadilla = new Mazmorra(7, "Pesadilla", 20);

		Scanner sc = new Scanner(System.in);

		int option;
		do {
			System.out.println(BLUE + "--------------------------" + RESET);
			System.out.println(BLUE + "----- Menú Principal -----" + RESET);
			System.out.println(BLUE + "--------------------------" + RESET);
			System.out.println(GREEN + "1. Apartado Personajes:" + RESET);
			System.out.println(GREEN + "2. Apartado Información:" + RESET);
			System.out.println(GREEN + "3. Explora una Mazmorra:" + RESET);
			System.out.println(RED + "4. Salir" + RESET);
			System.out.print(YELLOW + "Seleccione una opción: " + RESET);

			option = sc.nextInt();
			switch (option) {
			case 1:
				System.out.println("Has seleccionado el Apartado Personajes.");
				menuPersonajes(personajesJugables, razasDisponibles, clasesDisponibles, armas, equiposDisponibles);

				break;
			case 2:
				System.out.println("Has seleccionado el Apartado Información.");
				menuInformacion(razasDisponibles,armas,clasesDisponibles);
				break;
			case 3:
				System.out.println("Has seleccionado Explora una Mazmorra.");
				break;
			case 4:
				System.out.println("Saliendo del menú...");
				break;
			default:
				System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
			}
		} while (option != 4);

		sc.close();

	}

	private static void menuPersonajes(List<Jugable> jugables, List<Raza> razas, List<Clase> clases, List<Armas> armas,
			List<Equipamiento> equipo) {
		Scanner sc = new Scanner(System.in);
		int option;
		do {
			printPersonajesMenu();
			option = sc.nextInt();
			sc.nextLine();

			switch (option) {
			case 1:
				crearPersonaje(jugables, razas, clases, armas, equipo);
				break;
			case 2:
				System.out.println(jugables.toString());
				break;
			case 3:
				modificarPersonaje(jugables, razas, clases, armas, equipo);
				break;
			case 4:
				borrarPersonaje(jugables);
				break;
			case 5:
				System.out.println("Volviendo al menú principal...");
				break;
			default:
				System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
			}
		} while (option != 5);
	}

	private static void printPersonajesMenu() {
		System.out.println("\n----- Menú de Personajes -----");
		System.out.println("1. Crear Personaje");
		System.out.println("2. Ver Personajes Creados");
		System.out.println("3. Editar Personaje");
		System.out.println("4. Borrar Personaje");
		System.out.println("5. Volver al Menú Principal");
		System.out.print("Seleccione una opción: ");
	}

	public static void crearPersonaje(List<Jugable> jugables, List<Raza> razas, List<Clase> clases, List<Armas> armas,
			List<Equipamiento> equipo) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nombre: ");
		String nombre = sc.nextLine();
		System.out.print("Nivel: ");
		int nivel = sc.nextInt();
		sc.nextLine();
		System.out.print("Raza: ");
		String raza = sc.nextLine();
		Raza razaElegida = razas.stream().filter(r -> r.getNombre().equals(raza)).findFirst().orElse(null);
		System.out.print("Arma: ");
		String arma = sc.nextLine();
		Armas armaElegida = armas.stream().filter(a -> a.getNombre().equals(arma)).findFirst().orElse(null);
		System.out.print("Nombre del Jugador: ");
		String nombreJugador = sc.nextLine();
		System.out.print("Clase: ");
		String clase = sc.nextLine();
		Clase claseElegida = clases.stream().filter(c -> c.getNombre().equals(clase)).findFirst().orElse(null);
		System.out.print("Equipamiento: ");
		String equipamiento = sc.nextLine();
		Equipamiento equipoElegido = equipo.stream().filter(e -> e.getNombre().equals(equipamiento)).findFirst()
				.orElse(null);
		System.out.print("Oro: ");
		int oro = sc.nextInt();
		sc.nextLine();
		Atributo atributos = new Atributo();
		Jugable personaje = new Jugable(nombre, nivel, razaElegida, armaElegida, atributos, nombreJugador, claseElegida,
				equipoElegido, oro);
		jugables.add(personaje);
		System.out.println("Personaje creado exitosamente.");
	}
	
	
	public static void modificarPersonaje(List<Jugable> jugables, List<Raza> razas, List<Clase> clases, List<Armas> armas,
            List<Equipamiento> equipo) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el nombre del personaje a modificar: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese el nombre del jugador del personaje a modificar: ");
        String nombreJugador = sc.nextLine();

        Jugable personajeAModificar = null;
        for (Jugable personaje : jugables) {
            if (personaje.getJugador().equals(nombreJugador) && personaje.getNombre().equals(nombre)) {
                personajeAModificar = personaje;
                break;
            }
        }

        if (personajeAModificar != null) {
            System.out.println("Personaje encontrado: " + personajeAModificar);
            System.out.println("Ingrese los nuevos valores:");
            System.out.print("Nombre: ");
            String nuevoNombre = sc.nextLine();
            if (!nuevoNombre.isEmpty()) {
                personajeAModificar.setNombre(nuevoNombre);
            }
            System.out.print("Nivel: ");
            String nuevoNivel = sc.nextLine();
            if (!nuevoNivel.isEmpty()) {
                personajeAModificar.setNivel(Integer.parseInt(nuevoNivel));
            }
            System.out.print("Clase: ");
            String nuevaClase = sc.nextLine();
            if (!nuevaClase.isEmpty()) {
                personajeAModificar.setNivel(Integer.parseInt(nuevoNivel));
            }
            System.out.print("Raza: ");
            String nuevaRaza = sc.nextLine();
            if (!nuevaRaza.isEmpty()) {
                personajeAModificar.setNivel(Integer.parseInt(nuevoNivel));
            }
            System.out.print("Arma: ");
            String nuevaArma = sc.nextLine();
            if (!nuevoNivel.isEmpty()) {
                personajeAModificar.setNivel(Integer.parseInt(nuevoNivel));
            }
            System.out.print("Equipo: ");
            String nuevoEquipo = sc.nextLine();
            if (!nuevoNivel.isEmpty()) {
                personajeAModificar.setNivel(Integer.parseInt(nuevoNivel));
            }
           
            System.out.println("Personaje modificado exitosamente.");
        } else {
            System.out.println("No se encontró ningún personaje con los datos proporcionados.");
        }
    }
	
	


	private static void menuInformacion(List<Raza> razas, List<Armas> armas, List<Equipamiento> equipos, List<Clase> clases, List<NoJugable> enemigos) {
		Scanner sc = new Scanner(System.in);
		int option;
		do {
			printInformacionMenu();
			option = sc.nextInt();
			sc.nextLine();

			switch (option) {
			case 1:
				System.out.println(razas.toString());
				break;
			case 2:
				System.out.println(clases.toString());
				break;
			case 3:
				System.out.println(armas.toString());
				break;
			case 4:
				System.out.println(equipos.toString());
				break;
			case 5:
				System.out.println(enemigos.toString());
				break;
			case 6:
				System.out.println("Volviendo al menú principal...");
				break;
			default:
				System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
			}
		} while (option != 6);
	}

	private static void printInformacionMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\n----- Menú de Información -----");
		System.out.println("1. Ver Razas");
		System.out.println("2. Ver Clases");
		System.out.println("3. Ver Armas");
		System.out.println("4. Ver Equipamientos");
		System.out.println("5. Ver Enemigos");
		System.out.println("6. Volver al Menú Principal");
		System.out.print("Seleccione una opción: ");
	}

	 public static void borrarPersonaje(List<Jugable> jugables) {
	        Scanner sc = new Scanner(System.in);
	        System.out.print("Ingrese el nombre del personaje a borrar: ");
	        String nombre = sc.nextLine();
	        System.out.print("Ingrese el nombre del jugador del personaje a borrar: ");
	        String nombreJugador = sc.nextLine();

	        Jugable personajeABorrar = null;
	        for (Jugable personaje : jugables) {
	            if (personaje.getJugador().equals(nombreJugador) && personaje.getNombre().equals(nombre)) {
	                personajeABorrar = personaje;
	                break;
	            }
	        }

	        if (personajeABorrar != null) {
	            jugables.remove(personajeABorrar);
	            System.out.println("El personaje '" + personajeABorrar.getNombre() + "' borrado exitosamente.");
	        } else {
	            System.out.println("No se encontró ningún personaje con los datos proporcionados.");
	        }
	    }

	








	
	
	private static void printMazmorraMenu() {
        System.out.println("\n----- Menú de Mazmorra -----");
        System.out.println("1. Fácil (Nivel mínimo: 3)");
        System.out.println("2. Media (Nivel mínimo: 8)");
        System.out.println("3. Difícil (Nivel mínimo: 12)");
        System.out.println("4. Experto (Nivel mínimo: 20)");
        System.out.println("5. Volver al Menú Principal");
        System.out.print("Seleccione una opción: ");
    }


    String dificultad;

    List<Jugable> party = new ArrayList<Jugable>();

    public Boolean nivelSificiente(List<Jugable> party, String dificultad) {
        Integer minNivel = party.stream().min(Comparator.comparing(Jugable::getNivel)).get().getNivel();
        Boolean nivelSuficiente = false;
        if (dificultad == "Fácil" && minNivel >= 3) {
            nivelSuficiente = true;
        } else if (dificultad == "Media" && minNivel >= 8) {
            nivelSuficiente = true;
        } else if (dificultad == "Difícil" && minNivel >= 12) {
            nivelSuficiente = true;
        } else if (dificultad == "Experto" && minNivel >= 20) {
            nivelSuficiente = true;
        }
        return nivelSuficiente;
    }


}