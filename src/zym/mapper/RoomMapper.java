package zym.mapper;

import java.util.List;

import zym.domain.Room;

public interface RoomMapper {
	/**
	 * 查询所有房间
	 * @return
	 */
	public List<Room> selectRoom();
}
