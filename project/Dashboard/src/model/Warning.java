package model;

public class Warning {
	int idSensor;
	int idRoom;
	int idFloor;
	int idBuilding;
	int idArea;
	int idCity;
	
	public Warning(int idSensor, int idRoom, int idFloor, int idBuilding, int idArea, int idCity){
		this.idSensor=idSensor;
		this.idRoom=idRoom;
		this.idFloor=idFloor;
		this.idBuilding=idBuilding;
		this.idArea=idArea;
		this.idCity=idCity;
	}
	
	int getIdSensor() {
		return idSensor;
	}
	
	int getIdRoom() {
		return idRoom;
	}
	
	int getIdFloor() {
		return idFloor;
	}
	
	int getIdBuilding() {
		return idBuilding;
	}
	
	int getIdArea() {
		return idArea;
	}
	
	int getIdCity() {
		return idCity;
	}

}
