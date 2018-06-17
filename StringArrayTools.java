package day15.cn.itcast.string.demo;

public class StringArrayTools {
	String[] arr;

	StringArrayTools(String[] arr) {
		this.arr = arr;
	}

	// 打印
	public void printArray() {
		System.out.print("[");
		for (int i = 0; i < arr.length; i++) {
			if (i != arr.length - 1) {
				System.out.print(arr[i] + " , ");
			} else
				System.out.println(arr[i] + " ]");
		}
	}

	// 排序
	public void sortArray() {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i].compareTo(arr[j]) > 0) {//字符串比较用compareTo方法
					swap(arr, i, j);
				}
			}

		}

	}
	
	//元素置换
	private void swap(String[] arr2, int i, int j) {
		String temp = arr2[i];
		arr2[i] = arr2[j];
		arr2[j] = temp;

	}
}
