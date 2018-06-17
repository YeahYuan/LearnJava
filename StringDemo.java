package day15.cn.itcast.string.demo;



public class StringDemo {

	public static void main(String[] args) {
	/*
	 * 给定一个字符串数组,按照字典顺序进行从小到大的排序
	 * {"nba","abc","cba","zz","qq","haha"}
	 */		
		String[] arr = {"nba","abc","cba","zz","qq","haha"};
		StringArrayTools s = new StringArrayTools(arr);
		s.printArray();
		s.sortArray();
		s.printArray();/**/
		
		
	/*
	* 获取子串在整串中出现的次数
	*/	
		String str = "nbalkfnbajasjnbafkljlfjnbarnbagryionbaqjopnbamksnba";
		String key = "nba";
		
		int count1 = StringTools.getKeyStringCount(str, key);
		int count2 = StringTools.getKeyStringCount2(str, key);
		
		System.out.println("count1="+count1+"\ncount2="+count2);
	
	/*
	* 两个字符串当中最大相同的子串
	*/	
		String s1 = "jslkjfstringkjflkn";
		String s2 = "nsdlkfnlkwfkllkstringsklfdjkf";
		
		String maxSub = StringTools.getMaxSubString(s1,s2);
		
		System.out.println("maxSub="+maxSub);
		
	/*
	 * 练习四:创建trim函数功能:去掉字符串前后两端的空格
	 */
		String ss ="        h e l l o , j a v a !        ";
		System.out.println("["+ss+"]");
		
		ss = StringTools.myTrim(ss);
		System.out.println("["+ss+"]");
	
	
	
	
	
	
	
	
	
	
	}		
}
