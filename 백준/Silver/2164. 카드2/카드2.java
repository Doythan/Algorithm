import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Queue<Integer> myQueue = new LinkedList<>();
		
		for (int i=0; i<N; i++) {
			myQueue.add(i+1);
		}
		
		while (myQueue.size() > 1) {
			myQueue.poll();
			int m = myQueue.poll();
			myQueue.add(m);
		}
		
		System.out.println(myQueue.poll());
	}
}