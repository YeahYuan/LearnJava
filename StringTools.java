package day15.cn.itcast.string.demo;

public class StringTools {
	String str, key;

	StringTools(String str, String key) {
		this.str = str;
		this.key = key;
	}

	/**
	 * 获取子串在整串中出现的次数 
	 * 思路: 
	 * 1,通过indexOf方法查找并获取子串第一次出现的位置 
	 * 2,再指定从后面的位置继续查找,循环
	 * 3,变量1记录出现的次数,变量2记录角标 
	 * 4,直到查找结果(角标)为-1,停止查找
	 * 
	 * @param str
	 * @param key
	 * @return
	 */
	public static int getKeyStringCount(String str, String key) {
		int count = 0;// 记录次数
		int index = 0;// 记录角标,控制循环
		while ((index = str.indexOf(key, index)) != -1) {
			index++;
			count++;
		}
		return count;
	}

	/**
	 * 获取子串在整串中出现的次数
	 * 
	 * @param str
	 * @param key
	 * @return count
	 */
	public static int getKeyStringCount2(String str, String key) {
		// 1,定义计数器
		int count = 0;
		// 2,定义变量记录key出现的位置
		int index = 0;

		while ((index = str.indexOf(key)) != -1) {

			str = str.substring(index + key.length());
			count++;
		}
		return count;
	}
	/**
	 * 两个字符串当中的最大相同子串
	 * @param s1
	 * @param s2
	 * @return
	 */
	public static String getMaxSubString(String s1, String s2) {
		String max = null, min = null;
		max = (s1.length() > s2.length()) ? s1 : s2;
		min = (max.equals(s1)) ? s2 : s1;
		for (int i = 0; i < min.length(); i++) {
			for (int x = 0, y = min.length() - i; y < min.length() + 1; x++, y++) {
				//String sub = min.substring(x, y)
				if(max.contains(min.substring(x, y))) {
					return min.substring(x, y);
				}
			}
		}
		return null;
	}

	
	/**
	 * 去掉字符串前后两端的空格
	 * @param s
	 * @return
	 */
	public static String myTrim(String s) {
		int start=0,end=s.length()-1;
		while (start < end && s.charAt(start)==' ') {
			start++;
		}
		while (start<end&&s.charAt(end)==' ') {
			end--;
		}
		return s.substring(start, end+1);
	}
}
