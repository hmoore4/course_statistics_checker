import java.io.*;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.List;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;

/*
 * This is a tester class for CourseStatistics
 * 5/1/2019
 * @author Hunter Moore
 * @version 2.0
 */

public class CourseStatisticsTester{

	private static int counter = 1;
	
	public static void main(String[] args) {

		CourseStatistics Stats = new CourseStatistics();
		if(args.length != 1) {
			System.out.println("Error: You need to provide a file name.");
			System.exit(1);
		}
		try {

			String name = null;
			String title = null;
			int students = 0;
			int votes = 0;
			FileReader inFile = new FileReader(args[0]);
			BufferedReader in = new BufferedReader(inFile);
			String line;
			while((line = in.readLine()) != null){
			System.out.print(line);
			System.out.println(" COUNTER: " + counter);

			//Goes through file and saves each value to correct variable
				if(counter%4 == 1){
					 name = line;
					 counter++;
				}
				else if (counter % 4 == 2){
					 title = line;
					 counter++;
				}
				else if(counter % 4 == 3){
					students = Integer.parseInt(line);
					counter++;
				 }
				else if (counter % 4 == 0){
					 votes = Integer.parseInt(line);
					 Course course = new Course(name, title, students, votes);		//Adds course to inventory after all variables are set
					 Stats.addCourse(course);
					 counter++;
				}
			}				
		}
		catch(FileNotFoundException e) {
		System.out.println("Error: File " + args[0] + " not found.");
		System.exit(1);
		} catch(IOException e) {
		System.out.println(e);
		System.exit(1);
		}
		
		Stats.displayAll();
		System.out.println("");
		
		Stats.displayStats();
		System.out.println("");

		ArrayList<Course> list=new ArrayList<Course>();			//Makes list

		Scanner userInput = new Scanner(System.in);
		boolean continuer = true;
		


		System.out.println("*** Looking Up Courses...");
		System.out.println("Enter course IDs to look up statistics. Enter ’s’ to stop.");
		while(continuer){
			System.out.print("Course ID: ");
			String ID = userInput.nextLine();
			if("s".equals(ID)) {
				continuer = false;				//Stops loop
				break;
			}
			if(Stats.getCourse(ID) != null) {
				System.out.println(Stats.getCourse(ID).description());		
			}
		}		

		System.out.println("");
		System.out.println("*** Comparing Courses...");
		System.out.println("Enter course IDs to compare. Enter ’s’ to stop.");	
		continuer = true;		//Resets loop
		while(continuer){
			System.out.print("Course ID: ");
			String ID = userInput.nextLine();
			if("s".equals(ID)) {
				continuer = false;			//Stops loop
				break;
			}

			if(Stats.getCourse(ID) != null) {
				list.add(Stats.getCourse(ID));
			}
		}
		Stats.findBest(list);
	}
}		
