package zym.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zym.domain.Booked;
import zym.mapper.BookedMapper;

@Service
public class BookedService {
	@Autowired
	private BookedMapper bm;
	
	
	
	
	/**
	 * 根据放映安排编号查询已经预订座位
	 * @param PlanId
	 * @return
	 */
	public List<String> selectSeatNum(int PlanId){
		return this.getBm().selectSeatNum(PlanId);
	}
	/**
	 * 添加订购记录
	 * @param book
	 * @return
	 */
	public int addBooked(int UserId,int MovieId,int PlanId,String SeatNum) {
		return this.getBm().addBooked(UserId,MovieId,PlanId,SeatNum);
	}
	/**
	 * 根据用户id查询全部订阅记录
	 * @param UserId
	 * @return
	 */
	public List<Booked> selectBookedByUserId(int UserId){
		return this.getBm().selectBookedByUserId(UserId);
	}
	/**
	 * 根据订单id删除订单信息
	 * @param bookedId
	 * @return
	 */
	public int delBooked(int bookedId) {
		return this.getBm().delBooked(bookedId);
	}
	
	public BookedMapper getBm() {
		return bm;
	}

	public void setBm(BookedMapper bm) {
		this.bm = bm;
	}
}
