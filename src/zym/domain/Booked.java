package zym.domain;

public class Booked {
	private int BookedId;
	private User UserId;
	private Movie MovieId;
	private Plan PlanId;
	private String SeatNum;
	private String BookedTime;
	public int getBookedId() {
		return BookedId;
	}
	public void setBookedId(int booked) {
		BookedId = booked;
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
	public Plan getPlanId() {
		return PlanId;
	}
	public void setPlanid(Plan planId) {
		PlanId = planId;
	}
	public String getSeatNum() {
		return SeatNum;
	}
	public void setSeatNum(String seatNum) {
		SeatNum = seatNum;
	}
	public String getBookedTime() {
		return BookedTime;
	}
	public void setBookedTime(String bookedTime) {
		BookedTime = bookedTime;
	}
	
}
