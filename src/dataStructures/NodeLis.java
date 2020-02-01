package dataStructures;


	public class NodeLis{
		
		int value; 
		String sub; 
		public NodeLis(int value) {
			this.value=value; 
			this.sub= ""+value;
		}
		public void addToString(String n) {
			this.sub = " "+n+", "+this.value ;
		}
		public String getSub() {
			return this.sub;
		}
		public String toString() {
			return value+"";
		}
		public int getValue() {
			return value;
		}
	}


