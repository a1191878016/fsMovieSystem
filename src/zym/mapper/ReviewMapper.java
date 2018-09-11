package zym.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import zym.domain.Review;

public interface ReviewMapper {
	/**
	 * 查询用户的影评
	 * @param UserId
	 * @return
	 */
	public List<Review> selReviewByUser(@Param("UserId")int UserId);
	/**
	 * 删除影评
	 * @param ReviewId
	 * @return
	 */
	public int deleteReviewById(int ReviewId);
}
