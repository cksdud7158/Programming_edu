package self.test;

import self.MyDate;
import self.NoteBook;
import self.Programmer;

public class ProgrammerTest {

	public static void main(String[] args) {
		Programmer pro = new Programmer("James", 300000, "Python", new MyDate(1987, 4, 8));
		System.out.println("=========Programmer Infoirmation==============");
		System.out.println(pro.getProgrammer());
		
		System.out.println(" ");
		System.out.println(pro.getName()+" ¥‘¿Ã ±∏∏≈«— NoteBook Information==========");
		
		pro.buyNoteBook(new NoteBook("Gram", 1700000));
		
		NoteBook jamesNotebook=pro.getNoteBook();
		System.out.println(jamesNotebook.getNotgeBook());
	}
}







