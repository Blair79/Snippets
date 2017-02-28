package sort;

public class Selectsort {

	public int[] intArr = { 16, 23, 14, 7, 21, 20, 6, 1, 17, 13, 12, 9, 3, 19 };

	public int[] sort() {
		int q, k;
		for (int i = intArr.length - 1; i >= 1; i--) {
			q = 0;
			for (int j = 1; j <= i; j++) {
				if (intArr[j] > intArr[q]) {
					q = j;
				}
			}
			k = intArr[q];
			intArr[q] = intArr[i];
			intArr[i] = k;
		}
		return intArr;
	}

	public static void main(String[] args) {
		Selectsort ss = new Selectsort();
		int[] arr = ss.sort();
		for (int i = 0; i < arr.length; i++) {
			System.out.println(i + 1 + ": " + arr[i]);
		}
	}
}