package zym.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import zym.domain.Movie;
import zym.domain.Plan;
import zym.domain.Room;
import zym.service.PlanService;

@Controller
@RequestMapping("/plan")
public class PlanController {
	@Autowired
	private PlanService ps;
	/**
	 * 根据影片id查询放映安排
	 * @param MovieId
	 * @return
	 */
	@RequestMapping("/selByMovieId.ssm")
	@ResponseBody
	public List<Plan> selectPlanByMovieId(@RequestParam("MovieId") int MovieId){
		return this.getPs().selectPlanByMovieId(MovieId);
	}
	
	/**
	 * 根据影片id查询放映安排，并计算剩余座位
	 * @param MovieId
	 * @return
	 */
	@RequestMapping("/selUserPlanNews.ssm")
	@ResponseBody
	public HashMap<String,Object> selectUserPlanNews(int MovieId){
		return this.getPs().selectUserPlanNews(MovieId);
	}
	
	@RequestMapping("/addPlan.ssm")
	@ResponseBody
	public HashMap<String,Object> addPlan(int MovieId,int RoomId,int Price,String PlanTime){
		Plan p=new Plan();
		Movie m=new Movie();
		m.setMovieId(MovieId);
		p.setMovieId(m);
		Room r=new Room();
		r.setRoomId(RoomId);
		p.setRoomId(r);
		p.setMoviePrice(Price);
		p.setPlanTime(PlanTime);
		int count=this.getPs().addPlan(p);
		HashMap<String,Object> hm=new HashMap<>();
		if(count>0) {
			hm.put("result", "success");
		}else {
			hm.put("result", "error");
		}
		return hm;
	}
	
	public PlanService getPs() {
		return ps;
	}

	public void setPs(PlanService ps) {
		this.ps = ps;
	}
	
	
}
