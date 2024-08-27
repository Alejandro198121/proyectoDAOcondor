package Controller;

import DAO.DaoImpProfessor;
import DAO.DaoImpStudent;
import Vista.VistaEstudiante;
import Vista.VistaProfesor;

import java.util.Scanner;

public class Condor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DaoImpStudent studentDao = new DaoImpStudent();
        DaoImpProfessor professorDao = new DaoImpProfessor();

        VistaEstudiante vistaEstudiante = new VistaEstudiante(studentDao);
        VistaProfesor vistaProfesor = new VistaProfesor(professorDao);

        while (true) {
            System.out.println("Bienvenido al sistema de gestión.");
            System.out.println("1. Gestionar estudiantes");
            System.out.println("2. Gestionar profesores");
            System.out.println("3. Salir");

            int mainOption = scanner.nextInt();
            scanner.nextLine();

            switch (mainOption) {
                case 1:
                    vistaEstudiante.mostrarMenu();
                    break;
                case 2:
                    vistaProfesor.mostrarMenu();
                    break;
                case 3:
                    System.out.println("Saliendo del sistema.");
                    return;
                default:
                    System.out.println("Opción no válida. Por favor, intente nuevamente.");
            }
        }
    }
}
