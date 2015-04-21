package tier.first;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;

import tier.three.ObjectFileReader;
import tier.three.ObjectFileWriter;
import tier.two.Ticket;
import tier.two.Vehicle;

public class OptionsMenu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6064596087955640803L;

	// Our frame
	private static OptionsMenu frame;
	
	// Used to stream data to file
	private ObjectFileWriter writer;
	private ObjectFileReader reader;
	// File is used to store the ticket data
	private File tFile;
	private File vFile;
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
		    // If Nimbus is not available, you can set the GUI to another look and feel.
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new OptionsMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public OptionsMenu() {
		setTitle("Ticket Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 315, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JButton btnNewButton = new JButton("View Tickets");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
					} else {
						JOptionPane.showMessageDialog(null,"There are no tickets to view.", "No Tickets", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton, 25, SpringLayout.WEST, contentPane);
		contentPane.add(btnNewButton);
		
		JButton btnViewVehicles = new JButton("View Vehicles");
		btnViewVehicles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
					} else {
						JOptionPane.showMessageDialog(null, "There are no vehicles to view.", "No Vehicles", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNewButton, -6, SpringLayout.NORTH, btnViewVehicles);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton, 0, SpringLayout.EAST, btnViewVehicles);
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnViewVehicles, 69, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnViewVehicles, 25, SpringLayout.WEST, contentPane);
		contentPane.add(btnViewVehicles);
		
		JButton btnExitProgram = new JButton("Exit Program");
		btnExitProgram.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "You have exited the program.", "Exit Program", JOptionPane.INFORMATION_MESSAGE);
				frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnExitProgram, 6, SpringLayout.SOUTH, btnViewVehicles);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnExitProgram, 0, SpringLayout.WEST, btnNewButton);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnExitProgram, 120, SpringLayout.WEST, contentPane);
		contentPane.add(btnExitProgram);
		
		JLabel lblCommands = new JLabel("<html><b>Commands</b></html>");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblCommands, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblCommands, 0, SpringLayout.WEST, btnNewButton);
		contentPane.add(lblCommands);
		
		JLabel lblAddVehicle = new JLabel("<html><b>Add Vehicle</b></html>");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblAddVehicle, 0, SpringLayout.NORTH, lblCommands);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblAddVehicle, 72, SpringLayout.EAST, lblCommands);
		contentPane.add(lblAddVehicle);
		
		JButton btnTruck = new JButton("Truck");
		btnTruck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnTruck, 0, SpringLayout.NORTH, btnNewButton);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnTruck, 0, SpringLayout.WEST, lblAddVehicle);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnTruck, 255, SpringLayout.WEST, contentPane);
		contentPane.add(btnTruck);
		
		JButton btnCar = new JButton("Car");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnCar, 0, SpringLayout.NORTH, btnViewVehicles);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnCar, 0, SpringLayout.WEST, lblAddVehicle);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnCar, 135, SpringLayout.EAST, btnViewVehicles);
		contentPane.add(btnCar);
		
		JButton btnMotorbike = new JButton("Motorbike");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnMotorbike, 0, SpringLayout.NORTH, btnExitProgram);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnMotorbike, 0, SpringLayout.WEST, lblAddVehicle);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnMotorbike, 135, SpringLayout.EAST, btnExitProgram);
		contentPane.add(btnMotorbike);
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
