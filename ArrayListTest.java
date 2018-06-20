package cn.itcast.day17.arraylist.test;

import java.util.ArrayList;
import java.util.Iterator;

import cn.itcast.bean.Person;

public class ArrayListTest {

	public static void main(String[] args) {
		ArrayList a = new ArrayList();
		
		a.add(new Person("lisi1",21));
		a.add(new Person("lisi2",22));
		a.add(new Person("lisi3",23));
		a.add(new Person("lisi4",24));
		
		Iterator it = a.iterator();
		while(it.hasNext()) {
			Person p = (Person)it.next();//自定义对象要进行类型强转
			System.out.println(p.getName()+" : "+p.getAge());//迭代器中使用对象的不同函数要注意角标不断增加
		}

	}

}









