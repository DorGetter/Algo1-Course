package G_LIS;

import dataStructures.NodeLis;

public class Lis {
	//longest increasing subsequence
	public static void main(String[] args) {

		int [] arr = {5,1,2,42,7,3,6,8,9,12};
		lisCheck(arr);
		
		
		NodeLis [] n_arr = new NodeLis [arr.length];
		for (int i = 0; i < n_arr.length; i++) {
			n_arr[i] = new NodeLis(arr[i]);
		}
		lisCheckPro(n_arr);
		System.out.println();
		lisCheckProPlus(arr);
	}

	private static void lisCheckProPlus(int [] arr) {
		int [][] mat = new int [arr.length][arr.length]; 
		mat[0][0]=arr[0];
		int index=1;
		int i=0; int j=0;
		while (index < arr.length)
		{
			if(arr[index] > mat[i][j]) {
				j++; i++;
				mat[i][j] = arr[index++]; 
				for (int j2 = 0; j2 < j ; j2++) {
					mat[i][j2] = mat[i-1][j2];
				}
				
			}
			else {
				
				int change = BinarySearch(mat,i,j,arr[index]);
				mat[change][change] = arr[index++];
			}
			System.out.println("....");
		}
		
		for (int j2 = 0; j2 <= j; j2++) {
			System.out.println(mat[j2][j2]);
		}
		
	}

	private static int BinarySearch(int[][] mat, int i, int j,int val) {
		
		int [][] t = mat.clone();
		int left=0; int right = j;
		int mid=right/2;
		
		while( right>left && right!=left ) {
			
			if(mat[mid][mid] < val) {
				if(val < mat[mid+1][mid+1]) {
					return mid+1;
				}
				else {
					left=mid+1;
				}
			}
			else {
				if(val > mat[mid-1][mid-1]) {
					return mid;
				}
				else {
					right=mid-1;
				}
			}
			mid = (right-left)/2;
		}
		return mid;
	}

	private static void lisCheckPro(NodeLis[] arr) {

		int [] temp = new int [arr.length]; 
		int max = 0 ; int maxcord=0;
		for (int i = 0; i < temp.length; i++) {	temp[i]=1;	}

		for (int j = 1; j < arr.length; j++) 
		{
			for (int i = 0; i < j; i++) 
			{
				if(arr[i].getValue()<arr[j].getValue()) 
				{
					if(temp[i]+1 > temp[j]) 
					{
						temp[j] =temp[i]+1;
						arr[j].addToString(arr[i].getSub());
						
						if(max < temp[j]) {
							max= temp[j];
							maxcord=j;
							
						}
					}
				}
				
			}
		}
		System.out.println(arr[maxcord].getSub());
		System.out.println(max);
	}

	
		
		
		
	

	private static void lisCheck(int[] arr) {

		int [] temp = new int [arr.length]; 
		int max = 0 ; 
		for (int i = 0; i < temp.length; i++) {	temp[i]=1;	}

		for (int j = 1; j < arr.length; j++) 
		{
			for (int i = 0; i < j; i++) 
			{
				if(arr[i]<arr[j]) 
				{
					if(temp[i]+1 > temp[j]) 
					{
						temp[j] =temp[i]+1;
						if(max < temp[j]) {
							max= temp[j];
						}
					}
				}
				
			}
		}
		System.out.println(max);
	}

}
