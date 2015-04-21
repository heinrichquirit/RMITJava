package tier.first;

import java.awt.Dimension;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import tier.three.ObjectFileReader;
import tier.three.ObjectFileWriter;
import tier.two.Car;
import tier.two.Motorbike;
import tier.two.ParkingType;
import tier.two.Ticket;
import tier.two.Truck;
import tier.two.Vehicle;

public class Methods {
	
	// Used to stream data to file
	private ObjectFileWriter writer;
	private ObjectFileReader reader;
	// File is used to store the ticket data
	private File tFile;
	private File vFile;
	
	public Methods() {
		reader = new ObjectFileReader();
	}
	
	public void startMenu() {
		String input = getSelection();
		
		Random r = new Random();
		
		// Ticket fields to store in ticket object
		ParkingType tType = null;
		int tHours = 0;
		
		// Maximum range
		int rLot = r.nextInt(100);
		int rFloor = r.nextInt(20);
		int rBuilding = r.nextInt(5);
		
		/* If the user press cancel 
		 * or if the input is empty */
		if (input == null) {
			JOptionPane.showMessageDialog(null, "Exited Program.");
			return;
		}
		else if (input.equals("")) {
			JOptionPane.showMessageDialog(null, "Please enter a value.", "Error", JOptionPane.WARNING_MESSAGE);
			startMenu();
		}
		
		// Invalid selection
		if (isInvalidSelection(input)) {
			JOptionPane.showMessageDialog(null, "Invalid selection.", "Error", JOptionPane.ERROR_MESSAGE);
			startMenu();
		}
		
		if (input.equalsIgnoreCase("viewtickets")) {
			StringBuilder sb = new StringBuilder();
			File dir = new File("tickets/");
			if (dir.isDirectory()) {
				if (dir.list().length > 0) {
					for (Ticket t : reader.loadAllTickets()) {
						sb.append("Ticket ID: " + t.getId() + "\n")
							.append("Occupied: " + t.isOccupied() + "\n")
							.append("Vehicle Type: " + t.getParkingType() + "\n")
							.append("Lot Location: " + t.getLotLocation() + "\n")
							.append("Floor Level: " + t.getFloorLevel() + "\n")
							.append("Building Number: " + t.getBuildingNumber() + "\n")
							.append("Hours Occupied: " + t.getHoursOccupied() + "\n")
							.append("==============================\n");
					}
					showScrollableMsg("Total Tickets (" + reader.loadAllTickets().size() + ")", sb);
					startMenu();
				} else {
					JOptionPane.showMessageDialog(null, "There are no tickets to view", "No Tickets", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
		else if (input.equalsIgnoreCase("viewvehicles")) {
			StringBuilder sb = new StringBuilder();
			File dir = new File("vehicles/");
			if (dir.isDirectory()) {
				if (dir.list().length > 0) {
					for (Vehicle v : reader.loadAllVehicles()) {
						sb.append("Vehicle Type: " + v.getParkingType() + "\n")
							.append("Vehicle Model: " + v.getModel() + "\n")
							.append("Vehicle Year: " + v.getYear() + "\n")
							.append("==============================\n");
					}
					showScrollableMsg("Total Vehicles Stored (" + reader.loadAllVehicles().size() + ")", sb);
					startMenu();
				} else {
					JOptionPane.showMessageDialog(null, "There are no vehicles to view", "No Vehicles", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
		else if (input.equalsIgnoreCase("q")) {
			JOptionPane.showMessageDialog(null, "Exited Program.", "", JOptionPane.INFORMATION_MESSAGE);
		}
		else if (input.equals("1")) {
			tType = getParkingType(1);
			String h = JOptionPane.showInputDialog("You have selected " + getVehicle(1) 
						+ " with an hourly rate of $" + getParkingRate(1) 
						+ "\nHow many hours will you be parking for?");
			if (!isNumber(h)) {
				JOptionPane.showMessageDialog(null, "Please enter a number", "Error", JOptionPane.ERROR_MESSAGE);
				startMenu();
				return;
			}
			int hours = parseInt(h);
			String model = JOptionPane.showInputDialog("We will also be storing information about your vehicle."
					+ "\nWhat is the model of your " + getVehicle(1) + "?");
			String year = JOptionPane.showInputDialog("What is the year of your (" + getVehicle(1) + ") " + model + "?");
			JOptionPane.showMessageDialog(null, "Your " + year + " (" + getVehicle(1) + ") " + model + " has been stored."
					+ "\nYou have chosen to park for " + hours + " hours. Your total cost comes to $" + getParkingPrice(hours, 1)
					+ "\nYour parking spot is located at:\nLot Number: " + rLot + "\nFloor: " + rFloor + "\nBuilding: " + rBuilding);
			
			Ticket t = getTicket(true, tType, rLot, rFloor, rBuilding, tHours);
			Vehicle vehicle = getVehicle(1, tType, model, year);
			
			tFile = new File("tickets/" + t.getId() + ".dat");
			writer = new ObjectFileWriter(tFile, t);
			writer.save();
			
			vFile = new File("vehicles/" + vehicle.getId() + ".dat");
			writer = new ObjectFileWriter(vFile, vehicle);
			writer.save();
			
			startMenu();
		}
		else if (input.equals("2")) {
			tType = getParkingType(2);
			String h = JOptionPane.showInputDialog("You have selected " + getVehicle(2) 
						+ " with an hourly rate of $" + getParkingRate(2) 
						+ "\nHow many hours will you be parking for?");
			if (!isNumber(h)) {
				JOptionPane.showMessageDialog(null, "Please enter a number", "Error", JOptionPane.ERROR_MESSAGE);
				startMenu();
				return;
			}
			int hours = parseInt(h);
			String model = JOptionPane.showInputDialog("We will also be storing information about your vehicle."
					+ "\nWhat is the model of your " + getVehicle(2) + "?");
			String year = JOptionPane.showInputDialog("What is the year of your (" + getVehicle(2) + ") " + model + "?");
			JOptionPane.showMessageDialog(null, "Your " + year + " (" + getVehicle(2) + ") " + model + " has been stored."
					+ "\nYou have chosen to park for " + hours + " hours. Your total cost comes to $" + getParkingPrice(hours, 1)
					+ "\nYour parking spot is located at:\nLot Number: " + rLot + "\nFloor: " + rFloor + "\nBuilding: " + rBuilding);
			
			Ticket t = getTicket(true, tType, rLot, rFloor, rBuilding, tHours);
			Vehicle vehicle = getVehicle(2, tType, model, year);
			
			tFile = new File("tickets/" + t.getId() + ".dat");
			writer = new ObjectFileWriter(tFile, t);
			writer.save();
			
			vFile = new File("vehicles/" + vehicle.getId() + ".dat");
			writer = new ObjectFileWriter(vFile, vehicle);
			writer.save();
			
			startMenu();
		}
		else if (input.equals("3")) {
			tType = getParkingType(3);
			String h = JOptionPane.showInputDialog("You have selected " + getVehicle(3) 
						+ " with an hourly rate of $" + getParkingRate(3) 
						+ "\nHow many hours will you be parking for?");
			if (!isNumber(h)) {
				JOptionPane.showMessageDialog(null, "Please enter a number", "Error", JOptionPane.ERROR_MESSAGE);
				startMenu();
				return;
			}
			int hours = parseInt(h);
			String model = JOptionPane.showInputDialog("We will also be storing information about your vehicle."
					+ "\nWhat is the model of your " + getVehicle(3) + "?");
			String year = JOptionPane.showInputDialog("What is the year of your (" + getVehicle(3) + ") " + model + "?");
			JOptionPane.showMessageDialog(null, "Your " + year + " (" + getVehicle(3) + ") " + model + " has been stored."
					+ "\nYou have chosen to park for " + hours + " hours. Your total cost comes to $" + getParkingPrice(hours, 3)
					+ "\nYour parking spot is located at:\nLot Number: " + rLot + "\nFloor: " + rFloor + "\nBuilding: " + rBuilding);
			
			Ticket t = getTicket(true, tType, rLot, rFloor, rBuilding, tHours);
			Vehicle vehicle = getVehicle(3, tType, model, year);
			
			tFile = new File("tickets/" + t.getId() + ".dat");
			writer = new ObjectFileWriter(tFile, t);
			writer.save();
			
			vFile = new File("vehicles/" + vehicle.getId() + ".dat");
			writer = new ObjectFileWriter(vFile, vehicle);
			writer.save();
			
			startMenu();
		}
		
	}
	
	private Vehicle getVehicle(int vehicleId, ParkingType type, String model, String year) {
		ParkingType t = ParkingType.values()[vehicleId == 1 ? 0 : vehicleId == 2 ? 1 : vehicleId == 3 ? 2 : 0];
		switch(t) {
		case TRUCK:
			return new Truck(type, model, year);
		case CAR:
			return new Car(type, model, year);
		case MOTORBIKE:
			return new Motorbike(type, model, year);
		default:
			return null;
		}
	}
	
	public void createDir(String dir) {
		File f = new File(dir);
		if (!f.exists()) {
			f.mkdir();
		}
	}
	
	private Ticket getTicket(boolean a, ParkingType b, int c, int d, int e, int f) {
		return new Ticket(a, b, c, d, e, f);
	}
	
	private ParkingType getParkingType(int vehicleId) {
		if (vehicleId == 1) {
			return ParkingType.TRUCK;
		}
		else if (vehicleId == 2) {
			return ParkingType.CAR;
		}
		else if (vehicleId == 3) {
			return ParkingType.MOTORBIKE;
		}
		return null;
	}
	
	private boolean isInvalidSelection(String s) {
		List<String> menuItems = new ArrayList<String>();
		menuItems.add("viewtickets");
		menuItems.add("viewvehicles");
		menuItems.add("1");
		menuItems.add("2");
		menuItems.add("3");
		menuItems.add("q");
		return (!menuItems.contains(s));
	}
	
	private String getVehicle(int vehicleId) {
		ParkingType t = ParkingType.values()[vehicleId == 1 ? 0 : vehicleId == 2 ? 1 : vehicleId == 3 ? 2 : 0];
		switch(t) {
		case TRUCK:
			return ParkingType.TRUCK.toString();
		case CAR:
			return ParkingType.CAR.toString();
		case MOTORBIKE:
			return ParkingType.MOTORBIKE.toString();
		default:
			return "null";
		}
	}
	
	private double getParkingRate(int vehicleId) {
		ParkingType t = ParkingType.values()[vehicleId == 1 ? 0 : vehicleId == 2 ? 1 : vehicleId == 3 ? 2 : 0];
		switch(t) {
		case TRUCK:
			return ParkingType.TRUCK.getPrice();
		case CAR:
			return ParkingType.CAR.getPrice();
		case MOTORBIKE:
			return ParkingType.MOTORBIKE.getPrice();
		default:
			return 0.00;
		}
	}
	
	private double getParkingPrice(int hours, int vehicleId) {
		return hours * getParkingRate(vehicleId);
	}
	
	public static void print(String message) {
		System.out.println(message);
	}
	
	private String getSelection() {
		String menu = "=============== Parking Lot Menu ===============\n" 
				+ "You can view all tickets by typing 'viewtickets'\n"
				+ "You can view all vehicle details by typing 'viewvehicles'\n"
				+ "You can also exit the program by entering 'q'\n"
				+ "Please select and enter the number representing your type of vehicle.\n"
				+ "1. Truck\n"
				+ "2. Car\n"
				+ "3. Motorbike\n";
		return JOptionPane.showInputDialog(menu);
	}
	
	private boolean isNumber(String s) {
		try {
			Integer.parseInt(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	private static int parseInt(String a) {
		try {
			return Integer.parseInt(a);
		} catch (NumberFormatException e) {
			return 0;
		}
	}
	
	private void showScrollableMsg(String title, StringBuilder sb) {
		JTextArea textArea = new JTextArea(sb.toString());
		JScrollPane scrollPane = new JScrollPane(textArea);  
		textArea.setLineWrap(true);  
		textArea.setWrapStyleWord(true); 
		scrollPane.setPreferredSize(new Dimension( 500, 500 ));
		JOptionPane.showMessageDialog(null, scrollPane, title, JOptionPane.INFORMATION_MESSAGE);
	}
	
}
