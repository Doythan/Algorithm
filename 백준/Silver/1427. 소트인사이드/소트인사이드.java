import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int[] A = new int[str.length()];
		for(int i=0; i<str.length(); i++) {
			A[i] = Integer.parseInt(str.substring(i, i+1));
		}
		
		for (int i=0; i<str.length(); i++) {
			int max = 0;
			int max_idx =i;
			for (int j=i; j<str.length(); j++) {
				if (A[j] > max) {
					max = A[j];
					max_idx = j;
				}
			}
			A[max_idx] = A[i];
			A[i] = max;
		}
		
		for (int i=0; i<str.length(); i++) {
			System.out.print(A[i]);
		}
	}
}