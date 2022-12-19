package ex0214.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapExam extends HashMap<Integer, String>{
//public class MapExam extends HashMap<Integer, String>{//key를 정렬한다.
	public MapExam() {
		//map 추가
		super.put(10, "장희정");
		super.put(40, "이나영");
		super.put(20,"이효리");
		super.put(30,"김희선");
		super.put(60,"장동건");
		super.put(50,"고소영");
		
		super.put(30,"삼순이"); //기존의 같은 key가 있으면 value를 변경한다.
		
		System.out.println("저장된 개수: " + super.size());
		System.out.println(this);
		
		System.out.println("===========Map에 저장된 정보 조회===========");
		//Map에 있는 모든 key의 정보를 검색한다.
		Set<Integer> set = super.keySet();
		//System.out.println(set);
		
		Iterator<Integer> it = set.iterator();
		while(it.hasNext()) {
			Integer key = it.next();
			String value = super.get(key);
			
			System.out.println(key + " : " + value);
		}
		//
		System.out.println("---------위에 Iterator를 개선된 for문으로 변경----");
		for( Integer key: super.keySet()) {
			String value = super.get(key);
			
			System.out.println(key + " : " + value);
			
		}
		
		System.out.println("**********Map.Entry<K,V> 사용하기**********");
		Set<Map.Entry<Integer, String>> entryset = super.entrySet();
	
		Iterator<Map.Entry<Integer, String>> iter = entryset.iterator();
		while(iter.hasNext()) {
			Map.Entry<Integer, String> entry = iter.next();
			System.out.println(entry.getKey() + " : " + entry.getValue());
			
		}
		
		System.out.println("**********Map.Entry<K,V> 개선된 for문으로 변경**********");
		for( Map.Entry<Integer, String> me : super.entrySet()) {
			System.out.println(me.getKey() + " : " + me.getValue());
		}
		
		
	}
	public static void main(String[] args) {
		new MapExam();
 
	}

}
