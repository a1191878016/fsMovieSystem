package zym.domain;

public class Review {
	private int ReviewId;
	private User UserId;
	private Movie MovieId;
	private String Title;
	private String ReviewNews;
	private String ReviewTime;
	public int getReviewId() {
		return ReviewId;
	}
	public void setReviewId(int reviewId) {
		ReviewId = reviewId;
	}
	public User getUserId() {
		return UserId;
	}
	public void setUserId(User userId) {
		UserId = userId;
	}
	public Movie getMovieId() {
		return MovieId;
	}
	public void setMovieId(Movie movieId) {
		MovieId = movieId;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getReviewNews() {
		return ReviewNews;
	}
	public void setReviewNews(String reviewNews) {
		ReviewNews = reviewNews;
	}
	public String getReviewTime() {
		return ReviewTime;
	}
	public void setReviewTime(String reviewTime) {
		ReviewTime = reviewTime;
	}
	
}
