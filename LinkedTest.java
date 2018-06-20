package cn.itcast.day17.linkedlist.test;

/**
 * 使用LinkedList模拟一个堆栈或者队列数据结构
 * @author 袁二
 *
 */
public class LinkedTest {

	public static void main(String[] args) {
		
		DuiLie d1 = new DuiLie();
		
		d1.myAdd("abc1");
		d1.myAdd("abc2");
		d1.myAdd("abc3");
		d1.myAdd("abc4");
		
		while (!d1.isNull()) {
			System.out.println(d1.myGet());
		}
		
		DuiZhan d2 = new DuiZhan();
		
		d2.myAdd("abc1");
		d2.myAdd("abc2");
		d2.myAdd("abc3");
		d2.myAdd("abc4");
		
		while (!d2.isNull()) {
			System.out.println(d2.myGet());
		}

	}

	
	
	
	
	
	
	
	
	
	
	
}
