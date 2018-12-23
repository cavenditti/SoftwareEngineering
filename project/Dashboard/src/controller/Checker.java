package controller;
import model.Sensor;

public class Checker {
	public static void sensorTreshold(int id, int value) throws InterruptedException{
		//System.out.println("into checker");
		Sensor s = Cache.getSensor(id);
		if(s!=null) {
			if(value>s.getTreshold())  
				addWarningToCache(s);
			s.setValue(value);
			Cache.setSensor(s);
		}
	}
	
	public static void addWarningToCache(Sensor s) {
		//to do
	}
}
