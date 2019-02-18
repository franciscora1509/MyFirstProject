package empresa;

public class Nombre {
	private String nombre;
	private int veces;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getVeces() {
		return veces;
	}
	public void setVeces(int veces) {
		this.veces = veces;
	}
	public Nombre() {
		super();
	}
	public void getDatos() {
		System.out.println(nombre+": "+veces+"veces.");
	}
	
}
