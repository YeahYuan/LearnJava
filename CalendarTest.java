package cn.itcast.day20.otherapi.test;

import java.util.Calendar;

public class CalendarTest {

	public static void main(String[] args) {
		// 练习一:获取任意年2月的天数
		int year = 2018;
		int daysOfFab = getDaysOfFab(year);
		System.out.println(year + "年的二月有" + daysOfFab + "天.");
		// 练习二:获取昨天此时的时间
		yesterdayTime();
	}

	public static int getDaysOfFab(int year) {
		Calendar c = Calendar.getInstance();
		c.set(year, 2, 1);
		c.add(Calendar.DAY_OF_MONTH, -1);
		int days = c.get(Calendar.DAY_OF_MONTH);
		return days;
	}

	public static void yesterdayTime() {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_MONTH, -1);
		String yesterdayTime = getTimeString(c);
		System.out.println(yesterdayTime);
	}

	private static String getTimeString(Calendar c) {
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH) + 1;
		int day = c.get(Calendar.DAY_OF_MONTH);
		int week = c.get(Calendar.DAY_OF_WEEK);
		int hour = c.get(Calendar.HOUR_OF_DAY);
		int minute = c.get(Calendar.MINUTE);
		int second = c.get(Calendar.SECOND);
		return year + "年" + month + "月" + day + "日" + getWeek(week) + hour + ":" + minute + ":" + second;
	}

	private static String getWeek(int i) {
		String[] str = { "", "周日", "周一", "周二", "周三", "周四", "周五", "周六" };
		return str[i];
	}

}
