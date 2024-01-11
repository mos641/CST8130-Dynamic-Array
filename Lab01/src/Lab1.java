import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * *
 * This class contains the main method and menu 
 * Student Name: Mostapha A
 * Course: CST8130 - Data Structures CET-CS-Level 3
 * 
 */
public class Lab1 {

	/**
	 * Main method for printing menu and processing.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// var for menu input
		int menu = -1;
		// scanner
		Scanner input = new Scanner(System.in);
		// numbers object
		Numbers numbers = new Numbers();
		// formatter
		DecimalFormat format = new DecimalFormat("0.0#");

		// loop through menu
		do {
			// set menu to -1 ( this was added after main submission )
			menu = -1;
			
			// print menu
			displayMainMenu();

			// if input is an int, store
			if (input.hasNextInt()) {
				menu = input.nextInt();
			} else {
				// clear input
				input.next();
			}

			// if it is out of range print error and loop again
			if (menu < 1 || menu > 6) {
				// print error and loop through again
				System.out.println("Invalid Input. Try again. \n");
			} else {
				// case structure for menu options
				switch (menu) {
				case 1:
					// initialize default array
					numbers = new Numbers();
					break;
				case 2:
					// specified size of array
					int size = -1;

					// ask for size, validate input with loop
					do {
						System.out.print("Enter new size of array: ");

						if (input.hasNextInt()) {
							// store if an int
							size = input.nextInt();
						} else {
							// clear input
							input.next();
						}

						// if its not greater than 0 print error message
						if (size <= 0) {
							System.out.println("Invalid size. Enter an whole number greater than 0.");
						}

					} while (size <= 0);

					// create object with size
					numbers = new Numbers(size);
					break;
				case 3:
					// add value
					numbers.addValue(input);
					break;
				case 4:
					// display values
					System.out.println("Numbers are: \n" + numbers.toString());
					break;
				case 5:
					// display average
					System.out.println("Average is: " + format.format(numbers.calcAverage()) + ", " + numbers.getMinMax() + "\n");
					break;
				case 6:
					// exit
					System.out.println("Exiting...");
				}
			}

		} while (menu != 6);

	}

	/**
	 * Displays the menu.
	 */
	public static void displayMainMenu() {
		// print the menu
		System.out.print("Please select one of the following:\n" + "1: Initialize a default array\n"
				+ "2: To specify the max size of the array\n" + "3: Add value to the array\n"
				+ "4: Display values in the array\n"
				+ "5: Display average of the values, minimum value, maximum value\n" + "6: To Exit\n" + "> ");
	}

}