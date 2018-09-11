package zym.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import zym.domain.Booked;

public interface BookedMapper {
	
	
	
	
	/**
	 * 根据放映安排编号查询已经预订座位
	 * @param PlanId
	 * @return
	 */
	public List<String> selectSeatNum(int PlanId);
	/**
	 * 添加购买记录
	 * @param book
	 * @return
	 */
	public int addBooked(@Param("UserId")int UserId,@Param("MovieId")int MovieId,
			@Param("PlanId")int PlanId,@Param("SeatNum")String SeatNum);
	/**
	 * 根据用户Id查询该用户订单记录
	 * @param UserId
	 * @return
	 */
	public List<Booked> selectBookedByUserId(int UserId);
	/**
	 * 根据订单Id删除订单记录
	 * @param bookedId
	 * @return
	 */
	public int delBooked(@Param("BookedId")int bookedId);
}
