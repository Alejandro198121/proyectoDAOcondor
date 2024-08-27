package DAO;

import java.util.ArrayList;
import java.util.List;

import Model.Student;

public class DaoImpStudent implements IDaoStudent{

	private List<Student> students;
	
	public DaoImpStudent() {
		students = new ArrayList<Student>();
		Student s1 = new Student(1,"David","2434");
		saveStudent(s1);
	}
	
	public List<Student> getAllStudents() {
		return students;
	}
	
	public Student getStudent(String name) {
		for(Student student : students) {
			if(student.getName().equals(name)) {
				return student;
			}
		}
		return new Student();
	}
	
	public void saveStudent(Student student) {
		students.add(student);
		
	}
	
	public void deleteStudent(String name) {
		Student student = getStudent(name);
		try {
			students.remove(student);
		} catch (Exception e) {
			System.out.println("Estudiante no encontrado");
			
		}
	}
	
}
