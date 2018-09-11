package zym.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.catalina.core.ApplicationPart;

import com.google.gson.Gson;

import zym.domain.Movie;
import zym.service.MovieService;



/**
 * Servlet implementation class AddMovieController
 */
@WebServlet("/AddMovieController.ssm")
@MultipartConfig // 标识Servlet支持文件上传
public class AddMovieController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMovieController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/json;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		HashMap<String , Object > hm=new HashMap<>();
		String path = this.getServletContext().getRealPath("/images/");
		try {
			Part p = request.getPart("images");
			
			if (p.getContentType().contains("image")) {
				ApplicationPart ap = (ApplicationPart) p;
				String fname1 = ap.getSubmittedFileName();
				int path_idx = fname1.lastIndexOf("\\") + 1;
				String fname2 = fname1.substring(path_idx, fname1.length());
				p.write(path + "\\" + fname2);
				System.out.println(path +"\\" +fname2);
				// 数据库images/fname2
				// out.write("文件上传成功");

				response.sendRedirect("/fsMovieSystem/images/"+fname2);
				//this write myself code,insert /update datas code....
				String menuimage="/images/"+fname2;
				MovieService ms=new MovieService();
				Movie m=new Movie();
				m.setMovieName(request.getParameter("movieName"));
				m.setMovieActor(request.getParameter("movieActor"));
				m.setMovieDirector(request.getParameter("movieDirector"));
				m.setMovieDate(request.getParameter("movieDate"));
				m.setMovieType(request.getParameter("movieType"));
				m.setCountry(request.getParameter("country"));
				m.setMovieTime(new Integer(request.getParameter("movieTime")));
				m.setMovieInformation(request.getParameter("movieInformation"));
				m.setMoviePhoto(menuimage);
				m.setMovieId(0);
				m.setIsGoing(0);
				System.out.println("~~~~"+m.getCountry()+"  "+m.getMoviePhoto()+"  "+m.getMovieName());
				int count=ms.insertMovie(m);
				System.out.println(count);
				if(count>0){
					 hm.put("result", "success");
				}else{
					hm.put("result", "error");
				}
				
			} else {
				// out.write("请选择图片文件");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
             System.out.println("upload error "+ex.getMessage());
             hm.put("result", "uploaderror");
		}
		Gson g=new Gson();
		 String resultJson=g.toJson(hm);
		 response.getWriter().append(resultJson);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
