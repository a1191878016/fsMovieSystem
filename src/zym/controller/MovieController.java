package zym.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.catalina.core.ApplicationPart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import zym.domain.Movie;
import zym.service.MovieService;

@Controller
@RequestMapping("/movie")
public class MovieController {
	@Autowired
	private MovieService ms;
	/**
	 * 根据分页查询全部影片
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("/selectMovie.ssm")
	@ResponseBody
	public HashMap<String, Object> selectAllMovie(int pageNum,int pageSize){
		return this.getMs().selectAllMovie(pageNum, pageSize);
	}
	/**
	 * 根据影片id查询影片详细信息
	 * @param MovieId
	 * @return
	 */
	@RequestMapping("/selectById.ssm")
	@ResponseBody
	public HashMap<String,Object> selectMovieById(int MovieId){
		return this.getMs().selectMovieById(MovieId);
	}
	/**
	 * 删除
	 * @param MovieId
	 * @return
	 */
	@RequestMapping("/delMovieById.ssm")
	@ResponseBody
	public HashMap<String,Object>delMovieById(int MovieId){
		return this.getMs().delMovieById(MovieId);
	}
	/**
	 * 修改
	 * @param movieid
	 * @param movieName
	 * @param country
	 * @param movieActor
	 * @param movieDirector
	 * @param movieType
	 * @param movieTime
	 * @param movieInformation
	 * @param movieDate
	 * @return
	 */
	@RequestMapping("/updMovieNews.ssm")
	@ResponseBody
	public HashMap<String,Object>updMovieNews(@RequestParam("movieid")int movieid,@RequestParam("movieName")String movieName,@RequestParam("country")String country,
			@RequestParam("movieActor")String movieActor,@RequestParam("movieDirector")String movieDirector,@RequestParam("movieType")String movieType,
			@RequestParam("movieTime")int movieTime,@RequestParam("movieInformation")String movieInformation,@RequestParam("movieDate")String movieDate){
		Movie movie=new Movie();
		movie.setMovieId(movieid);
		movie.setCountry(country);
		movie.setMovieName(movieName);
		movie.setMovieActor(movieActor);
		movie.setMovieDirector(movieDirector);
		movie.setMovieTime(movieTime);
		movie.setMovieType(movieType);
		movie.setMovieInformation(movieInformation);
		movie.setMovieDate(movieDate);
		return this.getMs().updMovieNews(movie);
	}
	/**
	 * 模糊查询
	 * @return
	 */
	@RequestMapping("/selectMovieLike.ssm")
	@ResponseBody
	public List<Movie> seleceMovieLike(String movieName) {
		return this.getMs().selectMovieLike(movieName);
	}
	
//	@RequestParam("movieName")String movieName,@RequestParam("movieActor")String movieActor,@RequestParam("movieDirector")String movieDirector,
//	@RequestParam("movieType")String movieType,@RequestParam("country")String country,@RequestParam("movieTime")int movieTime,
//	@RequestParam("movieDate")String movieDate,@RequestParam("movieInformation")String movieInformation,@RequestParam("images")String images,
//	@RequestMapping("/addMovie.ssm")
//	@ResponseBody
//	public HashMap<String,Object> insertMovie(HttpServletRequest request, HttpServletResponse response){
//		Movie movie=new Movie();
//		movie.setCountry(request.getParameter("country"));
//		movie.setMovieName(request.getParameter("movieName"));
////		movie.setMovieActor(movieActor);
////		movie.setMovieDirector(movieDirector);
////		movie.setMovieType(movieType);
////		movie.setMovieTime(movieTime);
////		movie.setMovieDate(movieDate);
////		movie.setMovieInformation(movieInformation);
//		String path=request.getServletContext().getRealPath("/images/");
//		System.out.println("------!!!-----"+path);
//		try {
//			Part p=request.getPart("images");
//			System.out.println("-----------"+p);
//			if(p.getContentType().contains("image")) {
//				ApplicationPart ap=(ApplicationPart) p;
//				String fname1=ap.getSubmittedFileName();
//				int path_idx=fname1.lastIndexOf("\\")+1;
//				String fname2=fname1.substring(path_idx, fname1.length());
//				p.write(path+"\\"+fname2);
//				System.out.println(path+"\\"+fname2);
//				response.sendRedirect("/fsMovieSystem/images/"+fname2);
//				String menuimage="/images/"+fname2;
//				movie.setMoviePhoto(menuimage);
//			}
//		} catch (IllegalStateException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ServletException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return this.getMs().insertMovie(movie);
//	}
	@RequestMapping("/upload.ssm")
	@ResponseBody
	public HashMap<String,Object> upload(MultipartFile file,Movie movie,HttpServletRequest request,Model model) throws IllegalStateException, IOException{
		System.out.println(request.getParameter("movieName"));
		String sqlPath=null;
		String localPath="D:\\File\\";
		String filename=null;
		if(!file.isEmpty()) {
			String uuid=UUID.randomUUID().toString().replace("-", "");
			String contentType=file.getContentType();
			String suffixName=contentType.substring(contentType.indexOf("/")+1);
			filename=uuid+"."+suffixName;
			System.out.println(filename);
			file.transferTo(new File(localPath+filename));
		}
		sqlPath="/images/"+filename;
		System.out.println(sqlPath);
		movie.setMoviePhoto(sqlPath);
		HashMap<String,Object>hm=new HashMap();
		int count=this.getMs().insertMovie(movie);
		if(count>0) {
			hm.put("result", "success");
		}else {
			hm.put("result","error");
		}
	
		return hm;
	}
	
	
	public MovieService getMs() {
		return ms;
	}

	public void setMs(MovieService ms) {
		this.ms = ms;
	}
}
