package model;

import java.util.ArrayList;
import java.util.List;

import dao.BuildingQuerySet;
import dao.DatabaseException;

public class Building extends Aggregate<Floor> {
	String street;
	int civicNumber;
	int IDArea;

	public Building(int id) {
		super(id);
	};

	public Building(int idBuilding, String street, int civicNumber, int IDArea) {
		super(idBuilding);
		this.street = street;
		this.civicNumber = civicNumber;
		this.IDArea = IDArea;
	};

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getCivicNumber() {
		return civicNumber;
	}

	public void setCivicNumber(int civicNumber) {
		this.civicNumber = civicNumber;
	}

	public int getIDArea() {
		return IDArea;
	}

	public void setIDArea(int iDArea) {
		IDArea = iDArea;
	}

	public List<Floor> getFloors() throws DatabaseException {
		return BuildingQuerySet.getFloors(getId());
	};
}

