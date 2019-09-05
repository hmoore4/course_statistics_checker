import java.util.*; 
import java.lang.*; 
import java.io.*; 

/**
 * This class compares scores of courses which helps sort them by recommendation scores
 * 5/1/2019
 * @author Hunter Moore
 * @version 2.0
 */

public class CourseComparator implements Comparator<Course> {


	/**
	 * Compares two recommendation scores and determines which is higher/lower
	 * Time complexity: O(1)
	 * @param a The first course that is to be compared
	 * @param b The second course that is to be compared
	 * @return int A positive, negative, or 0 value that dictates which course is greater than the other
	 */
	public int compare(Course a, Course b) {
		if (a.getScore() > b.getScore()) {
			return -1;
		}
		else if (b.getScore() > a.getScore()) {
			return 1;
		}
		else {
			return 0;
		}
	}
}
