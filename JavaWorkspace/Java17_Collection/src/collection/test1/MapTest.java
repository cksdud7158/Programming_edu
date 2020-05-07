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
 * key-value를 쌍으로 저장하는 특징을 가진다.  
 */
public class MapTest {
	public static void main(String[] args) {		
		Map<String, Integer> map = new HashMap<>();
		
		map.put("강호동",90);
		map.put("이수근",100);
		map.put("피오",90);
		map.put("규현",85);
		
		System.out.println(map);
		//1. 키만 받아온다...keySet()
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
		System.out.println("총점 : "+totla);
		
		//3. 
		System.out.println("평균 : "+totla/map.size());
		System.out.println("최고점수 : "+Collections.max(col));
		System.out.println("최저점수 : "+Collections.min(col));
	}
}


















