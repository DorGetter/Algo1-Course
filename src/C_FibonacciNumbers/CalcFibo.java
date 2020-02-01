package C_FibonacciNumbers;

public class CalcFibo {
	public static void main(String[] args) {

		//number of the wished fibo number.
		int n = 5; 

		CalcFibo(n);

	}
	//fibo 1,1,2,3,5,8,13.....
	private static void CalcFibo(int n) {

		if(n == 0 || n==1 ) {
			System.out.println("fibo num : 1");
			return;
		}

		int [][] A = { {1,1},
				{1,0}  };		
		int [][] ans = { {1,1},
				{1,0}  };

		while(n > 0) {

			if (n%2 == 1) {ans = matrix_mul(A, ans);}
			A = matrix_mul(A,A);
			n = n/2;

		}
		
		System.out.println("fibo"+ ans[0][1]);
	}

	private static int[][] matrix_mul(int[][] a, int[][] b) {

		int [][] ans = new int[2][2];
		
		ans[0][0] = a[0][0]*b[0][0]+a[0][1]*b[1][0];
		ans[0][1] = a[0][0]*b[0][1]+a[0][1]*b[1][1];
		ans[1][0] = a[1][0]*b[0][0]+a[1][1]*b[1][0];
		ans[1][1] = a[1][0]*b[0][1]+a[1][1]*b[1][1];
				
		return ans;
	}






}
