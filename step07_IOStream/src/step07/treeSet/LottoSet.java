package step07.treeSet;

import java.util.Random;
import java.util.TreeSet;

public class LottoSet extends TreeSet<Integer>{ //����Բ��� �ϽŰ�

	public LottoSet() {
		while(super.size()<6) {
			Random r = new Random();
			int no = r.nextInt(45)+1;
			super.add(no);
		}
		
		System.out.println("lotto =" + this);
	}
		
	public static void main(String[] args) {
		new LottoSet();

	}

}
