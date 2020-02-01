package A_ParkingProblem;

import dataStructures.Node;
import dataStructures.Two_way_Linked_List;

public class CircleWithTail {


		//only a circle drive way: 

		public static void main(String[] args) {

			Two_way_Linked_List circle = new Two_way_Linked_List();
			
			Node end = null;
			Node st_circule = null;
			//create the circle..
			for (int i = 0; i < 20; i++) {
				
				if (i==3) {
					st_circule = new Node(i ,null ,null); 
					circle.addNode(st_circule);
				}
				else if ( i == 19 ) {
					end = new Node(i ,null ,null); 
					circle.addNode(end);
				
				}
				else 
					circle.add(i);
			}
			
			//create the tail. 
			
			end.setNext(st_circule);
			System.out.println(circle);
			HowManyCars(circle);
			
			
			
		}

	
		public static void HowManyCars(Two_way_Linked_List circle) {
			
			
			Node rabbit; 
			Node turtule; 
			//hops 2 times 
			rabbit = circle.getHead().getNext().getNext();
			//hops 1 time.
			turtule = circle.getHead().getNext();
			
			
			//find the meeting spot. 
			while(rabbit!=turtule) {
				
				rabbit  = rabbit.getNext().getNext();
				turtule = turtule.getNext();
			}
			//meeting point.
			Node k = rabbit;
			
			rabbit = circle.getHead();
			
			//Turtle will stay in the meeting point. 
			
			Node tempTurtule = turtule;
			int counterM = 0;
			
			//finding m - length of tail. 
			while(rabbit  != tempTurtule) {
				tempTurtule= tempTurtule.getNext();
				rabbit = rabbit.getNext();
				counterM ++;
			}
			
			System.out.println("circle start point = " + rabbit.getValue());
			System.out.println("tail size = "+counterM);
			
			rabbit = circle.getHead();
			int counterN = 0;
			while(rabbit  != turtule) {
				
				rabbit = rabbit.getNext();
				counterN ++;
			}
			
			
			System.out.println("circle size = "+counterN);
			
			
			
			
			
		}


	

	
}
