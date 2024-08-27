package Model;

public class Student extends Person {

	private String studentCode;

	public Student() {
	}

	public Student(int age, String name, String studentCode) {
		super(age, name);
		this.studentCode = studentCode;
	}

	public String getStudentCode() {
		return studentCode;
	}

	public void setStudentCode(String studentCode) {
		this.studentCode = studentCode;
	}

	@Override
	public String toString() {
		return "Age: " + super.getAge() + ", Name: " + super.getName() + ", Student Code: " + studentCode;
	}
}
