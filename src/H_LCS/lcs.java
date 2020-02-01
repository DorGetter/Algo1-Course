package H_LCS;

public class lcs {
	public static void main(String[] args) {
		
		String x = "aaaabbbdfs";
		String y = "afsbbb"; 
		lcs(x,y);
	}

	private static void lcs(String x, String y) {

		
		// the i refer to -> y
		// the j refer to -> x
		int [][] mat = new int [y.length()+1][x.length()+1];
		
		for (int i = 1; i < mat.length; i++) {
			for (int j = 1; j < mat[0].length; j++) {
				if(y.charAt(i-1) == x.charAt(j-1)) {
					mat[i][j] = 1+mat[i-1][j-1];
				}
				else {
					mat[i][j] = Math.max(mat[i-1][j], mat[i][j-1]);
				}
			}
		}
		StringBuffer str = new StringBuffer();
		int i = mat.length-1;
		int j = mat[0].length-1;
		while(i != 0 && j != 0) {
			
			if(y.charAt(i-1)==x.charAt(j-1)) {
				str.append(y.charAt(i-1)); 
				i--;j--; 
			}
			
			else {
				if(mat[i-1][j]>mat[i][j-1]) 
				{
					i--;
				}
				else {
					j--;
				}
			}
			
			
		}
		System.out.println(str.reverse().toString() + "   length : " + str.length());
		
		
	}
}
