package programmer.test;

import programmer.MyDate;
import programmer.Notebook;
import programmer.Programmer;

public class ProgrammerTest {

	public static void main(String[] args) {
		Programmer pro = new Programmer("James", 300000, "Python", new MyDate(1987, 4, 8));
		System.out.println("=========Programmer Infoirmation==============");
		System.out.println(pro.getProgrammer());
		
		System.out.println(" ");
		System.out.println(pro.getName()+" ¥‘¿Ã ±∏∏≈«— NoteBook Information==========");
		
		pro.buyNotebook(new Notebook("Gram", 1700000));
		
		Notebook jamesNotebook=pro.getNoteBook();
		System.out.println(jamesNotebook.getNoteBook());
	}
}







