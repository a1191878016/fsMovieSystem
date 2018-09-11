package zym.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import zym.domain.User;
import zym.mapper.UserDao;
import zym.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService us;
	/**
	 * 用户登录
	 * @param LoginName
	 * @param Password
	 * @param request
	 * @return
	 */
	@RequestMapping("/Login.ssm")
	@ResponseBody
	public HashMap<String,Object> Login(@RequestParam("LoginName")String LoginName,
			@RequestParam("Password") String Password,HttpServletRequest request){
		return this.getUs().Login(LoginName, Password,request);
	}
	/**
	 * 用户注册
	 * @param LoginName
	 * @param Password
	 * @param UserName
	 * @param UserSex
	 * @param UserPhone
	 * @param UserEmail
	 * @return
	 */
	@RequestMapping("/BuyerRegister.ssm")
	@ResponseBody
	public HashMap<String,Object> Login(@RequestParam("LoginName")String LoginName,@RequestParam("Password")String Password,
			@RequestParam("UserName")String UserName,@RequestParam("UserSex")String UserSex,@RequestParam("UserPhone")String UserPhone,@RequestParam("UserEmail")String UserEmail){
		User user=new User();
		user.setLoginName(LoginName);
		user.setPassword(Password);
		user.setUserEmail(UserEmail);
		user.setUserName(UserName);
		user.setUserPhone(UserPhone);
		user.setUserSex(UserSex);
		return this.getUs().BuyerRegister(user);
	}
	/**
	 * 查询用户信息
	 * @param UserId
	 * @return
	 */
	@RequestMapping("/SelUserAll.ssm")
	@ResponseBody
	public User SelUserAll(@RequestParam("UserId")int UserId) {
		return this.getUs().SelUserAll(UserId);
	}
	/**
	 * 修改用户信息
	 * @param UserId
	 * @param Password
	 * @param UserName
	 * @param UserSex
	 * @param UserPhone
	 * @param UserEmail
	 * @return
	 */
	@RequestMapping("/UpdUserNews.ssm")
	@ResponseBody
	public HashMap<String,Object> UpdUserNews(@RequestParam("UserId")int UserId,
			@RequestParam("UserName")String UserName,@RequestParam("UserSex")String UserSex,@RequestParam("UserPhone")String UserPhone,@RequestParam("UserEmail")String UserEmail){
		User user=new User();
		user.setUserId(UserId);
//		user.setPassword(Password);
		user.setUserEmail(UserEmail);
		user.setUserName(UserName);
		user.setUserPhone(UserPhone);
		user.setUserSex(UserSex);
		return this.getUs().UpdUserNews(user);
	}
	
	public UserService getUs() {
		return us;
	}

	public void setUs(UserService us) {
		this.us = us;
	}
}
