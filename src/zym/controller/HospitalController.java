package zym.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

@Controller
public class HospitalController {
	
	@RequestMapping("/hospital.ssm")
	@ResponseBody
	public String selectHospital(){
		List<String> l=new ArrayList();
		String str="{\"copd\":\"GOLD-I 吸烟\",\"now\":\"200\",\"future\":\"(150-400)\",\"now_bai\":\"20%\",\"future_bai\":\"(15%-40%)\"},"
				+ "{\"copd\":\"GOLD-I 不吸烟\",\"now\":\"400\",\"future\":\"(600-850)\",\"now_bai\":\"40%\",\"future_bai\":\"(60%-85%)\"}";
		Gson g=new Gson();
		String json=g.toJson(str);
		return str;
	}
}
