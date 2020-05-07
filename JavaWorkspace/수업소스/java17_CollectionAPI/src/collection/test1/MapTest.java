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
public class MapTest {
	public static void main(String[] args) {		
		Map<String, Integer> map = new HashMap<>();
		
		map.put("��ȣ��",90);
		map.put("�̼���",100);
		map.put("�ǿ�",90);
		map.put("����",85);
		
		System.out.println(map);
		//1. Ű�� �޾ƿ´�...keySet()
		Set<String> set=map.keySet();
		Iterator<String> it=set.iterator();
		while(it.hasNext()) {
			String name = it.next();
			System.out.println(name +" ====   "+map.get(name));
		}
		
		//2.
		Collection<Integer> col=map.values(); //90,100,90,85
		int totla = 0;
		
		Iterator<Integer> it2=col.iterator();
		while(it2.hasNext()) totla +=it2.next();			
		System.out.println("���� : "+totla);
		
		//3. 
		System.out.println("��� : "+totla/map.size());
		System.out.println("�ְ����� : "+Collections.max(col));
		System.out.println("�������� : "+Collections.min(col));
	}
}


















