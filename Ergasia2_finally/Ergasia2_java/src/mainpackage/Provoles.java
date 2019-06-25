package mainpackage;

public class Provoles {
	private String provoliID, provoliStartDate, provoliEndDate;
	private Films provoliFilm;
	private Cinemas provoliCinema;
	private boolean provoliIsAvailable;
	private int provoliNumberOfReservations;

	public Provoles(String id, Films film, Cinemas cinema, String startDate, String endDate, boolean available,
			int reservations) {
		provoliID = id;
		provoliFilm = film;
		provoliCinema = cinema;
		provoliStartDate = startDate;
		provoliEndDate = endDate;
		provoliIsAvailable = available;
		provoliNumberOfReservations = reservations;

	}

	public void setprovoliID(String x) {
		provoliID = x;
	}

	public String getprovoliID() {
		return provoliID;
	}

	public void setprovoliFilm(Films x) {
		provoliFilm = x;
	}

	public Films getprovoliFilm() {
		return provoliFilm;
	}

	public void setprovoliCinema(Cinemas x) {
		provoliCinema = x;
	}

	public Cinemas getprovoliCinema() {
		return provoliCinema;
	}

	public void setprovoliStartDate(String x) {
		provoliStartDate = x;
	}

	public String getprovoliStartDate() {
		return provoliStartDate;
	}

	public void setprovoliEndDate(String x) {
		provoliEndDate = x;
	}

	public String getprovoliEndDate() {
		return provoliEndDate;
	}

	public void setprovoliNumberOfReservations(int x) {
		provoliNumberOfReservations = x;
	}

	public int getprovoliNumberOfReservations() {
		return provoliNumberOfReservations;
	}

	public void setprovoliIsAvailable(boolean x) {
		provoliIsAvailable = x;
	}

	public boolean getprovoliIsAvailable() {
		return provoliIsAvailable;
	}
}
