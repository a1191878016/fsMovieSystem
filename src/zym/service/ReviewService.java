package zym.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zym.domain.Review;
import zym.mapper.ReviewMapper;

@Service
public class ReviewService {
	@Autowired
	private ReviewMapper rm;

	public ReviewMapper getRm() {
		return rm;
	}

	public void setRm(ReviewMapper rm) {
		this.rm = rm;
	}
	/**
	 * 查询用户影评
	 * @param userid
	 * @return
	 */
	public List<Review> selReviewByUser(int userid){
		return this.getRm().selReviewByUser(userid);
	}
	/**
	 * 删除影评
	 * @param ReviewId
	 * @return
	 */
	public HashMap<String,Object> delReviewById(int ReviewId){
		HashMap<String,Object> hm=new HashMap();
		int count=this.getRm().deleteReviewById(ReviewId);
		if(count>0) {
			hm.put("result","success");
		}else {
			hm.put("result", "error");
		}
		return hm;
	}
}
