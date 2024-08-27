package Controller;

import DAO.DaoImpProfessor;
import DAO.DaoImpStudent;

public class Condor {

	public static void main(String[] args) {
		
		DaoImpStudent ob = new DaoImpStudent();
		System.out.println(ob.getAllStudents());

		DaoImpProfessor pr = new DaoImpProfessor();
		System.out.println("\n" + pr.getAllProfessors());
	}

}
