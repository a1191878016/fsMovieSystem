package zym.mapper;

import java.util.List;

import zym.domain.Plan;

public interface PlanMapper {
	/**
	 * 根据影片id查询放映安排
	 * @param MovieId
	 * @return
	 */
	public List<Plan> selectPlanByMovieId(int MovieId);
	/**
	 * 查询该场次已售座位
	 */
	public int selectCountSeat(int planid);
	/**
	 * 添加影片信息
	 * @param plan
	 * @return
	 */
	public int addPlan(Plan plan);
}
