package Model;

public class Professor extends Person {

	private String classroom;
	private String subject;

	public Professor(int age, String name, String classroom, String subject) {
		super(age, name);
		this.classroom = classroom;
		this.subject = subject;
	}

	public String getClassroom() {
		return classroom;
	}

	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "Age: " + super.getAge() + ", Name: " + super.getName() + ", Classroom: " + classroom + ", Subject: " + subject;
	}

}