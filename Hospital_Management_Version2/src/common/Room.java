package common;

import java.util.Hashtable;

public class Room {
	
	public static Hashtable<String, Boolean> room = new Hashtable<String, Boolean>();

	public void bookRoom(String roomname)
	{
		if(roomStatus(roomname)==false)
		{
			return;
		}
		else
		{
			this.room.remove(roomname);
			this.room.put(roomname, false);
		}
	}
	
	public void makeRoomAvailable(String roomname)
	{
		if(roomStatus(roomname)==true)
		{
			return;
		}
		else
		{
			this.room.remove(roomname);
			this.room.put(roomname, true);
		}
	}
	
	public Boolean roomStatus(String roomname)
	{
		return this.room.get(roomname);
	}
}
