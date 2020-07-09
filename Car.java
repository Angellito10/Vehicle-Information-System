package Final_assignment.assignment;

/**
 * @author Muath
 *
 */

public class Car extends Vechiles {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// -- class attributes
	
	private String licenseType;

	// -- Default constructor
	public Car() {
		this.licenseType = " ";

	}

//-- this constructor will accept and inherited the value from super class accept the value from this class too..

	public Car(String ownerName, int ownerID, int locationID, String manufacture, String plateNumber,
			   String color, String model, String licenseType) {
		super(ownerName, ownerID, locationID, manufacture, plateNumber, color, model);

		// here this class value
		
		this.licenseType = licenseType;
	}


	public String getLicenseType() {
		return licenseType;
	}

	public void setLicenseType(String licenseType) {
		this.licenseType = licenseType;
	}

	@Override
	public String toString() { // -- here will override the new class attribute and inherent call for the
								// toString function from the super class
		return "Car ["+ super.toString() + "\nlicenseType\t\t= "
				+ licenseType  +"  ]"+ "\n-----------------------------------\n";
	}

    
}
