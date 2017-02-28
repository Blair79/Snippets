package datentime;

import java.time.LocalDate;
import java.time.Period;

public class DatumsDifferenz {

	public static void main(String[] args) {
		LocalDate now = LocalDate.now();
		LocalDate endDate = LocalDate.of(now.getYear(), 12, 24);
		Period p = Period.between(now, endDate);
		int y = p.getYears();
		int m = p.getMonths();
		int d = p.getDays();
		String yStr = y > 0 ? new Integer(y).toString() + (y > 1 ? " Jahren, " : " Jahr, ") : "";
		String mStr = m > 0 ? new Integer(m).toString() + (m > 1 ? " Monaten, " : " Monat, ") : "";
		String dStr = d > 0 ? new Integer(d).toString() + (d > 1 ? " Tagen" : " Tag") : "";
		int comp = endDate.compareTo(now);
		if (comp > 0)
			System.out.println("Weihnachten ist in " + yStr + mStr + dStr + ".");
		else if (comp == 0)
			System.out.println("Heute ist Weihnachten.");
		else
			System.out.println("Weihnachten ist vorbei.");
	}
}