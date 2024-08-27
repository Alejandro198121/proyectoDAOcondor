package DAO;

import java.util.List;
import Model.Professor;

public interface IDaoProfessor {
	public List<Professor> getAllProfessors();

	public Professor getProfessor(String name);

	public void saveProfessor(Professor professor);

	public void deleteProfessor(String name);
}
