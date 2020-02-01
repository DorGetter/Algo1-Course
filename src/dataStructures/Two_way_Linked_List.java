package dataStructures;
import dataStructures.*;

public class Two_way_Linked_List {

	Node head;
	int size=0;
	
	public Two_way_Linked_List() {}
	
	

	
	public void addNode(Node n) {
		if(size ==0) {
			head = n ; 
			n.setNext(n);
			n.setPrev(n);
			size++;
		}
		else {
			Node temp = head; 
			for (int i = 0; i < size-1; i++) {
				temp =temp.next;
				
			}
			temp.setNext( n );
			n.setPrev(temp); 
			n.setNext(head);
			size++;
		}
	}

	
	
	
	
	
	public void add(int value) {
		if(size ==0) {
			
			Node newnode = new Node(value,null,null);
			newnode.setNext(newnode);
			newnode.setPrev(newnode);	
			head = newnode; 
			size ++;
		}
		else {
			Node temp = head; 
			for (int i = 0; i < size-1; i++) {
				
				temp =temp.next;
				
			}
			Node newnode = new Node (value, head , temp);
			temp.setNext( newnode ); 
			size++;
		}
	}


	public Node getHead() {
		return head;
	}


	public void setHead(Node head) {
		this.head = head;
	}
	
	public String toString() {
		
		StringBuffer a= new StringBuffer();
		a.append("[");
		Node n = head;
		for (int i = 0; i < size; i++) {
			a.append(""+n.getValue()+",");
			n = n.next;
		}
		a.append("]");
		return a.toString();
	}
}