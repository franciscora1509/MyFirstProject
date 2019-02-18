package empresa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Util {
	
	static String introducirCadena() {
		String cadena="";
		InputStreamReader entrada =new InputStreamReader(System.in);
		BufferedReader teclado= new BufferedReader(entrada);
		try {
			cadena=teclado.readLine();
		}
		catch(IOException e) {
			System.out.println("Error al introducir datos");
		}
		return cadena;
	}
	
	static String introducirCadena(String mensaje) {
		String cadena="";
		System.out.println(mensaje);
		InputStreamReader entrada =new InputStreamReader(System.in);
		BufferedReader teclado= new BufferedReader(entrada);
		try {
			cadena=teclado.readLine();
		}
		catch(IOException e) {
			System.out.println("Error al introducir datos");
		}
		return cadena;
	}
	
	public static int leerInt(String mensaje) {
		int numero = 0;
		boolean error;
		System.out.println(mensaje);
		do {
			error=false;
			try {
				numero=Integer.parseInt(introducirCadena());	
			}
			catch(NumberFormatException e) {
				System.out.println("Error, el dato no es numérico. Introduce de nuevo: ");
				error=true;
			}
		}while(error);
		return numero;
	}
	
	public static int leerInt(String mensaje, int x, int y) {
		int numero=x;
		boolean error;
		System.out.println(mensaje);
		do {
			error=false;
			try {
				numero=Integer.parseInt(introducirCadena());	
			}
			catch(NumberFormatException e) {
				System.out.println("Error, el dato no es numérico. Introduce de nuevo: ");
				error=true;
			}
			if (numero<x || numero>y) {
				System.out.println("Error, dato fuera de rango. Introduce de nuevo: ");
				error=true;
			}
		}while(error);
		return numero;
	}
	
	public static float leerFloat(String mensaje) {
		float numero = 0;
		boolean error;
		System.out.println(mensaje);
		do {
			error=false;
			try {
				numero=Float.parseFloat(introducirCadena());
			}
			catch(NumberFormatException e) {
				System.out.println("Error, el dato no es numérico. Introduce de nuevo: ");
				error=true;
			}
		}while(error);
		return numero;
	}
	
	public static float leerFloat(String mensaje, float x, float y) {
		float numero=x;
		boolean error;
		System.out.println(mensaje);
		do {
			error=false;
			try {
				numero=Float.parseFloat(introducirCadena());	
			}
			catch(NumberFormatException e) {
				System.out.println("Error, el dato no es numérico. Introduce de nuevo: ");
				error=true;
			}
			if (numero<x || numero>y) {
				System.out.println("Error, dato fuera de rango. Introduce de nuevo: ");
				error=true;
			}
		}while(error);
		return numero;
	}

	public static char leerChar() {
		String sLetra;
		char cLetra;
		boolean error;
		do {
			error = false;
			sLetra = introducirCadena();
			if (sLetra.length() != 1) {
				error = true;
				System.out.println("Introduce UNA letra");
			}
		} while (error);
		cLetra = sLetra.charAt(0);
		return cLetra;
	}
	
	static String leerDni() {
		char l23[] = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H',
				'L', 'C', 'K', 'E' };

		String sDni, sAux;
		char aDni[] = new char[8];

		int iNumDni = 0;

		boolean error;
		do {
			do {
				do {
					do {
						System.out.println("Introduce tu DNI/NIE");
						sDni = introducirCadena();
						sDni = sDni.toUpperCase();
						if (sDni.length() < 9 | sDni.length() > 9)
							System.out.println("Error, tienes que introducir 9 caracteres");
					} while (sDni.length() < 9 | sDni.length() > 9);
					if (sDni.charAt(0) != 'X' & sDni.charAt(0) != 'Y' & sDni.charAt(0) != 'Z'
							& !(sDni.charAt(8) > 'A' & sDni.charAt(8) < 'Z')) {
						System.out.println("Dato inválido");
					}
					;
				} while (sDni.charAt(0) != 'X' & sDni.charAt(0) != 'Y' & sDni.charAt(0) != 'Z' & !(Character.isAlphabetic(sDni.charAt(8))));

				for (int i = 0; i < (aDni.length); i++) {
					aDni[i] = sDni.charAt(i);
				};
				System.out.println();

				if (aDni[0] == 'X') {
					aDni[0] = '0';
				} else if (aDni[0] == 'Y') {
					aDni[0] = '1';
				} else if (aDni[0] == 'Z') {
					aDni[0] = '2';
				}
				;

				sAux = String.copyValueOf(aDni);
				try {
					error = false;
					iNumDni = Integer.parseInt(sAux);
				} catch (NumberFormatException e) {
					error = true;
					System.out.println("hay que introducir números");
				}
			} while (error);

			if (sDni.charAt(8) != l23[(iNumDni % 23)])
				System.out.println("La letra introducida es incorrecta");

		} while (sDni.charAt(8) != l23[(iNumDni % 23)]);

		return sDni;
	}
	
	static boolean introducirBoolean() {
		String sCadena;
		boolean bCheck = false;
		do {
			sCadena = introducirCadena();
			if (!(sCadena.equalsIgnoreCase("s")) & !(sCadena.equalsIgnoreCase("n")) & !(sCadena.equalsIgnoreCase("si"))
					& !(sCadena.equalsIgnoreCase("no")) & !(sCadena.equalsIgnoreCase("true"))
					& !(sCadena.equalsIgnoreCase("false")) & !(sCadena.equalsIgnoreCase("1"))
					& !(sCadena.equalsIgnoreCase("0"))) {
				System.out.println("Error. Dato inválido");
			}
		} while (!(sCadena.equalsIgnoreCase("s")) & !(sCadena.equalsIgnoreCase("n")) & !(sCadena.equalsIgnoreCase("si"))
				& !(sCadena.equalsIgnoreCase("no")) & !(sCadena.equalsIgnoreCase("true"))
				& !(sCadena.equalsIgnoreCase("false")) & !(sCadena.equalsIgnoreCase("1"))
				& !(sCadena.equalsIgnoreCase("0")));
		if (sCadena.equalsIgnoreCase("s") | sCadena.equalsIgnoreCase("si") | sCadena.equalsIgnoreCase("true")
				| sCadena.equalsIgnoreCase("1"))
			bCheck = true;
		return bCheck;
	}
	
	public static LocalDate introducirFecha(String mensaje) {
		String fechaAux;
		LocalDate fechaNac = LocalDate.now();
		boolean error;
		DateTimeFormatter formateador=DateTimeFormatter.ofPattern("dd/MM/yyyy");
		do{
		  error=false;
		  System.out.println(mensaje);
		  fechaAux=Util.introducirCadena();
		  try{		
		   	fechaNac=LocalDate.parse(fechaAux, formateador);
		  } catch(DateTimeParseException e){
		   	error=true;
			System.out.println("Error,Introduce fecha con formato dd/mm/aaaa: ");
		  }
		}while (error);
		return fechaNac;
		}
}

