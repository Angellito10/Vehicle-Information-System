/**
 * 
 */
package Final_assignment.assignment;

/**
 * @author Muath
 *
 */

public class Motor extends Vechiles {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// -- class attributes
	private String type; // here type refer to type speed or normal
	private String fuelType;

	public Motor() {
		this.type = " ";
		this.fuelType = "";

	}

	// -- this constructor will accept and inherited the value from super class
	// accept the value from this class too..

	public Motor(String ownerName, int ownerID, int locationID, String manufacture, String plateNumber,
				 String color, String model, String type, int wheels, String fuelType) {
		super(ownerName, ownerID, locationID, manufacture, plateNumber, color, model);

		// here this class value
		this.type = type;
		this.fuelType = fuelType;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}


	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	@Override
	public String toString() {// -- here will override the new class attribute and inherent the toString
								// function from the super class
		return "Motor ["+ super.toString() +"\ntype\t\t\t= " + type +"\nfuelType\t\t = " + fuelType
				+ "\t]";
	}

}

//}
