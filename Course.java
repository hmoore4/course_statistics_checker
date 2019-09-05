/*
 * This class represents an individual course
 * 5/1/2019
 * @author Hunter Moore
 * @version 2.0
 */
public class Course{
	//vars	
	private String name;		//Name of class (E.g. CPSC215)
	private String title;		//Title of class (E.g. Data Strucutres and Algorithms)
	private int students;		//Amount of students that have taken class
	private int votes;			//Amount of students that recommend taking the class


	//Constructor allows course info to be set
	public Course (String name, String title, int students, int votes) {
		this.name = name;
		this.title = title;
		this.students = students;
		this.votes = votes;
	}
	//Default constructor sets a class just for me as the default course
	public Course() {
		name = "CPSC999";
		title = "Easy Class Made just for Hunter";
		students = 36;
		votes = 35;
	}
 /**
	* @return int returns number of students
	* Time Complexity : O(1)
	*/
	public int getStudents() {

		return students;
	}
	
		
 /**
	* @return String returns the title of the course
	* Time Complexity : O(1)
	*/
	public String getTitle() {
		return title;
	}
 /**
	* @return int returns number of votes to recommend class
	* Time Complexity : O(1)
	*/
	public int getVotes() {
		return votes;
	}
	
 /**
	* @return String returns the name of the course
	* Time Complexity : O(1)
	*/
	public String getName() {
		return name;
	}
	
 /**
	* @return double Returns percentage of students that recommend the course
	* Time Complexity : O(1)
	*/
	public double getScore() {
		double recommendation = ((double)getVotes())/getStudents() *100;
		return recommendation;
	}

 /**
	* @return String Returns the course name, title, and the recommendation percentage
	* Time Complexity : O(1)
	*/
	public String description() {
		return name + ": " + title + " has been taken by " + students + " students and has a " + String.format("%.0f", getScore()) + "% recommendation score.";
	}
	public String getDescription() {
		return description();
	}
	
 /**
	* Returns course name and recommendation score
	* Time Complexity : O(1)
	*/
	public String toString() {
		return name + ": " + String.format("%.0f", getScore()) + "%";
	}
}
