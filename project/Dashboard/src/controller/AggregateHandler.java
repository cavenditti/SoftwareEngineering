package controller;
import java.util.ArrayList;
import java.util.List;

import dao.DatabaseException;
import model.*;

public class AggregateHandler {

	
	public static String listAreas() throws DatabaseException{
			String tails="<div class=tail onclick=\"location.href='newAggregate.jsp?aggregateType=area' \"'>New Area</div> ";
			City city= new City(1);
			for(Area curr: city.getAreas())
				tails=tails+"<div class=tail onclick=\"location.href='?area="+curr.getId()+"'\"><div class=tailname >"+curr.getName()+"</div></div><br />";
			return tails;
	};
		
	public static String listBuildings(String p_area) throws DatabaseException{	
		String tails="<div class=tail>New Build</div>";
			int area =Integer.parseInt(p_area);
			
			Area area_obj = new Area(area);
			
			for(Building curr:  area_obj.getBuildings())
					tails=tails+"<div class=tail onclick=\"location.href='?area="+area+"&building="+curr.getId()+"'\"><div class=tailname >"+curr.getStreet()+"  "+curr.getCivicNumber()+"</div></div><br />";
			return tails;
	};	
		
	public static String listFloors(String p_area, String p_building) throws DatabaseException {
		String tails="<div class=tail >New Floor</div>";
			int area =Integer.parseInt(p_area);
			int building =Integer.parseInt(p_building);

			Building build_obj = new Building(building);
			
			for(Floor curr: build_obj.getFloors())
				tails=tails+"<div class=tail onclick=\"location.href='?area="+area+"&building="+building+"&floor="+curr.getId()+"'\"><div class=tailname >"+curr.getFloorNumber()+"</div></div><br />";
			return tails;
		};
		
	public static String listRooms(String p_area, String p_building, String p_floor) throws DatabaseException {
		String tails="<div class=tail >New Room</div>";
			int area =Integer.parseInt(p_area);
			int building =Integer.parseInt(p_building);
			int floor =Integer.parseInt(p_floor);
		
			Floor floor_obj = new Floor(floor);
			
			for(Room curr: floor_obj.getRooms())
				tails=tails+"<div class=tail onclick=\"location.href='?area="+area+"&building="+building+"&floor="+floor+"&room="+curr.getId()+"'\"><div class=tailname >"+curr.getNumber()+"</div></div><br />";
			return tails;
		}
	
	public static String listSensors(String p_room) throws DatabaseException, InterruptedException {
		String tails="";

			int room = Integer.parseInt(p_room);
		
			Room room_obj = new Room(room);
			
			for(Sensor curr: room_obj.getSensors())
				tails=tails+"<div class=tail ><div class=tailname >Id:"+curr.getId()+" Status:"+curr.getStatus()+" Treshold:"+curr.getTreshold()+" Value:"+curr.getValue()+"</div></div><br />";
			return tails;
		}
	}

