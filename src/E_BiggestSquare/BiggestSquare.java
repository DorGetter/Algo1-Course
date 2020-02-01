package E_BiggestSquare;

import java.util.Stack;

public class BiggestSquare {

	
	
	public static void main(String[] args) {
		int [][] square = {{1,1,0,1,0,1,1},
						   {0,1,0,0,1,0,0},
						   {1,1,0,1,1,1,0},
						   {1,1,0,0,1,1,1},
						   {0,1,0,1,1,1,1}};
		
		//BiggersSqr(square);
		BiggestRec(square);
	}
	
	public static void BiggersSqr(int [][] arr) {
		
		int [][] ans = new int[arr.length][arr[0].length];
		
		ans = arr.clone();
		int max = 0;
		String cord = "";
		
		for (int i = ans.length-2; i >= 0; i--) {
			
			for (int j = 1; j < ans[0].length; j++) {
				if(ans[i][j] ==1) {
					ans[i][j] = Math.min(ans[i][j-1], Math.min(ans[i+1][j], ans[i+1][j-1]))+1;
					
					if(ans[i][j]  > max) {
						max = ans[i][j];
						cord = "index i: "+i + "	index j: "+j;
					}
				}
			}		
		}
		
		print_mat(ans);
		System.out.println(cord);
	}
	
	public static void BiggestRec(int [][] arr) {
		
		int max_area = -1;
		int max_len = -1;

		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {	
				if(arr[i][j]==1) {
					arr[i][j] += arr[i-1][j];
				}
			}
			
			int temp = calcArea(arr,i);
			int tempLen =calcDist(arr,i);
			if(max_area<temp) {max_area = temp;}
			if(max_len < tempLen) { max_len = tempLen;}
		}
		System.out.println("biggest rectengle  = "+ max_area+"\n"+ "biggerst len :"+ max_len);	
		
		print_mat(arr);
	}
	
	private static int calcArea(int[][] arr, int i) {
		int max =  0; 
		int top = -1;
		int j=0;
		int area =0;
		Stack<Integer> stack = new Stack<Integer>();
		
		while(j<arr[0].length) {
			area =0;
			if( stack.isEmpty() || arr[i][j] >= arr[i][stack.peek()] ) {
				stack.add(j);
				j++;
			}
			else {
				top = stack.pop();
				if(stack.isEmpty()) {
					area = arr[i][top]*j;
				}
				else {
					area = (j - stack.peek()-1)*arr[i][top];
				}
				
				if(area > max) {
					max = area;
				}
			}
		}
		
		return max; 	
	}
	private static int calcDist(int[][] arr, int i) {
		
		int max =  0; 
		int top = -1;
		int j=0;
		int area =0;
		Stack<Integer> stack = new Stack<Integer>();
		
		while(j<arr[0].length) {
			area =0;
			if(stack.isEmpty() || arr[i][j] >= arr[i][stack.peek()] ) {
				stack.add(j);
				j++;
			}
			else {
				top = stack.pop();
				if(stack.isEmpty()) {
					area = 2*(arr[i][top]*j);
				}
				else {
					area =2*( (j - stack.peek()-1)+arr[i][top] );
				}
				
				if(area > max) {
					max = area;
				}
			}
		}
		
		return max; 
		
	}
	public static void print_mat(int [][] arr) {
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(i+"[");
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print("\t"+arr[i][j]+",");
			}
			System.out.print("\t"+"]"+i+" \n");
		}
		
		
	}
}
