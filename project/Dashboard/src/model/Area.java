package model;

import java.util.ArrayList;
import java.util.List;

import dao.AreaQuerySet;
import dao.DatabaseException;
	

public class Area extends Aggregate<Building> {
	private int IdCity;
	private String name;
	
	public Area(int id) {
		super(id);
	}
	
	public Area(int idArea, int IdCity, String areaName) {
		super(idArea);
		this.IdCity=IdCity;
		this.name=areaName;
	}
	
	
	
	public int getIdCity() {
		return IdCity;
	}

	public void setIdCity(int idCity) {
		IdCity = idCity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Building> getBuildings() throws DatabaseException{
		return AreaQuerySet.getBuildings(getId());
	};
}
