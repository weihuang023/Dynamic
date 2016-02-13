import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongestCommonSeq {

	public static void main(String arg[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Longest Common Subsequence Algorithm Test");

		System.out.println("Enter String 1: ");
		String str1 = br.readLine();

		System.out.println("Enter String 2: ");
		String str2 = br.readLine();

		int M = str1.length();
		int N = str2.length();

		// OPT[i][j] = Length of LCS, String1 [i...M] and String2 [j...N]

		int [][]opt = new int [M+1][N+1];

		for(int row = 0; row <= M ; row++ ){
			opt[row][0]=0;
		}

		for(int col = 0; col <= N ; col++ ){
			opt[0][col] =0;
		}

		// LCS via Dynamic Programming

		for( int i = 1; i <= M; i++){
			for(int j=1; j <= N ; j++){
				if(str1.charAt(i-1)==str2.charAt(i-1))
					opt[i][j]=opt[i-1][j-1]+1;
				else
					opt[i][j]=Math.max(opt[i][j-1], opt[i-1][j]);
			}
		}

		System.out.println(" ");
		System.out.println("Bottom Up Flow Chat: ");
		System.out.println(" ");

		for (int [] rows:opt){
			for (int col:rows){
				System.out.format("%5d",col);
			}
			System.out.println(" ");
		} 

		System.out.println(" ");
		System.out.println("LCS: ");

		// Recover LCS Itself and Print it to Standard Output

		int i = 0, j = 0;
		while( i < M && j < N){
			if (str1.charAt(i)==str2.charAt(j)){
				System.out.print(str1.charAt(i));
				i++;
				j++;
			} else if (opt[i+1][j] >= opt[i][j+1])
				i++;
			else
				j++;
		}
		System.out.println();
	}
}
