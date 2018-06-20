package cn.itcast.day17.treeset.test;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

import cn.itcast.bean.Person;
import cn.itcast.comparator.ComparatorByLength;

public class TreeSetTest {

	public static void main(String[] args) {
	//练习一:封装person对象的TreeSet以姓名排序(让元素自身具备比较功能)
		text1();
		
	//练习二:对字符串进行长度排序(让集合自身具备比较功能)
		TreeSet tr = new TreeSet(new ComparatorByLength());
		
		tr.add("zhangsan");
		tr.add("lisi");
		tr.add("aha");
		tr.add("yuan");
		tr.add("er");
		tr.add("heng");
		
		Iterator it = tr.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		
		
		
		
		
		
	}

	private static void text1() {
		TreeSet tr = new TreeSet();
		
		tr.add(new Person("zhangsan",22));
		tr.add(new Person("lisi",29));
		tr.add(new Person("wangwu",32));
		tr.add(new Person("yuaner",25));
		tr.add(new Person("zhongsan",20));
		
		Iterator it = tr.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}

}
