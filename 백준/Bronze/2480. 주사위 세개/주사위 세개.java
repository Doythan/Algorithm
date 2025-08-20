import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int answer = 0;
		
		if (A == B && A == C) {
			answer = 10000 + A * 1000;
		} else if (A == B && A != C) {
			answer = 1000 + A * 100;
		} else if (A == C && A != B) {
			answer = 1000 + A * 100;
		} else if (B == C && A != B) {
			answer = 1000 + B * 100;
		} else {
			if (A > B && A > C) {
				answer = A * 100;
			} else if (B > A && B > C) {
				answer = B * 100;
			} else {
				answer = C * 100;
			}
		}
		
		System.out.println(answer);
	}
}
