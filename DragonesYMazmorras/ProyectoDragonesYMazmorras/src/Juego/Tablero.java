package Juego;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/*
 * El tablero es nuestro lugar de juego
 */
public class Tablero {
	/*
	 * Estas variables sirven para el color
	 */
	public static final String RESET = "\033[0m";
	public static final String RED = "\033[0;31m";
	public static final String GREEN = "\033[0;32m";
	public static final String YELLOW = "\033[0;33m";
	public static final String BLUE = "\033[0;34m";

	public static void main(String[] args) {
		
		List<Raza> razasDisponibles = new ArrayList<>();

		Raza raza1 = new Raza("Elfo", 100, 30, "Élfico", true, "Mediano");
		Raza raza2 = new Raza("Enano", 150, 20, "Enánico", false, "Pequeño");
		Raza raza3 = (new Raza("Humano", 80, 40, "Común", false, "Mediano"));
		Raza raza4 = (new Raza("Orco", 60, 35, "Orco", false, "Grande"));
		Raza raza5 = (new Raza("Hada", 200, 25, "Feérico", true, "Pequeño"));
		Raza raza6 = (new Raza("Gnomo", 120, 20, "Gnómico", false, "Pequeño"));
		Raza raza7 = (new Raza("Troll", 40, 25, "Trol", false, "Grande"));
		Raza raza8 = (new Raza("Dragón", 1000, 50, "Dragónico", true, "Enorme"));
		Raza raza9 = (new Raza("Naga", 300, 40, "Nagático", true, "Grande"));
		Raza raza10 = (new Raza("Elfo Oscuro", 120, 35, "Élfico Oscuro", true, "Mediano"));

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

		List<NoJugable> enemigos = new ArrayList<>();
		enemigos.add(new NoJugable("Orco Guerrero", 8, raza1, arma1, new Atributo(), false, "Fuego"));
		enemigos.add(new NoJugable("Elfo Arquero", 9, raza2, arma2, new Atributo(), false, "Agua"));
		enemigos.add(new NoJugable("Goblin Ladrón", 7, raza3, arma3, new Atributo(), false, "Tierra"));
		enemigos.add(new NoJugable("Enano Guerrero", 10, raza4, arma4, new Atributo(), true, "Roca"));
		enemigos.add(new NoJugable("Trol Berserker", 12, raza5, arma5, new Atributo(), true, "Acido"));
		enemigos.add(new NoJugable("Hombre Bestia Salvaje", 15, raza6, arma6, new Atributo(), true, "Rayos"));
		enemigos.add(new NoJugable("Gnomo Ingeniero", 10, raza7, arma7, new Atributo(), false, "Magia"));
		enemigos.add(new NoJugable("No Muerto Caballero", 11, raza8, arma8, new Atributo(), true, "Ninguna"));
		enemigos.add(new NoJugable("Dragón Anciano", 20, raza9, arma9, new Atributo(), true, "Fuego"));
		enemigos.add(new NoJugable("Ogro Jefe", 14, raza10, arma10, new Atributo(), true, "Hierro"));

		List<Jugable> Party = new ArrayList<>();
		List<Combate> desafioFacil = new ArrayList<>();
		List<Combate> desafioMedio = new ArrayList<>();
		List<Combate> desafioDificil = new ArrayList<>();
		List<Combate> desafioPesadilla = new ArrayList<>();

		List<Mazmorra> Mazmorras = new ArrayList<>();
		Mazmorra facil = new Mazmorra(3, "Fácil", desafioFacil, 3);
		Mazmorra medio = new Mazmorra(4, "Medio", desafioMedio, 8);
		Mazmorra dificil = new Mazmorra(5, "Dificil", desafioDificil, 12);
		Mazmorra pesadilla = new Mazmorra(7, "Pesadilla", desafioPesadilla, 20);

		Scanner sc = new Scanner(System.in);
		
		int option;
		/*
		 * Este bucle do-while incia el menú principal donde veremos las primeras opciones a elegir
		 */
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
			/*
			 * Es este switch tenemos la llamada a las funciones dependiendo de las opciones seleccionadas
			 */
			switch (option) {
			case 1:
				System.out.println("Has seleccionado el Apartado Personajes.");
				menuPersonajes(personajesJugables, razasDisponibles, clasesDisponibles, armas);
				break;
			case 2:
				System.out.println("Has seleccionado el Apartado Información.");
				menuInformacion(razasDisponibles, armas, clasesDisponibles, enemigos);
				break;
			case 3:
				System.out.println("Has seleccionado Explora una Mazmorra.");
				menuMazmorra(Party);
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

	/*
	 * Esta funcion se le pasan como parametros los arrays de datos que utilizaremos
	 */
	private static void menuPersonajes(List<Jugable> party, List<Raza> razas, List<Clase> clases, List<Armas> armas) {
		Scanner sc = new Scanner(System.in);
		int option;
		do {
			printPersonajesMenu();
			option = sc.nextInt();
			sc.nextLine();

			switch (option) {
			case 1:
				crearPersonaje(party, razas, clases, armas);
				break;
			case 2:
				System.out.println(party.toString());
				break;
			case 3:
				modificarPersonaje(party, razas, clases, armas);
				break;
			case 4:
				borrarPersonaje(party);
				break;
			case 5:
				System.out.println("Volviendo al menú principal...");
				break;
			default:
				System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
			}
		} while (option != 5);
	}

	/*
	 * Esta funcionlo que hace es printear el menu de personaje
	 */
	private static void printPersonajesMenu() {
		System.out.println("\n----- Menú de Personajes -----");
		System.out.println("1. Crear Personaje");
		System.out.println("2. Ver Personajes Creados");
		System.out.println("3. Editar Personaje");
		System.out.println("4. Borrar Personaje");
		System.out.println("5. Volver al Menú Principal");
		System.out.print("Seleccione una opción: ");
	}

	/*
	 * Esta funcion nos crea un personaje
	 */
	public static void crearPersonaje(List<Jugable> jugables, List<Raza> razas, List<Clase> clases, List<Armas> armas) {
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
		System.out.print("Oro: ");
		int oro = sc.nextInt();
		sc.nextLine();
		Atributo atributos = new Atributo();
		Jugable personaje = new Jugable(nombre, nivel, razaElegida, armaElegida, atributos, nombreJugador, claseElegida, oro);
		jugables.add(personaje);
		System.out.println("Personaje creado exitosamente.");
	}
	
	
	/*
	 * Esta funcion nos permite modificar un personaje
	 */

	public static void modificarPersonaje(List<Jugable> party, List<Raza> razas, List<Clase> clases,
			List<Armas> armas) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Ingrese el nombre del personaje a modificar: ");
		String nombre = sc.nextLine();
		System.out.print("Ingrese el nombre del jugador del personaje a modificar: ");
		String nombreJugador = sc.nextLine();
		Jugable personajeAModificar = null;
		for (Jugable personaje : party) {
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

	/*
	 * Esta funcion invoca las funciones y el menu de informacion
	 */
	private static void menuInformacion(List<Raza> razas, List<Armas> armas,
			List<Clase> clases, List<NoJugable> enemigos) {
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
				System.out.println(enemigos.toString());
				break;
			case 5:
				System.out.println("Volviendo al menú principal...");
				break;
			default:
				System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
			}
		} while (option != 5);
	}

	/*
	 * Esta funcion imprime el menu de informacion
	 */
	private static void printInformacionMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\n----- Menú de Información -----");
		System.out.println("1. Ver Razas");
		System.out.println("2. Ver Clases");
		System.out.println("3. Ver Armas");
		System.out.println("4. Ver Enemigos");
		System.out.println("5. Volver al Menú Principal");
		System.out.print("Seleccione una opción: ");
	}
	
	
	/*
	 * Esta funcion nos sirve para borrar un personaje
	 */

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

