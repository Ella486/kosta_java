package step07.treeSet;


import java.util.Set;
import java.util.TreeSet;

public class LottoTest {
	public static void main(String[] args) {
		Set<Integer> lotto = new TreeSet<Integer>();
		
		while(lotto.size()<6) {
			int num = (int)(Math.random()*45)+1;
			lotto.add(num);
		}
		
		System.out.println("lotto = "+ lotto);
		
	}
}



