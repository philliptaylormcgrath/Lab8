package co.grandcircus;
//Lab 8

import java.util.InputMismatchException;

//Write a program that will recognize invalid inputs when the user requests information about students in a class
//1. Provide information about students in a class of at least 10 people
//2. Prompt the user to ask about a particular student
//3. Give proper responses according to user submitted information
//4. Ask if the user would like to learn about another student.
//5. Account for invalid user inputs with exceptions (use Validator class provided)
//6. Try to incorporate IndexOutOfBounds and IllegalArgumentException
//7. Make it easier for the user by letting them know what information is available
//8. Use parallel arrays!

import java.util.Scanner;

public class Lab8 {

	public static void main(String[] args) {

		String[] studentNames = { "Donald", "Barack", "Junior", "William", "George", "Ronald", "Jimmy", "Gerald",
				"Richard", "Lyndon" };
		String[] studentFood = { "Well done steak with a side of ketchup", "Dijon Mustard", "Grilled Cheese",
				"Chicken Enchiladas", "Anything but broccoli", "Jelly Bellys", "Corn Bread", "Waffles",
				"Yogurt. Seriously", "Mashed Potatoes" };
		String[] studentTerms = { "once so far", "twice", "twice", "twice", "once", "twice", "once",
				"once, after taking over for Richard", "twice, but he quit during the second term",
				"twice, after taking over for Johnny" };

		Scanner scan = new Scanner(System.in);

		String cont = "yes";

		while (cont.contentEquals("yes")) {
			
			try {
				// your code for this loop should start here
				System.out.println("Please enter the number of the student you would like to learn about: ");
				System.out.println("1. Donald\n" + "2. Barack\n" + "3. Junior\n" + "4. William\n" + "5. George\n"
						+ "6. Ronald\n" + "7. Jimmy\n" + "8. Gerald\n" + "9. Richard\n" + "10. Lyndon");
				// Try+Catch IndexOutOfBoundsException here, numbers that aren't between 1-10
				// will return this exception
				// InputMismatchException here, any input other than a number will return this
				// exception
				int userStudentSelection = scan.nextInt();

				System.out.println("You have selected " + studentNames[userStudentSelection - 1]); // use index to output
																									// president
				System.out.println("What would you like to know about " + studentNames[userStudentSelection - 1]
						+ "? Please input 1 for food preferences, 2 for number of terms served as student president");
				int userInfoSelect = scan.nextInt();
				if (userInfoSelect == 2) {
					System.out.println(studentNames[userStudentSelection - 1] + " served as student body president "
							+ studentTerms[userStudentSelection - 1]);
				} else if (userInfoSelect == 1) {

					System.out.println(studentNames[userStudentSelection - 1] + "'s favorite food is "
							+ studentFood[userStudentSelection - 1]);
				} else if (userInfoSelect > 2 || userInfoSelect < 1) {
					System.out.println("Input was not 1 or 2 for student information selection.");
				}
			} catch (InputMismatchException e) { //these cannot be on the same line. 
				System.out.println("Input mismatch! Invalid input. Please input a number between 1 and 10!");
				scan.next();
				
			} catch (ArrayIndexOutOfBoundsException e) {
				
				System.out.println("Invalid number! Please input a number between 1 and 10!");
			}
		

			// your logic should stop here, before user prompt to continue
			// loop
			//May need to clear scanner here for try/catch to function properly
			//scan.next();
			System.out.println("Would you like information about any other students? : yes/no");
			
			cont = scan.next();

		}
		scan.close(); // type this line at the end whenever you open a new scanner
		System.out.println("Student 'research' complete. Have a wonderful day!");
	}

}
