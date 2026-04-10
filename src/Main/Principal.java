package Main;

import java.util.Scanner;

import Dominio.Empleados;
import LogicaMetodos.Implementacion;

public class Principal {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner lectura = null;
		
		
		
		String nombre;
		float sueldo;
		char sexo;
		int menuPrin;
		
		Empleados empleados;
		
		Implementacion imp = new Implementacion();
		
		do {
			System.out.println("Bienvendido");
			System.out.println("1--Alta");
			System.out.println("2--Mostrar");
			System.out.println("3--Buscar");
			System.out.println("4--Editar sueldo por nombre");
			System.out.println("5--Eliminar");
			System.out.println("6--Salir");
			
			lectura = new Scanner(System.in);
			menuPrin = lectura.nextInt();
			
			switch (menuPrin) {
			case 1:
				try {
					System.out.println("Ingresa el nombre");
					lectura = new Scanner(System.in);
					nombre = lectura.nextLine();
					
					System.out.println("Ingresa el sueldo");
					lectura = new Scanner(System.in);
					sueldo = lectura.nextFloat();
					
					System.out.println("Ingresa el sexo");
					lectura = new Scanner(System.in);
					sexo = lectura.next().charAt(0);
					
					//crear el objeto
					empleados = new Empleados(nombre, sueldo, sexo);
					
					//Agregar al hashmap
					imp.guardar(empleados);
					System.out.println("Se guardo");
					
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Error al guardar "+ e.getMessage());
				}
				break;
			case 2:
				if(imp.contarRegisHash()>0)
				imp.mostrar();
				else 
					System.out.println("No hay registros");
				break;
			case 3:
				if(imp.contarRegisHash()>0) {
					
					System.out.println("Ingresa el nombre a buscar");
					lectura = new Scanner(System.in);
					nombre = lectura.nextLine();
					
					//Buscar
					empleados= imp.buscar(nombre);
					
					if(empleados != null)
						System.out.println(empleados);
					else
						System.out.println("No existe ese empleado");
				}else
					System.out.println("No hay registros para buscar");
				break;
			case 4:
				if(imp.contarRegisHash()>0) {
					
					System.out.println("Ingresa el nombre del empleado a editar");
					lectura = new Scanner(System.in);
					nombre = lectura.nextLine();
					
					//Buscar
					empleados= imp.buscar(nombre);
					
					if(empleados != null) {
						System.out.println("Se encontro "+empleados.getNombre());
						
						//Proceso para editar
						System.out.println("Ingresa el nuevo sueldo");
						lectura = new Scanner(System.in);
						sueldo = lectura.nextFloat();
						
						//Actualizar el objeto
						empleados.setSueldo(sueldo);
						
						//Actializar el objeto en el HashMap
						imp.editar(empleados);
						System.out.println("Se edito");
						
					}else
						System.out.println("No existe ese empleado");
				}else
					System.out.println("No hay registros para editar");
				
				break;
			case 5:
				System.out.println("Ingresa el nombre del empleado a eliminar");
				lectura = new Scanner(System.in);
				nombre = lectura.nextLine();
				
				//Eliminación
				imp.eliminar(nombre);
				System.out.println("Se elimino");
				break;
			case 6:
				break;
			}
			
		}while (menuPrin < 6);
	}

}
