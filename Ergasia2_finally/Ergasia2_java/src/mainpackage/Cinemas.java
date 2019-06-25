package mainpackage;

public class Cinemas {
	private String cinemaId, cinemaName;
	private boolean cinemaIs3D;
	private int cinemaNumberOfSeats;
	
	public Cinemas(String id, String name, boolean is3d, int seats) {
		cinemaId=id;
		cinemaName = name;
		cinemaIs3D=is3d;
		cinemaNumberOfSeats=seats;
		
	}
	public void setCinemaId(String x) {
		cinemaId = x;
	}
	public String getCinemaId() {
		return cinemaId;
	}
	public void setCinemaName(String x) {
		cinemaName = x;
	}
	public String getCinemaName() {
		return cinemaName;
	}
	public void setCinemaIs3D(boolean x) {
		cinemaIs3D = x;
	}
	public boolean getCinemaIs3D() {
		return cinemaIs3D;
	}
	public void setCinemaNumberOfSeats(int x) {
		cinemaNumberOfSeats = x;
	}
	public int getCinemaNumberOfSeats() {
		return cinemaNumberOfSeats;
	}
}
