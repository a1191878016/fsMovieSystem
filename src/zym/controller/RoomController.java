package zym.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import zym.domain.Room;
import zym.service.RoomService;

@Controller
@RequestMapping("/room")
public class RoomController {
	@Autowired
	private RoomService rs;
	
	@RequestMapping("/selectRoom.ssm")
	@ResponseBody
	public List<Room> selectRoom(){
		return this.getRs().selectRoom();
	}
	
	public RoomService getRs() {
		return rs;
	}

	public void setRs(RoomService rs) {
		this.rs = rs;
	}
}
