package tier.three;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import tier.two.Ticket;
import tier.two.Vehicle;

public class ObjectFileReader {

	
	public ObjectFileReader() {
		
	}
	
	public List<Vehicle> loadAllVehicles() {
		ArrayList<Vehicle> temp = new ArrayList<Vehicle>();
		File dir = new File("vehicles/");
		if (dir.isDirectory()) {
			for (File f : dir.listFiles()) {
				try(ObjectInputStream os = new ObjectInputStream(new FileInputStream(f))) {
					temp.add((Vehicle)os.readObject());
					if (temp.size() == dir.list().length) {
						// Now we know that all saved tickets have been transferred to the list
						return temp;
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	
	public List<Ticket> loadAllTickets() {
		ArrayList<Ticket> temp = new ArrayList<Ticket>();
		File dir = new File("tickets/");
		if (dir.isDirectory()) {
			for (File f : dir.listFiles()) {
				try(ObjectInputStream os = new ObjectInputStream(new FileInputStream(f))) {
					temp.add((Ticket)os.readObject());
					if (temp.size() == dir.list().length) {
						// Now we know that all saved tickets have been transferred to the list
						return temp;
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	
}
