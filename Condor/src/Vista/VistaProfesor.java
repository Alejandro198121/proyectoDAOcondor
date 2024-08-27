package Vista;

import Model.Professor;
import DAO.DaoImpProfessor;
import java.util.Scanner;

public class VistaProfesor {

	private DaoImpProfessor professorDao;
	private Scanner scanner;

	public VistaProfesor(DaoImpProfessor professorDao) {
		this.professorDao = professorDao;
		this.scanner = new Scanner(System.in);
	}

	public void mostrarMenu() {
		while (true) {
			System.out.println("Gestión de profesores:");
			System.out.println("1. Crear profesor");
			System.out.println("2. Buscar profesor");
			System.out.println("3. Actualizar profesor");
			System.out.println("4. Borrar profesor");
			System.out.println("5. Volver al menú principal");

			int option = scanner.nextInt();
			scanner.nextLine();

			switch (option) {
			case 1:
				crearProfesor();
				break;
			case 2:
				buscarProfesor();
				break;
			case 3:
				actualizarProfesor();
				break;
			case 4:
				borrarProfesor();
				break;
			case 5:
				return;
			default:
				System.out.println("Opción no válida. Por favor, intente nuevamente.");
			}
		}
	}

	private void crearProfesor() {
		System.out.println("Ingrese edad del profesor:");
		int age = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Ingrese nombre del profesor:");
		String name = scanner.nextLine();
		System.out.println("Ingrese aula del profesor:");
		String classroom = scanner.nextLine();
		System.out.println("Ingrese materia del profesor:");
		String subject = scanner.nextLine();
		Professor newProfessor = new Professor(age, name, classroom, subject);
		professorDao.saveProfessor(newProfessor);
		System.out.println("Profesor creado exitosamente.");
	}

	private void buscarProfesor() {
		System.out.println("Ingrese nombre del profesor a buscar:");
		String searchName = scanner.nextLine();
		Professor foundProfessor = professorDao.getProfessor(searchName);
		if (foundProfessor != null) {
			System.out.println("Resultado de búsqueda: " + foundProfessor);
		} else {
			System.out.println("\nProfesor no encontrado.");
		}
	}

	private void actualizarProfesor() {
		System.out.println("Ingrese nombre del profesor a actualizar:");
		String updateName = scanner.nextLine();
		Professor professorToUpdate = professorDao.getProfessor(updateName);
		if (professorToUpdate == null) {
			System.out.println("\nProfesor no encontrado.");
			return;
		}
		System.out.println("Ingrese nueva edad del profesor:");
		int newAge = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Ingrese nuevo aula del profesor:");
		String newClassroom = scanner.nextLine();
		System.out.println("Ingrese nueva materia del profesor:");
		String newSubject = scanner.nextLine();
		professorToUpdate.setAge(newAge);
		professorToUpdate.setClassroom(newClassroom);
		professorToUpdate.setSubject(newSubject);
		professorDao.saveProfessor(professorToUpdate);
		System.out.println("Profesor actualizado exitosamente.");
	}

	private void borrarProfesor() {
		System.out.println("Ingrese nombre del profesor a borrar:");
		String deleteName = scanner.nextLine();
		boolean deleted = professorDao.deleteProfessor(deleteName);
		if (deleted) {
			System.out.println("Profesor borrado exitosamente.");
		} else {
			System.out.println("\nProfesor no encontrado.");
		}
	}
}
