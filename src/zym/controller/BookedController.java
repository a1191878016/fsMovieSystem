package zym.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import zym.domain.Booked;
import zym.service.BookedService;

@Controller
@RequestMapping("/booked")
public class BookedController {
	@Autowired
	private BookedService bs;
	/**
	 * 根据放映计划id查询已经售出的座位号
	 * @param PlanId
	 * @return
	 */
	@RequestMapping("/selSeatNum.ssm")
	@ResponseBody
	public List<String> selectSeatNum(@RequestParam("PlanId")int PlanId){
		return this.getBs().selectSeatNum(PlanId);
	}
	/**
	 * 添加订购记录
	 * @param UserId
	 * @param MovieId
	 * @param PlanId
	 * @param SeatNum
	 * @return
	 */
	@RequestMapping("/addBooked.ssm")
	@ResponseBody
	public HashMap<String,Object> addBooked(@RequestParam("UserId")int UserId,@RequestParam("MovieId")int MovieId,
			@RequestParam("PlanId")int PlanId,@RequestParam("SeatNum")String SeatNum){
		HashMap<String,Object> hm=new HashMap();
		int count=this.getBs().addBooked(UserId,MovieId,PlanId,SeatNum);
		if(count>0) {
			hm.put("result","success");
		}else {
			hm.put("result","error");
		}
		return hm;
	}
	@RequestMapping("/delBooked.ssm")
	@ResponseBody
	public HashMap<String,Object> delBooked(@RequestParam("BookedId")int BookedId){
		HashMap<String,Object> hm=new HashMap();
		int count=this.getBs().delBooked(BookedId);
		if(count>0) {
			hm.put("result","success");
		}else {
			hm.put("result","error");
		}
		return hm;
	}
	
	/**
	 * 根据用户id查询用户的订购记录
	 * @param UserId
	 * @return
	 */
	@RequestMapping("/selectBookedByUserId.ssm")
	@ResponseBody
	public List<Booked> selectBookedByUserId(@RequestParam("UserId")int UserId){
		return this.getBs().selectBookedByUserId(UserId);
	}
	
	public BookedService getBs() {
		return bs;
	}

	public void setBs(BookedService bs) {
		this.bs = bs;
	}
}
