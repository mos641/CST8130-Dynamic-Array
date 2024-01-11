import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * *
 * This class contains the dynamically allocated array and it's processing
 * Student Name: Mostapha A
 * Course: CST8130 - Data Structures CET-CS-Level 3
 * 
 */
public class Numbers {
	/**
	 * Stores Float values.
	 */
	private float[] numbers;

	/**
	 * Store the number of items currently in the array.
	 */
	private int numItems = 0;

	/**
	 * Store the size of the array
	 */
	private int numSize = -1;

	/**
	 * Default Constructor
	 */
	public Numbers() {
		// initialize a "default" array with a size of 5
		numbers = new float[5];
		// numSize will stay -1 to indicate growing array
		// set the numItems to 0
		numItems = 0;
	}

	/**
	 * Constructor that initializes the numbers array.
	 * 
	 * @param size - Max size of the numbers array
	 */
	public Numbers(int size) {
		// initialize the numbers array of max 'size'
		numbers = new float[size];
		// set the numSize to the size of the array
		numSize = 5;
		// set the numItems to 0
		numItems = 0;
	}

	/**
	 * Adds a value in the array
	 * 
	 * @param input - Scanner object to use for input
	 */
	public void addValue(Scanner input) {
		if (numSize == -1) {
			if (numItems == numbers.length) {
				// if default array is full create larger one
				int newLength = numbers.length + 5;
				float[] temp = new float[newLength];
				// move information
				System.arraycopy(numbers, 0, temp, 0, numbers.length);
				// move back to numbers array
				numbers = new float[newLength];
				System.arraycopy(temp, 0, numbers, 0, newLength);
			}
			// add element
			// input to an object
			Float userInput = null;
			// loop to validate input
			do {
				// prompt for input
				System.out.print("Enter value: ");
				// check if its a float
				if (!input.hasNextFloat()) {
					// error message
					System.out.println("This is not a valid value, try again.");
					// clear input
					input.next();
				} else {
					// otherwise store the value
					userInput = input.nextFloat();
				}

				// while the value is null
			} while (userInput == null);

			// store the input in the array
			numbers[numItems] = userInput;

			// increment the numItems
			numItems++;
		} else {
			if (numItems >= numbers.length) {
				// print error message if array with set size reached capacity
				System.out.println("Array full");
			} else {
				// otherwise add element
				// input to an object
				Float userInput = null;
				// loop to validate input
				do {
					// prompt for input
					System.out.print("Enter value: ");
					// check if its a float
					if (!input.hasNextFloat()) {
						// error message
						System.out.println("This is not a valid value, try again.");
						// clear input
						input.next();
					} else {
						// otherwise store the value
						userInput = input.nextFloat();
					}

					// while the value is null
				} while (userInput == null);

				// store the input in the array
				numbers[numItems] = userInput;

				// increment the numItems
				numItems++;
			}
		}
	}

	/**
	 * Calculates the average of all the values in the numbers array.
	 * 
	 * @return float value that represents the average
	 */
	public float calcAverage() {
		// variable to add all the elements
		float sum = 0.0f;

		// loop through array and add all elements
		for (float element : numbers) {
			// add to sum
			sum = sum + element;
		}

		// if numItems is not 0
		if (numItems > 0) {
			// return the sum divided by number of elements
			return sum / numItems;
		} else {
			// otherwise return 0
			return 0f;
		}
	}

	/**
	 * Return all the elements of the array in a string.
	 */
	public String toString() {
		// string that will be returned with a all elements
		String elements = "";
		// formatter for returned input
		DecimalFormat format = new DecimalFormat("0.0#");

		// loop through array and add elements if numItems > 0
		if (numItems > 0) {
			for (int i = 0; i < numItems; i++) {
				elements = elements + format.format(numbers[i]).toString() + "\n";
			}
		}

		// return the string
		return elements;
	}

	/**
	 * Find the minimum value and maximum value in the array.
	 * 
	 * @return minimum and maximum values
	 */
	public String getMinMax() {
		// vars for max and min
		float min = 0.0f;
		float max = 0.0f;
		// formatter
		DecimalFormat format = new DecimalFormat("0.0#");

		// if numItems > 0 set min and max values to the first element
		if (numItems > 0) {
			// changed index to 0 after main submission
			min = numbers[0];
			max = numbers[0];

			// sort through the array and find the values
			for (int i = 0; i < numItems ; i++) {
				if (numbers[i] > max) {
					// if the array element is greater than first array element store it
					max = numbers[i];
					
				} else if (numbers[i] < min) {
					// if the element is less than first array element store it
					min = numbers[i];
				}
			}
		} // if there are no elements leave min and max at 0

		// return values
		return ("Minimum value is " + format.format(min) + ", Maximum value is " + format.format(max));
	}

}
