package DAO;

import java.util.ArrayList;
import java.util.List;
import Model.Professor;

public class DaoImpProfessor implements IDaoProfessor {

	private List<Professor> professors;

	public DaoImpProfessor() {
		professors = new ArrayList<Professor>();
		Professor p1 = new Professor(40, "John", "101", "Mathematics");
		saveProfessor(p1);
	}

	@Override
	public List<Professor> getAllProfessors() {
		return professors;
	}

	@Override
	public Professor getProfessor(String name) {
		for (Professor professor : professors) {
			if (professor.getName().equals(name)) {
				return professor;
			}
		}
		return new Professor(0, "Not Found", "", "");
	}

	@Override
	public void saveProfessor(Professor professor) {
		professors.add(professor);
	}

	@Override
	public void deleteProfessor(String name) {
		Professor professor = getProfessor(name);
		try {
			professors.remove(professor);
		} catch (Exception e) {
			System.out.println("Profesor no encontrado");
		}
	}
}
