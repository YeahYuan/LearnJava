package cn.itcast.day17.arraylist.test;

import java.util.ArrayList;
import java.util.Iterator;

import cn.itcast.bean.Person;
/*
 * 定义功能去除ArrayList中的重复元素
 */
public class ArrayListTest2 {
	public static void main(String[] args) {
		ArrayList a = new ArrayList();
		
		a.add(new Person("lisi1",21));
		a.add(new Person("lisi2",22));
		a.add(new Person("lisi3",23));
		a.add(new Person("lisi2",22));
		a.add(new Person("lisi3",23));
		a.add(new Person("lisi4",24));
		
		System.out.println(a);
		a = getSingleElement(a);
		System.out.println(a);

	}

	public static ArrayList getSingleElement(ArrayList a) {
		//1.定义一个临时容器
		ArrayList temp =new ArrayList();
		//2.迭代a集合
		Iterator it = a.iterator();
		while(it.hasNext()) {
			Object obj = it.next();
			//3.判断迭代到的元素是否已存在于临时容器中	
			if(!temp.contains(obj)) {
				temp.add(obj);
			}
		}		
		return temp;
	}

}



