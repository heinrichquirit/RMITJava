package tier.two;

public enum ParkingType {
	
	TRUCK(1, "Truck", 4.50), CAR(2, "Car", 2.75), MOTORBIKE(3, "Motorbike", 2.25);
	
	private final int id;
	private final String type;
	private final double price; // Price rate per hour
	
	private ParkingType(final int id, final String type, final double price) {
		this.id = id;
		this.type = type;
		this.price = price;
	}
	
	public int getId() {
		return id;
	}
	
	public double getPrice() {
		return price;
	}
	
	@Override
	public String toString() {
		return type;
	}
	
}
