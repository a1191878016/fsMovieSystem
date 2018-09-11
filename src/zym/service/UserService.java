package zym.service;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zym.domain.User;
import zym.mapper.UserDao;

@Service
public class UserService {
	@Autowired	
	private UserDao ud;

	public UserDao getUd() {
		return ud;
	}

	public void setUd(UserDao ud) {
		this.ud = ud;
	}
	/**
	 * 用户登录
	 * @param LoginName
	 * @param Password
	 * @param request
	 * @return
	 */
	public HashMap<String,Object> Login(String LoginName,String Password,HttpServletRequest request){
		HashMap<String,Object> hm=new HashMap<>();
		User user=this.getUd().Login(LoginName, Password);
		HttpSession hs=request.getSession();
		if(user==null) {
			hm.put("result", "no");
		}else {
			hm.put("result", "yes");
			hm.put("login", user);
			hs.setAttribute("user", user);
		}
		return hm;
	}
	/**
	 * 用户注册
	 * @param user
	 * @return
	 */
	public HashMap<String,Object> BuyerRegister(User user){
		HashMap<String,Object> hm=new HashMap<>();
		int count=this.getUd().BuyerRegister(user);
		if(count>0) {
			hm.put("result", "success");
		}else {
			hm.put("result","error");
		}
		return hm;
	}
	/**
	 * 修改用户信息
	 * @param user
	 * @return
	 */
	public HashMap<String,Object> UpdUserNews(User user){
		HashMap<String,Object> hm=new HashMap<>();
		int count=this.getUd().UpdUserNews(user);
		if(count>0) {
			hm.put("result", "success");
		}else {
			hm.put("result","error");
		}
		return hm;
	}
	
	public User SelUserAll(int UserId) {
		return this.getUd().SelUserAll(UserId);
	}
}
