package array;

import java.util.Arrays;

public class ArrayParts {

	public static void main(String[] args) {
		Object[] arr = new Object[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.valueOf(i);
		}
		int key = getKey(arr, Integer.valueOf(6));
		arr = switchParts(arr, key);
		for (Object o : arr)
			System.out.println(o);
	}

	private static int getKey(Object[] arr, Object value) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].equals(value)) {
				return i - 1;
			}
		}
		return 0;
	}

	private static Object[] switchParts(Object[] arr, int key) {

		Object[] first = Arrays.copyOfRange(arr, 0, key + 1);
		Object[] last = Arrays.copyOfRange(arr, key + 1, arr.length);

		System.arraycopy(last, 0, arr, 0, last.length);
		System.arraycopy(first, 0, arr, last.length, first.length);

		return arr;
	}
}