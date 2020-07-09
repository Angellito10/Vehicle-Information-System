package Final_assignment.assignment;

/**
 * @author Muath
 *
 */

public class Bus extends Vechiles {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// -- class attributes
	private int busNumber;
	private String type; // here type refer to if it electronic or normal

	// -- Default constructor
	public Bus() {
		this.busNumber = 0;
		this.type = "NOT yet.. ";
	

	}
	// -- this constructor will accept and inherited the value from super class
	// accept the value from this class too..

	public Bus(String ownerName, int ownerID, int locationID, String manufacture, String plateNumber,
			   String color, String model, int busNumber, String type, int capacity) {
		super(ownerName, ownerID, locationID, manufacture, plateNumber, color, model);

		// here this class value
		this.busNumber = busNumber;
		this.type = type;
		
	}

	public int getBusNumber() {
		return busNumber;
	}

	public void setBusNumber(int busNumber) {
		this.busNumber = busNumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}


	@Override
	public String toString() {// -- here will override the new class attribute and inherent the toString
								// function from the super class
		return "Bus ["+ super.toString() +"\nbusNumber\t\t= " + busNumber + "\ntype\t\t\t= " + type +
				 "\t]";
	}

}
