package zym.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zym.domain.Room;
import zym.mapper.RoomMapper;

@Service
public class RoomService {
	@Autowired
	private RoomMapper rm;
	/**
	 * 查询全部房间
	 * @return
	 */
	public List<Room> selectRoom(){
		return this.getRm().selectRoom();
	}
	
	public RoomMapper getRm() {
		return rm;
	}

	public void setRm(RoomMapper rm) {
		this.rm = rm;
	}
}
