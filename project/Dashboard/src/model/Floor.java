package model;

import java.util.ArrayList;
import java.util.List;

import dao.DatabaseException;
import dao.FloorQuerySet;

public class Floor extends Aggregate<Room> {
	int floorNumber;
	int IdBuilding;

	public Floor(int id) {
		super(id);
	};

	public Floor(int idFloor, int floorNumber, int IdBuilding) {
		super(idFloor);
		this.floorNumber = floorNumber;
		this.IdBuilding = IdBuilding;
	};

	public int getIdBuilding() {
		return IdBuilding;
	}

	public void setIdBuilding(int idBuilding) {
		IdBuilding = idBuilding;
	}

	public int getFloorNumber() {
		return floorNumber;
	}

	public void setFloorNumber(int floorNumber) {
		this.floorNumber = floorNumber;
	}

	public List<Room> getRooms() throws DatabaseException {
		return FloorQuerySet.getRooms(getId());
	};
}

