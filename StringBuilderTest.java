package day15.cn.itcast.stringbuffer.demo;

public class StringBuilderTest {

	public static void main(String[] args) {
		// 把int数组转换为字符串
		int[] arr = { 1, 4, 2, 5, 3, 6 };
		String s1 = arrayToString1(arr);
		String s2 = arrayToString2(arr);
		System.out.println(s1 + "\n" + s2);

	}
//建议使用该方法,不断在一个字符串容器中添加内容
	private static String arrayToString2(int[] arr) {
		StringBuilder s = new StringBuilder("[");
		for (int i = 0; i < arr.length; i++) {
			if (i != arr.length - 1) {
				s.append(arr[i] + ", ");
			} else {
				s.append(arr[i] + "]");
			}
		}
		return s.toString();
	}
//不建议使用,会产生多个字符串对象,产生垃圾占用资源
	public static String arrayToString1(int[] arr) {
		String s = "[";
		for (int i = 0; i < arr.length; i++) {
			if (i != arr.length - 1) {
				s = s + (arr[i] + ", ");
			} else {
				s = s + (arr[i] + "]");
			}
		}
		return s;
	}

}
