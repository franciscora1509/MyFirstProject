package empresa;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Main_Empresa {

	public static void main(String[] args) {
		int opc;
		ArrayList<Empleado>empleados=new ArrayList<Empleado>();
		do {
			opc=menu();
			
			switch (opc) {
			case 1:
				alta(empleados);
				break;
			case 2:
				listado(empleados);
				break;
			case 3:
				listadoOrdenadoApellido(empleados);
				break;
			case 4:
				modificar(empleados);
				break;
			case 5:
				borrar(empleados);
				break;
			case 6:
				listadoPorEdad(empleados);
				break;
			case 7:
				ListadoEdadAlta(empleados);
				break;
			case 8:
				ListadoOrdenadoPorAntiguedad(empleados);
				break;
			case 9:
				sorteo(empleados);
				break;
			case 10:
				estadisticas(empleados);
				break;
			}
			
		}while(opc!=11);
	}

	private static int menu() {
		System.out.println("********* M E N U**********");
		int op=Util.leerInt("1. Introducir empleado\r\n" + 
				"2. Listado de empleados\r\n" + 
				"3. Listado de empleados ordenados por apellido\r\n" + 
				"4. Consultar/Modificar datos del empleado a partir del DNI\r\n" + 
				"5. Borrado de empleado a partir de DNI\r\n" + 
				"6. Listado de la edad de los empleados indicando el más joven y el más mayor\r\n" + 
				"7. Listado de la edad de los empleados en el momento en el que\r\n" + 
				"   entraron a la empresa\r\n" + 
				"8. Listado ordenado en descendente de la antigüedad de los empleados\r\n" + 
				"9. Sorteo diario (se sortea hasta que hay ganador)\r\n" + 
				"10. Estadísticas:\r\n" + 
				"11. Salir",1,11);
		return op;
	}

	private static void alta(ArrayList<Empleado> empleados) {
		Empleado aux=new Empleado();
		aux.setDatos();
		empleados.add(aux);		
	}

	private static void listado(ArrayList<Empleado> empleados) {
		System.out.println("*****L I S T A D O*****");
		for (Empleado emple:empleados) {
			emple.getDatos();
		}
	}

	private static void listadoOrdenadoApellido(ArrayList<Empleado> empleados) {
		for (int i=0;i<empleados.size();i++) {
			for (int j=i+1;j<empleados.size();j++) {
				if(empleados.get(i).getApellido().compareToIgnoreCase(empleados.get(j).getApellido())>0) {
					Empleado aux=empleados.get(i);
					empleados.set(i, empleados.get(j));
					empleados.set(j, aux);
				}
			}
		}
		listado(empleados);
	}

	private static void modificar(ArrayList<Empleado> empleados) {
		int esta;
		String wDni=Util.introducirCadena("Introduzca un dni a modificar:");
		esta=comprobarDniI(wDni,empleados);
		if (esta!=-1) {
			empleados.get(esta).getDatos();
				int opc=Util.leerInt("Está seguro que quiere modificar los datos del empleado (1)SI - (0)NO?", 0, 1);
				if (opc==0) {
					System.out.println("Modificación anulada.");	
				}else {
					empleados.get(esta).setDatosPorDni();
				}	
		}
		else
			System.out.println("El DNI introducido no está en la base de datos.");
	}
	

	private static boolean comprobarDni(String wDni, ArrayList<Empleado> empleados) {
		boolean esta=false;
		for (Empleado emple:empleados) {
			if (emple.getDni().equals(wDni)) {
				esta=true;
				break;
			}
			
		}
		return esta;
	}
	
	private static int comprobarDniI(String wDni, ArrayList<Empleado> empleados) {
		int esta=-1;
		for (Empleado emple:empleados) {
			if (emple.getDni().equals(wDni)) {
				esta=empleados.indexOf(emple);
				break;
			}
			
		}
		return esta;
	}

	private static void borrar(ArrayList<Empleado> empleados) {
		String wDni=Util.introducirCadena("Introduzca DNI a borrar:");
		boolean esta=comprobarDni(wDni,empleados);
		if (esta) {
			for(Empleado emple:empleados) {
				
				if(emple.getDni().equals(wDni)) {
					emple.getDatos();
					int opc=Util.leerInt("Está seguro que quiere Borrar el empleado (1)SI - (0)NO?", 0, 1);
					if (opc==1) {
						//empleados.remove(cont);
						empleados.remove(emple);
						break;
					}else
						System.out.println("Operación de borrado cancelada.");
				}
			}
		}else
			System.out.println("El DNI introducido no está en la base de datos.");
		
	}

	private static void listadoPorEdad(ArrayList<Empleado> empleados) {
		int maxi=Integer.MIN_VALUE;
		int mini=Integer.MAX_VALUE;
		System.out.println("*********LISTADO POR EDAD**********");
		for (int i=0;i<empleados.size();i++) {
				if(empleados.get(i).getEdadAnios()<mini) {
					mini=empleados.get(i).getEdadAnios();
				}
				if(empleados.get(i).getEdadAnios()>maxi) {
					maxi=empleados.get(i).getEdadAnios();		
			}
			empleados.get(i).getDatos();
		}
		for (Empleado emple:empleados) {
			if (emple.getEdadAnios()==maxi)
				System.out.println(emple.getNombre()+" "+emple.getApellido()+" es el MAYOR de la empresa con "+emple.getEdadAnios()+" años.");
			if (emple.getEdadAnios()==mini)
				System.out.println(emple.getNombre()+" "+emple.getApellido()+" es el MENOR de la empresa con "+emple.getEdadAnios()+" años.");
		}
		
	}
		

	private static void ListadoEdadAlta(ArrayList<Empleado> empleados) {
		Period edadAlta;
		System.out.println("*****L I S T A D O*****");
		for(int i=0;i<empleados.size();i++) {
			edadAlta=Period.between(empleados.get(i).getFechaNac(), empleados.get(i).getFechaAlta());
			System.out.println(empleados.get(i).getNombre()+" "+empleados.get(i).getApellido()+" tenía "+edadAlta.getYears()+"años cuando entró en la empresa.");
		}
		
	}

	private static void ListadoOrdenadoPorAntiguedad(ArrayList<Empleado> empleados) {
		Period edadAltaI;
		Period edadAltaJ;
		for (int i=0;i<empleados.size();i++) {
			edadAltaI=Period.between(empleados.get(i).getFechaNac(), empleados.get(i).getFechaAlta());
			for (int j=i+1;j<empleados.size();j++) {
				edadAltaJ=Period.between(empleados.get(j).getFechaNac(), empleados.get(j).getFechaAlta());
				if(edadAltaI.getYears()>edadAltaJ.getYears()) {
					Empleado aux=empleados.get(i);
					empleados.set(i, empleados.get(j));
					empleados.set(j, aux);
				}
			}
		}
		listado(empleados);
		
	}

	private static void sorteo(ArrayList<Empleado> empleados) {
		int numGanador;
		boolean win=false;
		DateTimeFormatter formateador=DateTimeFormatter.ofPattern("dd/MM/yyyy");
		do {
			numGanador=(int) (Math.random()*99+1);
			for(Empleado e:empleados) {
				if(e.getNumSorteo()==numGanador) {
					win=true;
					System.out.println("El ganador de "+LocalDate.now().format(formateador)+"es:\r\n"+
										"Dni: "+e.getDni()+" Nombre: "+e.getNombre()+" "+e.getApellido()+" con el número: "+e.getNumSorteo()+".");
				}
			}
		}while(!win);
		
	}

	private static void estadisticas(ArrayList<Empleado> empleados) {
		int opc=Util.leerInt("**********E S T A D I S T I C A S**********\r\n1"
					+".- Cumpleaños del mes:\n2.- Por nombre:",1,2);
		if(opc==1) {
			opc=Util.leerInt("1.- Enero\r\n"
					+ "2.- Febrero\r\n"
					+ "3.- Marzo\r\n"
					+ "4.- Abril\r\n"
					+ "5.- Mayo\r\n"
					+ "6.- Junio\r\n"
					+ "7.- Julio\r\n"
					+ "8.- Agosto\r\n"
					+ "9.- Septimbre\r\n"
					+ "10.- Octubre\r\n"
					+ "11.- Noviembre\r\n"
					+ "12.- Diciembre",1,12);
			String opcChar=String.valueOf(opc);

			for(int i=0;i<empleados.size();i++) {
				for(int j=i+1;j<empleados.size();j++) {
					if(empleados.get(i).getFechaNac().isAfter(empleados.get(i).getFechaNac()) ) {
						Empleado aux=empleados.get(i);
						empleados.set(i, empleados.get(j));
						empleados.set(j, aux);
					}
				}
			}
		
			LocalDate mes=LocalDate.parse(opcChar, DateTimeFormatter.ofPattern("MM"));
			for(Empleado e:empleados) {
				if(e.getFechaNac().getMonth().equals(mes))
					System.out.println(e.getNombre()+" "+e.getApellido()+" "+e.getFechaNac().format(DateTimeFormatter.ofPattern("dd")));
			}

		}else {
			ArrayList <Nombre> nombres=new ArrayList <Nombre>();
			Nombre aux;
			boolean esta=false;
			for (int i=0;i<empleados.size();i++) {
				esta=false;
				for(int j=0;j<nombres.size();j++) {
					if(empleados.get(i).getNombre().equalsIgnoreCase(nombres.get(j).getNombre())) {
						esta=true;
						nombres.get(j).setVeces(nombres.get(j).getVeces()+1);
						break;
					}
				}
				if(!esta) {
					aux=new Nombre();
					aux.setNombre(empleados.get(i).getNombre());
					aux.setVeces(1);
					nombres.add(aux);
				}
			}
			for (int i=0;i<nombres.size();i++) {
				for(int j=i+1;j<nombres.size();j++) {
					if(nombres.get(i).getVeces()>nombres.get(j).getVeces()) {
						aux=nombres.get(i);
						nombres.set(i, nombres.get(j));
						nombres.set(j, aux);
					}
				}
			nombres.get(i).getDatos();
			}
		}
	}
}
