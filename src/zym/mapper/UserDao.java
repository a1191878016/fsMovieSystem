package zym.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;


import zym.domain.User;


public interface UserDao {
	/**
	 * 用户登录  根据用户名和密码
	 * @param LoginName
	 * @param Password
	 * @return
	 */
	public User Login(@Param("LoginName")String LoginName,@Param("Password")String Password);
	/**
	 * 注册用户
	 * @param user
	 * @return
	 */
	public int BuyerRegister(@Param("user")User user);
	/**
	 * 根据userid查询用户信息
	 * @param UserId
	 * @return
	 */
	public User SelUserAll(@Param("UserId")int UserId);
	/**
	 * 修改用户信息
	 * @param user
	 * @return
	 */
	public int UpdUserNews(@Param("user")User user);
	
	
}
