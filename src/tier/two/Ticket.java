package tier.two;

import java.io.Serializable;
import java.util.Random;


public class Ticket implements Serializable {
	
	private static final long serialVersionUID = 155238132427086469L;
	
	private int id;
	private boolean isOccupied;
	private ParkingType type;
	private int lotLocation, floorLevel, buildingNumber;
	private int hoursOccupied;
	
	public Ticket(boolean isOccupied, ParkingType type, int lotLoc, int floorLvl, int buildingNo, int hours) {
		id = new Random().nextInt(1000);
		setOccupied(isOccupied);
		setParkingType(type);
		setLotLocation(lotLoc);
		setFloorLevel(floorLvl);
		setBuildingNumber(buildingNo);
		setHoursOccupied(hours);
	}
	
	public int getId() {
		return id;
	}
	
	public void setOccupied(boolean occupy) {
		isOccupied = occupy;
	}
	
	public boolean isOccupied() {
		return isOccupied;
	}
	
	public void setParkingType(ParkingType type) {
		this.type = type;
	}
	
	public ParkingType getParkingType() {
		return type;
	}
	
	public void setLotLocation(int lotLocation) {
		this.lotLocation = lotLocation;
	}
	
	public int getLotLocation() {
		return lotLocation;
	}
	
	public void setFloorLevel(int floorLevel) {
		this.floorLevel = floorLevel;
	}
	
	public int getFloorLevel() {
		return floorLevel;
	}
	
	public void setBuildingNumber(int buildingNum) {
		buildingNumber = buildingNum;
	}
	
	public int getBuildingNumber() {
		return buildingNumber;
	}
	
	public void setHoursOccupied(int hoursOccupied) {
		this.hoursOccupied = hoursOccupied;
	}
	
	public int getHoursOccupied() {
		return hoursOccupied;
	}
	
	@Override
	public String toString() {
		return "Ticket [id=" + id + ", occupied=" + isOccupied + ", parkingtype=" 
					+ type + ", lotlocation=" + lotLocation + ", floorlevel=" 
					+ floorLevel + ", buildingnumber=" + buildingNumber + ", hoursoccupied=" + hoursOccupied + "]";
	}
	
}

