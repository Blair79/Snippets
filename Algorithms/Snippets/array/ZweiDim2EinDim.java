package array;

public class ZweiDim2EinDim {

	public static void main(String[] args) {

		String[] einString = new String[9];
		String[][] zweiString = { new String[] { "einsEins", "einsZwei", "einsDrei" },
				new String[] { "zweiEins", "zweiZwei", "zweiDrei" },
				new String[] { "dreiEins", "dreiZwei", "dreiDrei" } };

		int counter = 0;
		for (int i = 0; i < zweiString.length; i++) {
			for (int j = 0; j < zweiString[i].length; j++) {
				einString[counter] = zweiString[i][j];
				System.out.println(einString[counter]);
				counter++;
			}
		}
	}
}