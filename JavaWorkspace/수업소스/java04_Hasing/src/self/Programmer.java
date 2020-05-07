package self;

public class Programmer {
	private String name;
	private int salary;
	private String tech;
	private MyDate birthDate;	
	//¡÷¿‘
	private NoteBook noteBook;  //setNoteBook()|getNoteBook()
	
	public Programmer(String name, int salary, String tech, MyDate birthDate) {
		super();
		this.name = name;
		this.salary = salary;
		this.tech = tech;
		this.birthDate = birthDate;
	}
	public void buyNoteBook(NoteBook noteBook) {
		this.noteBook = noteBook;
	}
	public NoteBook getNoteBook() {
		return noteBook;
	}	
	public String getProgrammer() {
		return name+","+birthDate.getBirthDay()+","+tech;
	}
	public String getName() {
		return name;
	}
	public int getSalary() {
		return salary;
	}
	public String getTech() {
		return tech;
	}
	public MyDate getBirthDate() {
		return birthDate;
	}	
	
	
}
