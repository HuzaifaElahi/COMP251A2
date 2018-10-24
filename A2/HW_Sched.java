package A2;
import java.util.*;

class Assignment implements Comparator<Assignment>{
	int number;
	int weight;
	int deadline;


	protected Assignment() {
	}

	protected Assignment(int number, int weight, int deadline) {
		this.number = number;
		this.weight = weight;
		this.deadline = deadline;
	}



	/**
	 * This method is used to sort to compare assignment objects for sorting. 
	 * The way you implement this method will define which order the assignments appear in when you sort.
	 * Return 1 if a1 should appear after a2
	 * Return -1 if a1 should appear before a2
	 * Return 0 if a1 and a2 are equivalent 
	 */
	@Override
	public int compare(Assignment a1, Assignment a2) {
		
		// Sorting logic:
		// Try to sort in increasing order of deadlines
		// If deadlines equal, sort in increasing order of weight 
		
		if(a1.deadline > a2.deadline) {		        // a2 due before a1: a2 before
			return 1;

		} else if (a1.deadline < a2.deadline) {		// a1 due before a2: a1 before
			return -1;

		} else {		     						// a1 and a2 same deadline

			if (a1.weight > a2.weight){        // a1 higher importance
				return 1;

			} else if(a1.weight < a2.weight){  // a2 higher importance
				return -1;

			} else {					// a2 and a1 same
				return 0;
			}
		}
	}
}

public class HW_Sched {
	ArrayList<Assignment> Assignments = new ArrayList<Assignment>();
	int m;
	int lastDeadline = 0;

	protected HW_Sched(int[] weights, int[] deadlines, int size) {
		for (int i=0; i<size; i++) {
			Assignment homework = new Assignment(i, weights[i], deadlines[i]);
			this.Assignments.add(homework);
			if (homework.deadline > lastDeadline) {
				lastDeadline = homework.deadline;
			}
		}
		m =size;
	}


	/**
	 * 
	 * @return Array where output[i] corresponds to when assignment #i will be completed. output[i] is 0 if assignment #i is never completed.
	 * The homework you complete first will be given an output of 1, the second, 2, etc.
	 */
	public int[] SelectAssignments() {
		//Use the following command to sort your Assignments: 
		//Collections.sort(Assignments, new Assignment());
		//This will re-order your assignments. The resulting order will depend on how the compare function is implemented
		Collections.sort(Assignments, new Assignment());
		//Initializes the homeworkPlan, which you must fill out and output
		int[] homeworkPlan = new int[Assignments.size()];
				
		for(int count = 0 ; count < Assignments.size() ; count++) {
			Assignment a1 = Assignments.get(count);
			
			// Comparison logic:
			// If last member of array, insert as it is the greedy choice for sure
			// because we sort in increasing order of deadlines (if equal, then increasing weights)
			// else use the next member of array to compare if a1 is the biggest weighted 
			// member for it's corresponding deadline time
			
			if(count == Assignments.size()-1) {
				homeworkPlan[a1.number] = a1.deadline;
			}else {
				
				// Compare to next assignment in array

				Assignment a2 = Assignments.get(count+1);				
				if(a1.deadline == a2.deadline) {       // If same deadline, not the biggest weight for that deadline of a1
					homeworkPlan[a1.number] = 0;
				} else { 							   // New deadline, therefore a1 deadline has biggest weight for that time
					homeworkPlan[a1.number] = a1.deadline;
				}
			}
		}
		return homeworkPlan;
	}
}




