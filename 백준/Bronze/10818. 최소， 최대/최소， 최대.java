import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int maxValue = -1000001;
		int minValue = 1000001;
		
		
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(maxValue < num) maxValue = num;
			if(minValue > num) minValue = num;
		}
		
		System.out.print(minValue + " ");
		System.out.print(maxValue);
	}
}