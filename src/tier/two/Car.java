package tier.two;


public class Car extends Vehicle {

	private static final long serialVersionUID = 8897769398023381023L;
	
	private ParkingType t;
	private String m;
	private String y;
	
	public Car(ParkingType type, String model, String year) {
		super(type, model, year);
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
