package cn.itcast.day18.hashmap.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import cn.itcast.bean.Student;

public class HashMapTest {

	public static void main(String[] args) {
	/*
	 * 将学生对象的归属地通过键与值存储到map集合中
	 */
		HashMap<Student,String> hm = new HashMap<Student,String>() ;
		
		hm.put(new Student("zhangsan",20), "shanghai");
		hm.put(new Student("yuaner",18), "shandong");
		hm.put(new Student("wangwu",25), "beijing");
		hm.put(new Student("haha",20), "gaungdong");
		hm.put(new Student("yuaner",18), "shenzhen");
		
//		Set<Student> keySet = hm.keySet();
//		Iterator<Student> it = keySet.iterator();
		Iterator<Student> it = hm.keySet().iterator();
		while(it.hasNext()) {
			Student key = it.next();
			String value = hm.get(key);
			System.out.println(key.getName()+":"+key.getAge()+"..."+value);
		}
	}

}
























