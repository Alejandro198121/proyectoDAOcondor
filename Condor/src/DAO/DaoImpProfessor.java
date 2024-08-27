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
			if (professor.getName() != null && professor.getName().equals(name)) {
				return professor;
			}
		}
		return null;
	}

	@Override
	public void saveProfessor(Professor professor) {
		professors.add(professor);
	}

	@Override
	public boolean deleteProfessor(String name) {
		Professor professor = getProfessor(name);
		if (professor != null) {
			professors.remove(professor);
			return true;
		}
		return false;
	}
}
