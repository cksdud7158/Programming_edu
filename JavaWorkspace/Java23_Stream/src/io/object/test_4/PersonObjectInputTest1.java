package io.object.test_4;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class PersonObjectInputTest1 {

	public static void main(String[] args) throws Exception {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src\\Person.obj"));
		
		Person p = (Person) ois.readObject();
		System.out.println(p);
	}

}
