package collection.test1;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.xml.sax.HandlerBase;

/*
 * Map
 * ::
 * key-value�� ������ �����ϴ� Ư¡�� ������.  
 */
public class MapTest2 {
	public static void main(String[] args) {		
		Map<String, Integer> map = new HashMap<>();		
		
		map.put("��ȣ��",90);
		map.put("�̼���",100);
		map.put("�ǿ�",90);
		map.put("����",85);	
		
		Set<String> key=map.keySet();
		//
		for(String name : key) {
			System.out.print(map.get(name)+" ");
		}		
	}
}


















