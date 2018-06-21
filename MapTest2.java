package cn.itcast.day18.map.test;

import java.util.HashMap;
import java.util.Map;

public class MapTest2 {

	public static void main(String[] args) {
		/*
		 * map在有映射关系时,可以优先考虑
		 * 在查表法中的应用较为多见
		 */
		String week =getWeek(1);
		System.out.println(week);
		System.out.println(getWeekByMap(week));
	}

	private static String getWeekByMap(String week) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("星期一", "Monday");
		map.put("星期二", "Thursday");
		map.put("星期三", "Wensday");
		map.put("星期四", "Thsday");
		map.put("星期五", "Friday");
		map.put("星期日", "Sunday");
		map.put("星期天", "Sunday");
		return map.get(week);
	}

	public static String getWeek(int i) {
		if(i<1||i>7)
			throw new RuntimeException("没有对应的星期,你怕不是个傻子吧");
		String[] str = {"","星期一","星期二","星期三","星期四","星期五"};
		return str[i];
	}

}







