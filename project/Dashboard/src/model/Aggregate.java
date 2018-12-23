package model;

import java.util.ArrayList;
import java.util.List;

abstract class Aggregate<T>{
	private int id;
	private int sensorsNumber;
	private String name;
	private char status; 
	private List<T> subs = new ArrayList<T>();
	
	public Aggregate(int id) {
		this.id=id;
	}
	
	public int getId() {
		return id;
	};
	
	public String getName() {
		return name;
	};
	
	public List<T> getArea(){
		return subs;
	};
	
	public char getStatus(){
		return status;
	};
	
	public int getSensorsNumber() {
		return sensorsNumber;
	};
}
