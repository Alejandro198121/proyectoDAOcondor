package DAO;

import java.util.List;

import Model.Student;

public interface IDaoStudent {
	public List<Student> getAllStudents();

	public Student getStudent(String name);

	public void saveStudent(Student student);

	public void deleteStudent(String name);
}