	/*
	 * Esta funcion imprime el menu de las mazmorras
	 */
	private static void printMazmorraMenu() {

		System.out.println("\n----- Menú de Mazmorra -----");
		System.out.println("1. Fácil (Nivel mínimo: 3)");
		System.out.println("2. Media (Nivel mínimo: 8)");
		System.out.println("3. Difícil (Nivel mínimo: 12)");
		System.out.println("4. Experto (Nivel mínimo: 20)");
		System.out.println("5. Volver al Menú Principal");
		System.out.print("Seleccione una opción: ");
	}
	/*
	 * Esta funcion booleana nos comprueba las condiciones para poder entrar a la mazmorra
	 */
	public static Boolean nivelSuficiente(List<Jugable> party, String dificultad) {
		Integer minNivel = party.stream().min(Comparator.comparing(Jugable::getNivel)).get().getNivel();
		Boolean nivelSuficiente = false;
		if (dificultad == "Facil" && minNivel >= 3) {
			nivelSuficiente = true;
		} else if (dificultad == "Media" && minNivel >= 8) {
			nivelSuficiente = true;
		} else if (dificultad == "Dificil" && minNivel >= 12) {
			nivelSuficiente = true;
		} else if (dificultad == "Pesadilla" && minNivel >= 20) {
			nivelSuficiente = true;
		}
		return nivelSuficiente;
	}

	
	/*
	 * Esta funcion nos plantea las mazmorras y opciones de dificultad
	 */
	private static void menuMazmorra(List<Jugable> party) {
		Scanner sc = new Scanner(System.in);
		int option;
		do {
			printMazmorraMenu();
			option = sc.nextInt();
			sc.nextLine();

			switch (option) {
			case 1:
				if (nivelSuficiente(party, "Facil") == true) {
					System.out.println("Nuestra party de aventureros se aproximan a la mazmorra");
					System.out.println("Una vez dentro, se encuentran una puerta con una cerradura bastante extraña");
					System.out.println("¿Quereís hacer una tirada para buscar la llave?");
					 char respuesta = sc.next().charAt(0);
				        if (respuesta == 'S' || respuesta == 's') {
				            System.out.println("Haciendo una tirada para buscar la llave...");
				            int tirada = tirada();
				            if(tirada == 1) {
				            	System.out.println(tirada);
				            	System.out.println("Tienes demasiada mala suerte y te tropiezas");
				            }else if(tirada > 2 && tirada < 10){
				            	System.out.println(tirada);
				            	System.out.println("No encuestras la llave pero te llevas una moneda de consolacion");
				            }else if(tirada > 11 && tirada < 19){
				            	System.out.println("Encontrais la llave y abrís la puerta exitosamente, salís corriendo pq hay un zombie");
				            }else if(tirada == 20) {
				            	System.out.println("Abrís la puerta y os haceis millonarios");
				            }
				        } else if (respuesta == 'N' || respuesta == 'n') {
				            System.out.println("Pues os quedais sin tesoro.");
				        } else {
				            System.out.println("Por favor, responde con 'S' o 'N'.");
		
				        }
				} else {
					System.out.println("El nivel no es suficiente para esta mazmorra");
				}
				break;
			case 2:
				if (nivelSuficiente(party, "Medio") == true) {
					System.out.println("Mazmorra en desarrollo...");
				} else {
					System.out.println("El nivel no es suficiente para esta mazmorra");
				}
				break;
			case 3:
				if (nivelSuficiente(party, "Dificil") == true) {
					System.out.println("Mazmorra en desarrollo...");
				} else {
					System.out.println("El nivel no es suficiente para esta mazmorra");
				}
				break;
			case 4:
				if (nivelSuficiente(party, "Pesadilla")) {
					System.out.println("Tras arduas batallas y mucho trabajo, llegais a la sala final...");
					System.out.println("Sobre la pila de oro, rubies y artefactos de gran valor, se encuentra un dragon anciano, protegiendo su botín");
					System.out.println("El dragón abre sus fauces y deja escapar una llamarada capaz de destruit una ciudad entera");
					System.out.println("¿Haceis una tirada para esquivarlo?");
					char respuesta = sc.next().charAt(0);
			        if (respuesta == 'S' || respuesta == 's') {
			            System.out.println("Haciendo una tirada para buscar la llave...");
			            int tirada = tirada();
			            if(tirada == 20) {
			            	System.out.println(tirada);
			            	System.out.println("Empuñando vuestro arma, haceis un triple mortal, con tirabuzon y musica epica de fondo(no sabeis de donde viene), aterrizais sobre el dragon y le cortais la cabeza.");
			            	System.out.println("Os quedais con todo su tesoro y el pueblo os proclama reyes y protectores del reino");
			            }else {
			            	System.out.println("Quedais calzinados por las llamas...");
			            }
			        } else if (respuesta == 'N' || respuesta == 'n') {
			            System.out.println("Pues os quedais sin tesoro.");
			        } else {
			            System.out.println("Por favor, responde con 'S' o 'N'.");
			        }
				} else {
					System.out.println("El nivel no es suficiente para esta mazmorra");
				}
				break;
			case 5:
				System.out.println("Volviendo al menú principal...");
				break;
			default:
				System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
			}
		} while (option != 5);
	}

	public static int tirada() {
        Random random = new Random();
        int dado = random.nextInt(21);
        return dado;
    }
}