package D_GameOfNumbers;

public class numberGame {

	public static void main(String[] args) {

		int [] even = {1,2,3,4,5,6};
		int []  odd = {12,41,52,854,23,75,32,12,4,33,64,75,123};
		//play size is even . 		
		//firstSoulotion(even);


		AdaptiveSolution(even);
		NumbersGame(even);

	}

	private static void NumbersGame(int [] arr) {

		int [][] mat = new int [arr.length][arr.length];

		for (int i = 0; i < arr.length; i++) {
			mat[i][i] = arr[i];
		}


		for (int i = 0; i < arr.length-1 ; i++) {

			if(mat[i][i] < mat[i+1][i+1])
				mat[i][i+1]=mat[i+1][i+1]-mat[i][i] ;

			else 
				mat[i][i+1] = mat[i][i]-mat[i+1][i+1];   
		}


		for (int i = 0; i < arr.length-2; i++) {
			int j=i+2; 

			//player1 choice
			if(mat[i][i] < mat[j][j]) {

				if(mat[i][i] < mat[j-1][j-1]) {
					mat[i][j] = mat[j][j] - mat[j-1][j-1] +mat[i][i];		
				}
				else
					mat[i][j] = mat[j][j] + mat[j-1][j-1] -mat[i][i];	
			}
			else if(mat[i][i] > mat[j][j]){

				if(mat[j][j] < mat[j-1][j-1]) {

					mat[i][j] = mat[i][i] - mat[j-1][j-1] +mat[j][j];		
				}
				else
					mat[i][j] = mat[i][i] + mat[j-1][j-1] -mat[j][j];	
			}

		}
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(i+"[");
			for (int j = 0; j < arr.length; j++) {
				System.out.print("\t"+mat[i][j]+",");
			}
			System.out.print("\t"+"]"+i+" \n");
		}
		
		
		
		for (int i = arr.length-3; i >= 0; i--) {
			
			for (int j = i+3; j < arr.length; j++) {
				mat[i][j] = Math.max(arr[i] - mat[i+1][j] , arr[j] - mat[i][j-1]);
			}
			
		}
		
		
		
		System.out.println("\n");
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(i+"[");
			for (int j = 0; j < arr.length; j++) {
				System.out.print("\t"+mat[i][j]+",");
			}
			System.out.print("\t"+"]"+i+" \n");
		}
		
		
	}


	private static void AdaptiveSolution(int[] arr) {


		//	firstSoulotion(arr);

		int i =0;
		int j =arr.length-1;
		int scorePlayer1=0;
		int scorePlayer2=0;


		int even =0;int odd =0;
		//sums ..
		for (int k  =0; k < arr.length; k++) {
			if (i%2 == 0) {even+=arr[i];}
			else 		  {odd+=arr[i];}
		}

		while (i<j) {
			//even win
			System.out.print("stat :"+i + "       "+j+"\t");
			if(even - odd > 0) {

				if(i%2==0) {
					scorePlayer1 += arr[i];
					even -= arr[i];
					i++;

					if(arr[i]>arr[j]) {
						scorePlayer2 += arr[i];
						odd -= arr[i];
						i++;
					}
					else {
						scorePlayer2 += arr[j];
						odd -= arr[j];
						j--;
					}

				}else {		
					scorePlayer1 += arr[j];
					even -= arr[j];
					j--;

					if(arr[i]>arr[j]) {
						scorePlayer2 += arr[i];
						odd -= arr[i];
						i++;
					}

					else {
						scorePlayer2 += arr[j];
						odd -= arr[j];
						j--;
					}

				}	
			}else {

				if(i%2!=0) {
					scorePlayer1 += arr[i];
					odd -= arr[i];
					i++;

					if(arr[i]>arr[j]) {
						scorePlayer2 += arr[i];
						even -= arr[i];
						i++;
					}
					else {
						scorePlayer2 += arr[j];
						even -= arr[j];
						j--;
					}

				}else {		
					scorePlayer1 += arr[j];
					odd -= arr[j];
					j--;

					if(arr[i]>arr[j]) {
						scorePlayer2 += arr[i];
						even -= arr[i];
						i++;
					}
					else {
						scorePlayer2 += arr[j];
						even -= arr[j];
						j--;
					}

				}

			}
			System.out.println(i + "       "+j);
		}

		int odd1	=0;
		int even1 	=0;
		for (int a  =0; a < arr.length; a++) {
			if (a%2 == 0) {even1+=arr[a];}
			else 		  {odd1+=arr[a];}
		}

		System.out.println(odd1+ "<-odd     even->"+even1);

		System.out.println("P1 : "+scorePlayer1+"    P2: "+scorePlayer2 + "   d "+(scorePlayer1-scorePlayer2));
	}

	private static void firstSoulotion(int[] arr) {
		int odd1	=0;
		int even1 	=0;
		for (int i  =0; i < arr.length; i++) {
			if (i%2 == 0) {even1+=arr[i];}
			else 		  {odd1+=arr[i];}
		}

		System.out.println("odd : " + odd1 + "    even : "+ even1);

		if(odd1>even1) {
			//System.out.println("play odd");
		}
		//	else
		//System.out.println("play even");
	}	





}
