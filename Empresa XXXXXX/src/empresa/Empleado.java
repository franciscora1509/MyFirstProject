package empresa;
//Fran

import java.time.LocalDate;
import java.time.Period;

public class Empleado {
	private String nombre;
	private String apellido;
	private String dni;
	private LocalDate fechaNac;
	private LocalDate fechaAlta;
	private int numSorteo;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public LocalDate getFechaNac() {
		return fechaNac;
	}
	public void setFechaNac(LocalDate fechaNac) {
		this.fechaNac = fechaNac;
	}
	public LocalDate getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	public int getNumSorteo() {
		return numSorteo;
	}
	public void setNumSorteo(int numSorteo) {
		this.numSorteo = numSorteo;
	}
	public Empleado() {
		super();
	}
	
	public int getEdadAnios() {
		Period pEdad=Period.between(fechaNac,LocalDate.now());
		int iEdad=pEdad.getYears();
		return iEdad;
	}
	
	public void setDatos(){
		dni=Util.introducirCadena("Introduce DNI:");
		nombre=Util.introducirCadena("Introduce el nombre:");
		apellido=Util.introducirCadena("Introduce apellido:");
		fechaNac=Util.introducirFecha("Introduce fecha de nacimiento dd/mm/aaaa");
		int op=Util.leerInt("Fecha Alta: Hoy(0) - Introducir a mano(1)", 0, 1);
		if (op==0)
			fechaAlta=LocalDate.now();
		else
			fechaAlta=Util.introducirFecha("Introduce la fecha de alta con formato dd/mm/aaaa");
		numSorteo=(int) (Math.random()*99+1);
		}
	
	public void setDatosPorDni(){
		nombre=Util.introducirCadena("Introduce el nombre:");
		apellido=Util.introducirCadena("Introduce apellido:");
		fechaNac=Util.introducirFecha("Introduce fecha de nacimiento dd/mm/aaaa");
		int op=Util.leerInt("Fecha Alta: Hoy(0) - Introducir a mano(1)", 0, 1);
		if (op==0)
			fechaAlta=LocalDate.now();
		else
			fechaAlta=Util.introducirFecha("Introduce la fecha de alta con formato dd/mm/aaaa");
		}
	
	public Empleado(String nombre, String apellido, String dni, LocalDate fechaNac, LocalDate fechaAlta,
			int numSorteo) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.fechaNac = fechaNac;
		this.fechaAlta = fechaAlta;
		this.numSorteo = numSorteo;
	}
	
	public void getDatos() {
		System.out.println(nombre+" "+apellido+" con DNI "+dni+" y "+getEdadAnios()+" años de edad, entró en la empresa el año "+fechaAlta.getYear());
	}
	
	
}
