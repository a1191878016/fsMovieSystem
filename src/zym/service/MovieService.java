package zym.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import zym.domain.Movie;
import zym.mapper.MovieMapper;

@Service
public class MovieService {
	@Autowired
	private MovieMapper mp;

	public MovieMapper getMp() {
		return mp;
	}

	public void setMp(MovieMapper mp) {
		this.mp = mp;
	}
	/**
	 * 根据分页查询全部影片
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public HashMap<String, Object> selectAllMovie(int pageNum,int pageSize){
		PageHelper.startPage(pageNum, pageSize);
		List<Movie> l=this.getMp().selectAllMovie();
		PageInfo<Movie> pinfo=new PageInfo<>(l);
		HashMap<String,Object> hm=new HashMap<>();
		hm.put("total", pinfo.getTotal());
		hm.put("pagenum", pinfo.getPageNum());
		hm.put("pages", pinfo.getPages());
		hm.put("pagesize", pinfo.getPageSize());
		hm.put("datas", pinfo.getList());
		return hm;
	}
	/**
	 * 根据影片名称模糊查询
	 * @param movieName
	 * @return
	 */
	public List<Movie>selectMovieLike(String movieName){
		return this.getMp().selectMovieLike(movieName);
	}
	
	public HashMap<String,Object> selectMovieById(int MovieId){
		HashMap<String,Object> hm=new HashMap<>();
		Movie m=this.getMp().selectMovieById(MovieId);
		hm.put("datas", m);
		return hm;
	}
	/**
	 * 删除影片
	 * @param MovieId
	 * @return
	 */
	public HashMap<String,Object> delMovieById(int MovieId){
		HashMap<String,Object> hm=new HashMap();
		int count=this.getMp().delMovieById(MovieId);
		if(count>0) {
			hm.put("result", "success");
		}else {
			hm.put("result", "error");
		}
		return hm;
	}
	/**
	 * 修改影片信息
	 * @param movie
	 * @return
	 */
	public HashMap<String,Object> updMovieNews(Movie movie){
		HashMap<String,Object> hm=new HashMap();
		int count=this.getMp().updMovieNews(movie);
		if(count>0) {
			hm.put("result", "success");
		}else {
			hm.put("result", "error");
		}
		return hm;
	}
	/**
	 * 添加影片信息
	 * @param movie
	 * @return
	 */
	public int insertMovie(Movie movie){
//		HashMap<String,Object> hm=new HashMap();
//		int count=this.getMp().insertMovie(movie);
//		if(count>0) {
//			hm.put("result", "success");
//		}else{
//			hm.put("result", "error");
//		}
//		return hm;
		return this.getMp().insertMovie(movie);
	}
}
