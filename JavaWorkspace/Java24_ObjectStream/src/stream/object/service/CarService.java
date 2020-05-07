/*
 * 직렬화/ 역질렬화 모두 담겠다
 * Car는 여러개 던지고 받을 수 있다.
 * 여러개를 던지면 안되고 하나에 담아 던져야함
 */

package stream.object.service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import stream.object.vo.Car;

public class CarService {
	public void outputCar(ArrayList<Car> list, String path) throws Exception{
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
		
		oos.writeObject(list);
		
		oos.close();
	}
	//역직렬화 기능
	public ArrayList<Car> inputCar(String path) throws Exception{
		ArrayList<Car> list = null;
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
		list = (ArrayList<Car>) ois.readObject();
		
		return list;
	}
}
