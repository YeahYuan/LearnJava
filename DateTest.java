package cn.itcast.day20.otherapi.test;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/*
 * 练习:
 * "2018-3-17"到"2018-4-6"
 * 中间有多少天?
 * 思路:
 * 字符串-->date对象-->毫秒值-->相减得天数
 * 
 */
public class DateTest {

	public static void main(String[] args) throws ParseException {
		String str_date1 = "2018-3-17";
		String str_date2 = "2018-4-6";
		test(str_date1,str_date2);

	}

	public static void test(String str_date1, String str_date2) throws ParseException {
		//DateFormat dateformat = DateFormat.getDateInstance();
		DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		
		Date date1 = dateformat.parse(str_date1);
		Date date2 = dateformat.parse(str_date2);
		
		long time1 = date1.getTime();
		long time2 = date2.getTime();
		
		long time = Math.abs(time1-time2);
		
		int day = getDay(time);
		
		System.out.println("day="+day);
	}

	private static int getDay(long time) {
		
		return (int)(time/1000/60/60/24);
	}



}




















