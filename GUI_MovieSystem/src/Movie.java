import java.io.Serializable;

public class Movie implements Serializable{
	String title; // 영화제목
	String director; //영화감독
	String cast; 	// 배우
	String genre; 	// 영화장르
	String releaseDate; 	// 개봉일
	String grade; 			// 관람등급
	int runtime; 		// 영화 상영시간(단위: 분)
	String photo;		// 영화 관련 이미지(포스터)
//	int starpoint; 				// 영화 별점
	String synopsis;	// 시놉시스
	String reviews; 	// 감상평
	static int movieCounts = 0; // 전체 영화 갯수 관리 목적

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
		description="제목: "+title+"\n";
		description+="감독: "+director+"\n";
		description+="배우: "+cast+"\n";
		description+="장르: "+genre+"\n";
		description+="개봉일: "+releaseDate+"\n";
		description+="등급: "+grade+"\n";
		description+="상영시간: "+runtime+"\n";
		description+="사진: "+photo+"\n";				
		//description+="별점: "+starpoint+"\n";
		description+="<시놉시스>\n ";
		description+=synopsis+"\n";
		description+="<감상평>\n";
		description+=reviews+"\n";	
		return description;
	}	
}