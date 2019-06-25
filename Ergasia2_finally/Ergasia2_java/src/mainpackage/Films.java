package mainpackage;

public class Films {
	private String filmId, filmTitle, filmCategory, filmDescription;
	
	public Films(String id, String title, String category, String description) {
		filmId=id;
		filmTitle= title;
		filmCategory=category;
		filmDescription=description;
	}
	public void setFilmId(String x) {
		filmId = x;
	}
	public String getFilmId() {
		return filmId;
	}
	public void setFilmTitle(String x) {
		filmTitle = x;
	}
	public String getFilmTitle() {
		return filmTitle;
	}
	public void setFilmCategory(String x) {
		filmCategory = x;
	}
	public String getFilmCategory() {
		return filmCategory;
	}
	public void setFilmDescription(String x) {
		filmDescription = x;
	}
	public String getFilmDescription() {
		return filmDescription;
	}
}
