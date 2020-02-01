package B_MinMax;

public class MaxMax {
	
	
	
	public static void main(String[] args) {
		
	
	int [] arr= {2,3,5,1,7,4,8,12,4,0,21,44,52,23,-5,100,17,24,128,512,-4,330};
	System.out.println("arr len "+ arr.length);
	findMax(arr);
	findMin(arr);
	findMaxMax(arr);
	findMaxMin(arr);

	
	}


	private static void findMaxMax(int[] arr) {
	
		int max1 = (int) Double.MIN_VALUE;
		int max2 = (int) Double.MIN_VALUE;
		int comp =0;
		
		int k =0;
		int i = 0;
		int j = 1;
		while (k<arr.length/2) {
			
			int m1;
			int m2;
			if(arr[i]>=arr[j]) {
				m1 = arr[i];
				m2 = arr[j];
			}else {
				m1 = arr[j];
				m2 = arr[i];
			}
			comp++;
			
			if(m1 > max1) {
				int temp = max1;
				max1 =m1;
				max2 =temp;
				if(m2> max2) {
					max2 = m2;
				}
			}
			else if(m1>max2) {
				max2 = m1;
			}
			comp+=2;		
			i+=2;
			j+=2;
			k++;
		}
	
		if (arr.length%2 == 1) {
			int last =arr[arr.length-1]; 

			if(last > max1) {
				int temp = max1;
				max1 = last;
				max2 = temp;
			}
			else if(last> max2) {
				max2 = last;
			}
			comp+=2;
		}
		System.out.println("Max1: "+max1 + "    Max2: " +max2 +"   comper:" + comp  );
		
		
		
	}

	private static void findMaxMin(int[] arr) {
		
		int min = (int) Double.MAX_VALUE;
		int max = (int) Double.MIN_VALUE;
		int comp =0;
		
		for (int i = 0, j=1, k=0; k < arr.length/2; i= i+2,j = j+2,k++) {
			
			int temp_max = arr[i];
			int temp_min = arr[j];
			//who is bigger in the array
			if(temp_max < temp_min) {
				int temp = temp_max;
				temp_max = temp_min;
				temp_min = temp;
			}
			if(temp_max> max) { max = temp_max; }
			if(temp_min< min) { min = temp_min; }
			comp+=3;
		
		}
		
		
		
		if (arr.length%2 == 1) {
			int last =arr[arr.length-1]; 
			if(last> max) { max = last; }
			if(last< min) { min = last; }
			comp+=2;
		}
		System.out.println("Min: "+min + "    Max: " +max +"   comper:" + comp  );
		
		
		
		
		
	}

	private static void findMin(int[] arr) {
		int min = (int) Double.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]<min) {
				min= arr[i];
			}
		}
		System.out.println("Min: "+min + "O(n)");
		
	}

	private static void findMax(int[] arr) {
		
		int max = (int) Double.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]>max) {
				max= arr[i];
			}
		}
		System.out.println("Max: "+max + "O(n)");
		
	}
	
	

}
