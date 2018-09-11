package zym.domain;

public class Plan {
	private int PlanId;
	private Movie MovieId;
	private Room RoomId;
	private String PlanTime;
	private int MoviePrice;
	public int getPlanId() {
		return PlanId;
	}
	public void setPlanId(int planId) {
		PlanId = planId;
	}
	
	
	public String getPlanTime() {
		return PlanTime;
	}
	public void setPlanTime(String planTime) {
		PlanTime = planTime;
	}
	public int getMoviePrice() {
		return MoviePrice;
	}
	public void setMoviePrice(int moviePrice) {
		MoviePrice = moviePrice;
	}
	public Movie getMovieId() {
		return MovieId;
	}
	public void setMovieId(Movie movieId) {
		MovieId = movieId;
	}
	public Room getRoomId() {
		return RoomId;
	}
	public void setRoomId(Room roomId) {
		RoomId = roomId;
	}
	
}
