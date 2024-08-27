package Vista;

import Model.Student;
import DAO.DaoImpStudent;
import java.util.Scanner;

public class VistaEstudiante {

	private DaoImpStudent studentDao;
	private Scanner scanner;

	public VistaEstudiante(DaoImpStudent studentDao) {
		this.studentDao = studentDao;
		this.scanner = new Scanner(System.in);
	}

	public void mostrarMenu() {
		while (true) {
			System.out.println("Gestión de estudiantes:");
			System.out.println("1. Crear estudiante");
			System.out.println("2. Buscar estudiante");
			System.out.println("3. Actualizar estudiante");
			System.out.println("4. Borrar estudiante");
			System.out.println("5. Volver al menú principal");

			int option = scanner.nextInt();
			scanner.nextLine();

			switch (option) {
			case 1:
				crearEstudiante();
				break;
			case 2:
				buscarEstudiante();
				break;
			case 3:
				actualizarEstudiante();
				break;
			case 4:
				borrarEstudiante();
				break;
			case 5:
				return;
			default:
				System.out.println("Opción no válida. Por favor, intente nuevamente.");
			}
		}
	}

	private void crearEstudiante() {
		System.out.println("Ingrese edad del estudiante:");
		int age = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Ingrese nombre del estudiante:");
		String name = scanner.nextLine();
		System.out.println("Ingrese código del estudiante:");
		String code = scanner.nextLine();
		Student newStudent = new Student(age, name, code);
		studentDao.saveStudent(newStudent);
		System.out.println("Estudiante creado exitosamente.");
	}

	private void buscarEstudiante() {
		System.out.println("Ingrese nombre del estudiante a buscar:");
		String searchName = scanner.nextLine();
		Student foundStudent = studentDao.getStudent(searchName);
		if (foundStudent != null) {
			System.out.println("Resultado de búsqueda: " + foundStudent);
		} else {
			System.out.println("\nEstudiante no encontrado.");
		}
	}

	private void actualizarEstudiante() {
		System.out.println("Ingrese nombre del estudiante a actualizar:");
		String updateName = scanner.nextLine();
		Student studentToUpdate = studentDao.getStudent(updateName);
		if (studentToUpdate == null) {
			System.out.println("\nEstudiante no encontrado.");
			return;
		}
		System.out.println("Ingrese nueva edad del estudiante:");
		int newAge = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Ingrese nuevo código del estudiante:");
		String newCode = scanner.nextLine();
		studentToUpdate.setAge(newAge);
		studentToUpdate.setStudentCode(newCode);
		studentDao.saveStudent(studentToUpdate);
		System.out.println("Estudiante actualizado exitosamente.");
	}

	private void borrarEstudiante() {
		System.out.println("Ingrese nombre del estudiante a borrar:");
		String deleteName = scanner.nextLine();
		boolean deleted = studentDao.deleteStudent(deleteName);
		if (deleted) {
			System.out.println("Estudiante borrado exitosamente.");
		} else {
			System.out.println("\nEstudiante no encontrado.");
		}
	}
}
