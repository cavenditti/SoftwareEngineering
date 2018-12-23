package model;


import java.util.ArrayList;
import java.util.List;

import controller.Cache;
import dao.DatabaseException;
import dao.RoomQuerySet;

public class Room extends Aggregate<Sensor> {
	int number;
	int IdFloor;

	public Room(int id) {
		super(id);
	}

	public Room(int idRoom, int roomNumber, int IdFloor) {
		super(idRoom);
		this.number = roomNumber;
		this.IdFloor = IdFloor;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getIdFloor() {
		return IdFloor;
	}

	public void setIdFloor(int idFloor) {
		IdFloor = idFloor;
	}

	public List<Sensor> getSensors() throws DatabaseException, InterruptedException {
		return Cache.getSensorsByRoom(getId());
	};
}

