package Student_6;

public class St {

	public static void main(String[] args) {
		
	}
}

class Student{
	private int studentId;
	private String name;
	private double gpa;
	
	Student(int studentId, String name, double gpa){
		this.studentId = studentId;
		this.name = name;
		this.gpa = gpa;
	}
	
	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
}

class Node{
	private Student student;
	private Node prev;
	private Node next;
	
	Node(Student student){
		this.student = student;
	}
	
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Node getPrev() {
		return prev;
	}

	public void setPrev(Node prev) {
		this.prev = prev;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
}

class StudentDataBase{
	private int size;
	private Node head;
	private Node tail;
	
	StudentDataBase(int size){
		this.size = size;
	}
	
	public void addStudent(int studentId, String name, double gpa, int position) {
		Student newStudent = new Student(studentId, name, gpa);
		Node newNode = new Node(newStudent);
		if(size == 0) {
			head = newNode;
			tail = newNode;
		}	
		else if(position == 0){
			Node current = head;
			head = newNode;
			current.setPrev(newNode);
			newNode.setNext(current);
		}
		else if(position == size) {
			Node current = tail;
			tail = newNode;
			current.setNext(newNode);
			newNode.setPrev(current);
		}
		else {
			Node current = head;
			for(int i = 0; i <size-1; i++)
				current = current.getNext();
			newNode.setPrev(current);
			newNode.setNext(current.getNext());
			current.setNext(newNode);
			current.getNext().setPrev(newNode);
		}
	}
	
//	public Student getStudent() {
//		
//	}
//	
//	public void remove(int position) {
//		if(position<0 || position=>size)
//			throw new IndexOutOfBoundsException();
//		if(studentList.size() == 1) {
//			head = null;
//			tail = null;
//		}
//	}
	
}

