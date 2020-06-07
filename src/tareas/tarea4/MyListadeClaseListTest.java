package tareas.tarea4;

public class MyListadeClaseListTest {

	public static void main(String[] args) {
		MyListadeClaseList estudiantes = new MyListadeClaseList();

		System.out.println("¿La lista esta vacia? -> R: " + estudiantes.isEmpty());
		
		System.out.println("---------CREAR E INSERTAR-------");
		Estudiante estudiante1 = new Estudiante();
		Estudiante estudiante2 = new Estudiante();
		Estudiante estudiante3 = new Estudiante();
		Estudiante estudiante4 = new Estudiante();
		Estudiante estudiante5 = new Estudiante();

		estudiantes.insert(estudiante1);
		estudiantes.insert(estudiante2);
		estudiantes.insert(estudiante3);
		estudiantes.insert(estudiante4);
		estudiantes.insert(estudiante5);
		
		System.out.println("----------ACTUALIZAR-----------");
		estudiantes.actualizar(2);
		
		System.out.println("---------RETIRAR-------");
		Estudiante retirado = estudiantes.extract();
		System.out.println("Se retiro de la lista a: "+ retirado.getNombre());
		
		System.out.println("---------IMPRIMIR UNO-------");
		estudiantes.print(3);
		System.out.println("---------IMPRIMIR TODOS-------");
		estudiantes.print();
	}

}
