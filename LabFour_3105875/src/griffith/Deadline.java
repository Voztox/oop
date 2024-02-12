//Mert Faruk Gunes - 3105875
package griffith;

import java.time.LocalDate;

public final class Deadline {
    private final int year;
    private final int month;
    private final int day;
    private final int time;

    //variables
    public Deadline(int year, int month, int day, int time) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.time = time;
    }

    public boolean beforeDeadline(LocalDate time) {
        return time.isBefore(LocalDate.of(year, month, day));
    }

	public int getTime() {
		// TODO Auto-generated method stub
		return time;
	}

	public int getYear() {
		// TODO Auto-generated method stub
		return year;
	}

	public int getMonth() {
		// TODO Auto-generated method stub
		return month;
	}

	public int getDay() {
		// TODO Auto-generated method stub
		return day;
	}
}


