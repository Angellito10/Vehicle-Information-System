package Final_assignment.assignment;

import java.io.Serializable;

/**
 * @author Muath
 *
 */

//import java.io.Serializable;

public class Vechiles implements Serializable{

//public class Vehicles {

	//-- class attributes
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String ownerName; //-- the owner name for car
	private int ownerID;	//-- the owner Id if the owner student or lecturer or employee
	private int locationID; //-- the location ID of where the vehicle is parked
	private String manufacture;//-- the factory of the vehicle 
	private String plateNumber; //-- plate number that every vehicle must have
	private String color;
	private String  model;


	// -- Default constructor
	public Vechiles( ) { // -- here default constructor when the user didn't add any record to store
		this.ownerName = "NULL Vehicle record .. "; //this return null when ther's no value assign to the record
		this.ownerID = 0 ;
		this.locationID = 0;
		this.manufacture = "NULL Vehicle record ..";
		this.plateNumber = "NULL Vehicle record ..";
		this.color =  " ";
		this.model = " ";
		
	}
	
	//-- Constructor With arguments 
	public Vechiles(String ownerName, int ownerID, int locationID, String manufacture, String plateNumber,
					String color, String model) {
		super();// this it must be hidden but here for calling the default constructor of this class
		this.ownerName = ownerName;
		this.ownerID = ownerID;
		this.locationID = locationID;
		this.manufacture = manufacture;
		this.plateNumber = plateNumber;
		this.color = color;
		this.model = model;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public int getOwnerID() {
		return ownerID;
	}

	public void setOwnerID(int ownerID) {
		this.ownerID = ownerID;
	}

	public int getlocationID() {
		return locationID;
	}

	public void setlocationID(int locationID) {
		this.locationID = locationID;
	}

	public String getManufacture() {
		return manufacture;
	}

	public void setManufacture(String manufacture) {
		this.manufacture = manufacture;
	}

	public String getPlateNumber() {
		return plateNumber;
	}

	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}


	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	
	@Override
	public String toString() {
		return "Vehicles [\nOwner_Name\t\t= " + ownerName + "\nOwner_ID\t\t= " + ownerID + "\nLocation_ID\t\t= " + locationID
				+ "\nManufacture\t\t= " + manufacture + "\nPlate_Number\t\t= " + plateNumber + "\nColor\t\t\t= "
				+ color + "\nModel\t\t\t= " + model + " ";
	}
	
	
	
}
