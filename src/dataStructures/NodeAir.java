package dataStructures;

public class NodeAir {

	int value; 
	Node next,prev; 
	


	public NodeAir(int value, Node next ,Node prev) {
		this.value=value; 
		this.next = next; 
		this.prev = prev; 
	}

	public String toString() {
		return value+"";
	}


}


