package Dominio;

public class Empleados {
	
	private String Nombre;//Esta sera la llave del HashMap
	private float sueldo;
	private char sexo;
	
	public Empleados(String nombre, float sueldo, char sexo) {
		Nombre = nombre;
		this.sueldo = sueldo;
		this.sexo = sexo;
	}
	@Override
	public String toString() {
		return "Empleados [Nombre=" + Nombre + ", sueldo=" + sueldo + ", sexo=" + sexo + "]\n";
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public float getSueldo() {
		return sueldo;
	}
	public void setSueldo(float sueldo) {
		this.sueldo = sueldo;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	

}
