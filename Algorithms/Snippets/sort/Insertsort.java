package sort;

public class Insertsort {

	public int[] intArr = { 16, 23, 14, 7, 21, 20, 6, 1, 17, 13, 12, 9, 3, 19 };

	public int[] sort() {
		int k;
		for (int i = 0; i < intArr.length; i++) {
			for (int j = intArr.length - 1; j > 0; j--) {
				if (intArr[j - 1] > intArr[j]) {
					k = intArr[j];
					intArr[j] = intArr[j - 1];
					intArr[j - 1] = k;
				}
			}
		}
		return intArr;
	}

	public static void main(String[] args) {
		Insertsort is = new Insertsort();
		int[] arr = is.sort();
		for (int i = 0; i < arr.length; i++) {
			System.out.println(i + 1 + ": " + arr[i]);
		}
	}
}