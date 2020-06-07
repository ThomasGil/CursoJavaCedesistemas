package tareas.tarea5.temaArrayList;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibretaContactos {
	
	private static List<Contacto> contactos = new ArrayList<>();
	private static Scanner lectorTeclado = new Scanner(System.in);
	
	public static void main(String[] args) {
		int opcion = 0;
		do {
			System.out.println("Ingrese 1 para agregar contacto, 2 para buscar, 3 para modificar, 4 para eliminar, 5 para imprimir todos o 0 para salir.");
			opcion = lectorTeclado.nextInt();
			Contacto contacto;
			switch (opcion) {
			case 0:
				break;
			case 1:
				contactos.add(new Contacto());
				break;
			case 2:
				contacto = buscarContacto();
				if(contacto != null){
					contacto.imprimir();
				}
				break;
			case 3:
				contacto = buscarContacto();
				if(contacto != null){
					contacto.modificar();
				}
				break;
			case 4:
				contacto = buscarContacto();
				if(contacto != null){
					contactos.remove(contacto);
				}
				break;
			case 5:
				for (Contacto contactoGuardado : contactos) {
					contactoGuardado.imprimir();
				}
				break;
			default:
				System.out.println("ingrese una opcion correcta.");
				break;
			}
		} while(opcion != 0);
	}

	private static Contacto buscarContacto(){
		try {
			System.out.println("ingrese la posicion para buscar el contacto");
			int posicion = lectorTeclado.nextInt();
			return contactos.get(posicion);
		} catch (Exception e) {
			System.out.println("No se encuentra un contacto en esa posicion.");
			return null;
		}
	}
}
