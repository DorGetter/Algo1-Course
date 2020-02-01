package dataStructures;


public class Node{
	
	int value; 
	Node next,prev; 
	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Node getPrev() {
		return prev;
	}

	public void setPrev(Node prev) {
		this.prev = prev;
	}

	public Node(int value, Node next ,Node prev) {
		this.value=value; 
		this.next = next; 
		this.prev = prev; 
	}
	
	public String toString() {
		return value+"";
	}
	
	
}
