package cn.itcast.day17.hashset.test;

import java.util.HashSet;
import java.util.Iterator;

import cn.itcast.bean.Person;

/*
 * 往hashset集合中存储Person对象.如果姓名和年龄相同,视为同一个人=相同元素
 */
public class HashSetTest {

	public static void main(String[] args) {
		HashSet hs = new HashSet();
		
		hs.add(new Person("lisi4",24));
		hs.add(new Person("lisi7",27));
		hs.add(new Person("lisi1",21));
		hs.add(new Person("lisi9",29));
		hs.add(new Person("lisi9",29));
		
		Iterator it = hs.iterator();
		while(it.hasNext()) {
			Person p = (Person)it.next();
			System.out.println(p.getName()+"..."+p.getAge());
		}
	}

}



























