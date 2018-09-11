package zym.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zym.domain.Plan;
import zym.domain.Room;
import zym.mapper.PlanMapper;

@Service
public class PlanService {
	@Autowired
	private PlanMapper pm;
	/**
	 * 根据影片id查询放映安排
	 * @param MovieId
	 * @return
	 */
	public List<Plan> selectPlanByMovieId(int MovieId){
		return this.getPm().selectPlanByMovieId(MovieId);
	}
	/**
	 * 根据影片id查询放映安排，并计算剩余座位
	 * @param MovieId
	 * @return
	 */
	public HashMap<String,Object> selectUserPlanNews(int MovieId){
		int planid=0;
		HashMap<String,Object> hm=new HashMap();
		List<Plan> plans=this.getPm().selectPlanByMovieId(MovieId);
		List<Integer> seat=new ArrayList();
		for(Plan p:plans) {
			Room r=p.getRoomId();
			planid=p.getPlanId();
			seat.add(r.getColumns()*r.getRow()-this.selectCountSeat(planid));
		}
		hm.put("plan", plans);
		hm.put("seat", seat);
		return hm;
	}
	
	/**
	 * 根据放映编号查询座位总数
	 * @param planid
	 * @return
	 */
	public int selectCountSeat(int planid) {
		return this.getPm().selectCountSeat(planid);
	}
	/**
	 * 添加放映安排
	 * @param plan
	 * @return
	 */
	public int addPlan(Plan plan) {
		return this.getPm().addPlan(plan);
	}
	public PlanMapper getPm() {
		return pm;
	}

	public void setPm(PlanMapper pm) {
		this.pm = pm;
	}
	

}
