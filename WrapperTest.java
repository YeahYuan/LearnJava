package cn.itcast.wrapper.demo;

import java.util.Arrays;

/*
 * 对一个字符串中的数值从小到大排序
 * "20 78 9 -7 88 36 29"
 */
public class WrapperTest {
	private static final String SPACE_SEPARATOR = " ";

	public static void main(String[] args) {
		String numStr = "20 78 9 -7 88 36 29";
		System.out.println(numStr);
		numStr = sortStringNumber(numStr);
		System.out.println(numStr);
	}

	public static String sortStringNumber(String numStr) {
		// 1.将字符串变成字符串数组
		String[] str_arr = stringToArray(numStr);
		// 2.将字符串数组变成int数组
		int[] num_arr = toIntArray(str_arr);
		// 3.对int数组排序
		mySortArray(num_arr);
		// 4.将int数组变成字符串
		String temp = arrayToString(num_arr);

		return temp;
	}

	public static String arrayToString(int[] arr) {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			if (i != arr.length - 1) {
				s.append(arr[i] + SPACE_SEPARATOR);
			} else {
				s.append(arr[i]);
			}
		}
		return s.toString();
	}

	public static void mySortArray(int[] num_arr) {
		Arrays.sort(num_arr);
	}

	public static int[] toIntArray(String[] str_arr) {
		int[] num_arr = new int[str_arr.length];
		for (int i = 0; i < str_arr.length; i++) {
			num_arr[i] = Integer.parseInt(str_arr[i]);
		}
		return num_arr;
	}

	public static String[] stringToArray(String numStr) {
		return numStr.split(SPACE_SEPARATOR);
	}

}
