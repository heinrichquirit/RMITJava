package tier.two;

import java.io.Serializable;
import java.util.Random;

public abstract class Vehicle implements Serializable {
	
	private static final long serialVersionUID = 8710959415788264709L;
	
	private int id;
	private ParkingType t;
	private String m;
	private String y;
	
	public Vehicle(ParkingType type, String model, String year) {
		id = new Random().nextInt(1000);
		setParkingType(type);
		setModel(model);
		setYear(year);
	}
	
	public int getId() {
		return id;
	}
	
	public void setParkingType(ParkingType type) {
		t = type;
	}
	
	public ParkingType getParkingType() { 
		return t;
	}
	
	public void setModel(String model) { 
		m = model;
	}
	
	public String getModel() { 
		return m;
	}
	
	public void setYear(String year) {
		y = year;
	}
	
	public String getYear() {
		return y;
	}
	
}
