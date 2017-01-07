import java.io.Serializable;

public class Movie implements Serializable{
	String title; // ��ȭ����
	String director; //��ȭ����
	String cast; 	// ���
	String genre; 	// ��ȭ�帣
	String releaseDate; 	// ������
	String grade; 			// �������
	int runtime; 		// ��ȭ �󿵽ð�(����: ��)
	String photo;		// ��ȭ ���� �̹���(������)
//	int starpoint; 				// ��ȭ ����
	String synopsis;	// �ó�ý�
	String reviews; 	// ������
	static int movieCounts = 0; // ��ü ��ȭ ���� ���� ����

	public Movie(String title, String director, String cast, String genre, String releaseDate,String grade,
			int runtime, String photo, /*int starpoint,*/ String synopsis, String reviews) {
		this.title = title;
		this.director = director;
		this.cast = cast;
		this.genre = genre;
		this.releaseDate = releaseDate;
		this.grade = grade;
		this.runtime = runtime;
		this.photo = photo;
		//this.starpoint = starpoint;
		this.synopsis = synopsis;
		this.reviews = reviews;
	}
	public void edit(String title, String director, String cast, String genre, String releaseDate, String grade,
			int runtime, String photo, /*int starpoint,*/ String synopsis, String reviews) {
		this.title = title;
		this.director = director;
		this.cast = cast;
		this.genre = genre;
		this.releaseDate = releaseDate;
		this.grade = grade;
		this.runtime = runtime;
		this.photo = photo;
		//this.starpoint = starpoint;
		this.synopsis = synopsis;
		this.reviews = reviews;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getCast() {
		return cast;
	}
	public void setCast(String cast) {
		this.cast = cast;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public int getRuntime() {
		return runtime;
	}
	public void setRuntime(int runtime) {
		this.runtime = runtime;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	/*public int getStarpoint() {
		return starpoint;
	}
	public void setStarpoint(int starpoint) {
		this.starpoint = starpoint;
	}*/
	public String getSynopsis() {
		return synopsis;
	}
	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}
	public String getReviews() {
		return reviews;
	}
	public void setReviews(String reviews) {
		this.reviews = reviews;
	}
	public static int getMovieCounts() {
		return movieCounts;
	}
	public static void setMovieCounts(int movieCounts) {
		Movie.movieCounts = movieCounts;
	}
	@Override
	public String toString() {
		String description;		
		description="����: "+title+"\n";
		description+="����: "+director+"\n";
		description+="���: "+cast+"\n";
		description+="�帣: "+genre+"\n";
		description+="������: "+releaseDate+"\n";
		description+="���: "+grade+"\n";
		description+="�󿵽ð�: "+runtime+"\n";
		description+="����: "+photo+"\n";				
		//description+="����: "+starpoint+"\n";
		description+="<�ó�ý�>\n ";
		description+=synopsis+"\n";
		description+="<������>\n";
		description+=reviews+"\n";	
		return description;
	}	
}