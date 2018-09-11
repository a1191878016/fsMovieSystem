package zym.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import zym.domain.Review;
import zym.service.ReviewService;

@Controller
@RequestMapping("/review")
public class ReviewController {
	@Autowired
	private ReviewService rs;

	public ReviewService getRs() {
		return rs;
	}

	public void setRs(ReviewService rs) {
		this.rs = rs;
	}
	/**
	 * 根据用户查询影评
	 * @param userid
	 * @return
	 */
	@RequestMapping("/selReviewByUser.ssm")
	@ResponseBody
	public List<Review> selReviewByUser(@RequestParam("userid")int userid){
		return this.getRs().selReviewByUser(userid);
	}
	/**
	 * 删除影评
	 * @param ReviewId
	 * @return
	 */
	@RequestMapping("/delReviewById.ssm")
	@ResponseBody
	public HashMap<String,Object> deleteReviewById(@RequestParam("ReviewId")int ReviewId){
		return this.getRs().delReviewById(ReviewId);
	}
}
