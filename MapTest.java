package cn.itcast.day18.map.test;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class MapTest {
	/*
	 * 练习: "hfweour9230hfnwlq[93rodji0"获取该字符串中每一个字母出现的次数 要求打印结果是:a(1)b(3)...;
	 * 
	 * 思路: 字母与次数之间存在映射关系且多组数据 考虑能够存储有映射关系容器:数组和map集合
	 * 字母或次数是双方都不是有序的(1,2,3...),则使用map集合 可以保证唯一性的一方具备着顺序(a,b,c...),则使用TreeMap???
	 * 
	 * 使用map集合存储字母和次数的对应关系
	 * 
	 * 步骤: 1.将字符串变成字符数组 2.遍历字符数组,用每一个字母作为键去查找集合中是否有对应的键 |--没有,字母作为键,1作为值,存储
	 * |--有,字母作为键,对应的值取出再+1作为值,存储 键相同,值会覆盖 3.遍历结束,map集合记录了所有字母出现的次数
	 */
	public static void main(String[] args) {
		String str = "hfAAAwoAAur9230hfnwDDDq[93ro0";
		String s = getCharCount(str);
		System.out.println(s);
	}

	private static String getCharCount(String str) {
		// 1.字符串变成字符数组
		char[] chs = str.toCharArray();
		// 2.定义map集合表
		Map<Character, Integer> map = new TreeMap<Character, Integer>();
		// 3.存储数据
		for (int i = 0; i < chs.length; i++) {
			if (!(chs[i] >= 'a' && chs[i] <= 'z' || chs[i] >= 'A' && chs[i] <= 'Z')) {
				continue;
			}
			Integer value = map.get(chs[i]);
			map.put(chs[i], value == null ? 1 : value + 1);
			/*
			 * int count = 1; if(!(value==null)) count = value+1; map.put(chs[i], count);
			 * 
			 * 
			 * 
			 * if (value==null) { map.put(chs[i], 1); } else { map.put(chs[i], value+1); }
			 */
		}
		// 4.定义toString
		return mapToString(map);
	}

	private static String mapToString(Map<Character, Integer> map) {
		StringBuilder sb = new StringBuilder();
		Iterator<Character> it = map.keySet().iterator();

		while (it.hasNext()) {
			Character key = it.next();
			Integer value = map.get(key);
			sb.append(key + "(" + value + ")");
		}
		return sb.toString();
	}

}
