package zym.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import zym.domain.Movie;

public interface MovieMapper {
	/**
	 * 查询全部影片
	 * @return
	 */
	public List<Movie> selectAllMovie();
	/**
	 * 根据影片id查询影片
	 * @param MovieId
	 * @return
	 */
	public Movie selectMovieById(@Param("MovieId")int MovieId);
	/**
	 * 根据影片名模糊查询
	 * @param movieName
	 * @return
	 */
	public List<Movie> selectMovieLike(@Param("movieName")String movieName);
	
	/**
	 * 根据影片id删除影片
	 * @param MovieId
	 * @return
	 */
	public int delMovieById(@Param("MovieId")int MovieId);
	/**
	 * 修改影片信息
	 * @param movie
	 * @return
	 */
	public int updMovieNews(@Param("m")Movie movie);
	/**
	 * 添加影片信息
	 * @param movie
	 * @return
	 */
	public int insertMovie(@Param("m")Movie movie);
}
