package Final_assignment.assignment;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class TestMain {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		int choice = 0, option = 0, ownerId, busN, parkN,searchId;
		String owner, manufact, coloR, plateNum = "NULL", modeL, licenseT, typE, fuelTypE;
		Scanner input = new Scanner(System.in);
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader buf = new BufferedReader(isr);
		System.out.println("\n\t\t\t-----------------------------------------------");
		System.out.println("\t\t\t-___ Welcome to, Vehicle information System  ___-");
		System.out.println("\t\t\t-----------------------------------------------\n");
		do {
			System.out.print("Select which Operation you want to perform ? \n"
					+ "\n[1].To Add or Register New Vehicle\n[2].To Dispaly info About Vehicle \n"
					+ "[3].To Search About Vehicle\n" + "[0].To Exit ...: " + "\n\npress: [1] or [2] or [3] or [0] : ");
			boolean invalIN = true;
			String temmp;
			do {
				try {
					System.out.println("Enter Your choice : ");
					temmp = input.nextLine();// store the value in string temp2 // -- Convert value to long using
												// Wrapper class
					choice = (int) Long.parseLong(temmp);
					invalIN = false;
				} catch (NumberFormatException e) {
					System.out.println("Not VAlid input :( Please Select Number form the list..");
				}
			} while (invalIN);
			switch (choice) {
			case 1:
				FileOutputStream file = null; // -- I declare the file to use outouptstream to
				ObjectOutputStream objOut = null; // -- this to write object

				System.out.println("\nSelect What type of vehicle you want to Register  :) " + "\n[1].Car" + "\n[2].Bus"
						+ "\n[3].Motor" + "\n[0].Exit || press any number to back to go back to main menu "
						+ "\nOption: ");
				boolean OptionVAL = true;
				String tempOP;
				do {// this will check the validation of the user choice
					try {
						System.out.println("Enter Your Option : ");
						tempOP = input.nextLine();// store the value in string temp2 // -- Convert value to long using
													// Wrapper class
						option = (int) Long.parseLong(tempOP);
						OptionVAL = false;
					} catch (NumberFormatException e) {
						System.out.println("Not VAlid Option :( select from list..");
					}
				} while (OptionVAL);
				if (option == 1) {
					System.out.println("How many Cars You want to register: "); // here we will take the size of
																				// array
					try {
						file = new FileOutputStream("CarInfo.txt");// -- The create the car info file
						objOut = new ObjectOutputStream(file);// -- pass the file to the objcout to store the info of
																// the car

						boolean sizeVAL = true;
						String sizeST;
						int size = 0; // -- ask to the array size that will be the number of object will created form
										// car class
						do {// this will check the validation of the user choice
							try {
								System.out.println("Enter how many  Cars : ");
								sizeST = input.nextLine();// store the value in string temp2 // -- Convert value to long
															// using Wrapper class
								size = (int) Long.parseLong(sizeST);
								sizeVAL = false;
							} catch (NumberFormatException e) {
								System.out.println("Not VAlid Size :( SIZE must be intger ..");
							}
						} while (sizeVAL); // -- ask to the array size that will be the number of object will created
											// form car class
						Car[] cr = new Car[size];

						for (int i = 0; i < cr.length; i++) { // --- start the loop
							cr[i] = new Car();
							// and pass it to the

							// --- In this sequence first we will set the Vehicle attribute value from 1 - 8

							// -- Read the first attribute
							System.out.println("Enter Owner Name: ");
							owner = buf.readLine();
							cr[i].setOwnerName(owner);

							// 1-- Read the second attribute
							String temp1;
							boolean invalid = true;
							do {// check the validation of the user input and keep asking again
								try {
									System.out.println("Enter Owner ID: ");
									temp1 = buf.readLine();// store the value in string temp1 // -- Convert value to
															// long using Wrapper class
									ownerId = (int) Long.parseLong(temp1);
									cr[i].setOwnerID(ownerId);
									invalid = false;
								} catch (NumberFormatException e) {
									System.out.println("Not VAlid input :) Must be Number..TryAgain");
								} catch (IOException e) {
									e.printStackTrace();
								}
							} while (invalid);

							// -- Read the third attribute
							String temp2;
							boolean invalid_2 = true;
							do {// check the validation of the user input and keep asking again
								try {
									System.out.println("Enter Location ID [1|2|3|4]: ");
									temp2 = buf.readLine();// store the value in string temp2 // -- Convert value to
															// long
															// using Wrapper class
									parkN = (int) Long.parseLong(temp2);
									cr[i].setlocationID(parkN);
									invalid_2 = false;
								} catch (NumberFormatException e) {
									System.out.println(
											"Not VAlid input :) Must be one of those [1|2|3|4] numbers ..TryAgain");
								} catch (IOException e) {
									e.printStackTrace();
								}
							} while (invalid_2);

							// -- Read the fourth attribute
							System.out.println("Enter Manufacture Name: ");
							manufact = buf.readLine();
							cr[i].setManufacture(manufact);

							// -- Read the fifth attribute
							System.out.println("Enter plate Number: ");
							plateNum = buf.readLine();
							cr[i].setPlateNumber(plateNum);

							// -- Read Sixth attribute
							// year deleted

							// -- Read the seventh attribute
							System.out.println("Enter car color: ");
							coloR = buf.readLine();
							cr[i].setColor(coloR);

							// -- Read the eighth attribute
							System.out.println("Enter car model: ");
							modeL = buf.readLine();
							cr[i].setModel(modeL);

							// --- In this sequence we will set the CAR attribute value from 1 - 4 :

							// -- Read 1st attribute
							// numofdoors, speed, engine deleted

							// -- Read 4th attribute
							System.out.println("Enter license Type [P or L]: ");
							licenseT = buf.readLine();
							cr[i].setLicenseType(licenseT);

							objOut.writeObject(cr[i]);// --here writeObject will write the car info to the file
							System.out.println("Successfully written  Car:) ");
							System.out.println(cr[i].toString()); // this to just for us to see the info we write using
																	// toString method

						} // end loop

					} catch (IOException e) {
						System.out.println("Ther's some thing wrong! ): "); // -- if there's any error append

					} finally {
						if (objOut != null) {
							System.out.println("Done Writting to Car"); // -- if the creation done correctly
							objOut.close(); // -- must close the file after finished use it
						}
					}

				} else if (option == 2) {

					try {
						file = new FileOutputStream("BusInfo.txt");// -- The create the bus info file
						objOut = new ObjectOutputStream(file);// -- pass the file to the objcout to store the info of
																// the car

						System.out.println("How many BUS You want to register..: "); // here we will take the size of
																						// array

						boolean sizeVAL = true;
						String sizeST;
						int size = 0; // -- ask to the array size that will be the number of object will created form
										// car class
						do {// this will check the validation of the user choice
							try {
								System.out.println("Enter how many: ");
								sizeST = input.nextLine();// store the value in string temp2 // -- Convert value to long
															// using Wrapper class
								size = (int) Long.parseLong(sizeST);
								sizeVAL = false;
							} catch (NumberFormatException e) {
								System.out.println("Not VAlid Size :( SIZE must be intger ..");
							}
						} while (sizeVAL); // -- ask to the array size that will be the number of object will created
											// form car class1

						Bus[] bus = new Bus[size];
						for (int i = 0; i < bus.length; i++) {
							bus[i] = new Bus();

							// --- In this sequence first we will set the Vehicle attribute value from 1 - 8

							// -- Read the first attribute
							System.out.println("Enter Owner Name: ");
							owner = buf.readLine();
							bus[i].setOwnerName(owner);

							// 1-- Read the second attribute
							String temp1;
							boolean invalid = true;
							do {// check the validation of the user input and keep asking again
								try {
									System.out.println("Enter Owner ID: ");
									temp1 = buf.readLine();// store the value in string temp1 // -- Convert value to
															// long using Wrapper class
									ownerId = (int) Long.parseLong(temp1);
									bus[i].setOwnerID(ownerId);
									invalid = false;
								} catch (NumberFormatException e) {
									System.out.println("Not VAlid input :) Must be Number..TryAgain");
								} catch (IOException e) {
									e.printStackTrace();
								}
							} while (invalid);

							// -- Read the third attribute
							String temp2;
							boolean invalid_2 = true;
							do {// check the validation of the user input and keep asking again
								try {
									System.out.println("Enter Location ID [1|2|3|4]: ");
									temp2 = buf.readLine();// store the value in string temp2 // -- Convert value to
															// long
															// using Wrapper class
									parkN = (int) Long.parseLong(temp2);
									bus[i].setlocationID(parkN);
									invalid_2 = false;
								} catch (NumberFormatException e) {
									System.out.println(
											"Not VAlid input :) Must be one of those [1|2|3|4] numbers ..TryAgain");
								} catch (IOException e) {
									e.printStackTrace();
								}
							} while (invalid_2);

							// -- Read the fourth attribute
							System.out.println("Enter Manufacture Name: ");
							manufact = buf.readLine();
							bus[i].setManufacture(manufact);

							// -- Read the fifth attribute
							System.out.println("Enter plate Number: ");
							plateNum = buf.readLine();
							bus[i].setPlateNumber(plateNum);

							// -- Read Sixth attribute
							// year deleted

							// -- Read the seventh attribute
							System.out.println("Enter Bus color: ");
							coloR = buf.readLine();
							bus[i].setColor(coloR);

							// -- Read the eighth attribute
							System.out.println("Enter Bus model: ");
							modeL = buf.readLine();
							bus[i].setModel(modeL);

							// --- In this sequence we will set the BUS attribute value from 1 - 4 :

							// -- Read 1st attribute

							String tempB;
							boolean invalid_3 = true;
							do {// check the validation of the user input and keep asking again
								try {
									System.out.println("Enter The BUS Number: ");
									tempB = buf.readLine();// store the value in string temp2 // -- Convert value to
															// long
															// using Wrapper class
									busN = (int) Long.parseLong(tempB);
									bus[i].setBusNumber(busN);
									invalid_3 = false;
								} catch (NumberFormatException e) {
									System.out.println(
											"Not VAlid input :) Must be one of those [1|2|3|4] numbers ..TryAgain");
								} catch (IOException e) {
									e.printStackTrace();
								}
							} while (invalid_3);

							// -- Read the eighth attribute
							System.out.println("Enter Type of Bus: ");
							typE = buf.readLine();
							bus[i].setType(typE);

							// -- Read 3ed attribute
							// capacity deleted

							objOut.writeObject(bus[i]);// --here writeObject will write the Bus info to the file
							System.out.println("Successfully written  Bus:) ");

						} // end loop

					} catch (IOException e) {
						System.out.println("Ther's some thing wrong! ): ");

					} finally {
						if (objOut != null) {
							System.out.println("Done Writting Bus");
							objOut.close();
						}
					}
				} else if (option == 3) {

					try {
						file = new FileOutputStream("MotorInfo.txt");
						objOut = new ObjectOutputStream(file);

						System.out.println("How many MOTOR You want to register..: "); // here we will take the size of
																						// array
						// and pass it to the constructor to
						// create objects
						boolean sizeVAL = true;
						String sizeST;
						int size = 0; // -- ask to the array size that will be the number of object will created form
										// car class
						do {// this will check the validation of the user choice
							try {
								System.out.println("Enter how many Motor: ");
								sizeST = input.nextLine();// store the value in string temp2 // -- Convert value to long
															// using Wrapper class
								size = (int) Long.parseLong(sizeST);
								sizeVAL = false;
							} catch (NumberFormatException e) {
								System.out.println("Not VAlid Size :( SIZE must be intger ..");
							}
						} while (sizeVAL); // -- ask to the array size that will be the number of object will created
											// form car class
						Motor[] motor = new Motor[size];
						for (int i = 0; i < motor.length; i++) {
							motor[i] = new Motor();
							// --- In this sequence first we will set the Vehicle attribute value from 1 - 8

							// -- Read the first attribute
							System.out.println("Enter Owner Name: ");
							owner = buf.readLine();
							motor[i].setOwnerName(owner);

							// 1-- Read the second attribute
							String temp1;
							boolean invalid = true;
							do {// check the validation of the user input and keep asking again
								try {
									System.out.println("Enter Owner ID: ");
									temp1 = buf.readLine();// store the value in string temp1 // -- Convert value to
															// long using Wrapper class
									ownerId = (int) Long.parseLong(temp1);
									motor[i].setOwnerID(ownerId);
									invalid = false;
								} catch (NumberFormatException e) {
									System.out.println("Not VAlid input :) Must be Number..TryAgain");
								} catch (IOException e) {
									e.printStackTrace();
								}
							} while (invalid);

							// -- Read the third attribute
							String temp2;
							boolean invalid_2 = true;
							do {// check the validation of the user input and keep asking again
								try {
									System.out.println("Enter Location ID [1|2|3|4]: ");
									temp2 = buf.readLine();// store the value in string temp2 // -- Convert value to
															// long
															// using Wrapper class
									parkN = (int) Long.parseLong(temp2);
									motor[i].setlocationID(parkN);
									invalid_2 = false;
								} catch (NumberFormatException e) {
									System.out.println(
											"Not VAlid input :) Must be one of those [1|2|3|4] numbers ..TryAgain");
								} catch (IOException e) {
									e.printStackTrace();
								}
							} while (invalid_2);

							// -- Read the fourth attribute
							System.out.println("Enter Manufacture Name: ");
							manufact = buf.readLine();
							motor[i].setManufacture(manufact);

							// -- Read the fifth attribute
							System.out.println("Enter plate Number: ");
							plateNum = buf.readLine();
							motor[i].setPlateNumber(plateNum);

							// -- Read Sixth attribute
							// year deleted

							// -- Read the seventh attribute
							System.out.println("Enter Motor color: ");
							coloR = buf.readLine();
							motor[i].setColor(coloR);

							// -- Read the eighth attribute
							System.out.println("Enter Motor model: ");
							modeL = buf.readLine();
							motor[i].setModel(modeL);
							// --- In this sequence we will set the CAR attribute value from 1 - 4 :

							// -- Read 1st attribute
							// wheels deleted

							// -- Read the eighth attribute
							System.out.println("Enter Motor Type [Superbike or normal]: ");
							typE = buf.readLine();
							motor[i].setType(typE);

							// -- Read 3ed attribute
							System.out.println("Enter Fuel Type: ");
							fuelTypE = buf.readLine();
							motor[i].setFuelType(fuelTypE);

							objOut.writeObject(motor[i]);
							System.out.println("Successfully written  to Motor:) ");
							System.out.println(motor[i].toString());

						} // end loop

					} catch (IOException e) {
						System.out.println("Ther's some thing wrong! ): ");

					} finally {
						if (objOut != null) {
							System.out.println("Done Writting to Motor");
							objOut.close();
						}
					}
				} else {
					System.out.println("Try Again and select valid choice from list.. :( ");
				}

			case 2:
				System.out.println("\n\tWhat Type of Vehicle You wnat to display info?  :) "
						+ "\n[1].To Display CAR Info" + "\t\t[2].To Display BUS Info" + "\n[3].To Display MOTOR info"
						+ "\t[0].Exit || press any number to back to main minue.. "
						+ "\n\npress: [1] | [2] | [3] | [0 Exit]: ");
				option = input.nextInt();
				if (option == 1) {

					try {
						String fileName = "CarInfo.txt";
						ObjectInputStream carInof = new ObjectInputStream(new FileInputStream(fileName));
						Car[] cr = new Car[fileName.length()];

						for (int i = 0; i < cr.length; i++) {
							cr[i] = (Car) carInof.readObject();
							// 2System.out.println("Name Is: " + cr[i].getOwnerName());
							System.out.println("Name Is: " + cr[i].toString());
						}
						carInof.close();
					} catch (EOFException eof) {
						//
					} catch (Exception e) {
						//
					}

				}
				if (option == 2) {
					try {
						String fileName = "BusInfo.txt";
						ObjectInputStream busInfo = new ObjectInputStream(new FileInputStream(fileName));
						Bus[] bus = new Bus[fileName.length()];

						for (int i = 0; i < bus.length; i++) {
							bus[i] = (Bus) busInfo.readObject();
							System.out.println("Name Is: " + bus[i].toString());
						}
						busInfo.close();
					} catch (EOFException eof) {
						//
					} catch (Exception e) {
						System.out.println("File Not found! ");
					}
				} 
				if (option == 3) {
					try {
						String fileName = "MotorInfo.txt";
						ObjectInputStream motorInfo = new ObjectInputStream(new FileInputStream(fileName));
						Motor[] motor = new Motor[fileName.length()];

						for (int i = 0; i < motor.length; i++) {
							motor[i] = (Motor) motorInfo.readObject();
							System.out.println("Name Is: " + motor[i].toString());
						}
						motorInfo.close();
					} catch (EOFException eof) {
						//
					} catch (Exception e) {
						//
					}
				} 
				else {
					System.out.println("Try Again and select valid choice from list.. :( ");
				}

				choice = input.nextInt();// this for scan choice if the user want to back to main menu or exit ..
				break;
				case 3:
					int option_1;
					System.out.println("\n\tWhat Type of Vehicle You want to search for ?  :) "
							+ "\n[1].CAR Info" + "\t\t[2].BUS Info" + "\n[3]. MOTOR info"
							+ "\t[0].Exit || press any number to back to main minue.. "
							+ "\n\npress: [1] | [2] | [3] | [0 Exit]: ");
					option_1 = input.nextInt();
					if (option_1 == 1) {

						try {
							String fileName = "CarInfo.txt";
							ObjectInputStream carInof = new ObjectInputStream(new FileInputStream(fileName));
							Car[] cr = new Car[fileName.length()];
							String ttmp;
							boolean invalidd = true;
							do{
							try {
								System.out.println("Enter the Car  Owner ID: ");
								ttmp = buf.readLine();// store the value in string ttmp // -- Convert value to long using Wrapper class
								searchId = (int) Long.parseLong(ttmp);
								invalidd = false;
							for (int i = 0; i < cr.length; i++) { //in this loop I used Linear Search algorithm
								cr[i] = (Car) carInof.readObject();
								if(cr[i].getOwnerID() == searchId) {//it will check if the value of owner equal the value I entered
									System.out.println("The info register with this ownreId: "+searchId
											+"\nis: "+cr[i].toString());
									break;
								}else {//if the value not equal any id in the list
									System.out.println("Not found,there's no car registered under this owner id :(\n");
									break;
								}
							}
							} catch (NumberFormatException e) {
								System.out.println("Not VAlid input :) Must be Number..TryAgain");
							} catch (IOException e) {
								e.printStackTrace();
							}
							} while (invalidd);

							carInof.close();
						} catch (EOFException eof) {
							//
						} catch (Exception e) {
							//
						}

					}if(option_1 == 2){
					try {
						String fileName = "BusInfo.txt";
						ObjectInputStream busInfo = new ObjectInputStream(new FileInputStream(fileName));
						Bus[] bus = new Bus[fileName.length()];
						String ttmp;
						boolean invalidd = true;
						do{
							try {
								System.out.println("Enter the Bus Owner ID: ");
								ttmp = buf.readLine();// store the value in string ttmp // -- Convert value to long using Wrapper class
								searchId = (int) Long.parseLong(ttmp);
								invalidd = false;
								for (int i = 0; i < bus.length; i++) { //in this loop I used Linear Search algorithm
									bus[i] = (Bus) busInfo.readObject();
									if(bus[i].getOwnerID() == searchId) {//it will check if the value of owner equal the value I entered
										System.out.println("The info register with this ownreId: "+searchId
												+"\nis: "+bus[i].toString());
										break;
									}else {//if the value not equal any id in the list
										System.out.println("Not found,there's no Bus registered under this owner id :(\n");
										break;
									}
								}
							} catch (NumberFormatException e) {
								System.out.println("Not VAlid input :) Must be Number..TryAgain");
							} catch (IOException e) {
								e.printStackTrace();
							}
						} while (invalidd);

						busInfo.close();
					} catch (EOFException eof) {
						//
					} catch (Exception e) {
						//
					}

				}if(option_1 == 3){
					try {
						String fileName = "MotorInfo.txt";
						ObjectInputStream motorInfo = new ObjectInputStream(new FileInputStream(fileName));
						Motor[] motor = new Motor[fileName.length()];
						String ttmp;
						boolean invalidd = true;
						do{
							try {
								System.out.println("Enter the Motor Owner ID: ");
								ttmp = buf.readLine();// store the value in string ttmp // -- Convert value to long using Wrapper class
								searchId = (int) Long.parseLong(ttmp);
								invalidd = false;
								for (int i = 0; i < motor.length; i++) { //in this loop I used Linear Search algorithm
									motor[i] = (Motor) motorInfo.readObject();
									if(motor[i].getOwnerID() == searchId) {//it will check if the value of owner equal the value I entered
										System.out.println("The info register with this ownreId: "+searchId
												+"\nis: "+motor[i].toString());
										break;
									}else {//if the value not equal any id in the list
										System.out.println("Not found,there's no Motor registered under this owner id :(\n");
										break;
									}
								}
							} catch (NumberFormatException e) {
								System.out.println("Not VAlid input :) Must be Number..TryAgain");
							} catch (IOException e) {
								e.printStackTrace();
							}
						} while (invalidd);

						motorInfo.close();
					} catch (EOFException eof) {
						//
					} catch (Exception e) {
						//
					}

				}
					break;

			}

		} while (choice != 0);
		input.close();

	}

}
