import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[] numbers;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		numbers = new int[M];
		visited = new boolean[N];
		back(0);
	}
	
	private static void back(int length) {
		if (length == M) {
			printArray();
			return;
		}
		
		for (int i=0; i<N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				numbers[length] = i;
				back(length + 1);
				visited[i] = false;
			}
		}
	}
	
	private static void printArray() {
		for(int i=0; i<M; i++) {
			System.out.print(numbers[i] + 1 + " ");
		}
		System.out.println();
	}
}