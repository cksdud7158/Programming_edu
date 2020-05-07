package programmer;

public class Programmer {
	private String name;
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	private int salary;
	private String tech;
	private MyDate birthDay;
	private Notebook noteBook;
	
	public Programmer(String name, int salary, String tech, MyDate birthDay) {
		super();
		this.name = name;
		this.salary = salary;
		this.tech = tech;
		this.birthDay = birthDay;
	}

	public void buyNotebook(Notebook noteBook) {
		this.noteBook = noteBook;
	}


	public void setBirthDay(MyDate birthDay) {
		this.birthDay = birthDay;
	}


	public Notebook getNoteBook() {
		return noteBook;
	}


	public void setNoteBook(Notebook noteBook) {
		this.noteBook = noteBook;
	}
	
	public String getProgrammer() {
		return name+","+birthDay.getBirthDay()+","+tech;
	}
	
	
	
	
	
	

	
	
}
