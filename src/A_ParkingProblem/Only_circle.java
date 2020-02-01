package A_ParkingProblem;


import dataStructures.Node;
import dataStructures.Two_way_Linked_List;

public class Only_circle {

	//only a circle drive way: 

	public static void main(String[] args) {

		Two_way_Linked_List circle = new Two_way_Linked_List();

		//create the circle..
		for (int i = 0; i < 20; i++) {

			if(i%2 == 0 ) {circle.add(1000);}

			else if (i%3 == 0 ) {circle.add(2000);}

			else 
				circle.add(i);
		}

		System.out.println(circle.toString());
		
		//quesion num 1 : solve the prob with linked list: 
		System.out.println(HowManyCarsInCircle(circle));
	}


	public static int HowManyCarsInCircle(Two_way_Linked_List list) {

		int counter=0;  
		//until the signs and steps are same. 
		boolean flag = true; 
		
		list.getHead().setValue(1000);
		Node step = list.getHead();

		while (flag) {
			
			//go to first 1000 sign && increment counter
			step = step.getNext();
			counter++;
			while(step.getValue()!=1000)
			{
				step = step.getNext();
				counter++;
			}
			step.setValue(2000);
			int revCounter = counter; 
			
			
			//go back and check if the start point is changed
			while(revCounter>=0) {
				
				step = step.getPrev();
				revCounter--;
			}
			
			if(step.getValue() == 2000) {
				return counter; 
			}
			
			counter = 0 ;
			
		}

		return -1; 
	}



}
