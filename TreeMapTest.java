package cn.itcast.day18.treemap.test;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import cn.itcast.bean.Student;
import cn.itcast.comparator.ComparatorByName;

public class TreeMapTest {

	public static void main(String[] args) {
		/*
		 * 将学生对象的归属地通过键与值存储到map集合中
		 */
		TreeMap<Student, String> tm = new TreeMap<Student, String>(new ComparatorByName());

		tm.put(new Student("zhangsan", 20), "shanghai");
		tm.put(new Student("yuaner", 18), "shandong");
		tm.put(new Student("wangwu", 25), "beijing");
		tm.put(new Student("haha", 20), "gaungdong");
		tm.put(new Student("yuaner", 18), "shenzhen");

		Iterator<Map.Entry<Student, String>> it = tm.entrySet().iterator();
//		Set<Map.Entry<Student, String>> entrySet = tm.entrySet();
//		Iterator<Map.Entry<Student, String>> it = entrySet.iterator();
		
		while (it.hasNext()) {
			Map.Entry<Student, String> me = it.next();
			Student key = me.getKey();
			String value = me.getValue();
			System.out.println(key.getName() + ":" + key.getAge() + "..." + value);
		}

	}

}











